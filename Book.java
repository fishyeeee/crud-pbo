public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private int stock;

    public Book(String id, String title, String author, int year, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.stock = stock;
    }

    // Getter
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public int getStock() { return stock; }

    // Setter
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return String.format("ID: %s | Judul: %s | Penulis: %s | Tahun: %d | Stok: %d",
                id, title, author, year, stock);
    }
}
