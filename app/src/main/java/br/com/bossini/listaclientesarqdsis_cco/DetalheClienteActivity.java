package br.com.bossini.listaclientesarqdsis_cco;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalheClienteActivity extends AppCompatActivity {

    ImageView clienteImageView;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        Intent intent = getIntent();
        cliente = new Cliente(1, intent.getStringExtra(ListaClientesActivity.DATA),
                intent.getStringExtra(ListaClientesActivity.VALOR), intent.getStringExtra(ListaClientesActivity.NOME));
        clienteImageView = (ImageView)
                findViewById(R.id.cliente_image_view);
        Drawable drawable = Util.getDrawable(this, cliente.getFoto());
        clienteImageView.setImageDrawable(drawable);
        TextView data = (TextView)
                findViewById(R.id.txt_cliente_nome);
        TextView valor = (TextView) findViewById(R.id.txt_cliente_fone);
        TextView nome = (TextView)
                findViewById(R.id.txt_cliente_email);
        data.setText(cliente.getData());
        valor.setText(cliente.getValor());
        nome.setText(cliente.getNome());
    }
}
