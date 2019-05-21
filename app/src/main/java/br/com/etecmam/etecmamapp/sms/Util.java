package br.com.etecmam.etecmamapp.sms;

import android.content.Context;
import android.telephony.SmsManager;

import br.com.etecmam.etecmamapp.App;

public class Util {

    private static App app = null;

    private static Context telaAtual;


    public static void enviarSMS(String numero, String mensagem) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(numero,null, mensagem ,null,null);
    }


    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        Util.app = app;
    }


    public static Context getTelaAtual() {
        return telaAtual;
    }

    public static void setTelaAtual(Context telaAtual) {
        Util.telaAtual = telaAtual;
    }
}

