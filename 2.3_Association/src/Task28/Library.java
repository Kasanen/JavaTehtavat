package Task28;

import java.util.ArrayList;

class Book {

    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;
    private double rating;
    private String review;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
        this.rating = 0.0;
        this.review = "Not rewieved";
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

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return this.rating;
    }

    public void addReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year + ", Rating: " + rating + ", Review: " + review;
    }
}

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println();
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

    public boolean isBookAvailable(String title) {
        for (Book existingBook : books) {
            if (existingBook.getTitle().equals(title)) {
                System.out.println(!existingBook.isBorrowed());
                return !existingBook.isBorrowed();
            }
        }
        System.out.println(false);
        return false;
    }

    public void setRating(String title, double rating) {
        if (rating < 0 || rating > 5) {
            System.out.println("Rating must be between 0 and 5");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setRating(rating);
                System.out.println("Rating " + rating + " set for " + title);
                return;
            }
        }
        System.out.println("Book " + title + " not found in library");
    }

    public void getAverageBookRating() {
        double avgRate = 0.0;
        for (Book book : books) {
            avgRate += book.getRating();
        }
        System.out.println("Avarage book rating is " + avgRate / books.size());
        System.out.println();
    }

    public void addReview(String title, String review) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.addReview(review);
                System.out.println("Rewiev " + review + " set for " + title);
                return;
            }
        }
        System.out.println("Book " + title + " not found in library");
    }

    public void getMostReviewedBook() {
        Book highestRated = null;
        double highestRating = 0.0;

        for (Book book : books) {
            if (book.getRating() > highestRating) {
                highestRating = book.getRating();
                highestRated = book;
            }
        }

        if (highestRated != null && highestRating > 0) {
            System.out.println("Highest rated book: " + highestRated.getTitle());
            System.out.println("Rating: " + highestRating + "/5.0");
        } else {
            System.out.println("No books have ratings yet");
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

        lib.isBookAvailable("The Art of Fiction");

        Book borrowedBook = lib.findBookByTitle("The Art of Fiction");
        if (borrowedBook != null) {
            lib.returnBook(borrowedBook);
        }
        lib.displayBooks();

        lib.isBookAvailable("The Art of Fiction");

        lib.setRating("Introduction to Java Programming", 4.5);
        lib.setRating("Data Structures and Algorithms", 3.8);
        lib.setRating("The Art of Fiction", 4.2);
        lib.setRating("Non-existing Book", 5.0);
        lib.setRating("Introduction to Java Programming", 6.0);

        lib.addReview("Introduction to Java Programming", "Excellent book for beginners!");
        lib.addReview("Data Structures and Algorithms", "Very comprehensive and well-written.");
        lib.addReview("The Art of Fiction", "Beautiful prose and compelling characters.");
        lib.addReview("Non-existing Book", "This book doesn't exist!");

        lib.displayBooks();

        lib.getAverageBookRating();
        lib.getMostReviewedBook();
    }
}
