package br.com.etecmam.etecmamapp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import br.com.etecmam.etecmamapp.notificacao.Config;
import br.com.etecmam.etecmamapp.notificacao.NotificationUtils;
import br.com.etecmam.etecmamapp.sms.Util;

public class MenuActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 0;
    private static final String TAG = "MenuActivity";

    private static final String TAG_PUSH = MenuActivity.class.getSimpleName();
    private BroadcastReceiver mRegistrationBroadcastReceiver;


    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Util.setTelaAtual(this);
        registarReceptorPush();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("ETECMAM GARÇA");

        if(! hasReadSmsPermission()){
            requestReadAndSendSmsPermission();
        }

        Util.getApp().iniciarServicoEmBackGround();

        //NOTIFICACAO FIREBASE PUSH
        criarBroadcastReceiver();


        ListView lista = findViewById(R.id.menu_lista);

        List<ItemMenu> itens = new ArrayList<>();

        itens.add( new ItemMenu(R.drawable.escola,"SOBRE A ESCOLA") );
        itens.add( new ItemMenu(R.drawable.cursos,"CURSOS") );
        itens.add( new ItemMenu(R.drawable.vestibulinho,"VESTIBULINHO") );
        itens.add( new ItemMenu(R.drawable.localizacao,"LOCALIZAÇÃO") );

        MenuAdapter adapter = new MenuAdapter(itens, this);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {

                Intent i = null;

                switch (posicao){
                    case 0:
                        i = new Intent(MenuActivity.this, EscolaActivity.class);
                        break;

                    case 1:
                        i = new Intent(MenuActivity.this, CursosActivity.class);
                        break;

                    case 2:
                        i = new Intent(MenuActivity.this, VestibulinhoActivity.class);
                        break;

                    case 3:
                        i = new Intent(Intent.ACTION_VIEW);
                        i.setData( Uri.parse( "geo:0,0?q=ETEC MONSENHOR ANTONIO MAGLIANO?z=21"));
                        break;

                }

                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){

            case R.id.menu_sobre:
                Intent telaSobre = new Intent(this, SobreActivity.class);
                startActivity(telaSobre);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private boolean hasReadSmsPermission() {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestReadAndSendSmsPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {
            Log.i(TAG,"shouldShowRequestPermissionRationale(), no permission requested");
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.READ_SMS,
                        Manifest.permission.RECEIVE_SMS,
                        Manifest.permission.SEND_SMS
                },
                SMS_PERMISSION_CODE);
    }

    private void registarReceptorPush(){

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    private void criarBroadcastReceiver(){

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received
                    String message = intent.getStringExtra("message");
                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

                }
            }
        };
    }

}
