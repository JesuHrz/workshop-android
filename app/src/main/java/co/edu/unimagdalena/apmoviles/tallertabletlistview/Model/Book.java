package co.edu.unimagdalena.apmoviles.tallertabletlistview.Model;

public class Book {
   public String author, book, edition;



    public Book(String book, String author, String edition) {
        this.author = author;
        this.book = book;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
