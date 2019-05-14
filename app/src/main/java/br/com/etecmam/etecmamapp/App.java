package br.com.etecmam.etecmamapp;

import android.app.Application;
import android.content.Intent;

import br.com.etecmam.etecmamapp.sms.Servico;
import br.com.etecmam.etecmamapp.sms.Util;

public class App extends Application {

    private Servico servico;
    private Intent intentService;

    @Override
    public void onCreate() {
        super.onCreate();
        Util.setApp(this);
    }

    public void iniciarServicoEmBackGround(){
        servico = new Servico(false);
        intentService = new Intent( getApplicationContext(), servico.getClass() );
        startService(intentService);
    }

}
