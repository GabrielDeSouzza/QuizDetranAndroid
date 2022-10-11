package com.example.quizdetran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class TelaPlacaAlfandega extends AppCompatActivity {
    private RadioGroup rdGroupAlfadega;
    private Button btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_placa_alfandega);
        rdGroupAlfadega = findViewById(R.id.rdGroupAlfadega);
        btnConfirmar = findViewById(R.id.btnConfirmar);
    }
    public void onConfirmar(View view){
        int acerto =0;
        if(rdGroupAlfadega.getCheckedRadioButtonId() == R.id.rdAlfadega){
            acerto++;
        }
        Intent it = new Intent(getApplicationContext(), TelaPreferencia.class);
        it.putExtra("acertosUser", acerto);
        startActivity(it);
        finish();
    }
    public void OnRadioButtonClicked(View view){
        btnConfirmar.setEnabled(true);
    }
}