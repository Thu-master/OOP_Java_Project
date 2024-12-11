/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import Funtion.DiscountManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Admin extends User
{
    public Admin(String employeeId, String fullname, String role) 
    {
       super(employeeId, fullname, role);
    }

    @Override
    public void showPermissions() 
    {
       System.out.println("Quyen han: Toan quyen trong he thong.");
    }
    
    public void approveAddEmployee(User_Management userManagement) 
    {
        userManagement.approveRequest();
    }

//--------------------------------------------------------------------------------------------------------------------
    // Phê duyệt yêu cầu thêm nhân viên
    public void approveAddEmployeeRequest(User_Management userManagement) 
    {
       userManagement.approveRequest();
    }

    // Phê duyệt yêu cầu xóa nhân viên
    public void approveDeleteEmployeeRequest(User_Management userManagement) 
    {
       userManagement.approveDeleteEmployee();
    }
    
    // Xem danh sách nhân viên hiện tại
    public void viewEmployeeList(User_Management userManagement) 
    {
        //userManagement.loadUsersFromFile("List-NV.txt");
        System.out.println("\n--- DANH SACH NHAN VIEN HIEN TAI ---");
        for (User user : userManagement.getUsers()) 
        {
            System.out.println("- ID: " + user.getEmloyeeI() + ", Ten: " + user.getFullname() + ", Chuc vu: " + user.getRole());
        }
    }

    // Quản lý người dùng
    public void manageUsersWithMenu(User_Management userManagement) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean keepManaging = true;

        while (keepManaging) {
            System.out.println("\n--- QUAN LY NHAN VIEN ---");
            System.out.println("Ban dang co " + userManagement.getPendingRequests().size() + " yeu cau them nhan vien can duyet.");
            System.out.println("Ban dang co " + userManagement.getDeleteRequests().size() + " yeu cau xoa nhan vien can duyet.");
            System.out.println("1. Phe duyet yeu cau them nhan vien");
            System.out.println("2. Phe duyet yeu cau xoa nhan vien");
            System.out.println("3. Xem lich su duyet");
            System.out.println("4. Xem danh sach nhan vien hien tai");
            System.out.println("5. Quay lai");
            System.out.println("0. Thoat chuong trinh");
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
                    // Phê duyệt yêu cầu thêm nhân viên
                    approveAddEmployeeRequest(userManagement);
                    break;
                case 2:
                    // Phê duyệt yêu cầu xóa nhân viên
                    approveDeleteEmployeeRequest(userManagement);
                    break;
                case 3:
                    // Xem lịch sử duyệt
                    userManagement.viewApprovalHistory("[Employee Approval]");
                    break;
                case 4:
                    // Xem danh sách nhân viên hiện tại
                    viewEmployeeList(userManagement);
                    break;
                case 5:
                    // Thoát menu
                    keepManaging = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------
 public void manageSales() {
        Scanner sc = new Scanner(System.in);
        boolean keepManaging = true;

        while (keepManaging) {
            System.out.println("\n--- MENU THONG KE DOANH SO ---");
            System.out.println("1. Thong ke doanh so sach");
            System.out.println("2. Doanh thu cua nhan vien");
            System.out.println("3. Mat hang ban chay nhat");
            System.out.println("5. Quay lai");
            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    reportSales();
                    break;
                case 2:
                    topEmployeesByRevenue();
                    break;
                case 3:
                    bestSellingProduct();
                    break;
                case 5:
                    keepManaging = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

private void reportSales() {
    Map<String, int[]> salesReport = new HashMap<>();
    String filePath = "invoices.txt"; // Đường dẫn file

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("Ten sach:")) {
                String[] parts = line.split(",");
                if (parts.length >= 3) { // Kiểm tra đủ thông tin
                    try {
                        String bookName = parts[0].split(":")[1].trim();
                        int quantity = Integer.parseInt(parts[1].split(":")[1].trim());
                        double price = Double.parseDouble(parts[2].split(":")[1].trim().replace(",", "."));

                        // Cập nhật vào report
                        salesReport.putIfAbsent(bookName, new int[2]);
                        salesReport.get(bookName)[0] += quantity;
                        salesReport.get(bookName)[1] += (int) (quantity * price);
                    } catch (Exception e) {
                        System.out.println("Dòng bị lỗi: " + line);
                        continue; // Bỏ qua dòng không hợp lệ
                    }
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Loi khi doc file: " + e.getMessage());
    }

    // Hiển thị kết quả
    System.out.println("\n--- Thong ke doanh so sach ---");
    System.out.printf("%-30s %-11s %-15s\n", "Ten sach", "So luong", "Doanh so (VND)");
    salesReport.forEach((bookName, stats) -> {
        try {
            System.out.printf("%-30s %-11d %-15s\n", bookName, stats[0], String.format("%,.2f", (double) stats[1])); // Định dạng giá tiền ngăn cách hàng nghìn
        } catch (Exception e) {
            System.out.println("Loi khi in dong: " + bookName);
        }
    });
}

    private void topEmployeesByRevenue() {
        Map<String, Double> employeeRevenueReport = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("invoices.txt"))) {
            String line;
            String currentEmployee = "Unknown"; // Lưu trữ nhân viên hiện tại

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Kiểm tra dòng chứa thông tin nhân viên
                if (line.startsWith("Ca:")) {
                    String[] parts = line.split(" - Thu ngan: ");
                    if (parts.length > 1) {
                        currentEmployee = parts[1].split(" \\(ID:")[0].trim();
                    }
                }

                // Kiểm tra dòng chứa tổng cộng
                if (line.startsWith("Tong cong:")) {
                    String totalString = line.split(":")[1].trim().replace(",", ".");
                    double total = Double.parseDouble(totalString);

                    // Cộng dồn doanh thu cho nhân viên
                    employeeRevenueReport.put(currentEmployee,
                            employeeRevenueReport.getOrDefault(currentEmployee, 0.0) + total);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Loi khi doc file hoa don: " + e.getMessage());
        }

        // Hiển thị top 3 nhân viên có doanh thu cao nhất
        System.out.println("\n--- Doanh thu của nhan vien ---");
        employeeRevenueReport.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sắp xếp theo doanh thu giảm dần
            .limit(3) // Lấy top 3
            .forEach(entry -> 
                System.out.println("Nhan vien: " + entry.getKey() + ", Doanh thu: " + String.format("%,.2f VND", entry.getValue()))
            );
    }

    private void bestSellingProduct() {
        Map<String, Integer> productReport = new HashMap<>();
        readInvoices((book, quantity, price, employee) -> {
            productReport.put(book, productReport.getOrDefault(book, 0) + quantity);
        });
        System.out.println("\n--- San pham ban chay nhat ---");
        productReport.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .ifPresent(entry -> 
                System.out.println("Sach ban chay nhat: " + entry.getKey() + ", So luong: " + entry.getValue())
            );
    }

    private void readInvoices(InvoiceProcessor processor) {
        try (BufferedReader br = new BufferedReader(new FileReader("invoices.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Ten sach:")) {
                    String[] parts = line.split(", ");
                    String book = parts[0].split(":")[1].trim();
                    int quantity = Integer.parseInt(parts[1].split(":")[1].trim());
                    // Chuyển đổi định dạng trước khi parse double
                    String priceString = parts[2].split(":")[1].trim().replace(",", ".");
                    double price = Double.parseDouble(priceString);
                    //double price = Double.parseDouble(parts[2].split(":")[1].trim());
                    String employee = parts.length > 3 ? parts[3].split(":")[1].trim() : "Unknown";
                    processor.process(book, quantity, price, employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file hoa don: " + e.getMessage());
        }
    }

    private interface InvoiceProcessor {
        void process(String book, int quantity, double price, String employee);
    }
//--------------------------------------------------------------------------------------------------------------------
    public void manageDiscounts() {
    DiscountManager discountManager = new DiscountManager();
    Scanner sc = new Scanner(System.in);
    boolean keepManaging = true;

    while (keepManaging) {
        System.out.println("\n--- QUAN LY MA GIAM GIA ---");
        System.out.println("1. Them ma giam gia");
        System.out.println("2. Xoa ma giam gia");
        System.out.println("3. Sua ma giam gia");
        System.out.println("4. Xem danh sach ma giam gia");
        System.out.println("5. Quay lai");
        System.out.print("Chon chuc nang: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Nhap ma giam gia: ");
                String code = sc.nextLine();
                System.out.print("Nhap mo ta: ");
                String description = sc.nextLine();
                System.out.print("Nhap so luong sach toi thieu: ");
                int minBooks = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap gia tri toi thieu: ");
                double minAmount = Double.parseDouble(sc.nextLine());
                System.out.print("Nhap so tien giam: ");
                double discountAmount = Double.parseDouble(sc.nextLine());
                discountManager.addDiscount(code, description, minBooks, minAmount, discountAmount);
                break;
            case 2:
                System.out.print("Nhap ma giam gia can xoa: ");
                discountManager.deleteDiscount(sc.nextLine());
                break;
            case 3:
                System.out.print("Nhap ma giam gia can sua: ");
                code = sc.nextLine();
                System.out.print("Nhap mo ta moi: ");
                description = sc.nextLine();
                System.out.print("Nhap so luong sach toi thieu: ");
                minBooks = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap gia tri toi thieu: ");
                minAmount = Double.parseDouble(sc.nextLine());
                System.out.print("Nhap so tien giam: ");
                discountAmount = Double.parseDouble(sc.nextLine());
                discountManager.modifyDiscount(code, description, minBooks, minAmount, discountAmount);
                break;
            case 4:
                discountManager.displayDiscounts();
                break;
            case 5:
                keepManaging = false;
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }
}

}
