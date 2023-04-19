package com.example.calcprojetoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.CalcProjetoInt.R;


public class TelaJurosCompostos extends AppCompatActivity {

    private Spinner MedidaDeTempo;

    private String medidaDeTempoSelecionada;

    int tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_juros_compostos);

        Button botaocalcule = findViewById(R.id.botaocalcule);
        botaocalcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView TextViewResultadoJuros = findViewById(R.id.textViewResultadoJuros);

                EditText editcapital = findViewById(R.id.EditCapital);
                EditText editTaxa = findViewById(R.id.EditTaxa);
                EditText editTempo = findViewById(R.id.EditTempo);

                double capitalInicial = Double.parseDouble(editcapital.getText().toString());
                double taxaJuros = Double.parseDouble(editTaxa.getText().toString()) / 100; // convertendo a taxa de juros para decimal
                int tempo = Integer.parseInt(editTempo.getText().toString());

                if (medidaDeTempoSelecionada.equals("Diario")){
                    double montante = capitalInicial * Math.pow((1 + taxaJuros / 365), tempo);
                    String resultadoFormatoJu = String.format("%.2f", montante);
                    TextViewResultadoJuros.setText("Seu acumulo de juros será de R$" + resultadoFormatoJu);

                } else if (medidaDeTempoSelecionada.equals("Trimestral")) {
                    double montante = capitalInicial * Math.pow((1 + taxaJuros / 4), tempo);
                    String resultadoFormatoJu = String.format("%.2f", montante);
                    TextViewResultadoJuros.setText("Seu acumulo de juros será de R$" + resultadoFormatoJu);

                } else if (medidaDeTempoSelecionada.equals("Anual")) {
                    double montante = capitalInicial * Math.pow((1 + taxaJuros), tempo);
                    String resultadoFormatoJu = String.format("%.2f", montante);
                    TextViewResultadoJuros.setText("Seu acumulo de juros será de R$" + resultadoFormatoJu);
                }


            }
        });
        EditText editTextCapitaç = findViewById(R.id.EditCapital);

        editTextCapitaç.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextCapitaç.setText("");
                }
            }
        });
        EditText editTextTaxa = findViewById(R.id.EditTaxa);

        editTextTaxa.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextTaxa.setText("");
                }
            }
        });
        EditText editTextTempo = findViewById(R.id.EditTempo);

        editTextTempo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextTempo.setText("");
                }
            }
        });

        MedidaDeTempo = findViewById(R.id.spinnerJuros);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[] {"Diario", "Anual", "Trimestral"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MedidaDeTempo.setAdapter(adapter);

        MedidaDeTempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                medidaDeTempoSelecionada= parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                medidaDeTempoSelecionada = "Diario";

            }
        });


    }
}