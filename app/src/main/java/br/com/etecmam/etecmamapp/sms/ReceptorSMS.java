package br.com.etecmam.etecmamapp.sms;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import br.com.etecmam.etecmamapp.R;


public class ReceptorSMS  extends android.content.BroadcastReceiver {
    public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    public ReceptorSMS() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                // get sms objects
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) {
                    return;
                }
                SmsMessage[] messages = new SmsMessage[pdus.length];
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }

                final String mensagem = sb.toString();
                String sender = messages[0].getOriginatingAddress();

                if(sender.equals("981193960")){
                    AlertDialog.Builder alerta = new AlertDialog.Builder( Util.getTelaAtual() );
                    alerta.setIcon(R.drawable.sms);
                    alerta.setTitle("RECADO DA ETEC");
                    alerta.setMessage(mensagem);
                    alerta.setPositiveButton("OK", null);
                    alerta.show();
                }
            }
        }
    }
}

