package br.com.bossini.listaclientesarqdsis_cco;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaClientesActivity extends AppCompatActivity {
    public static final String NOME =
            "br.usjt.arqdesis.clientep2.nome";
    public static final String VALOR = "br.usjt.arqdesis.clientep2.valor";
    public static final String DATA =
            "br.usjt.arqdesis.clientep1.data";
    Activity atividade;
    Cliente[] lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = Data.buscaClientes(chave);
        BaseAdapter adapter = new MeuAdapter(this,lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
// manda para a tela de detalheIntent  intent = new Intent(getApplicationContext(),DetalheClienteActivity.class);
                Intent intent = new Intent(atividade,
                        DetalheClienteActivity.class);
                intent.putExtra(DATA, lista[position].getData());
                intent.putExtra(VALOR, lista[position].getValor());
                intent.putExtra(NOME, lista[position].getNome());
                startActivity(intent);
            }
        });
    }
}
