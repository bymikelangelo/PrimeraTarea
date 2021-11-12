package com.example.primeratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DNIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni);

        androidx.appcompat.widget.Toolbar miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.removeItem(R.id.menuDNI);
        return true;
    }

    public void irAActivity (MenuItem item) {
        Intent intencion;
        switch (item.getItemId()) {
            case R.id.menuMain:
                intencion = new Intent(this, MainActivity.class);
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