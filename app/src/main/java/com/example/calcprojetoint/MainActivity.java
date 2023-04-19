package com.example.calcprojetoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

import com.example.CalcProjetoInt.R;


public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.bt_conversor);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),telaconversao.class);
                startActivity(intent);
            }
        });
        imageButton = findViewById(R.id.botaojuros);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TelaJurosCompostos.class);
                startActivity(intent);
            }
        });

        imageButton = findViewById(R.id.botaoamortizacao);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TelaAmortizacao.class);
                startActivity(intent);
            }
        });

        imageButton = findViewById(R.id.botaotaxa);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tela_taxa_retorno.class);
                startActivity(intent);
            }
        });






    }
}