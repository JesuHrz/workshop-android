package co.edu.unimagdalena.apmoviles.tallertabletlistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bmas,bmenos,bpor,bdiv,bsqrt,binv,bc,bigual;
    EditText dato;
    long acum=0;
    boolean operador = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(this);
        b1= findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2= findViewById(R.id.b2);   b2.setOnClickListener(this);
        b3= findViewById(R.id.b3);   b3.setOnClickListener(this);
        b4= findViewById(R.id.b4);   b4.setOnClickListener(this);
        b5= findViewById(R.id.b5);    b5.setOnClickListener(this);
        b6= findViewById(R.id.b6);  b6.setOnClickListener(this);
        b7= findViewById(R.id.b7);  b7.setOnClickListener(this);
        b8= findViewById(R.id.b8);  b8.setOnClickListener(this);
        b9= findViewById(R.id.b9);  b9.setOnClickListener(this);
        bmas= findViewById(R.id.bmas);   bmas.setOnClickListener(this);
        bmenos= findViewById(R.id.bmenos);   bmenos.setOnClickListener(this);
        bpor= findViewById(R.id.bpor);    bpor.setOnClickListener(this);
        bdiv= findViewById(R.id.bdiv);    bdiv.setOnClickListener(this);
        bsqrt= findViewById(R.id.bsqrt);    bsqrt.setOnClickListener(this);
        binv= findViewById(R.id.binv);    binv.setOnClickListener(this);
        bigual= findViewById(R.id.bigual);   bigual.setOnClickListener(this);
        bc= findViewById(R.id.bc);    bc.setOnClickListener(this);
        dato= findViewById(R.id.edtdato);
       // dato.setText("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        String valor;
        long num=0;
          if(!TextUtils.isEmpty(dato.getText().toString())) {
              num = Integer.parseInt(dato.getText().toString());
              valor=dato.getText().toString();
          }
          else{
           valor="";
          }
            switch(v.getId()){
            case R.id.b0: if (num!=0){
                            valor = valor + "0";
                            dato.setText(valor);
                           }

                      break;

            case R.id.b1:
                valor = valor + "1";
                dato.setText(valor);
                break;

            case R.id.b2:
                valor = valor + "2";
                dato.setText(valor);
                break;

            case R.id.b3:
                valor = valor + "3";
                dato.setText(valor);
                break;

                case R.id.bmas: if (!operador){
                                 acum = Integer.parseInt(dato.getText().toString());
                                dato.setText("");
                                 operador = true;}
                                break;

                case R.id.bigual :  dato.setText(acum + Integer.parseInt(dato.getText().toString())+ "");
                                    acum = acum + Integer.parseInt(dato.getText().toString());
                                    operador=false;
                   break;

                case R.id.bc: operador = false;
                                  acum =0;
                                  dato.setText("");
                               break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mnupaises:
                Intent i = new Intent(this,ListaPaises.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
