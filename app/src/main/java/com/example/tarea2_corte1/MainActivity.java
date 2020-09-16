package com.example.tarea2_corte1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;

import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    EditText employee_input, salary_input, extra_hour_input, value_hour_input, pension_input, health_input, total_salary_input;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employee_input = findViewById(R.id.employee_input);
        salary_input = findViewById(R.id.salary_input);
        extra_hour_input = findViewById(R.id.extra_hour_input);
        value_hour_input = findViewById(R.id.value_hour_input);
        pension_input = findViewById(R.id.pension_input);
        health_input = findViewById(R.id.health_input);
        total_salary_input = findViewById(R.id.total_salary_input);

        calculate = findViewById(R.id.calculate);


        pension_input.setEnabled(false);
        health_input.setEnabled(false);
        total_salary_input.setEnabled(false);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.calculate:
                this.handleCalculate();
                break;
        }
    }

    public void handleCalculate (){
        int salary_input = Integer.valueOf(this.salary_input.getText().toString());
        int extra_hour_input = Integer.valueOf(this.extra_hour_input.getText().toString());
        int value_hour_input = Integer.valueOf(this.value_hour_input.getText().toString());

        int total = salary_input + (extra_hour_input * value_hour_input);
        int pension = (int) (total * 0.04);
        int health = (int) (total * 0.04);

        pension_input.setText(String.valueOf(pension));
        health_input.setText(String.valueOf(health));
        total_salary_input.setText(String.valueOf(total));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clean:
                clean();
                break;
            case R.id.min_salary:
                clean();
                salary_input.setText("877803");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void clean (){
        employee_input.setText("");
        salary_input.setText("");
        extra_hour_input.setText("");
        value_hour_input.setText("");
        pension_input.setText("");
        health_input.setText("");
        total_salary_input.setText("");
    }

}