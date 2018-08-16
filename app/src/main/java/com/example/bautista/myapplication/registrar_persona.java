package com.example.bautista.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registrar_persona extends AppCompatActivity {

EditText Nombre = (EditText)findViewById(R.id.TxtNombre);
    EditText Email = (EditText)findViewById(R.id.TxtEmail);
    EditText Celular = (EditText)findViewById(R.id.TxtNcelular);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_persona);
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
    }
    public void Registrar(View view){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "BaseDeDatos", null, 1 );
        SQLiteDatabase BaseDeDatos =admin.getReadableDatabase();

        String Nombres= Nombre.getText().toString();
        String CEmail = Email.getText().toString();
        String NCelular= Celular.getText().toString();
        if (!CEmail.isEmpty() && !Nombres.isEmpty() && !NCelular.isEmpty()){
            ContentValues Registro = new ContentValues();
            Registro.put("Email",CEmail);
            Registro.put("Nombre", Nombres);
            Registro.put("Telefono", NCelular);
            BaseDeDatos.insert("Empleado",null, Registro);
            BaseDeDatos.close();
            Nombre.setText("");
            Celular.setText("");
            Email.setText("");
            Toast.makeText(this,"Registro Realizado con exito :v", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    public void Buscar(View view){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "BaseDeDatos", null, 1 );
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String Nombres= Nombre.getText().toString();
        String CEmail = Email.getText().toString();
        String NCelular= Celular.getText().toString();

        if (!CEmail.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select Email,Telefono from Usuario where Nombre="+Nombres, null);
            if (fila.moveToFirst()){
                Email.setText(fila.getString(0));
                Celular.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this,"No existe un usuario con este Nombre", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this,"debes especificasr el nombre para buscar usuarios", Toast.LENGTH_SHORT).show();
        }
    }


    public void eliminar (View view){
        adminSQLiteOpenHelper admin = new adminSQLiteOpenHelper(this, "BaseDeDatos", null, 1 );
        SQLiteDatabase base = admin.getWritableDatabase();
        String Nombres= Nombre.getText().toString();
        String CEmail = Email.getText().toString();
        String NCelular= Celular.getText().toString();
        if (!Nombres.isEmpty()){
            int cantidad = base.delete("Usuario","Nombre="+Nombres,null);
            base.close();
            Nombre.setText("");
            Celular.setText("");
            Email.setText("");
            if (cantidad>0){
                Toast.makeText(this,"El usuario ha sido eliminado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Este men no existe :'v", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes especificar el nombre", Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar (View view){
        adminSQLiteOpenHelper Admin = new adminSQLiteOpenHelper(this, "BaseDeDatos", null, 1 );
        SQLiteDatabase Base = Admin.getWritableDatabase();
        String Nombres= Nombre.getText().toString();
        String CEmail = Email.getText().toString();
        String NCelular= Celular.getText().toString();

        if (!CEmail.isEmpty() && !Nombres.isEmpty() && !NCelular.isEmpty()){
            ContentValues Registro = new ContentValues();
            Registro.put("Email",CEmail);
            Registro.put("Nombre", Nombres);
            Registro.put("Telefono", NCelular);
            int cantidad = Base.update("Usuario", Registro, "Nombre="+Nombres, null);
            Base.close();
            if (cantidad>0){
                Toast.makeText(this,"Se ha actualizado el usuario", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Este men no existe :'v", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes especificar el nombre", Toast.LENGTH_SHORT).show();
        }

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
