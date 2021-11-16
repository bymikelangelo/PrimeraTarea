package com.example.primeratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ConversorActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar miToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        //activamos el boton hacia atras en la barra de la aplicación.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}