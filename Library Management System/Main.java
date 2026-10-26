import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Add a member");
            System.out.println("3. Issue a book to a member");
            System.out.println("4. Collect a returned book");
            System.out.println("5. Show all books");
            System.out.println("6. Show all members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            switch (input.nextLine()) {
                case "1":
                    System.out.print("Book ID: ");
                    String bookId = input.nextLine();
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    System.out.println(library.addBook(new Book(bookId, title, author))
                            ? "Book added."
                            : "A book with that ID already exists.");
                    break;
                case "2":
                    System.out.print("Member ID: ");
                    String memberId = input.nextLine();
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.println(library.addMember(new Member(memberId, name))
                            ? "Member added."
                            : "A member with that ID already exists.");
                    break;
                case "3":
                    System.out.print("Book ID: ");
                    bookId = input.nextLine();
                    System.out.print("Member ID: ");
                    memberId = input.nextLine();
                    System.out.println(library.issueBook(bookId, memberId)
                            ? "Book issued."
                            : "Could not issue book. Check the IDs and availability.");
                    break;
                case "4":
                    System.out.print("Book ID: ");
                    bookId = input.nextLine();
                    System.out.print("Member ID: ");
                    memberId = input.nextLine();
                    System.out.println(library.returnBook(bookId, memberId)
                            ? "Book returned."
                            : "Could not return book. Check the IDs and member's loans.");
                    break;
                case "5":
                    showBooks(library);
                    break;
                case "6":
                    showMembers(library);
                    break;
                case "7":
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option. Choose 1-7.");
            }
            }
        }
    }

    private static void showBooks(Library library) {
        if (library.getBooks().isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book book : library.getBooks()) {
            String status = book.isAvailable() ? "Available" : "Issued";
            System.out.printf("%s - %s by %s (%s)%n",
                    book.getId(), book.getTitle(), book.getAuthor(), status);
        }
    }

    private static void showMembers(Library library) {
        if (library.getMembers().isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        for (Member member : library.getMembers()) {
            System.out.printf("%s - %s; borrowed books: ", member.getId(), member.getName());
            if (member.getBorrowedBooks().isEmpty()) {
                System.out.println("none");
            } else {
                for (Book book : member.getBorrowedBooks()) {
                    System.out.printf("%s (%s) ", book.getTitle(), book.getId());
                }
                System.out.println();
            }
        }
    }
}