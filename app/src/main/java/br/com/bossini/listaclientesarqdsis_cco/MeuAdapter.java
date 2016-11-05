package br.com.bossini.listaclientesarqdsis_cco;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rodrigo on 22/09/16.
 */
public class MeuAdapter <T extends Cliente> extends BaseAdapter{
    private T [] dados;
    private Activity context;

    public MeuAdapter (Activity context, T [] dados){
        this.dados = dados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dados.length;
    }

    @Override
    public Object getItem(int i) {
        return dados[i];
    }

    @Override
    public long getItemId(int i) {
       return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null){
            LayoutInflater li = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.minha_linha, viewGroup, false);
            ImageView letraCliente =
                    (ImageView)convertView.findViewById(R.id.foto_cliente);
            TextView nomeCliente =
                    (TextView)convertView.findViewById(R.id.nome_cliente);
            TextView detalheCliente =
                    (TextView)convertView.findViewById(R.id.detalhe_cliente);
            convertView.setTag(new ViewHolder(letraCliente, nomeCliente,
                    detalheCliente));
        }
        ViewHolder holder = (ViewHolder)convertView.getTag();
        //carrega os novos valores
        Drawable drawable = Util.getDrawable(context, dados[position].getFoto());
        holder.getFotoCliente().setImageDrawable(drawable);
        holder.getNomeCliente().setText((dados[position]).getData());
        holder.getDetalheCliente().setText(String.format("%s - %s",dados[position].getValor(),
                dados[position].getNome()));
        return convertView;
    }
}
