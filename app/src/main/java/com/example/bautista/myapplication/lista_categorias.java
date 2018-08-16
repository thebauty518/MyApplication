package com.example.bautista.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class lista_categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);
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

        CardView Que_Hacer = (CardView)findViewById(R.id.que_hacer);
        CardView Que_Visitar = (CardView)findViewById(R.id.que_visitar);
        CardView Donde_Dormir = (CardView)findViewById(R.id.donde_dormir);
        CardView Donde_Comer = (CardView)findViewById(R.id.donde_comer);
        CardView Servicios_Turisticos = (CardView)findViewById(R.id.servicios_turisticos);
        CardView Llamadas= (CardView)findViewById(R.id.llamadas);

        Que_Hacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uno = new Intent(lista_categorias.this,items_que_hacer.class);
                startActivity(uno);
            }
        });

        Que_Visitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uno = new Intent(lista_categorias.this,items_que_visitar.class);
                startActivity(uno);
            }
        });
        Donde_Dormir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uno = new Intent(lista_categorias.this,items_donde_dormir.class);
                startActivity(uno);
            }
        });
        Donde_Comer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uno = new Intent(lista_categorias.this,items_donde_comer.class);
                startActivity(uno);
            }
        });
        Servicios_Turisticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uno = new Intent(lista_categorias.this,items_servicios_turisticos.class);
                startActivity(uno);
            }
        });
        Llamadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uno = new Intent(lista_categorias.this,items_llamadas.class);
                startActivity(uno);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.mSalir) {
            finish();
            return true;
        }

        if (id == R.id.mAyuda) {
            return true;
        }

        if (id == R.id.mRegistrarse) {
            Intent registrarse = new Intent(this, registrar_persona.class);
            startActivity(registrarse);
            return true;
        }

        if (id == R.id.mConfiguracion) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
