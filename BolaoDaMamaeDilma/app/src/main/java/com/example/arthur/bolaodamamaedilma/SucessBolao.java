package com.example.arthur.bolaodamamaedilma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class SucessBolao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess_bolao);
        Intent intent = getIntent();
        String nomeActivity = intent.getStringExtra(EnterBolao.NOMEINTENT);
        String dataActivity = intent.getStringExtra(EnterBolao.DATAINTENT);
        Boolean lulaActivity = intent.getExtras().getBoolean(EnterBolao.CHECKLULAINTENT);
        TextView nome_sucess = (TextView) findViewById(R.id.bolaoSucess);
        String lulaPreso;
        if (lulaActivity==true){
            lulaPreso = "Sim";
        }
        else{
            lulaPreso = "Não";
        }
        nome_sucess.setText(SetBolaoContent(nomeActivity, dataActivity, lulaPreso));
    }

    public String SetBolaoContent(String nome, String data, String lula){
        String responseBolaoSucess = "Usuário: " + nome;
        responseBolaoSucess+= "\nData escolhida: " + data;
        responseBolaoSucess+= "\nLula vai ser preso? " + lula;
        return responseBolaoSucess;
    }

}
