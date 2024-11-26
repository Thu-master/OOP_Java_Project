/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import Funtion.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class SystemManager 
{
    private User_Management userManagement; // Quản lý người dùng
    private Scanner scanner;                // Nhập dữ liệu từ bàn phím

    public SystemManager() {
        userManagement = new User_Management();
        scanner = new Scanner(System.in);

        // Nạp dữ liệu từ file
        String filePath = "List-NV.txt"; // Đường dẫn tới file
        userManagement.loadUsersFromFile(filePath);
    }

//    public void run() 
//    {
//        System.out.println("He thong quan ly nguoi dung da san sang.");
//        // Nhập thông tin người dùng
//        System.out.print("Nhap ma so nhan vien: ");
//        String employeeId = scanner.nextLine();
//
//        System.out.print("Nhap ho ten cua ban: ");
//        String fullName = scanner.nextLine();
//
//        // Tìm kiếm người dùng
//        User user = userManagement.findUserByInfo(employeeId, fullName);
//        if (user == null) 
//        {
//            System.out.println("Thong tin khong ton tai! Vui long kiem tra lai.");
//            return;
//        }
//
//        // Hiển thị quyền hạn
//        System.out.println("Xin chao, " + user.getFullname() + "!");
//        user.showPermissions();
//
//        // Hiển thị menu
//        showMenu(user);
//    }
    
    public void run() {
    boolean keepRunning = true;
    Scanner scanner = new Scanner(System.in);

    while (keepRunning) {
        System.out.println("He thong quan ly nguoi dung da san sang.");

        // Nhập thông tin người dùng
        System.out.print("Nhap ma so nhan vien: ");
        String employeeId = scanner.nextLine();

        System.out.print("Nhap ho ten cua ban: ");
        String fullName = scanner.nextLine();

        // Tìm kiếm người dùng
        User user = userManagement.findUserByInfo(employeeId, fullName);

        if (user == null) {
            System.out.println("Thong tin khong ton tai! Vui long kiem tra lai.");

            // Hỏi người dùng có muốn đăng nhập lại không
            System.out.print("Ban co muon thu lai khong (Y/N): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("Y")) {
                System.out.println("Thoat chuong trinh.");
                keepRunning = false; // Thoát chương trình
            }
        } else {
            // Đăng nhập thành công
            System.out.println("\nXin chao, " + user.getFullname() + "!");
            user.showPermissions();
            showMenu(user); // Hiển thị menu chính
            keepRunning = false; // Thoát sau khi xử lý menu
        }
    }
}
    
    private void showMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        Book bookManager = new Book();

        while (keepRunning) {
            switch (user.getRole()) {
                case "Employee":
                    System.out.println("\n--- MENU NHAN VIEN ---");
                    System.out.println("1. Them sach");
                    System.out.println("2. Xoa sach");
                    System.out.println("3. Sua sach");
                    System.out.println("4. Xem sach");
                    System.out.println("5. Thoat");
                    break;
                case "Manager":
                    System.out.println("\n--- MENU QUAN LY ---");
                    System.out.println("1. Them sach");
                    System.out.println("2. Xoa sach");
                    System.out.println("3. Sua sach");
                    System.out.println("4. Them nhan vien");
                    System.out.println("5. Xoa nhan vien");
                    System.out.println("6. Sua nhan vien");
                    System.out.println("7. Xem sach");
                    System.out.println("8. Thoat");
                    break;
                case "Admin":
                    System.out.println("Ban co toan quyen trong he thong.");
                    System.out.println("1. Quan ly nguoi dung");
                    System.out.println("2. Them sach");
                    System.out.println("3. Xem sach");
                    System.out.println("4. Thoat");
                    break;
                default:
                    System.out.println("Chuc vu khong hop le!");
                    return;
            }

            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("\n--- Them sach ---");
                    bookManager.docFile();
                    bookManager.ghiFile();
                    break;
                case 2:
                    System.out.println("Xoa sach");
                    break;
                case 3:
                    System.out.println("Sua sach");
                    break;
                case 4:
                    if (user.getRole().equals("Admin") || user.getRole().equals("Manager")) {
                        System.out.println("Quan ly nguoi dung");
                    } else {
                        viewBooks();
                    }
                    break;
                case 5:
                    if (user.getRole().equals("Employee")) {
                        keepRunning = false;
                    } else {
                        System.out.println("Khong hop le");
                    }
                    break;
                case 8:
                    if (user.getRole().equals("Manager")) {
                        keepRunning = false;
                    }
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
}

private void viewBooks() {
    Scanner scanner = new Scanner(System.in);
    Book b = new Book();
    b.docFile();
    boolean backToMainMenu = false;

    while (!backToMainMenu) {
        System.out.println("\n--- MENU XEM SACH ---");
        System.out.println("1: Giao khoa lop 1");
        System.out.println("2: Giao khoa lop 2");
        System.out.println("3: Giao khoa lop 3");
        System.out.println("4: Giao khoa lop 4");
        System.out.println("5: Giao khoa lop 5");
        System.out.println("6: Giao khoa lop 6");
        System.out.println("7: Giao khoa lop 7");
        System.out.println("8: Giao khoa lop 8");
        System.out.println("9: Giao khoa lop 9");
        System.out.println("10: Giao khoa lop 10");
        System.out.println("11: Giao khoa lop 11");
        System.out.println("12: Giao khoa lop 12");
        System.out.println("0: Quay lai");

        System.out.print("Chon loai sach: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                displayBooks(b.getGk1Book());
                break;
            case 2:
                displayBooks(b.getGk2Book());
                break;
            case 3:
                displayBooks(b.getGk3Book());
                break;
            case 4:
                displayBooks(b.getGk4Book());
                break;
            case 5:
                displayBooks(b.getGk5Book());
                break;
            case 6:
                displayBooks(b.getGk6Book());
                break;
            case 7:
                displayBooks(b.getGk7Book());
                break;
            case 8:
                displayBooks(b.getGk8Book());
                break;
            case 9:
                displayBooks(b.getGk9Book());
                break;
            case 10:
                displayBooks(b.getGk10Book());
                break;
            case 11:
                displayBooks(b.getGk11Book());
                break;
            case 12:
                displayBooks(b.getGk12Book());
                break;
            case 0:
                backToMainMenu = true;
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }
}

private void displayBooks(ArrayList<Book> books) {
    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
    for (Book book : books) {
        System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n",
                book.getType(), book.getId(), book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor());
    }
}
}
