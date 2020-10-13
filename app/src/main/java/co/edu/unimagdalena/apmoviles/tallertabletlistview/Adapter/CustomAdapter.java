package co.edu.unimagdalena.apmoviles.tallertabletlistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.edu.unimagdalena.apmoviles.tallertabletlistview.Model.Book;
import co.edu.unimagdalena.apmoviles.tallertabletlistview.R;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Book> bookList;

    public CustomAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView bookName;
        TextView author;
        TextView edition;

        Book book = bookList.get(i);
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.layout_lista_libros, null);

        author = view.findViewById(R.id.txtAutor);
        bookName = view.findViewById(R.id.txtLibro);
        edition = view.findViewById(R.id.txtEdicion);

        bookName.setText(book.book);
        author.setText(book.author);
        edition.setText(book.edition);

        return view;
    }
}
