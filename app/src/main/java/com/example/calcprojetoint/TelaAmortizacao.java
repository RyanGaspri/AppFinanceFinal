package com.example.calcprojetoint;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.CalcProjetoInt.R;

public class TelaAmortizacao extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_amortizacao);
        Button botaoCalculeAmortizacao = findViewById(R.id.botaoCalculeAmortizacao);
        botaoCalculeAmortizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView TextViewResultadoAmortizacao = findViewById(R.id.TextViewResultadoAmortizacao);
                EditText Edittextemprestimo = findViewById(R.id.Edittextemprestimo);
                EditText Edittetextjuros =  findViewById(R.id.EditextJurosJuros);
                EditText EdittetextNumeroPagamento = findViewById(R.id.EdittextNumeroPagamento);
                double valorEmprestimo = Double.parseDouble(Edittextemprestimo.getText().toString());
                double valorJuros = Double.parseDouble(Edittetextjuros.getText().toString());
                double numPagamentos = Double.parseDouble(EdittetextNumeroPagamento.getText().toString());
                double porcentagem = valorJuros/100;
                double taxaAmortizacao = (valorEmprestimo * porcentagem * Math.pow(1 + porcentagem, numPagamentos)) / (Math.pow(1 + porcentagem, numPagamentos) - 1);
                String resultadoFormato = String.format("%.2f", taxaAmortizacao);
                TextViewResultadoAmortizacao.setText("Sua taxa de amortização é de: R$" + resultadoFormato);


            }
        });
        EditText Edittextemprestimo = findViewById(R.id.Edittextemprestimo);
        Edittextemprestimo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    Edittextemprestimo.setText("");

                }
            }
        });
        EditText Edittetextjuros =  findViewById(R.id.EditextJurosJuros);
        Edittetextjuros.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    Edittetextjuros.setText("");
                }
            }
        });
        EditText EdittetextNumeroPagamento = findViewById(R.id.EdittextNumeroPagamento);
        EdittetextNumeroPagamento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    EdittetextNumeroPagamento.setText("");
                }

            }
        });


    }

}