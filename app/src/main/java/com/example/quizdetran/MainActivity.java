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
        private Button btnConfirma;
    private ListView listAcertos, listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConfirma = findViewById(R.id.btnConfirmar);
        listAcertos = findViewById(R.id.listAcertos);
        listData = findViewById(R.id.listData);
        atualizarHistorico();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            atualizarHistorico();
        }
    }
    public void atualizarHistorico(){
        UseDB db = new UseDB(getApplicationContext());

        List<Integer>  list= db.pegarAcertos();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listAcertos.setAdapter(adapter);

        List<String>  list2= db.pegarData();
        ArrayAdapter<String> adapterData = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list2);
        listData.setAdapter(adapterData);
    }
    public void onSair(View view){
        finish();
    }
    public void onIniciar(View view){
        Intent it = new Intent(getApplicationContext(), TelaPlacaAlfandega.class);
        startActivity(it);
    }
    public void onApagarHistorico(View view){
        UseDB useDB = new UseDB(getApplicationContext());
        useDB.deletar();
        finish();
        startActivity(getIntent());
    }
    public void OnRadioButtonClicked(View view){
        btnConfirma.setEnabled(true);
    }
}