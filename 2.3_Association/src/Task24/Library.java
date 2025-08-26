package Task24;

import java.util.ArrayList;

class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return this.author;
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
            bookNo++;
            System.out.println(bookNo + ". " + book);
        }
        System.out.println("\n");
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by author " + author);
        for (Book existingBook : books) {
            if (existingBook.getAuthor().equals(author)) {
                System.out.println(existingBook);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Library lib = new Library();

        lib.addBook(new Book("Introduction to Java Programming", "John Smith", 2020));
        lib.addBook(new Book("Data Structures and Algorithms", "Jane Doe", 2018));
        lib.addBook(new Book("The Art of Fiction", "Alice Johnson", 2019));

        lib.displayBooks();
        lib.findBooksByAuthor("Jane Doe");
    }
}
