package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ingresar, cancelar, boton1, boton2;
    EditText usuario, clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.edtusuario);
        clave = findViewById(R.id.edtclave);

        ingresar = findViewById(R.id.btningresar);
        cancelar = findViewById(R.id.btncancelar);
        boton1 = findViewById(R.id.prueba1);
        boton2 = findViewById(R.id.prueba2);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(usuario.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Usuario invalido", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                    i.putExtra("Usuario", usuario.getText().toString());
                    startActivity(i);
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                clave.setText("");
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.prueba1:
                Toast.makeText(getApplicationContext(), "Boton prueba 1", Toast.LENGTH_LONG).show();
                break;

            case R.id.prueba2:
                Toast.makeText(getApplicationContext(), "Boton prueba 2", Toast.LENGTH_LONG).show();
                break;

        }
    }
}