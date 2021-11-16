package com.example.primeratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar miToolbar;
    TextView textDescrAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);

        textDescrAct = findViewById(R.id.textDescrAct);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.removeItem(R.id.menuMain);
        MenuItem item = findViewById(R.id.menuMain);
        return true;
    }

    public void verDescripcion (View vista) {
        switch (vista.getId()) {
            case R.id.botonDNI:
                textDescrAct.setText(R.string.descripcion_dni);
                break;
            case R.id.botonConv:
                textDescrAct.setText(R.string.descripcion_conversor);
                break;
            case R.id.botonImages:
                textDescrAct.setText(R.string.descripcion_imagenes);
                break;
        }
    }

    public void irAActivity (MenuItem item) {
        Intent intencion;
        switch (item.getItemId()) {
            case R.id.menuDNI:
                intencion = new Intent(this, DNIActivity.class);
                startActivity(intencion);
                break;
            case R.id.menuConversor:
                intencion = new Intent(this, ConversorActivity.class);
                startActivity(intencion);
                break;
            case R.id.menuImages:
                intencion = new Intent(this, ImagesActivity.class);
                startActivity(intencion);
                break;
        }
    }
}