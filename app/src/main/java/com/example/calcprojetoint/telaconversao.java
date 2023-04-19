package com.example.calcprojetoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.CalcProjetoInt.R;

public class telaconversao extends AppCompatActivity {

    private boolean RealParaDolar = true;
    private boolean RealParaIene = true;
    private boolean RealParaDolarAus = true;
    private boolean RealParaFrancoSuiço = true;
    private boolean RealParaLibra = true;
    private boolean RealParaEuro = true;
    private boolean RealParamoeda = true;

    private Spinner spinnerMoeda;

    private String moedaSelecionada = "Dolar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaconversao);

        Button botaoCalcular = findViewById(R.id.BotaoCalcular);
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextReal = findViewById(R.id.editTextDolar);
                TextView textViewResultado = findViewById(R.id.textViewResultado);

                double valor = Double.parseDouble(editTextReal.getText().toString());
                double resultado;

                switch (moedaSelecionada){
                    case "Dólar":
                    if (RealParaDolar){
                        resultado = valor * 5.6;
                        textViewResultado.setText("O valor convertido em reais é: R$" + resultado);
                    }else {
                        resultado = valor / 5.6;
                        String resultadoFormato = String.format("%.2f", resultado);
                        textViewResultado.setText("O valor convertido em dolares é: $" + resultadoFormato);
                    }
                    break;
                    case "Euro":
                        if(RealParaEuro){
                            resultado = valor * 5.42;
                            textViewResultado.setText("O valor convertido em reais é: R$" + resultado);
                        }else{
                            resultado = valor / 5.42;
                            String resultadoFormato = String.format("%.2f", resultado);
                            textViewResultado.setText("O valor convertido em Euro é: " + resultadoFormato);
                        }
                        break;
                    case "Iene":
                        if (RealParaIene){
                            resultado = valor * 0.037;
                            textViewResultado.setText("O valor convertido em reais é: " + resultado);
                        }else{
                            resultado = valor / 0.037;
                            String resultadoFormato = String.format("%.2f", resultado);
                            textViewResultado.setText("O valor convertido em Iene é: " + resultadoFormato);
                        }
                        break;
                    case "Dólar Australiano":
                        if (RealParaDolarAus){
                            resultado = valor * 3.32;
                            textViewResultado.setText("O valor convertido em reais é: " + resultado);
                        }else{
                            resultado = valor / 3.32;
                            String resultadoFormato = String.format("%.2f", resultado);
                            textViewResultado.setText("O valor convertido em Dolar Aus. é: $" + resultadoFormato);
                        }
                        break;
                    case "Franco Suiço":
                        if (RealParaFrancoSuiço){
                            resultado = valor * 5.53;
                            textViewResultado.setText("O valor convertido em reais é: " + resultado);
                        }else {
                            resultado = valor / 5.53;
                            String resultadoFormato = String.format("%.2f", resultado);
                            textViewResultado.setText("O valor convertido em Franco suiço é: " + resultadoFormato);
                        }
                        break;
                    case "Libra esterlina":
                        if (RealParaLibra){
                            resultado = valor * 6.15;
                            textViewResultado.setText("O valor convertido em reais é: " + resultado);
                        }else {
                            resultado = valor / 6.15;
                            String resultadoFormato = String.format("%.2f", resultado);
                            textViewResultado.setText("O valor convertido em Libra esterlina é: " + resultadoFormato);
                        }
                }
            }
        });
        Button botaoInverter = findViewById(R.id.botaoInverter);
        botaoInverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealParamoeda = !RealParamoeda;

                TextView textViewResultado = findViewById(R.id.textViewResultado);
                if (RealParamoeda){
                    textViewResultado.setText("Real para " + moedaSelecionada);
                }else {
                    textViewResultado.setText(moedaSelecionada + " para real");
                }

                switch (moedaSelecionada){
                    case "Dólar":
                        RealParaDolar = RealParamoeda;
                        break;
                    case "Dólar Australiano":
                        RealParaDolarAus = RealParamoeda;
                    case "Iene":
                        RealParaIene = RealParamoeda;
                        break;
                    case "Franco Suiço":
                        RealParaFrancoSuiço = RealParamoeda;
                        break;
                    case "Euro":
                        RealParaEuro = RealParamoeda;
                        break;
                    case "Libra esterlina":
                        RealParaLibra = RealParamoeda;
                        break;
                    default:
                        // código caso ocorra algum erro na seleção da moeda
                        break;
                }
            }
        });
        spinnerMoeda = findViewById(R.id.spinnerMoedas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.moedas_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerMoeda.setAdapter(adapter);

        spinnerMoeda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moedaSelecionada = parent.getItemAtPosition(position).toString();

                TextView textViewResultado = findViewById(R.id.textViewResultado);
                if (RealParamoeda){
                    textViewResultado.setText("Real para " + moedaSelecionada);
                }else {
                    textViewResultado.setText(moedaSelecionada + "para real");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ImageButton imageButton = findViewById(R.id.MoedaSite);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://abraofilho.blog.br/moedas-mais-valorizadas-do-mundo-descubra-as-principais/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}