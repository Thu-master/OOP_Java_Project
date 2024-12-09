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
import Decentralization.SystemManager;
import Decentralization.User;



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
        Scanner sc = new Scanner(System.in);
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
            int choice = Integer.parseInt(sc.nextLine());

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
        System.out.println("Ban dang trong che do them sach. Nhan Enter de quay lai menu neu ban khong muon them");
        System.out.println("Nhap loai sach:");
        String type = sc.nextLine();
        if (type.isEmpty())
        {
            System.out.println("Thoat khoi che do them sach.");
            return;
        }
        System.out.println("Nhap ma so sach:");
        String id = sc.nextLine();
        if (id.isEmpty())
        {
            System.out.println("Thoat khoi che do them sach.");
            return;
        }
        if (kiemTraIdVaTen(id, "")) {
            System.out.println("Ma sach da ton tai. Khong the them sach trung ID.");
            return;
        }

        System.out.println("Nhap ten sach:");
        String name = sc.nextLine();
        if (name.isEmpty())
        {
            System.out.println("Thoat khoi che do them sach.");
            return;
        }
        if (kiemTraIdVaTen("", name)) {
            System.out.println("Ten sach da ton tai. Khong the them sach trung ten.");
            return;
        }

        System.out.println("Nhap gia sach:");
        String priceInput = sc.nextLine();
        if (priceInput.isEmpty()) {
            System.out.println("Thoat khoi che do them sach.");
            return;
        }
        double price = Double.parseDouble(priceInput);
        
        System.out.println("Nhap so luong:");
        String quantityInput = sc.nextLine();
        if (quantityInput.isEmpty()) {
            System.out.println("Thoat khoi che do them sach.");
            return;
        }
        int quantity = Integer.parseInt(quantityInput);
        System.out.println("Nhap ten tac gia:");
        String author = sc.nextLine();
        if (author.isEmpty()){
            System.out.println("Thoat khoi che do them sach.");
            return;
        }
        Book newBook = new Book(type, id, name, price, quantity, author);
        
        try{
            File f = new File ("sach.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(newBook.toString());
            booksByType.computeIfAbsent(type, k -> new ArrayList<>()).add(newBook);
            System.out.println("Da them sach va ghi vao file thanh cong.");
            ghiLichSu("Them sach", newBook);
        } catch (Exception e) {
            System.out.println("Khong the ghi file");
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
        try{
            File f = new File("approval_history.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println("[" + timestamp + "] [Book Action] " + hanhDong + " - Loai: " + book.getType() +
                    ", Ma so: " + book.getId() + ", Ten: " + book.getName() +
                    ", Gia: " + book.getPrice() + ", So luong: " + book.getQuantity() +
                    ", Tac gia: " + book.getAuthor());
        } catch (IOException e) {
            System.out.println("Khong the ghi lich su: " + e.getMessage());
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
    Scanner sc = new Scanner(System.in);
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
        System.out.println("8. Xem lich su hoa don");
        System.out.println("9. Quay lai");
        System.out.print("Chon chuc nang: ");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) 
        {
/*            case 0:
                //Thoát chương trình
                System.out.println("Dang thoat chuong trinh... Tam biet!");
                System.exit(0);
                break;*/
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
                viewPaymentHistory(); //Gọi phương thức xem lịch sử hóa đơn
                break;
            case 9:
                keepManaging = false; // Quay lại menu trước
                break;
            default:
                System.out.println("Lua chon khong hop le! Vui long chon lai.");
        }
    }
}
    
    public void muaSach() {
        Bill billManager = new Bill();
        Scanner sc = new Scanner(System.in);
        boolean keepShopping = true;

        while (keepShopping) {
            System.out.println("\n--- MENU MUA SACH ---");
            System.out.println("1. Them sach vao gio hang");
            System.out.println("2. Xem gio hang");
            System.out.println("3. Chinh sua gio hang");
            System.out.println("4. Thanh toan");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    billManager.TinhThanhTien(this); // Thêm sách vào giỏ
                    break;
                case 2:
                    System.out.println("\n--- Gio hang hien tai ---");
                    System.out.println(billManager.toString()); // Xem giỏ hàng
                    break;
                case 3:
                    suaGioHang(billManager); // Chỉnh sửa giỏ hàng
                    break;
                case 4:
                    if (billManager.getCart().isEmpty()) 
                    {
                        System.out.println("Gio hang cua ban dang trong. Vui long them sach truoc khi thanh toan.");
                        break;
                    }
                    else
                    {
                    hienThiHoaDon(billManager); // Xuất giao diện hóa đơn
                    savePaymentHistory(billManager); // Lưu hóa đơn
                    updateInventory(billManager); // Cập nhật tồn kho
                    billManager.getCart().clear(); // Xóa giỏ hàng sau thanh toán
                    billManager.setThanhTien(0);   // Đặt tổng thành tiền về 0
                    }
                    keepShopping = false; // Thoát sau thanh toán
                    break;
                case 0:
                    keepShopping = false; // Thoát menu mua sách
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai!");
            }
        }
    }

private void hienThiHoaDon(Bill billManager) 
{
    // Lấy thông tin ca làm việc từ Bill
    String currentShift = billManager.getCurrentShift();

    // Lấy thông tin nhân viên từ SystemManager
    User currentUser = SystemManager.getCurrentUser();
    String cashierName = (currentUser != null) ? currentUser.getFullname() : "Unknown";
    String cashierId = (currentUser != null) ? currentUser.getEmloyeeI() : "N/A";
    
        // Định nghĩa độ rộng bảng
        int width = 83; // Tổng chiều rộng bảng
        int col1Width = 40; // Cột "Mặt hàng"
        int col2Width = 6;  // Cột "SL"
        int col3Width = 12; // Cột "Đơn giá"
        int col4Width = 12; // Cột "Thành tiền"
        String border = "-".repeat(width);

        // Tính tổng tiền và thuế từ billManager
        billManager.calculateThanhTien();
        double totalAmount = billManager.getThanhTien(); // Lấy tổng tiền đã tính trong Bill
        double taxRate = 0.08; // Thuế 8%
        double totalTax = Math.round(totalAmount * taxRate); // Tính thuế
        double finalAmount = totalAmount + totalTax; // Tổng cộng sau thuế

        // Yêu cầu người dùng nhập số tiền khách trả
        Scanner sc = new Scanner(System.in);
        double tienKhachTra = 0;
        while (true) {
            System.out.printf("\nTong cong : %.2f VND\n", totalAmount);
            System.out.print("Nhap so tien khach tra: ");
            tienKhachTra = sc.nextDouble();

            if (tienKhachTra >= finalAmount) {
                break; // Số tiền hợp lệ
            } else {
                System.out.println("So tien khach tra khong du (Co the vi bao gom thue)! Vui long nhap lai.");
            }
        }

        double tienThua = tienKhachTra - finalAmount; // Tính tiền thừa

        // In header của hóa đơn
        System.out.println(border);
        System.out.printf("| %-30s %-48s |\n", " " ,"NHA SACH TRUNG LAN");
        System.out.printf("| %-22s %-56s |\n", " " ,"42/4 TTN01, P. TAN THOI NHAT, Q12");
        System.out.println(border);
        System.out.printf("| %-79s |\n", "Khach hang: Khach le");
        System.out.printf("| %-79s |\n", "So PTT: 00000052       Ngay: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.printf("| %-79s |\n", 
                           String.format("Ca: %s - Thu ngan: %s (ID: %s)", currentShift, cashierName, cashierId));
        System.out.println(border);

        // In danh sách sách trong giỏ hàng
        System.out.printf("| %-40s | %-6s | %-12s | %-12s |\n", "Mat hang", "SL", "Don gia", "Thanh tien");
        System.out.println(border);

        for (Book book : billManager.getCart()) {
            double thanhTien = book.getPrice() * book.getQuantity(); // Thành tiền từng sách
            String itemName = book.getName();
            if (itemName.length() > col1Width - 2) {
                itemName = itemName.substring(0, col1Width - 5) + "..."; // Cắt tên nếu dài
            }
            System.out.printf("| %-40s | %d      | %.0f       | %.0f      |\n",
                    String.format("%-" + col1Width + "s", itemName), 
                    book.getQuantity(), 
                    book.getPrice(), 
                    thanhTien);
        }

        // Hiển thị phần tổng tiền, thuế, và các thông tin thanh toán
        System.out.println(border);
        System.out.printf("| %-40s | %-6s | %-12s | %12.0f |\n", "Tong tien:", "", "", totalAmount);
        System.out.printf("| %-40s | %-6s | %-12s | %12.0f |\n", "Thue 8%:", "", "", totalTax);
        System.out.printf("| %-40s | %-6s | %-12s | %12.0f |\n", "Tong cong:", "", "", finalAmount);
        System.out.printf("| %-40s | %-6s | %-12s | %12.0f |\n", "Tien khach tra:", "", "", tienKhachTra);
        System.out.printf("| %-40s | %-6s | %-12s | %12.0f |\n", "Tien thua:", "", "", tienThua);

        // Đóng khung
        System.out.println(border);
        System.out.printf("| %-79s |\n", "Cam on Quy khach, hen gap lai!");
        System.out.println(border);
    }

    // Phương thức chỉnh sửa giỏ hàng
    private void suaGioHang(Bill billManager) {
        Scanner sc = new Scanner(System.in);
        if (billManager.getCart().isEmpty()) {
            System.out.println("Gio hang cua ban dang trong.");
            return;
        }

        System.out.println("\n--- Gio hang hien tai ---");
        System.out.println(billManager.toString());
        System.out.print("Nhap ID hoac ten sach can xoa khoi gio hang: ");
        String search = sc.nextLine().trim();

        Book bookToRemove = null;
        for (Book b : billManager.getCart()) {
            if (b.getId().equalsIgnoreCase(search) || b.getName().equalsIgnoreCase(search)) {
                bookToRemove = b;
                break;
            }
        }

        if (bookToRemove != null) {
            billManager.getCart().remove(bookToRemove);
            System.out.println("Da xoa sach \"" + bookToRemove.getName() + "\" khoi gio hang.");
        } else {
            System.out.println("Khong tim thay sach trong gio hang.");
        }
    }

    // Lưu hóa đơn vào file
    private void savePaymentHistory(Bill billManager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("invoices.txt", true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        // Lấy thông tin ca làm việc
            String currentShift = billManager.getCurrentShift();

            // Lấy thông tin thu ngân
            User currentUser = SystemManager.getCurrentUser();
            String cashierName = (currentUser != null) ? currentUser.getFullname() : "Unknown";
            String cashierId = (currentUser != null) ? currentUser.getEmloyeeI() : "N/A";
            
            writer.write("[" + timestamp + "]\n");
            writer.write("Ca: " + currentShift + " - Thu ngan: " + cashierName + " (ID: " + cashierId + ")\n");
            writer.write("--- Hoa don thanh toan ---\n");          
            for (Book book : billManager.getCart()) {
                writer.write(String.format("Ten sach: %s, So luong: %d, Don gia: %.2f, Thanh tien: %.2f\n",
                        book.getName(), book.getQuantity(), book.getPrice(), book.getPrice() * book.getQuantity()));
            }
            double totalAmount = billManager.getThanhTien();
            double taxRate = 0.08;
            double totalTax = totalAmount * taxRate;
            double finalAmount = totalAmount + totalTax;
            writer.write(String.format("Tong tien: %.2f\nThue (8%%): %.2f\nTong cong: %.2f\n", totalAmount, totalTax, finalAmount));
            writer.write("-----------------------------\n\n");
            System.out.println("Lich su thanh toan da duoc luu.");
        } catch (IOException e) {
            System.out.println("Loi khi luu lich su thanh toan: " + e.getMessage());
        }
    }
    
    public void viewPaymentHistory() {
    try (BufferedReader reader = new BufferedReader(new FileReader("invoices.txt"))) {
        String line;
        System.out.println("\n--- Lich su thanh toan ---");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Khong co lich su thanh toan nao.");
    } catch (IOException e) {
        System.out.println("Loi khi doc lich su thanh toan: " + e.getMessage());
    }
}


    // Cập nhật tồn kho
    private void updateInventory(Bill billManager) {
        for (Book purchasedBook : billManager.getCart()) {
            for (ArrayList<Book> books : booksByType.values()) {
                for (Book book : books) {
                    if (book.getId().equalsIgnoreCase(purchasedBook.getId())) {
                        book.setQuantity(book.getQuantity() - purchasedBook.getQuantity());
                    }
                }
            }
        }
        ghiLaiFile(); // Lưu lại dữ liệu sách sau cập nhật
    }
    
}
