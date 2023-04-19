package com.example.calcprojetoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.CalcProjetoInt.R;

public class tela_taxa_retorno extends AppCompatActivity {

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_taxa_retorno);
        Button botaoCalculeTaxa = findViewById(R.id.botaoCalculeTaxa);
        botaoCalculeTaxa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textViewResultadoTaxa = findViewById(R.id.textViewResultadoTaxa);
                EditText EditValorInicial = findViewById(R.id.EditValorInicial);
                EditText EditValorFinal = findViewById(R.id.EditValorFinal);
                EditText EditPeriodo = findViewById(R.id.EditPeriodo);


                double valorInicial = Double.parseDouble(EditValorInicial.getText().toString());
                double valorFinal = Double.parseDouble(EditValorFinal.getText().toString());
                double Periodo = Double.parseDouble(EditPeriodo.getText().toString());

                double ganho = valorFinal - valorInicial;
                double taxaRetorno = (ganho / valorInicial) / Periodo;
                String resultadoFormato = String.format("%.2f", taxaRetorno * 100);
                textViewResultadoTaxa.setText("Sua taxa de retorno anual é de: %" + resultadoFormato);


            }
        });
        EditText EditValorInicial = findViewById(R.id.EditValorInicial);
        EditValorInicial.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    EditValorInicial.setText("");
                }

            }
        });
        EditText EditValorFinal = findViewById(R.id.EditValorFinal);
        EditValorFinal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    EditValorFinal.setText("");
                }

            }
        });
        EditText EditPeriodo = findViewById(R.id.EditPeriodo);
        EditPeriodo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    EditPeriodo.setText("");
                }

            }
        });
    }
}