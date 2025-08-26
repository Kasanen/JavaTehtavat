package Task25;

import java.util.ArrayList;

class Book {

    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    public void borrow() {
        this.isBorrowed = !this.isBorrowed;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog: ");
        int bookNo = 0;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                bookNo++;
                System.out.println(bookNo + ". " + book);
            }
        }
        System.out.println("\n");
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by author " + author);
        for (Book existingBook : books) {
            if (existingBook.getAuthor().equals(author)) {
                System.out.println(existingBook);
            }
        }
    }

    public void borrowBook(String title) {
        for (Book existingBook : books) {
            if (existingBook.getTitle().equals(title) && existingBook.isBorrowed() == false) {
                System.out.println("Book " + title + " borrowed!");
                existingBook.borrow();
            }
        }
    }

    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            book.borrow();
            System.out.println("Book " + book.getTitle() + " returned!");
        }
    }

    public static void main(String[] args) throws Exception {
        Library lib = new Library();

        lib.addBook(new Book("Introduction to Java Programming", "John Smith", 2020));
        lib.addBook(new Book("Data Structures and Algorithms", "Jane Doe", 2018));
        lib.addBook(new Book("The Art of Fiction", "Alice Johnson", 2019));

        lib.displayBooks();
        lib.findBooksByAuthor("Jane Doe");

        lib.borrowBook("The Art of Fiction");
        lib.displayBooks();

        Book borrowedBook = lib.findBookByTitle("The Art of Fiction");
        if (borrowedBook != null) {
            lib.returnBook(borrowedBook);
        }
        lib.displayBooks();
    }
}
