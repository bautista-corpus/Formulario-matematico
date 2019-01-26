package com.jbta.formulariomatematico;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jesusbautista on 25/12/15.
 */
public class SubTemaListAdapter extends ArrayAdapter<String>{


    private final Activity context;
    private final String[] itemname;
    private final Integer[] integers;

    public SubTemaListAdapter(Activity context, String[] itemname, Integer[] integers) {
        super(context, R.layout.fila_lista_sub, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.integers=integers;
    }

    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.fila_lista_sub, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.texto_principal);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(itemname[posicion]);
        imageView.setImageResource(integers[posicion]);


        //else {
        //    etxDescripcion.setText("Description " + itemname[posicion]);
        //}
        return rowView;
    }


}
