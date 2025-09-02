package library;

import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Brave New World", "Aldous Huxley", 1932);

        // Create members
        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        // Add books and members to library
        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        // Borrow book
        library.borrowBook(member1, book1);

        // Try to borrow the same book again
        library.borrowBook(member2, book1);

        // Return book
        library.returnBook(member1, book1);

        // Now Bob borrows the returned book
        library.borrowBook(member2, book1);
    }
}
