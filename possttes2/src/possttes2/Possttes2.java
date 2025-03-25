/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package possttes2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MSi-GAMING
 */
public class Possttes2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){}
public class Main {
    static final class Shoe {
        private final String shoeId;
        private String shoeName;
        private double price;
        private int stock;

        public Shoe(String shoeId, String shoeName, double price, int stock) {
            this.shoeId = shoeId;
            this.shoeName = shoeName;
            setPrice(price);
            setStock(stock);
        }

        public String getShoeId() {
            return shoeId;
        }

        public String getShoeName() {
            return shoeName;
        }

        public void setShoeName(String shoeName) {
            this.shoeName = shoeName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            if (price > 0) {
                this.price = price;
            } else {
                System.out.println("Harga harus lebih dari 0!");
            }
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            if (stock >= 0) {
                this.stock = stock;
            } else {
                System.out.println("Stok tidak boleh negatif!");
            }
        }

        @Override
        public String toString() {
            return "ID: " + shoeId + ", Nama: " + shoeName + ", Harga: Rp " + price + ", Stok: " + stock;
        }
    }

    static ArrayList<Shoe> shoeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> createShoe();
                    case 2 -> readShoes();
                    case 3 -> updateShoe();
                    case 4 -> deleteShoe();
                    case 5 -> {
                        running = false;
                        System.out.println("Terima kasih telah menggunakan program!");
                    }
                    default -> System.out.println("Pilihan tidak valid, silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("\n=== Sistem Penjualan Sepatu ===");
        System.out.println("1. Tambah Sepatu");
        System.out.println("2. Lihat Semua Sepatu");
        System.out.println("3. Update Sepatu");
        System.out.println("4. Hapus Sepatu");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    static void createShoe() {
        try {
            System.out.print("Masukkan ID Sepatu: ");
            String shoeId = scanner.nextLine();
            System.out.print("Masukkan Nama Sepatu: ");
            String shoeName = scanner.nextLine();
            System.out.print("Masukkan Harga Sepatu: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Masukkan Stok Sepatu: ");
            int stock = Integer.parseInt(scanner.nextLine());

            if (price <= 0 || stock < 0) {
                System.out.println("Harga harus lebih dari 0 dan stok tidak boleh negatif!");
                return;
            }
            
            shoeList.add(new Shoe(shoeId, shoeName, price, stock));
            System.out.println("Sepatu berhasil ditambahkan!");
        } catch (NumberFormatException e) {
            System.out.println("Masukkan angka yang valid untuk harga dan stok!");
        }
    }

    static void readShoes() {
        if (shoeList.isEmpty()) {
            System.out.println("Belum ada data sepatu.");
        } else {
            System.out.println("\nDaftar Sepatu:");
            for (int i = 0; i < shoeList.size(); i++) {
                System.out.println("[" + i + "] " + shoeList.get(i));
            }
        }
    }

    static void updateShoe() {
        readShoes();
        if (!shoeList.isEmpty()) {
            try {
                System.out.print("Masukkan nomor sepatu yang akan diupdate: ");
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 0 && index < shoeList.size()) {
                    Shoe shoe = shoeList.get(index);
                    System.out.print("Masukkan Nama Baru (kosongkan jika tidak diubah): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) shoe.setShoeName(newName);

                    System.out.print("Masukkan Harga Baru (0 jika tidak diubah): ");
                    String priceInput = scanner.nextLine();
                    if (!priceInput.isEmpty()) {
                        double newPrice = Double.parseDouble(priceInput);
                        if (newPrice > 0) shoe.setPrice(newPrice);
                    }

                    System.out.print("Masukkan Stok Baru (0 jika tidak diubah): ");
                    String stockInput = scanner.nextLine();
                    if (!stockInput.isEmpty()) {
                        int newStock = Integer.parseInt(stockInput);
                        if (newStock >= 0) shoe.setStock(newStock);
                    }

                    System.out.println("Data sepatu berhasil diupdate!");
                } else {
                    System.out.println("Nomor sepatu tidak valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }

    static void deleteShoe() {
        readShoes();
        if (!shoeList.isEmpty()) {
            try {
                System.out.print("Masukkan nomor sepatu yang akan dihapus: ");
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 0 && index < shoeList.size()) {
                    shoeList.remove(index);
                    System.out.println("Sepatu berhasil dihapus!");
                } else {
                    System.out.println("Nomor sepatu tidak valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }
}

    }
    

