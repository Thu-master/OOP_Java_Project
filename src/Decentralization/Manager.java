/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Manager extends User
{
    public Manager(String employeeId, String fullname, String role) 
    {
       super(employeeId, fullname, role);
    }

    @Override
    public void showPermissions() 
    {
       System.out.println("Quyen han: Them, xoa, sua sach. Them, xoa, sua nhan vien.");
    }
    
    public void requestAddEmployee(User_Management userManagement, User newEmployee) 
    {
        userManagement.addEmployeeRequest(newEmployee);
    }

        public void requestAddEmployeesWithMenu(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("\nNhập mã nhân viên mới: ");
        String empId = scanner.nextLine();
        System.out.print("Nhập họ tên nhân viên mới: ");
        String fullName = scanner.nextLine();
        User newEmployee = new Employee(empId, fullName, "Employee");
        userManagement.addEmployeeRequest(newEmployee);

        System.out.println("Đã gửi yêu cầu thêm nhân viên: " + fullName);
        System.out.println("Hiện có " + userManagement.getPendingRequests().size() + " yêu cầu đang chờ duyệt.");

        System.out.print("Bạn có muốn thêm nhân viên khác không? (Y/N): ");
        String choice = scanner.nextLine();
        if (!choice.equalsIgnoreCase("Y")) {
            break;
        }
    }
}

public void cancelRequest(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Danh sách yêu cầu chờ duyệt:");
    for (User pending : userManagement.getPendingRequests()) {
        System.out.println("- ID: " + pending.getEmloyeeI() + ", Tên: " + pending.getFullname());
    }
    System.out.print("\nNhập ID nhân viên bạn muốn hủy yêu cầu: ");
    String employeeId = scanner.nextLine();
    userManagement.cancelEmployeeRequest(employeeId);
}

        public void requestAddEmployeesWithUpdatedMenu(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    boolean keepAdding = true;

    while (keepAdding) {
        System.out.println("\n--- MENU QUẢN LÝ ---");
        System.out.println("Hiện có " + userManagement.getPendingRequests().size() + " yêu cầu đang chờ duyệt.");
        System.out.println("1. Thêm nhân viên mới");
        System.out.println("2. Thoát về menu chính");
        System.out.print("Chọn chức năng: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Nhập mã nhân viên mới: ");
                String empId = scanner.nextLine();
                System.out.print("Nhập họ tên nhân viên mới: ");
                String fullName = scanner.nextLine();
                User newEmployee = new Employee(empId, fullName, "Employee");
                userManagement.addEmployeeRequest(newEmployee);

                System.out.println("Đã gửi yêu cầu thêm nhân viên: " + fullName);
                break;
            case 2:
                keepAdding = false;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
        }
    }
}

        
}
