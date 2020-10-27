package com.nemoreno.healthApp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.util.Log;

import com.nemoreno.healthApp.Modelos.record;
import com.nemoreno.healthApp.Modelos.recordDBHelper;
import com.nemoreno.healthApp.Modelos.recordContract;

import java.util.ArrayList;

public class listarActivity extends AppCompatActivity {
    recordDBHelper con;
    SQLiteDatabase db;
    RecyclerView recyclerView;
    recyclerViewAdapter adapter;
    private static final String TAG = "listarActivity";
    private ArrayList<record> records = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        Log.d(TAG, "Created");
        consultarSql();
        initRecyclerView();
        registerForContextMenu(recyclerView);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 122:
                String id = String.valueOf(records.get(adapter.getPosition()).getId());
                Intent intent = new Intent(listarActivity.this, editActivity.class);
                intent.putExtra("ID", id);
                this.finish();
                startActivity(intent);

                break;
            case 123:
                int idEliminar = records.get(adapter.getPosition()).getId();
                deleteSql(idEliminar);
                //Toast.makeText(this, "Eliminar", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void consultarSqlite() {
        con = new recordDBHelper(this, "bd_registros", null, 1);
        db = con.getReadableDatabase();
        String parametro[] = {""};
        String[] campos = {recordContract.NOMBRE, recordContract.SISTOLICO, recordContract.DISTOLICO, recordContract.DATE};
        try {
            Cursor cursor = db.query(recordContract.TABLE_NAME, campos, recordContract.ID + " = ?", parametro, null, null, null, null);
            cursor.moveToFirst();
           // Toast.makeText(getApplicationContext(), cursor.getString(0), Toast.LENGTH_SHORT).show();
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void deleteSql(int ID) {
        con = new recordDBHelper(this, "bd_registros", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        long idResultado = db.delete(recordContract.TABLE_NAME, "id = ?", new String[]{String.valueOf(ID)});
        Toast.makeText(this, "Contacto Eliminado:" + idResultado, Toast.LENGTH_SHORT).show();
        db.close();
        this.finish();
        startActivity(new Intent(this, opcionesActivity.class));
    }

    private void consultarSql() {
        con = new recordDBHelper(this, "bd_registros", null, 1);
        Log.d(TAG, "consultarSql: iniciado");
        try {
            SQLiteDatabase db = con.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + recordContract.TABLE_NAME, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    int id = cursor.getInt(cursor.getColumnIndex(recordContract.ID));
                    String nombre = cursor.getString(cursor.getColumnIndex(recordContract.NOMBRE));
                    String barrio = cursor.getString(cursor.getColumnIndex(recordContract.BARRIO));
                    String apellido = cursor.getString(cursor.getColumnIndex(recordContract.SISTOLICO));
                    String telefono = cursor.getString(cursor.getColumnIndex(recordContract.DISTOLICO));
                    String cumpleaños = cursor.getString(cursor.getColumnIndex(recordContract.DATE));
                    cursor.moveToNext();
                    records.add(new record(id,nombre, barrio, apellido, telefono, cumpleaños));
                    Log.e("LOOOOOG",new record(id,barrio, nombre, apellido, telefono, cumpleaños).toString());
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView");
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new recyclerViewAdapter(records, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //Toast.makeText(listarActivity.this, "Text Changed", Toast.LENGTH_SHORT).show();
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

}
