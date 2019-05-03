package br.com.etecmam.etecmamapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("ETECMAM GARÇA");

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
}
