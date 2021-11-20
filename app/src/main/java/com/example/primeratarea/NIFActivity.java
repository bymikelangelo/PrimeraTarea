package com.example.primeratarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NIFActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar miToolbar;
    EditText editNIF;
    TextView textValidate, textInfomativo;
    ImageView imageValidate;
    Button botonBorrar, botonValidar;
    int numeroNIF;
    String letraNIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nif);

        miToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(miToolbar);
        //activamos el boton hacia atras en la barra de la aplicación.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editNIF = findViewById(R.id.editNIF);
        editNIF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int caracteresRestantes = 9 - s.length();
                if (s.length() == 0) {
                    textInfomativo.setTextColor(getColor(R.color.black));
                    textInfomativo.setText(R.string.informativo_default);
                }
                else {
                    char caracter = s.charAt(0);
                    if ((caracter == 'Y') || (caracter == 'y') || (caracter == 'X') || (caracter == 'x')
                            || (caracter == 'Z') || (caracter == 'z')) {
                        textInfomativo.setTextColor(getColor(R.color.black));
                        if (caracteresRestantes == 0)
                            textInfomativo.setText(R.string.informativo_nie_validar);
                        else {
                            //textInfomativo.setText(R.string.informativo_nie_restantes + caracteresRestantes);
                            textInfomativo.setText("Estás escribiendo un NIE. Carácteres restantes: " + caracteresRestantes);
                        }
                    }
                    else if (caracter >= '0' & caracter <= '9') {
                        textInfomativo.setTextColor(getColor(R.color.black));
                        if (caracteresRestantes == 0)
                            textInfomativo.setText(R.string.informativo_dni_validar);
                        else {
                            //textInfomativo.setText(R.string.informativo_dni_restantes + caracteresRestantes);
                            textInfomativo.setText("Estás escribiendo un DNI. Carácteres restantes: " + caracteresRestantes);
                        }
                    }
                    else {
                        textInfomativo.setTextColor(getColor(R.color.design_default_color_error));
                        textInfomativo.setText(R.string.informativo_fallo);
                    }
                }
            }
        });
        textInfomativo = findViewById(R.id.textInformativo);
        textValidate = findViewById(R.id.textValidate);
        imageValidate = findViewById(R.id.imageValidate);
        botonBorrar = findViewById(R.id.botonBorrar);
        botonValidar = findViewById(R.id.botonValidar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.removeItem(R.id.menuNIF);
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
        editNIF.setText("");
        textInfomativo.setText(R.string.informativo_default);
        imageValidate.setImageBitmap(null);
        textValidate.setText("");
    }

    public void clickValidar(View vista) {
        if (comprobarDatos())
            validarDNI();
    }

    public boolean comprobarDatos() {
        if ((String.valueOf(editNIF.getText()).equals("") || editNIF.getText().length() < 9))
            Toast.makeText(this, R.string.toast_nif_fallo_1, Toast.LENGTH_SHORT).show();
        else {
            String cadenaNumeroNIF = "";
            for (int i = 0; i < editNIF.getText().length(); i++) {
                char caracter = editNIF.getText().charAt(i);
                if (i == 0) {
                    if ((caracter == 'X') || (caracter == 'x'))
                        cadenaNumeroNIF = cadenaNumeroNIF + "0";
                    else if ((caracter == 'Y') || (caracter == 'y'))
                        cadenaNumeroNIF = cadenaNumeroNIF + "1";
                    else if ((caracter == 'Z') || (caracter == 'z'))
                        cadenaNumeroNIF = cadenaNumeroNIF + "2";
                    else if (caracter >= '0' & caracter <= '9')
                        cadenaNumeroNIF = cadenaNumeroNIF + caracter;
                    else {
                        Toast.makeText(this, R.string.toast_nif_fallo_2, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
                else if (i == 8) {
                    if ((caracter >= 'A' & caracter <= 'Z') || (caracter >= 'a' & caracter <= 'z')) {
                        letraNIF = String.valueOf(caracter);
                        numeroNIF = Integer.parseInt(cadenaNumeroNIF);
                        return true;
                    }
                    else {
                        Toast.makeText(this, R.string.toast_nif_fallo_3, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
                else {
                    if (caracter >= '0' & caracter <= '9') {
                        cadenaNumeroNIF = cadenaNumeroNIF + caracter;
                    }
                    else {
                        Toast.makeText(this, R.string.toast_nif_fallo_4, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void validarDNI() {
        int resto = numeroNIF % 23;
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
            Toast.makeText(this, R.string.toast_nif_fallo_5, Toast.LENGTH_SHORT).show();
        }
        else if (letraNIF.toUpperCase().equals(letraValida)) {
            imageValidate.setImageResource(R.drawable.tick);
            textValidate.setText(R.string.validate_si);
        }
        else {
            imageValidate.setImageResource(R.drawable.cross);
            //textValidate.setText(R.string.validate_no + letraValida);
            textValidate.setText("Letra no válida. La correcta sería: " + letraValida);
        }
    }
}