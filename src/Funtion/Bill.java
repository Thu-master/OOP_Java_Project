/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public void calculateThanhTien() {
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
        Scanner sc = new Scanner(System.in);

        double ThanhTien = 0; // Tổng tiền của giỏ hàng

        
        while (true) {
            System.out.println("\n--- Danh muc loai sach ---");
            ArrayList<String> bookTypes = new ArrayList<>(book.booksByType.keySet());

            for (int i = 0; i < bookTypes.size(); i++) {
                System.out.println((i + 1) + ". " + bookTypes.get(i));
            }
            System.out.println("0. Thoat");

            System.out.print("Chon loai sach (nhap so hoac loai truc tiep): ");
            String typeInput = sc.nextLine().trim();

            if (typeInput.equalsIgnoreCase("0")) {
                break;
            }

            ArrayList<Book> filteredBooks = null;
            if (typeInput.matches("\\d+")) {
                int typeChoice = Integer.parseInt(typeInput);
                if (typeChoice < 1 || typeChoice > bookTypes.size()) {
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
                    continue;
                }
                String selectedType = bookTypes.get(typeChoice - 1);
                filteredBooks = book.booksByType.get(selectedType);
            } else {
                if (book.booksByType.containsKey(typeInput)) {
                    filteredBooks = book.booksByType.get(typeInput);
                } else {
                    System.out.println("Khong tim thay loai sach tuong ung. Vui long thu lai.");
                    continue;
                }
            }

            if (filteredBooks == null || filteredBooks.isEmpty()) {
                System.out.println("Khong co sach nao thuoc loai nay.");
                continue;
            }

            System.out.println("\nDanh sach sach:");
            System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
            for (Book b : filteredBooks) {
                System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                        b.getType(), b.getId(), b.getName(), b.getPrice(), b.getQuantity(), b.getAuthor());
            }

            System.out.print("\nNhap ma so hoac ten sach de them vao gio hang: ");
            String search = sc.nextLine().trim();

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
                int quantity = Integer.parseInt(sc.nextLine());

                if (quantity > selectedBook.getQuantity()) {
                    System.out.println("So luong sach trong kho khong du. Vui long nhap lai.");
                    continue;
                }

                // Kiem tra xem sach da co trong gio hang chua
                boolean alreadyInCart = false;
                for (Book b : cart) {
                    if (b.getId().equalsIgnoreCase(selectedBook.getId())) {
                        alreadyInCart = true;
                        int currentQuantity = b.getQuantity();
                        b.setQuantity(currentQuantity + quantity);
                        System.out.println("Cap nhat so luong sach \"" + b.getName() + "\" trong gio hang: " + (currentQuantity + quantity));
                        break;
                    }
                }

                if (!alreadyInCart) {
                    // Tao doi tuong moi va gan gia tri tu selectedBook
                    Book bookToAdd = new Book(
                            selectedBook.getType(),
                            selectedBook.getId(),
                            selectedBook.getName(),
                            selectedBook.getPrice(),
                            quantity,
                            selectedBook.getAuthor()
                    );
                    cart.add(bookToAdd);
                    System.out.println("Da them " + quantity + " sach \"" + bookToAdd.getName() + "\" vao gio hang.");
                }
            }

            System.out.print("\nBan co muon tiep tuc mua sam? (Y/N): ");
            String continueChoice = sc.nextLine().trim();
            if (continueChoice.equalsIgnoreCase("N")) {
                break;
            }
        }

        // Cập nhật số lượng sách trong kho khi thanh toán
        double totalAmount = 0;
        System.out.println("\n--- Hoa don gio hang ---");
        System.out.printf("%-30s %-10s %-10s %-10s\n", "Ten sach", "So luong", "Don gia", "Thanh tien");

        // Tính tổng tiền và cập nhật số lượng sách trong kho
        for (Book b : cart) {
            double subtotal = b.getPrice() * b.getQuantity();
            totalAmount += subtotal;

            System.out.printf("%-30s %-10d %-10.2f %-10.2f\n",
                    b.getName(), b.getQuantity(), b.getPrice(), subtotal);
        }
        System.out.printf("\nTong thanh tien: %.2f\n", totalAmount);
    }

    // Override toString
    @Override
    public String toString() {
        StringBuilder billDetails = new StringBuilder("Hoa don chi tiet:\n");
        double totalAmount = 0; // Biến cục bộ để tính tổng tiền

        if (cart != null && !cart.isEmpty()) {
            for (Book book : cart) {
                double subTotal = book.getPrice() * book.getQuantity();
                totalAmount += subTotal; // Cộng dồn thành tiền cho từng cuốn sách
                billDetails.append("Sach: ").append(book.getName())
                           .append(", So luong: ").append(book.getQuantity())
                           .append(", Don gia: ").append(book.getPrice())
                           .append(", Thanh tien: ").append(subTotal)
                           .append("\n");
            }
        } else {
            billDetails.append("Gio hang trong.\n");
        }

        billDetails.append("Tong cong: ").append(totalAmount); // Hiển thị tổng cộng
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



