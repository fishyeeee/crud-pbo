import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // CREATE
    public boolean addBook(Book book) {
        if (findBookById(book.getId()) != null) return false; // ID harus unik
        books.add(book);
        return true;
    }

    // READ
    public ArrayList<Book> getAllBooks() {
        return books;
    }

    // UPDATE
    public boolean updateBook(String id, String newTitle, String newAuthor, int newYear, int newStock) {
        Book b = findBookById(id);
        if (b == null) return false;

        b.setTitle(newTitle);
        b.setAuthor(newAuthor);
        b.setYear(newYear);
        b.setStock(newStock);
        return true;
    }

    // DELETE
    public boolean deleteBook(String id) {
        Book b = findBookById(id);
        if (b == null) return false;
        books.remove(b);
        return true;
    }

    // SEARCH (helper)
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }
}
