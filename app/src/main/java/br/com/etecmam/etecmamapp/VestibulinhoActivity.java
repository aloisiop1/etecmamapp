package br.com.etecmam.etecmamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.etecmam.etecmamapp.sms.Util;

public class VestibulinhoActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Util.setTelaAtual(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vestibulinho);
        setTitle("VESTIBULINHO");
    }
}
