/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;

import java.util.ArrayList;
import java.util.Scanner;

public class Bill {
    private ArrayList<Book> cart = new ArrayList<>();
    private double ThanhTien;                       

    public Bill() {
        this.cart = new ArrayList<>();
        this.ThanhTien = 0.0;
    }

    public Bill(ArrayList<Book> cart, double ThanhTien) {
        this.cart = cart;
        this.ThanhTien = ThanhTien;
    }

    
    public ArrayList<Book> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Book> cart) {
        this.cart = cart;
        calculateThanhTien();
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    private void calculateThanhTien() {
        this.ThanhTien = 0.0;
        if (cart != null) {
            for (Book book : cart) {
                this.ThanhTien += book.getPrice() * book.getQuantity();
            }
        }
    }

    // Phương thức thêm sách vào giỏ hàng
    public void addBookToCart(Book book) {
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(book);
        calculateThanhTien();
    }

    // Phương thức chính để tính toán và hiển thị giỏ hàng
    public void TinhThanhTien(Book book) {
        book.docFile(); // Đọc dữ liệu từ file
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Danh muc loai sach ---");
            ArrayList<String> bookTypes = new ArrayList<>(book.booksByType.keySet());

            for (int i = 0; i < bookTypes.size(); i++) {
                System.out.println((i + 1) + ". " + bookTypes.get(i));
            }
            System.out.println("0. Thoat");

            System.out.print("Chon loai sach (nhap so): ");
            int typeChoice = Integer.parseInt(scanner.nextLine());

            if (typeChoice == 0) {
                break;
            }
            if (typeChoice < 1 || typeChoice > bookTypes.size()) {
                System.out.println("Lua chon khong hop le. Vui long thu lai.");
                continue;
            }

            String selectedType = bookTypes.get(typeChoice - 1);
            System.out.println("\nDanh sach sach thuoc looi \"" + selectedType + "\":");
            ArrayList<Book> filteredBooks = book.booksByType.get(selectedType);

            if (filteredBooks == null || filteredBooks.isEmpty()) {
                System.out.println("Khong co sach nao thuoc looi nay.");
                continue;
            }

            // Hiển thị sách theo định dạng bảng
            System.out.printf("%-10s %-10s %-30s %-10s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
            for (Book b : filteredBooks) {
                System.out.printf("%-10s %-10s %-30s %-10.2f %-10d %-20s\n",
                    b.getType(), b.getId(), b.getName(), b.getPrice(), b.getQuantity(), b.getAuthor());
            }

            System.out.print("\nNhap ma so hoac ten sach de them vao gio hang: ");
            String search = scanner.nextLine().trim();

            Book selectedBook = null;
            for (Book b : filteredBooks) {
                if (b.getId().equalsIgnoreCase(search) || b.getName().equalsIgnoreCase(search)) {
                    selectedBook = b;
                    break;
                }
            }

            if (selectedBook == null) {
                System.out.println("Khong tim thay sach voi ma hoac ten vua nhap.");
            } else {
                System.out.print("Nhap so luong sach muon mua: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                // Kiểm tra số lượng sách có sẵn trong kho
                if (quantity > selectedBook.getQuantity()) {
                    System.out.println("So luong sach trong kho khong du. Vui long nhap lai.");
                    continue;
                }

                // Cập nhật số lượng sách trong giỏ hàng
                selectedBook.setQuantity(quantity);  // Cập nhật số lượng sách trong giỏ hàng
                addBookToCart(selectedBook); // Thêm vào giỏ hàng
                System.out.println("Da them " + quantity + " sach \"" + selectedBook.getName() + "\" vao gio hang.");
            }

            System.out.print("\nBan co muon tiep tuc mua sam? (Y/N): ");
            String continueChoice = scanner.nextLine().trim();
            if (continueChoice.equalsIgnoreCase("N")) {
                break;
            }
        }

        // Tính toán tổng tiền và hiển thị hóa đơn
        double ThanhTien = 0;
        System.out.println("\n--- Hoa don gio hang ---");
        System.out.printf("%-30s %-10s %-10s %-10s\n", "Ten sach", "So luong", "Don gia", "Thanh tien");
        for (Book b : cart) {
            double subtotal = b.getPrice() * b.getQuantity();
            ThanhTien += subtotal;
            System.out.printf("%-30s %-10d %-10.2f %-10.2f\n",
                b.getName(), b.getQuantity(), b.getPrice(), subtotal);
        }
        System.out.println("Tong thanh tien: " + ThanhTien);
    }

    // Override toString
    @Override
    public String toString() {
        StringBuilder billDetails = new StringBuilder("Hoa don chi tiet:\n");
        if (cart != null && !cart.isEmpty()) {
            for (Book book : cart) {
                billDetails.append("Sach: ").append(book.getName())
                           .append(", So luong: ").append(book.getQuantity())
                           .append(", Don gia: ").append(book.getPrice())
                           .append(", Thanh tien: ").append(book.getPrice() * book.getQuantity())
                           .append("\n");
            }
        } else {
            billDetails.append("Gio hang trong.\n");
        }
        billDetails.append("Tong cong: ").append(ThanhTien);
        return billDetails.toString();
    }
    
//    public void applyDiscount(DiscountManager discountManager) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập mã giảm giá (hoặc bỏ qua): ");
//        String discountCode = scanner.nextLine().trim();
//
//        Discount discount = discountManager.validateDiscount(discountCode, this.ThanhTien);
//        if (discount != null) {
//            double discountAmount = this.ThanhTien * (discount.getPercentage() / 100);
//            this.ThanhTien -= discountAmount;
//            System.out.println("Giảm giá áp dụng: -" + discountAmount + " VND");
//        } else {
//            System.out.println("Không áp dụng giảm giá.");
//        }
//    }



}



