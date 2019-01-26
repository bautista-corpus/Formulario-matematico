package com.jbta.formulariomatematico;

/**
 * Created by jesusbautista on 10/12/15.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class TemasListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] integers;

    public TemasListAdapter(Activity context, String[] itemname, Integer[] integers) {
        super(context, R.layout.fila_lista, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.integers=integers;
    }

    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.fila_lista,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.texto_principal);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView etxDescripcion = (TextView) rowView.findViewById(R.id.texto_secundario);

        txtTitle.setText(itemname[posicion]);
        imageView.setImageResource(integers[posicion]);
        if (posicion==0){
            etxDescripcion.setText("Formulas de integración y derivación ");
        }
        if (posicion==1){
            etxDescripcion.setText("Razones trigonométricas y formulas");
        }
        if (posicion==2){
            etxDescripcion.setText("Formulas de perimetros y areas");
        }
        //else {
        //    etxDescripcion.setText("Description " + itemname[posicion]);
        //}
        return rowView;
    }


}
