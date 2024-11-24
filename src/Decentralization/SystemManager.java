/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

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

    public void run() {
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
            return;
        }

        // Hiển thị quyền hạn
        System.out.println("Xin chao, " + user.getFullname() + "!");
        user.showPermissions();

        // Hiển thị menu
        showMenu(user);
    }

    private void showMenu(User user) {
        switch (user.getRole()) {
            case "Employee":
                System.out.println("\n--- MENU NHAN VIEN ---");
                System.out.println("1. Them sach");
                System.out.println("2. Xoa sach");
                System.out.println("3. Sua sach");
                break;
            case "Manager":
                System.out.println("\n--- MENU QUAN LY ---");
                System.out.println("1. Them sach");
                System.out.println("2. Xoa sach");
                System.out.println("3. Sua sach");
                System.out.println("4. Them nhan vien");
                System.out.println("5. Xoa nhan vien");
                System.out.println("6. Sua nhan vien");
                break;
            case "Admin":
                System.out.println("Ban co toan quyen trong he thong.");
                break;
            default:
                System.out.println("Chuc vu khong hop le!");
        }
    }
}