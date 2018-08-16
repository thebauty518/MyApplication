package com.example.bautista.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class adminSQLiteOpenHelper extends SQLiteOpenHelper {
    public adminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table Categorias(QueVisitar,DondeDormir,DondeComer,QueHacer,ServiciosTuristicos,Llamadas)");
        BaseDeDatos.execSQL("Create table TiposItems(Museos, Monumentos, Parques, ZonadeCamping, Hoteles, Heladerías, Restaurantes, Guías Turísticos, Transporte, Droguería, Policía)");
        BaseDeDatos.execSQL("create table Items(Nombre,Descripcion,Direccion,Telefono,Web,Email,TipoItem)");
        BaseDeDatos.execSQL("create table Usuario(Nombre,Telefono,Email)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
