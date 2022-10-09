package com.example.quizdetran;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnInicar, btnSair;
    private ListView listAcertos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInicar = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);
        listAcertos = findViewById(R.id.listAcertos);
        UseDB db = new UseDB(getApplicationContext());
        List<Integer>  list= db.pegarDados();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listAcertos.setAdapter(adapter);
    }
    public void onSair(View view){
        finish();
    }
    public void onIniciar(View view){
        Intent it = new Intent(getApplicationContext(), TelaPlacaAlfandega.class);
        startActivity(it);
    }
}