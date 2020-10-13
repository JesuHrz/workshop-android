package co.edu.unimagdalena.apmoviles.tallertabletlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.edu.unimagdalena.apmoviles.tallertabletlistview.Adapter.CustomAdapter;
import co.edu.unimagdalena.apmoviles.tallertabletlistview.Model.Book;

public class ListaPaises extends AppCompatActivity {

    ListView books;
    List<Book> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        books = findViewById(R.id.lstpaises);
        CustomAdapter adapter = new CustomAdapter(this, getBook());
        books.setAdapter(adapter);

        books.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = bookList.get(position);
                Toast.makeText(getApplicationContext(), "Book : " + (book.author), Toast.LENGTH_LONG).show();
            }
        });

    }

    private List<Book> getBook() {
        bookList = new ArrayList<>();
        bookList.add(new Book("JavaScript Scope and Closures", "Simpson, Kyle", "1 Edition"));
        bookList.add(new Book("You Don t Know JS : Up & Going", "Simpson, Kyle", "2 Edition"));

        return bookList;
    }


}
