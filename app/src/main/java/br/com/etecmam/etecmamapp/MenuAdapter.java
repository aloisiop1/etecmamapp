package br.com.etecmam.etecmamapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {

    private final List<ItemMenu> itens;
    private final Context contexto;

    public MenuAdapter(List<ItemMenu> itens, Context contexto) {
        this.itens = itens;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(contexto);
        View v = inflater.inflate(R.layout.item_menu,null);

        ImageView foto = v.findViewById(R.id.item_foto);
        TextView texto = v.findViewById(R.id.item_texto);

        ItemMenu item =  itens.get(i);

        Drawable d = contexto.getResources().getDrawable(item.getDesenho());

        foto.setImageDrawable(d);
        texto.setText( item.getTitulo());


        return v;
    }
}
