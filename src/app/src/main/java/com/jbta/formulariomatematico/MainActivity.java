package com.jbta.formulariomatematico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String temas[]=new String[]{"Cálculo","Trigonometria","Áreas y perímetros"};

    private Integer[] imgid={
            R.drawable.square74,
            R.drawable.compass58,
            R.drawable.td

    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {
                //
                Snackbar.make(view, "Aqui se abre la calculadora", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
                 //Intent intent = new Intent(getApplicationContext(),calculo.class);
                 //startActivity(intent);
            }


        });

        TemasListAdapter adapter=new TemasListAdapter(this,temas,imgid);
        lista=(ListView)findViewById(R.id.mi_lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Selecteditem = temas[+position];
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
                if (Selecteditem==temas[0]){
                    Intent intent = new Intent(getApplicationContext(),calculo.class);
                    startActivity(intent);
                }
                if (Selecteditem==temas[1]){
                    Intent intent = new Intent(getApplicationContext(),trigonometria.class);
                    startActivity(intent);
                }
                if (Selecteditem==temas[2]){
                    Intent intent = new Intent(getApplicationContext(),areasperimetros.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, acercade.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
