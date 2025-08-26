package Task29;

import java.util.ArrayList;

class User {

    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks); // Return copy for safety
    }

    // Borrow a book
    public void borrowBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
        }
    }

    // Return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Check if user has borrowed a specific book
    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    // Display borrowed books
    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedBooks.get(i).getTitle());
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "User: " + name + ", Age: " + age + ", Books borrowed: " + borrowedBooks.size();
    }

}

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

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    // User
    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void displayUsers() {
        System.out.println("Library Users:");
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i));
            }
        }
        System.out.println();
    }

    // Book
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

    public void borrowBook(String userName, String title) {
        User user = findUserByName(userName);
        if (user == null) {
            System.out.println("User " + userName + " not found.");
            return;
        }

        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Book " + title + " not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Book " + title + " is already borrowed.");
            return;
        }

        book.borrow();
        user.borrowBook(book);
        System.out.println(userName + " borrowed " + title);
    }

    public void returnBook(String userName, String title) {
        User user = findUserByName(userName);
        if (user == null) {
            System.out.println("User " + userName + " not found.");
            return;
        }

        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Book '" + title + "' not found.");
            return;
        }

        if (!user.hasBorrowedBook(book)) {
            System.out.println(userName + " has not borrowed '" + title + "'");
            return;
        }

        book.borrow();
        user.returnBook(book);
        System.out.println(userName + " returned " + title);
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

    public void displayAllBorrowedBooks() {
        System.out.println("All Borrowed Books:");
        boolean anyBorrowed = false;

        for (User user : users) {
            if (!user.getBorrowedBooks().isEmpty()) {
                anyBorrowed = true;
                System.out.println(user.getName() + " has borrowed:");
                for (Book book : user.getBorrowedBooks()) {
                    System.out.println("  - " + book.getTitle());
                }
            }
        }

        if (!anyBorrowed) {
            System.out.println("No books are currently borrowed.");
        }
        System.out.println();
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

        lib.addUser(new User("Alice", 25));
        lib.addUser(new User("Bob", 30));
        lib.addUser(new User("Charlie", 22));

        lib.displayBooks();
        lib.displayUsers();

        lib.borrowBook("Alice", "The Art of Fiction");
        lib.borrowBook("Bob", "Data Structures and Algorithms");
        lib.borrowBook("Charlie", "Introduction to Java Programming");
        lib.borrowBook("Alice", "Introduction to Java Programming");

        lib.displayBooks();
        lib.displayAllBorrowedBooks();

        lib.returnBook("Alice", "The Art of Fiction");
        lib.returnBook("Bob", "The Art of Fiction");

        lib.displayBooks();
        lib.displayAllBorrowedBooks();

        lib.setRating("Introduction to Java Programming", 4.5);
        lib.addReview("Introduction to Java Programming", "Great for beginners!");

        lib.displayBooks();
    }
}
