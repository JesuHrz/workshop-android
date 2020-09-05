package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertir, longitud;
    ToggleButton toggleButton;
    CheckBox edtmaymin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);
        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertir = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);
        toggleButton = findViewById(R.id.toggleButton);
        edtmaymin = findViewById(R.id.edtmaymin);

        longitud.setOnClickListener(this);
        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
               }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"P1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<00){
                            Toast.makeText(getApplicationContext(),"P1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

        vocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
                }
                else {
                    String textOne = removeVowels(p1.getText().toString());
                    String textTwo = removeVowels(p2.getText().toString());
                    p1.setText(textOne);
                    p2.setText(textTwo);
                }
            }
        });


        invertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
            }
            else {
                new StringBuilder();
                String textOne = p1.getText().toString();
                String textTwo = p2.getText().toString();
                String offsetTextOne = "";
                String offsetTextTwo = "";

                for (int i = textOne.length() - 1; i >= 0; i--) {
                    offsetTextOne = offsetTextOne + String.valueOf(textOne.charAt(i));
                }

                for (int i = textTwo.length() - 1; i >= 0; i--) {
                    offsetTextTwo = offsetTextTwo + String.valueOf(textTwo.charAt(i));
                }

                p1.setText(offsetTextOne);
                p2.setText(offsetTextTwo);
            }
            }
        });


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!toggleButton.isChecked()){
                    mayor.setEnabled(true);
                    vocal.setEnabled(true);
                    invertir.setEnabled(true);
                    longitud.setEnabled(true);
                }
                else {
                    mayor.setEnabled(false);
                    vocal.setEnabled(false);
                    invertir.setEnabled(false);
                    longitud.setEnabled(false);
                }
            }
        });

        edtmaymin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textOne = p1.getText().toString();
                String textTwo = p2.getText().toString();

                if (edtmaymin.isChecked()){
                    p1.setText(textOne.toUpperCase());
                    p2.setText(textTwo.toUpperCase());
                }
                else {
                    p1.setText(textOne.toLowerCase());
                    p2.setText(textTwo.toLowerCase());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
                                  int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"L1=" + l1 + " L2=" + l2, Toast.LENGTH_LONG).show();
                 break;
            case R.id.btninvertir:
                 break;

            case R.id.btnvocales:
                break;
        }
    }

    public String removeVowels(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }


}
