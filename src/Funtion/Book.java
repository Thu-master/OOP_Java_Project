/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Decentralization.User_Management;


/**
 *
 * @author Thu
 */
public class Book extends Product
{
    private String author;
    private String type;
    public Map<String, ArrayList<Book>> booksByType = new HashMap<>();
    private User_Management userManagement;


    public Book() {
    }

    public Book(String type, String id, String name, double price, int quantity, String author) {
        super(id, name, price, quantity);
        this.type = type;
        this.author = author;
    }
    
    public Book(User_Management userManagement) 
    {
        this.userManagement = userManagement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
        public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getType() + ";" + getId() + ";" + getName() + ";" + getPrice() + ";" + getQuantity() + ";" + author;
    }

    // Đọc file và tự động phân loại sách
    public void docFile() {
        booksByType.clear(); // Xóa dữ liệu cũ
        try {
            File f = new File("sach.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("[;]+");
                if (parts.length == 6) {
                    String type = parts[0];
                    String id = parts[1];
                    String name = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    String author = parts[5];

                    Book book = new Book(type, id, name, price, quantity, author);
                    booksByType.computeIfAbsent(type, k -> new ArrayList<>()).add(book);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Khong the doc file: " + e.getMessage());
        }
    }

    // Hiển thị các loại sách hiện có
    public void viewBooks(){
        Scanner scanner = new Scanner(System.in);
        docFile(); // Đọc dữ liệu từ file
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\n--- MENU XEM SACH ---");
            int index = 1;
            List<String> types = new ArrayList<>(booksByType.keySet());
            for (String type : types){
                System.out.println(index + ": " + type);
                index++;
            }
            System.out.println("0: Quay lai");

            System.out.print("Chon loai sach: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) {
                backToMainMenu = true;
            } else if (choice > 0 && choice <= types.size()) {
                String selectedType = types.get(choice - 1);
                displayBooks(booksByType.get(selectedType));
            } else {
                System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // Hiển thị danh sách sách thuộc một loại
    public void displayBooks(ArrayList<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("Khong co sach nao trong loai nay.");
            return;
        }
        System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
        for (Book book : books) {
            System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                    book.getType(), book.getId(), book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor());
        }
    }

    // Thêm sách mới và ghi vào file
    public void ThemSachVaGhiFile() 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap loai sach:");
        String type = sc.nextLine();
        System.out.println("Nhap ma so sach:");
        String id = sc.nextLine();

        if (kiemTraIdVaTen(id, "")) {
            System.out.println("Ma sach da ton tai. Khong the them sach trung ID.");
            return;
        }

        System.out.println("Nhap ten sach:");
        String name = sc.nextLine();
        if (kiemTraIdVaTen("", name)) {
            System.out.println("Ten sach da ton tai. Khong the them sach trung ten.");
            return;
        }

        System.out.println("Nhap gia sach:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong:");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten tac gia:");
        String author = sc.nextLine();

        Book newBook = new Book(type, id, name, price, quantity, author);

        try (FileWriter fw = new FileWriter("sach.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(newBook.toString());
            booksByType.computeIfAbsent(type, k -> new ArrayList<>()).add(newBook);
            System.out.println("Da them sach va ghi vao file thanh cong.");
            ghiLichSu("Them sach", newBook);
        } catch (IOException e) {
            System.out.println("Khong the ghi file: " + e.getMessage());
        }
    }
    
    public void xoaSachTheoIDHoacTen() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ID hoac ten sach can xoa: ");
        String input = sc.nextLine().trim();

        boolean found = false;

        // Duyệt qua tất cả các loại sách trong Map
        for (Map.Entry<String, ArrayList<Book>> entry : booksByType.entrySet()) {
            ArrayList<Book> books = entry.getValue();

            // Tìm sách dựa trên ID hoặc tên
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                if (book.getId().equalsIgnoreCase(input) || book.getName().equalsIgnoreCase(input)) {
                    // Hiển thị thông tin sách cần xóa
                    System.out.println("\nTim thay sach can xoa:");
                    System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
                    System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                            book.getType(), book.getId(), book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor());

                    // Yêu cầu xác nhận xóa
                    System.out.print("Ban co chac chan muon xoa sach nay khong? (Y/N): ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        books.remove(i); // Xóa sách khỏi danh sách
                        System.out.println("Sach da duoc xoa thanh cong!");

                        // Ghi lịch sử xóa
                        ghiLichSu("Xoa sach", book);
                        found = true;
                        break;
                    } else {
                        System.out.println("Huy thao tac xoa sach.");
                        return;
                    }
                }
            }
            if (found) break; // Dừng tìm kiếm khi đã xóa sách
        }

        if (!found) {
            System.out.println("Khong tim thay sach co ID hoac ten nhu vay.");
        } else {
            // Ghi lại toàn bộ dữ liệu sau khi xóa
            ghiLaiFile();
        }
    }

    // Kiểm tra trùng ID hoặc tên sách
    public boolean kiemTraIdVaTen(String id, String name) {
        for (ArrayList<Book> books : booksByType.values()) {
            for (Book book : books) {
                if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void capNhatSachVaGhiFile() {
        Scanner sc = new Scanner(System.in);

        // Yêu cầu người dùng nhập ID hoặc tên sách cần sửa
        System.out.println("Nhap ID hoac ten sach can cap nhat: ");
        String input = sc.nextLine().trim();

        boolean found = false; // Đánh dấu sách đã được tìm thấy

        // Duyệt qua tất cả các loại sách trong Map
        for (Map.Entry<String, ArrayList<Book>> entry : booksByType.entrySet()) {
            ArrayList<Book> books = entry.getValue();

            // Tìm sách dựa trên ID hoặc tên
            for (Book book : books) {
                if (book.getId().equalsIgnoreCase(input) || book.getName().equalsIgnoreCase(input)) {
                    // Hiển thị thông tin sách tìm thấy
                    System.out.println("\nTim thay sach can sua:");
                    System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
                    System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                            book.getType(), book.getId(), book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor());

                    // Cập nhật thông tin sách
                    System.out.println("\nNhap thong tin moi (nhan Enter de giu nguyen gia tri cu):");
                    System.out.print("Loai sach cu (" + book.getType() + "), nhap loai sach moi: ");
                    String newType = sc.nextLine().trim();
                    if (!newType.isEmpty()) book.setType(newType);

                    System.out.print("Ma so cu (" + book.getId() + "), nhap ma so moi: ");
                    String newId = sc.nextLine().trim();
                    if (!newId.isEmpty()) book.setId(newId);

                    System.out.print("Ten cu (" + book.getName() + "), nhap ten moi: ");
                    String newName = sc.nextLine().trim();
                    if (!newName.isEmpty()) book.setName(newName);

                    System.out.print("Gia cu (" + book.getPrice() + "), nhap gia moi: ");
                    String newPriceStr = sc.nextLine().trim();
                    if (!newPriceStr.isEmpty()) {
                        double newPrice = Double.parseDouble(newPriceStr);
                        book.setPrice(newPrice);
                    }

                    System.out.print("So luong cu (" + book.getQuantity() + "), nhap so luong moi: ");
                    String newQuantityStr = sc.nextLine().trim();
                    if (!newQuantityStr.isEmpty()) {
                        int newQuantity = Integer.parseInt(newQuantityStr);
                        book.setQuantity(newQuantity);
                    }

                    System.out.print("Tac gia cu (" + book.getAuthor() + "), nhap tac gia moi: ");
                    String newAuthor = sc.nextLine().trim();
                    if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);

                    System.out.println("\nCap nhat thong tin sach thanh cong!");
                    ghiLichSu("Sua sach", book); // Ghi lịch sử
                    found = true;
                    break;
                }
            }
            if (found) break; // Dừng tìm kiếm khi đã tìm thấy sách
        }

        if (found) {
            // Ghi lại toàn bộ dữ liệu sau khi sửa
            ghiLaiFile();
        } else {
            System.out.println("Khong tim thay sach co ID hoac ten nhu vay.");
        }
    }

    // Ghi toàn bộ dữ liệu sách hiện tại vào file
    private void ghiLaiFile() {
        try {
            File f = new File("sach.txt");
            FileWriter fw = new FileWriter(f, false);
            PrintWriter pw = new PrintWriter(fw);

            for (ArrayList<Book> books : booksByType.values()) {
                for (Book book : books) {
                    pw.println(book.toString());
                }
            }
            pw.close();
            fw.close();
            System.out.println("Da cap nhat du lieu sach vao file thanh cong!");
        } catch (Exception e) {
            System.out.println("Khong the ghi vào file: " + e.getMessage());
        }
    }
    
    private void ghiLichSu(String hanhDong, Book book) {
        try (FileWriter fw = new FileWriter("approval_history.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println("[" + timestamp + "] [Book Action] " + hanhDong + " - Loai: " + book.getType() +
                    ", Ma so: " + book.getId() + ", Ten: " + book.getName() +
                    ", Gia: " + book.getPrice() + ", So luong: " + book.getQuantity() +
                    ", Tac gia: " + book.getAuthor());
        } catch (IOException e) {
            System.out.println("Không thể ghi lịch sử: " + e.getMessage());
        }
    }
    
    public void xemLichSu(String hanhDong) {
        try (BufferedReader br = new BufferedReader(new FileReader("approval_history.txt"))) {
            String line;
            System.out.println("\n--- Lich su " + hanhDong.toLowerCase() + " ---");
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.contains("[Book Action]") && line.contains(hanhDong)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Khong tim thay lich su nao cho hanh dong: " + hanhDong);
            }
        } catch (IOException e) {
            System.out.println("Khong the doc lich su: " + e.getMessage());
        }
    }


    public void manageBooksWithMenu() {
    Scanner scanner = new Scanner(System.in);
    boolean keepManaging = true;
    Book bookManager = new Book(userManagement); // Truyền userManagement



    while (keepManaging) {
        System.out.println("\n--- QUAN LY SACH ---");
        System.out.println("1. Them sach");
        System.out.println("2. Xoa sach");
        System.out.println("3. Sua sach");
        System.out.println("4. Xem sach");
        System.out.println("5. Xem lich su them sach");
        System.out.println("6. Xem lich su sua sach");
        System.out.println("7. Xem lich su xoa sach");
        System.out.println("8. Quay lai");
        System.out.println("0. Thoat");
        System.out.print("Chon chuc nang: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) 
        {
            case 0:
                //Thoát chương trình
                System.out.println("Dang thoat chuong trinh... Tam biet!");
                System.exit(0);
                break;
            case 1:
                System.out.println("\n--- THEM SACH ---");
                docFile(); // Đọc file dữ liệu hiện tại
                ThemSachVaGhiFile(); // Thêm sách
                break;
            case 2:
                System.out.println("\n--- XOA SACH ---");
                docFile();
                xoaSachTheoIDHoacTen(); // Xóa sách
                break;
            case 3:
                System.out.println("\n--- SUA SACH ---");
                docFile();
                capNhatSachVaGhiFile(); // Sửa sách
                break;
            case 4:
                System.out.println("\n--- XEM SACH ---");
                viewBooks(); // Xem sách
                break;
            case 5:
                xemLichSu("Them sach");
                break;
            case 6:
                xemLichSu("Sua sach"); // Xem lịch sử sửa sách
                break;
            case 7:
                xemLichSu("Xoa sach");   // Xem lịch sử xóa sách
                break;
            case 8:
                keepManaging = false; // Quay lại menu trước
                break;
            default:
                System.out.println("Lua chon khong hop le! Vui long chon lai.");
        }
    }
}

}
