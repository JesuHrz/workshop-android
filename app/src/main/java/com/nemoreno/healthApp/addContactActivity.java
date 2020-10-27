package com.nemoreno.healthApp;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.nemoreno.healthApp.Modelos.recordContract;
import com.nemoreno.healthApp.Modelos.recordDBHelper;

public class addContactActivity extends AppCompatActivity {
    EditText etNombre, etApellido,etBarrio, etTelefono;
    Button ingresarButton, dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_contact);
        dateButton = findViewById(R.id.dateButton);
        etNombre = findViewById(R.id.etNombre);
        etBarrio = findViewById(R.id.etBarrio);
        etApellido = findViewById(R.id.etSistolico);
        etTelefono = findViewById(R.id.etDistolico);
        ingresarButton = findViewById(R.id.ingresarButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        ingresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noEmpty();

            }
        });
    }

    private void registrarUsuario() {
        recordDBHelper conexion = new recordDBHelper(this, "bd_registros", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues values = new ContentValues();
        Log.e("LOGGG", "EL BARRIO: "+etBarrio.getText().toString());
        Log.e("LOGGG", "EL NOMBRE: "+etNombre.getText().toString());
        values.put(recordContract.NOMBRE, etNombre.getText().toString());
        values.put(recordContract.BARRIO, etBarrio.getText().toString());
        values.put(recordContract.SISTOLICO, etApellido.getText().toString());
        values.put(recordContract.DISTOLICO, etTelefono.getText().toString());
        values.put(recordContract.DATE, dateButton.getText().toString());
        long idResultado = db.insert(recordContract.TABLE_NAME, null, values);
        Toast.makeText(this, "Id registro: " + idResultado, Toast.LENGTH_SHORT).show();
        db.close();
        this.finish();
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month + 1) + " / " + year;
                dateButton.setText(selectedDate);

            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void noEmpty() {
        if (TextUtils.isEmpty(etApellido.getText().toString())) {
            etApellido.setError("No hay Sistolico");
            return;
        }
        if (TextUtils.isEmpty(etTelefono.getText().toString())) {
            etTelefono.setError("No hay Distolico");
            return;
        }
        if (Float.parseFloat(etTelefono.getText().toString())>=Float.parseFloat(etApellido.getText().toString())){
            etTelefono.setError("El Diastolico tiene que ser menor al Sistolico");
            return;
        }
        if (Float.parseFloat(etTelefono.getText().toString())<0){
            etTelefono.setError("El Diastolico no puede ser negativo");
            return;
        }
        if (0>Float.parseFloat(etApellido.getText().toString())){
            etApellido.setError("El sistolico no puede ser negativo");
            return;
        }
        if (TextUtils.isEmpty(etNombre.getText().toString())) {
            etNombre.setError("No hay nombre");
            return;
        }
        if (TextUtils.isEmpty(etBarrio.getText().toString())) {
            etBarrio.setError("No hay barrio");
            return;
        }

        if (TextUtils.isEmpty(dateButton.getText().toString())) {
            dateButton.setError("No hay Fecha");
            return;
        }

        registrarUsuario();
    }
}
