package com.jbta.formulariomatematico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class calculo extends AppCompatActivity {

    private String temascalculo[]=new String[]{"Integración","Derivación"};

    private Integer[] imgid={
            R.drawable.paper64,
            R.drawable.paper64

    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SubTemaListAdapter adapter=new SubTemaListAdapter(this,temascalculo,imgid);
        lista=(ListView)findViewById(R.id.mi_lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Selecteditem = temascalculo[+position];
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
                if (Selecteditem == temascalculo[0]) {
                    Intent intent = new Intent(getApplicationContext(), calculo_subtemas.class);
                    startActivity(intent);
                }
                if (Selecteditem == temascalculo[1]) {
                    Intent intent = new Intent(getApplicationContext(), calculo_derivacion.class);
                    startActivity(intent);
                }


            }
        });

    }

}
