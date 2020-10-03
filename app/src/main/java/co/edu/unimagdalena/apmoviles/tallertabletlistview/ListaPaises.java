package co.edu.unimagdalena.apmoviles.tallertabletlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaPaises extends AppCompatActivity {

    ListView listapaises;
    ArrayList<String> paises = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        paises.add("Colombia");
        paises.add("Chile");
        paises.add("Peru");
        paises.add("Brasil");
        paises.add("Usa");
        paises.add("Panamá");
        listapaises = findViewById(R.id.lstpaises);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paises);
        listapaises.setAdapter(adapter);

        listapaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Pais : " + (paises.get(position)),Toast.LENGTH_LONG).show();
            }
        });

    }


}
