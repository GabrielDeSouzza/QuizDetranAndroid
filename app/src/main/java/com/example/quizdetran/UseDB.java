package com.example.quizdetran;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UseDB {
    private SQLiteDatabase db;
    public  UseDB(Context context){
        DBAcertos dbAcertos= new DBAcertos(context);
        db = dbAcertos.getWritableDatabase();
    }
    public void Inserir(Acertos acertos){
        ContentValues contentValues = new ContentValues();
        contentValues.put("acertosUser", acertos.getAcertos());
        db.insert("acerto", null, contentValues);
    }
    public void deletar(){
        db.execSQL("drop table acerto");
    }
    public List<Integer> pegarDados(){
        List<Integer> listAcertos = new ArrayList<Integer>();
        String[] colunas = new String[]{"acertosUser"};
        Cursor cursor = db.query("acerto", colunas, null,null, null,null,null);
        if(cursor.getCount() >0){
            cursor.moveToFirst();
            do{
                Acertos acertos = new Acertos();
                acertos.setAcertos( cursor.getInt(0));
                listAcertos.add(acertos.getAcertos());
            }
            while (cursor.moveToNext());
        }
        return listAcertos;
    }
}
