package br.com.etecmam.etecmamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import br.com.etecmam.etecmamapp.sms.Util;

public class CursoActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Util.setTelaAtual(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        Curso c = (Curso) getIntent().getSerializableExtra("curso");

        setTitle(c.getNome());
        ( (TextView) findViewById(R.id.curso_eixo)).setText( c.getEixo() );

        ( (WebView) findViewById(R.id.curso_eixo_descricao) )
                .loadData("<p style=\"text-align:justify\">" + c.getEixoDescricao()  + "</p>",
                        "text/html; charset=utf-8",
                        "utf-8");

        ( (WebView) findViewById(R.id.curso_mercado_descrica) )
                .loadData("<p style=\"text-align:justify\">" + c.getMercado()  + "</p>",
                        "text/html; charset=utf-8",
                        "utf-8");
    }
}
