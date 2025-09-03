package Task3.library.model;

public class Book {

    private String title;
    private String author;
    private int isbn;
    private boolean reserved;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.reserved = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn() {
        this.isbn = isbn;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public void reserve() {
        if (!reserved) {
            reserved = true;
        } else {
            reserved = false;
        }
    }
}
