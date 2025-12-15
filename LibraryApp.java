import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka. Coba lagi.");
            }
        }
    }

    private static void printBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }
        System.out.println("\n=== DAFTAR BUKU ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Data awal (opsional)
        library.addBook(new Book("B001", "Clean Code", "Robert C. Martin", 2008, 5));
        library.addBook(new Book("B002", "Introduction to Algorithms", "CLRS", 2009, 3));

        int choice;
        do {
            System.out.println("\n==============================");
            System.out.println("  MANAJEMEN BUKU PERPUSTAKAAN ");
            System.out.println("==============================");
            System.out.println("1. Tambah Buku (Create)");
            System.out.println("2. Lihat Semua Buku (Read)");
            System.out.println("3. Update Buku (Update)");
            System.out.println("4. Hapus Buku (Delete)");
            System.out.println("5. Cari Buku by ID");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1: {
                    System.out.println("\n--- Tambah Buku ---");
                    System.out.print("ID Buku: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Judul: ");
                    String title = sc.nextLine().trim();
                    System.out.print("Penulis: ");
                    String author = sc.nextLine().trim();
                    int year = readInt(sc, "Tahun: ");
                    int stock = readInt(sc, "Stok: ");

                    boolean ok = library.addBook(new Book(id, title, author, year, stock));
                    if (ok) System.out.println("✅ Buku berhasil ditambahkan.");
                    else System.out.println("❌ Gagal: ID buku sudah ada.");
                    break;
                }

                case 2: {
                    printBooks(library.getAllBooks());
                    break;
                }

                case 3: {
                    System.out.println("\n--- Update Buku ---");
                    System.out.print("Masukkan ID Buku yang mau diupdate: ");
                    String id = sc.nextLine().trim();

                    Book b = library.findBookById(id);
                    if (b == null) {
                        System.out.println("❌ Buku tidak ditemukan.");
                        break;
                    }

                    System.out.println("Data saat ini: " + b);
                    System.out.print("Judul baru: ");
                    String newTitle = sc.nextLine().trim();
                    System.out.print("Penulis baru: ");
                    String newAuthor = sc.nextLine().trim();
                    int newYear = readInt(sc, "Tahun baru: ");
                    int newStock = readInt(sc, "Stok baru: ");

                    boolean ok = library.updateBook(id, newTitle, newAuthor, newYear, newStock);
                    System.out.println(ok ? "✅ Buku berhasil diupdate." : "❌ Update gagal.");
                    break;
                }

                case 4: {
                    System.out.println("\n--- Hapus Buku ---");
                    System.out.print("Masukkan ID Buku yang mau dihapus: ");
                    String id = sc.nextLine().trim();

                    boolean ok = library.deleteBook(id);
                    System.out.println(ok ? "✅ Buku berhasil dihapus." : "❌ Buku tidak ditemukan.");
                    break;
                }

                case 5: {
                    System.out.println("\n--- Cari Buku ---");
                    System.out.print("Masukkan ID Buku: ");
                    String id = sc.nextLine().trim();

                    Book b = library.findBookById(id);
                    if (b == null) System.out.println("❌ Buku tidak ditemukan.");
                    else System.out.println("✅ Ditemukan: " + b);
                    break;
                }

                case 0:
                    System.out.println("Keluar... 👋");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }

        } while (choice != 0);

        sc.close();
    }
}
