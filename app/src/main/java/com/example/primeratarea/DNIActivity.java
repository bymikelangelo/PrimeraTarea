package com.example.primeratarea;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DNIActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar miToolbar;
    EditText editDNINum, editDNILetra;
    TextView textValidate;
    ImageView imageValidate;
    Button botonBorrar, botonValidar;
    int numeroDNI;
    String letraDNI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni);

        miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        //activamos el boton hacia atras en la barra de la aplicación.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editDNINum = findViewById(R.id.editDNINum);
        editDNILetra = findViewById(R.id.editDNILetra);
        textValidate = findViewById(R.id.textValidate);
        imageValidate = findViewById(R.id.imageValidate);
        botonBorrar = findViewById(R.id.botonBorrar);
        botonValidar = findViewById(R.id.botonValidar);
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

    public void clickBorrar(View vista) {
        editDNILetra.setText("");
        editDNINum.setText("");
        imageValidate.setImageBitmap(null);
        textValidate.setText("");
    }

    public void clickValidar(View vista) {
        if (comprobarDatos())
            validarDNI();
    }

    public boolean comprobarDatos() {
        boolean esCorrecto = false;
        if (editDNINum.getText().length() < 8)
            Toast.makeText(this, "Debes introducir 8 carácteres numéricos.", Toast.LENGTH_SHORT).show();
        else if (String.valueOf(editDNILetra.getText()).equals(""))
            Toast.makeText(this, "Debes introducir una letra.", Toast.LENGTH_SHORT).show();
        else {
            char caracter = editDNILetra.getText().charAt(0);
            if ((caracter >= 'A' & caracter <= 'Z') || (caracter >= 'a' & caracter <= 'Z'))
                Toast.makeText(this, "Debes introducir una letra válida.", Toast.LENGTH_SHORT).show();
            else {
                numeroDNI = Integer.parseInt(String.valueOf(editDNINum.getText()));
                letraDNI = String.valueOf(editDNILetra.getText());
                esCorrecto = true;
            }
        }
        return esCorrecto;
    }

    public void validarDNI() {
        int resto = numeroDNI % 23;
        String letraValida;
        switch (resto) {
            case 0:
                letraValida = "T";
                break;
            case 1:
                letraValida = "R";
                break;
            case 2:
                letraValida = "W";
                break;
            case 3:
                letraValida = "A";
                break;
            case 4:
                letraValida = "G";
                break;
            case 5:
                letraValida = "M";
                break;
            case 6:
                letraValida = "Y";
                break;
            case 7:
                letraValida = "F";
                break;
            case 8:
                letraValida = "P";
                break;
            case 9:
                letraValida = "D";
                break;
            case 10:
                letraValida = "X";
                break;
            case 11:
                letraValida = "B";
                break;
            case 12:
                letraValida = "N";
                break;
            case 13:
                letraValida = "J";
                break;
            case 14:
                letraValida = "Z";
                break;
            case 15:
                letraValida = "S";
                break;
            case 16:
                letraValida = "Q";
                break;
            case 17:
                letraValida = "V";
                break;
            case 18:
                letraValida = "H";
                break;
            case 19:
                letraValida = "L";
                break;
            case 20:
                letraValida = "C";
                break;
            case 21:
                letraValida = "K";
                break;
            case 22:
                letraValida = "E";
                break;
            default:
                letraValida = "";
        }
        if (letraValida == "") {
            Toast.makeText(this, "Fallo en la validación. Introduce otro número.", Toast.LENGTH_SHORT).show();
        }
        else if (letraDNI.toUpperCase().equals(letraValida)) {
            imageValidate.setImageResource(R.drawable.tick);
            textValidate.setText("DNI válido");
        }
        else {
            imageValidate.setImageResource(R.drawable.cross);
            textValidate.setText("Letra no válida. La correcta sería: " + letraValida);
        }
    }
}