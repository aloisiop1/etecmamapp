package br.com.etecmam.etecmamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import br.com.etecmam.etecmamapp.sms.Util;

public class EscolaActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Util.setTelaAtual(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escola);
        setTitle("SOBRE A ESCOLA");

        String escola = "A Escola Técnica Estadual Monsenhor Antônio Magliano é uma unidade do Centro Paula Souza, onde são oferecidos cursos " +
                "técnicos e ensino médio gratuitos de ótima qualidade através do Governo do Estado de São Paulo, com professores capacitados a" +
                " oferecer o máximo de conhecimento aos alunos. Você pode aprimorar seu potencial de trabalho, conhecimento e novas " +
                "oportunidades, estudando conosco. Para ingressar, você precisa passar pelo exame do Vestibulinho que é oferecido duas " +
                "vezes ao ano e se classificar de acordo com o número de vagas oferecidas.";

        WebView tela = findViewById(R.id.escola_texto);

        tela.loadData("<p style=\"text-align:justify\">" + escola + "</p>",
                "text/html; charset=utf-8",
                "utf-8");

        findViewById(R.id.escola_mensagem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(EscolaActivity.this, ContatoActivity.class) );
            }
        });

    }
}
