package com.example.primeratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ConversorActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar miToolbar;

    EditText editCantidad;
    Spinner spinnerUnidades;
    TextView textResultado1, textResultado2, textResultado3, textResultado4, textResultado5, textAdvertencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        //activamos el boton hacia atras en la barra de la aplicación.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editCantidad = findViewById(R.id.editCantidad);
        editCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hallarResultados(s.toString());
            }
        });
        spinnerUnidades = findViewById(R.id.spinnerUnidades);
        spinnerUnidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hallarResultados(editCantidad.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        textResultado1 = findViewById(R.id.textResultado1);
        textResultado2 = findViewById(R.id.textResultado2);
        textResultado3 = findViewById(R.id.textResultado3);
        textResultado4 = findViewById(R.id.textResultado4);
        textResultado5 = findViewById(R.id.textResultado5);
        textAdvertencia = findViewById(R.id.textAdvertecia);

    }

    public void hallarResultados(String texto) {
        if (texto.equals("")) {
            textAdvertencia.setText("Debes introducir un número");
            textResultado1.setText("");
            textResultado2.setText("");
            textResultado3.setText("");
            textResultado4.setText("");
            textResultado5.setText("");
        }
        else {
            textAdvertencia.setText("");
            double cantidad = Double.parseDouble(texto);
            switch (spinnerUnidades.getSelectedItemPosition()) {
                case 0:  //calculamos metros
                    textResultado1.setText(cantidad * 0.001 + " kilometros");
                    textResultado2.setText(cantidad * 100 + " centimetros");
                    textResultado3.setText(cantidad * 0.000621371 + " millas");
                    textResultado4.setText(cantidad * 3.28084 + " pies");
                    textResultado5.setText(cantidad * 39.3701 + " pulgadas");
                    break;
                case 1:  //calculamos kilometros
                    textResultado1.setText(cantidad * 1000 + " metros");
                    textResultado2.setText(cantidad * 100000 + " centimetros");
                    textResultado3.setText(cantidad * 0.621371 + " millas");
                    textResultado4.setText(cantidad * 3280.84 + " pies");
                    textResultado5.setText(cantidad * 39370.1 + " pulgadas");
                    break;
                case 2:  //calculamos centimetros
                    textResultado1.setText(cantidad * 0.01 + " metros");
                    textResultado2.setText(cantidad * 0.00001 + " kilometros");
                    textResultado3.setText(cantidad * 0.00000621371 + " millas");
                    textResultado4.setText(cantidad * 3.28084 + " pies");
                    textResultado5.setText(cantidad * 39.3701 + " pulgadas");
                    break;
                case 3:  //calculamos millas
                    textResultado1.setText(cantidad * 1609.34 + " metros");
                    textResultado2.setText(cantidad * 1.60934 + " kilometros");
                    textResultado3.setText(cantidad * 160934 + " centimetros");
                    textResultado4.setText(cantidad * 5280 + " pies");
                    textResultado5.setText(cantidad * 63360 + " pulgadas");
                    break;
                case 4:  //calculamos pies
                    textResultado1.setText(cantidad * 0.3048 + " metros");
                    textResultado2.setText(cantidad * 0.0003048 + " kilometros");
                    textResultado3.setText(cantidad * 30.48 + " centimetros");
                    textResultado4.setText(cantidad * 0.000189394 + " millas");
                    textResultado5.setText(cantidad * 12 + " pulgadas");
                    break;
                case 5:  //calculamos pulgadas
                    textResultado1.setText(cantidad * 0.0254 + " metros");
                    textResultado2.setText(cantidad * 2.54e-5 + " kilometros");
                    textResultado3.setText(cantidad * 2.54 + " centimetros");
                    textResultado4.setText(cantidad * 1.5783e-5 + " millas");
                    textResultado5.setText(cantidad * 0.0833333 + " pies");
                    break;
            }
        }
    }
}