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
    
//    public void manageDiscounts(DiscountManager discountManager) 
//    {
//                Scanner scanner = new Scanner(System.in);
//        boolean keepManaging = true;
//
//        while (keepManaging) {
//            System.out.println("\n--- Quản lý mã giảm giá ---");
//            System.out.println("1. Thêm mã giảm giá");
//            System.out.println("2. Xem danh sách mã giảm giá");
//            System.out.println("3. Quay lại");
//            System.out.print("Chọn chức năng: ");
//
//            int choice = Integer.parseInt(scanner.nextLine());
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Nhập mã giảm giá: ");
//                    String code = scanner.nextLine().trim();
//                    System.out.print("Nhập phần trăm giảm giá: ");
//                    double percentage = Double.parseDouble(scanner.nextLine());
//                    System.out.print("Nhập giá trị đơn hàng tối thiểu: ");
//                    double minOrder = Double.parseDouble(scanner.nextLine());
//                    discountManager.addDiscount(code, percentage, minOrder);
//                    break;
//                case 2:
//                    discountManager.viewDiscounts();
//                    break;
//                case 3:
//                    keepManaging = false;
//                    break;
//                default:
//                    System.out.println("Lựa chọn không hợp lệ!");
//            }
//        }
//    }
    
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
}
