package br.com.etecmam.etecmamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.etecmam.etecmamapp.sms.Util;

public class ContatoActivity extends AppCompatActivity {

    EditText texto;
    ImageButton botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        texto = findViewById(R.id.contato_texto);
        botao = findViewById(R.id.contato_botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.enviarSMS("981193960",texto.getText().toString() );
                Toast.makeText(ContatoActivity.this,
                                 "MENSAGEM ENVIADA...",
                                      Toast.LENGTH_SHORT)
                                      .show();
            }
        });

    }

}
