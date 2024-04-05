package com.gustavoeufrazio.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextView textViewPorcentagem;
    private SeekBar seekBarGorjeta;
    private TextInputEditText txtValor;
    private EditText txtGorjeta;
    private EditText txtTotal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        txtValor = findViewById(R.id.txtValor);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtTotal = findViewById(R.id.txtTotal);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewPorcentagem.setText(i+"%");
                String textoValor = txtValor.getText().toString();
                /*if(textoValor.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Valor nulo ou inválido", Toast.LENGTH_SHORT);
                }

                 */
                int valor = Integer.parseInt(textoValor);
                int gorjeta = valor*i/100;
                txtGorjeta.setText(String.valueOf(gorjeta));
                txtTotal.setText(String.valueOf(valor+gorjeta));
                //problema resolvido, haja visto a necessidade de usar valueOf() para conversão de tipos
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}