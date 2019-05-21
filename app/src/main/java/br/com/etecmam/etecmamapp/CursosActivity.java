package br.com.etecmam.etecmamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.etecmam.etecmamapp.sms.Util;

public class CursosActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Util.setTelaAtual(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        setTitle("CURSOS");

        ListView lista = findViewById(R.id.cursos_lista);

        List<ItemMenu> itens = new ArrayList<>();
        final List<Curso> cursos = montaListaDeCursos();

        itens.add( new ItemMenu(R.drawable.curso_ds,"DESENVOLVIMENTO DE SISTEMAS") );
        itens.add( new ItemMenu(R.drawable.curso_adm,"ADMINISTRAÇÃO") );
        itens.add( new ItemMenu(R.drawable.curso_meca,"MECÂNICA") );
        itens.add( new ItemMenu(R.drawable.curso_enf,"ENFERMAGEM") );
        itens.add( new ItemMenu(R.drawable.curso_seg,"SEGURANÇA DO TRABALHO") );
        itens.add( new ItemMenu(R.drawable.curso_eletronica,"ELETRÔNICA") );

        MenuAdapter adapter = new MenuAdapter(itens, this);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CursosActivity.this, CursoActivity.class);
                intent.putExtra("curso",cursos.get(i));
                startActivity(intent);
            }
        });

    }

    private List<Curso> montaListaDeCursos() {
        List<Curso> cursos = new ArrayList<>();

        cursos.add(
                new Curso("Desenv. de Sistemas",
                "Eixo Tecnológico: Desenvolv. Educacional e Social",
                "É o profissional que analisa e projeta sistemas. Constrói, documenta, realiza testes e mantém " +
                        "sistemas de informação. Utiliza ambientes de desenvolvimento e linguagens de programação específica. " +
                        "Modela, implementa e mantém bancos de dados.",
                "Empresas e departamentos de desenvolvimento de sistemas em organizações governamentais e não governamentais, " +
                        "podendo também atuar como profissional autônomo.")
        );

        cursos.add(
                new Curso("Administração",
                        "Eixo Tecnológico:Gestão e Negócios",
                        "O técnico em Administração pode trabalhar em vários departamentos. No setor de compras, por exemplo, pode " +
                                "elaborar pedidos de compra de produtos, cadastrar fornecedores assim como conferir a entrega das mercadorias " +
                                "adquiridas. Na área de produção, pode fazer planilhas de controle de processos e produtos, registrando quais já " +
                                "foram produzidos e em qual quantidade. No departamento de vendas, também pode elaborar planilhas para acompanhar o " +
                                "desempenho das vendas, cadastrar clientes, preencher notas fiscais e gerar boletos bancários. No setor de Recursos " +
                                "Humanos, o técnico pode trabalhar calculando salários e benefícios dos funcionários e auxiliando nos processos de " +
                                "contratação e demissão de pessoal. Em qualquer área, pode atender clientes e fornecedores e redigir documentos, como " +
                                "e-mails, memorandos e atas. ",
                        "Empresas privadas, seja de comércio, serviço ou indústria, órgãos públicos (prefeituras, secretarias de " +
                                "governo, ministérios do governo federal etc.) e ONGs.")
        );

        cursos.add(
                new Curso("Mecânica",
                        "Eixo Tecnológico: Gestão e Processos Industriais",
                        "O técnico em Mecânica é o profissional que elabora projetos mecânicos e sistemas automatizados. Monta e " +
                                "instala máquinas e equipamentos. \n" +
                                "Planeja e realiza manutenção. Desenvolve processos de fabricação e montagem de conjuntos mecânicos. Elabora documentação," +
                                " realiza compras e vendas técnicas e cumpre normas e procedimentos de segurança no trabalho e preservação ambiental.",
                        "Indústrias, fábricas de máquinas, equipamentos e componentes mecânicos. Laboratórios de controle de qualidade, de manutenção " +
                                "e pesquisa no setor produtivo mecânico; prestadoras de serviços.")
        );

        cursos.add(
                new Curso("Enfermagem",
                        "Eixo Tecnológico: Ambiente e Saúde",
                        "O técnico cumpre função assistencial ao enfermeiro, como cuidados básicos em pacientes graves, aplicação de vacina, dar " +
                                "um banho em um paciente, auxiliar em exames, entre outras funções. Pode atuar na área administrativa, na prevenção e pode " +
                                "montar ações educativas, na área de segurança do trabalho.",
                        "Unidades básicas de saúde, hospitais, casa de repouso, escolas e clínicas.")
        );

        cursos.add(
                new Curso("Segurança do Trabalho",
                        "Eixo Tecnológico: Segurança",
                        "O profissional atua na identificação de riscos presentes nos ambientes de trabalho, estuda a aplicação das normas " +
                                "obrigatórias e propõe soluções para a prevenção de acidentes. O técnico também ajuda no treinamento dos funcionários em " +
                                "relação à segurança no trabalho. É responsável por selecionar os equipamentos de proteção de acordo com a necessidade de " +
                                "cada funcionário.",
                        "Construção civil, indústrias, hospitais, mineradoras, áreas agrícolas, portuárias, entre outras.")
        );

        cursos.add(
                new Curso("Eletrônica",
                        "Eixo Tecnológico:Controle e Processos Industriais",
                        "Participa do desenvolvimento de projetos. Executa a instalação e a manutenção de equipamentos e sistemas " +
                                "eletrônicos e de automação. Faz medições e testes com equipamentos eletrônicos. Realiza procedimentos de " +
                                "controle de qualidade e gestão da produção de equipamentos eletrônicos.",
                        "Indústrias; laboratórios de controle de qualidade e de manutenção; empresas de informática, de telecomunicações e " +
                                "de produtos eletrônicos.")
        );

        return cursos;

    }
}
