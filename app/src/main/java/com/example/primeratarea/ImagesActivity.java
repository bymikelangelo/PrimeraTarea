package com.example.primeratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

public class ImagesActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar miToolbar;
    ImageView imagenLogo, imagenPersonaje;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        //activamos el boton hacia atras en la barra de la aplicación.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imagenLogo = findViewById(R.id.imagenLogo);
        imagenLogo.setImageResource(R.drawable.logo);
        imagenPersonaje = findViewById(R.id.imagenPersonaje);
        imagenPersonaje.setImageResource(R.drawable.mario);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        imagenPersonaje.setImageResource(R.drawable.mario);
                        break;
                    case 1:
                        imagenPersonaje.setImageResource(R.drawable.luigi);
                        break;
                    case 2:
                        imagenPersonaje.setImageResource(R.drawable.peach);
                        break;
                    case 3:
                        imagenPersonaje.setImageResource(R.drawable.toad);
                        break;
                    case 4:
                        imagenPersonaje.setImageResource(R.drawable.yoshi);
                        break;
                    case 5:
                        imagenPersonaje.setImageResource(R.drawable.rosalina);
                        break;
                    case 6:
                        imagenPersonaje.setImageResource(R.drawable.bowser);
                        break;
                    case 7:
                        imagenPersonaje.setImageResource(R.drawable.wario);
                        break;
                    case 8:
                        imagenPersonaje.setImageResource(R.drawable.diddykong);
                        break;
                    case 9:
                        imagenPersonaje.setImageResource(R.drawable.donkeykong);
                        break;
                    default:
                        imagenPersonaje.setImageResource(R.drawable.mario);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.removeItem(R.id.menuImages);
        return true;
    }

    public void irAActivity (MenuItem item) {
        Intent intencion;
        switch (item.getItemId()) {
            case R.id.menuMain:
                intencion = new Intent(this, MainActivity.class);
                startActivity(intencion);
                break;
            case R.id.menuNIF:
                intencion = new Intent(this, NIFActivity.class);
                startActivity(intencion);
                break;
            case R.id.menuConversor:
                intencion = new Intent(this, ConversorActivity.class);
                startActivity(intencion);
                break;
        }
    }
}