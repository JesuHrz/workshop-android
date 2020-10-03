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

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bmas, bmenos, bpor, bdiv, bsqrt, binv, bc, bigual;
    EditText dato;
    long acum = 0;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(this);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);

        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);

        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(this);

        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(this);

        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(this);

        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(this);

        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(this);

        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(this);

        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(this);

        bmas = findViewById(R.id.bmas);
        bmas.setOnClickListener(this);

        bmenos = findViewById(R.id.bmenos);
        bmenos.setOnClickListener(this);

        bpor = findViewById(R.id.bpor);
        bpor.setOnClickListener(this);

        bdiv = findViewById(R.id.bdiv);
        bdiv.setOnClickListener(this);

        bsqrt = findViewById(R.id.bsqrt);
        bsqrt.setOnClickListener(this);

        binv = findViewById(R.id.binv);
        binv.setOnClickListener(this);

        bigual = findViewById(R.id.bigual);
        bigual.setOnClickListener(this);

        bc = findViewById(R.id.bc);
        bc.setOnClickListener(this);

        this.dato = findViewById(R.id.edtdato);
    }

    @Override
    public void onClick(View v) {
      String valor;
      double num = 0;

      if (!TextUtils.isEmpty(this.dato.getText().toString())) {
        num = Double.parseDouble(this.dato.getText().toString());
        valor = this.dato.getText().toString();
      } else {
        valor = "";
      }

      switch (v.getId()) {
        case R.id.b0:
          if (num != 0) {
            valor = valor + "0";
            this.dato.setText(valor);
          }
          break;

        case R.id.b1:
          valor = valor + "1";
          this.dato.setText(valor);
          break;

        case R.id.b2:
          valor = valor + "2";
          this.dato.setText(valor);
          break;

        case R.id.b3:
          valor = valor + "3";
          this.dato.setText(valor);
          break;

        case R.id.b4:
          valor = valor + "4";
          this.dato.setText(valor);
          break;

        case R.id.b5:
          valor = valor + "5";
          this.dato.setText(valor);
          break;

        case R.id.b6:
          valor = valor + "6";
          this.dato.setText(valor);
          break;

        case R.id.b7:
          valor = valor + "7";
          this.dato.setText(valor);
          break;

        case R.id.b8:
          valor = valor + "8";
          this.dato.setText(valor);
          break;

        case R.id.b9:
          valor = valor + "9";
          this.dato.setText(valor);
          break;

        case R.id.bmas:
          this.acum = Integer.parseInt(this.dato.getText().toString());
          this.dato.setText("");
          this.operador = bmas.getText().toString();
          break;

        case R.id.bmenos:
            this.acum = Integer.parseInt(this.dato.getText().toString());
            this.dato.setText("");
            this.operador = bmenos.getText().toString();
            break;

        case R.id.bpor:
            this.acum = Integer.parseInt(this.dato.getText().toString());
            this.dato.setText("");
            this.operador = bpor.getText().toString();
            break;

        case R.id.bdiv:
            this.acum = Integer.parseInt(this.dato.getText().toString());
            this.dato.setText("");
            this.operador = bdiv.getText().toString();
            break;

        case R.id.bsqrt:
            double sqrt = Math.sqrt(Double.parseDouble(this.dato.getText().toString()));
            this.dato.setText(String.valueOf(sqrt));
            break;

        case R.id.binv:
            int result = invertido(Integer.parseInt(this.dato.getText().toString()));
            this.dato.setText(String.valueOf(result));
            break;

        case R.id.bigual:
          if (this.operador.equals("+")) {
            this.dato.setText(this.acum + Integer.parseInt(this.dato.getText().toString()) + "");
            this.acum = this.acum + Integer.parseInt(this.dato.getText().toString());
          } else if (this.operador.equals("-")) {
            this.dato.setText(this.acum - Integer.parseInt(this.dato.getText().toString()) + "");
            this.acum = this.acum - Integer.parseInt(this.dato.getText().toString());
          } else if (this.operador.equals("*")) {
            this.dato.setText(this.acum * Integer.parseInt(this.dato.getText().toString()) + "");
            this.acum = this.acum * Integer.parseInt(this.dato.getText().toString());
          } else if (this.operador.equals("/")) {
            this.dato.setText(this.acum / Integer.parseInt(this.dato.getText().toString()) + "");
            this.acum = this.acum / Integer.parseInt(this.dato.getText().toString());
          }
         break;

        case R.id.bc:
          if (bsqrt.equals("SQRT")) {
            this.acum =0;
            this.dato.setText("");
          } else {
            this.operador = "";
            this.acum = 0;
            this.dato.setText("");
          }
          break;
      }
    }

    private int invertido(int n) {
        int offSetMum = 0;

        while(n > 0) {
          offSetMum = offSetMum * 10 + n % 10;
          n = n / 10;
        }
        return offSetMum;
    }
}
