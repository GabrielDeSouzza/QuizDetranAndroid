package com.example.quizdetran;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAcertos extends SQLiteOpenHelper {
    private static final String NOME_DB="DBAcertos";
    private static final int VERSION_DB=6;
    public  DBAcertos(Context context){
        super(context,NOME_DB,null,VERSION_DB);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table acerto(_id integer primary key autoincrement," +
                "acertosUser integer not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table acerto;");
        onCreate(db);
    }
}
