import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public boolean addBook(Book book) {
        if (findBook(book.getId()) != null) {
            return false;
        }
        books.add(book);
        return true;
    }

    public boolean addMember(Member member) {
        if (findMember(member.getId()) != null) {
            return false;
        }
        members.add(member);
        return true;
    }

    public boolean issueBook(String bookId, String memberId) {
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        if (book == null || member == null || !book.isAvailable()) {
            return false;
        }
        book.setAvailable(false);
        member.getBorrowedBooks().add(book);
        return true;
    }

    public boolean returnBook(String bookId, String memberId) {
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        if (book == null || member == null || !member.getBorrowedBooks().remove(book)) {
            return false;
        }
        book.setAvailable(true);
        return true;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    private Book findBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private Member findMember(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }
}