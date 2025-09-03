package Task3.library;

import Task3.library.model.Book;
import Task3.library.model.LibraryMember;
import Task3.library.system.Library;

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

        library.reserveBook(member1, book2);
        library.reserveBook(member2, book1);

        library.displayReserved(member1);
        library.displayReserved(member2);

        library.cancelReservation(member2, book1);

        library.displayReserved(member1);
        library.displayReserved(member2);
    }
}
