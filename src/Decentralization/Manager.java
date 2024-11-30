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
    
/*    public void requestAddEmployee(User_Management userManagement, User newEmployee) 
    {
        userManagement.addEmployeeRequest(newEmployee);
    }

    public void requestAddEmployeesWithMenu(User_Management userManagement) 
    {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.print("\nNhập mã nhân viên mới: ");
            String empId = scanner.nextLine();
            System.out.print("Nhập họ tên nhân viên mới: ");
            String fullName = scanner.nextLine();
            User newEmployee = new Employee(empId, fullName, "Employee");
            userManagement.addEmployeeRequest(newEmployee);

            System.out.println("Da gui yeu cau them nhan vien: " + fullName);
            System.out.println("Hien co " + userManagement.getPendingRequests().size() + " yeu cau dang cho duyet.");

            System.out.print("Ban co muon them nhan vien khac khong?(Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) 
            {
                break;
            }
        }
    }
        
    public void cancelRequest(User_Management userManagement) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Danh sach yeu cau cho duyet:");

        // Hiển thị danh sách yêu cầu đang chờ duyệt
        ArrayList<User> pendingRequests = userManagement.getPendingRequests();
        if (pendingRequests.isEmpty())
        {
            System.out.println("Khong co yeu cau nao dang cho duyet.");
            return;
        }

        for (User pending : pendingRequests) 
        {
            System.out.println("- ID: " + pending.getEmloyeeI() + ", Ten: " + pending.getFullname());
        }

        System.out.print("\nNhap ID nhan vien ban muon huy yeu cau: ");
        String employeeId = scanner.nextLine();

        // Kiểm tra yêu cầu có tồn tại trong danh sách không
        boolean exists = pendingRequests.stream()
                .anyMatch(req -> req.getEmloyeeI().equalsIgnoreCase(employeeId));

        if (exists) 
        {
            // Xác nhận từ người dùng
            System.out.print("Ban co chac chan muon huy yeu cau nay khong (Y/N)? ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) 
            {
                userManagement.cancelEmployeeRequest(employeeId);
            } 
            else 
            {
                System.out.println("Yeu cau khong duoc huy.");
            }
        } 
        else 
        {
            System.out.println("Khong tim thay yeu cau voi ID: " + employeeId);
        }
    }


    public void requestAddEmployeesWithUpdatedMenu(User_Management userManagement) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean keepAdding = true;

        while (keepAdding) 
        {
            System.out.println("\n--- MENU QUAN LY ---");
            System.out.println("Hien co " + userManagement.getPendingRequests().size() + " yeu cau dang cho duyet.");
            System.out.println("1. Them nhan vien moi");
            System.out.println("2. Huy yeu cau them nhan vien moi");
            System.out.println("3. Xem cac yeu cau da gui");
            System.out.println("4. Thoat ve menu chinh");
            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) 
            {
                case 1:
                    System.out.print("Nhap ma nhan vien moi: ");
                    String empId = scanner.nextLine();
                    System.out.print("Nhap ho ten nhan vien moi: ");
                    String fullName = scanner.nextLine();
                    User newEmployee = new Employee(empId, fullName, "Employee");
                    userManagement.addEmployeeRequest(newEmployee);
                    System.out.println("Da gui yeu cau them nhan vien: " + fullName);
                    break;
                case 2:
                    cancelRequest(userManagement);
                    break;
                case 3:
                    viewSentRequests(userManagement);
                    break;
                case 4:
                    keepAdding = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
        }
    }

    public void viewSentRequests(User_Management userManagement) 
    {
        ArrayList<User> pendingRequests = userManagement.getPendingRequests();

        // Lọc các yêu cầu được gửi bởi Manager hiện tại
        ArrayList<User> managerRequests = new ArrayList<>();
        for (User pending : pendingRequests) 
        {
            if (pending instanceof Employee) 
            {
               managerRequests.add(pending);
            }
        }
        // Kiểm tra và hiển thị danh sách yêu cầu đã gửi
        if (managerRequests.isEmpty()) 
        {
            System.out.println("Bạn chưa gửi yêu cầu nào.");
        } 
        else 
        {
            System.out.println("\n--- Danh sách các yêu cầu đã gửi ---");
            for (User request : managerRequests) 
            {
                System.out.println("- ID: " + request.getEmloyeeI() + ", Tên: " + request.getFullname());
            }
        }
    }*/
//---------------------------------------------------------------------------------------------------------------------
    // Gửi yêu cầu thêm nhân viên
public void requestAddEmployee(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ma so nhan vien muon them: ");
    String employeeId = scanner.nextLine();
    System.out.print("Nhap ho ten nhan vien muon them: ");
    String fullname = scanner.nextLine();

    User newEmployee = new Employee(employeeId, fullname, "Employee");
    userManagement.addEmployeeRequest(newEmployee);
    System.out.println("Da gui yeu cau them nhan vien: " + fullname);
}

    // Hủy yêu cầu thêm nhân viên
public void cancelAddRequest(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap ma so nhan vien muon huy yeu cau them: ");
    String employeeId = scanner.nextLine();

    userManagement.cancelEmployeeRequest(employeeId);
}

    // Xem các yêu cầu thêm đã gửi
public void viewSentAddRequests(User_Management userManagement) {
    ArrayList<User> addRequests = userManagement.getPendingRequests();

    if (addRequests.isEmpty()) {
        System.out.println("Ban chua gui yeu cau them nao.");
    } else {
        System.out.println("\n--- DANH SACH YEU CAU THEM DA GUI ---");
        for (User request : addRequests) {
            System.out.println("- ID: " + request.getEmloyeeI() + ", Ten: " + request.getFullname());
        }
    }
}
    
    // Quản lý yêu cầu thêm nhân viên
public void requestAddEmployeesWithMenu(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    boolean keepManaging = true;

    while (keepManaging) {
        System.out.println("\n--- QUAN LY YEU CAU THEM NHAN VIEN ---");
        System.out.println("Hien co " + userManagement.getPendingRequests().size() + " yeu cau them nhan vien dang cho duyet.");
        System.out.println("1. Gui yeu cau them nhan vien");
        System.out.println("2. Huy yeu cau them nhan vien");
        System.out.println("3. Xem cac yeu cau them da gui");
        System.out.println("4. Thoat ve menu chinh");
        System.out.print("Chon chuc nang: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                // Gửi yêu cầu thêm nhân viên
                requestAddEmployee(userManagement);
                break;
            case 2:
                // Hủy yêu cầu thêm nhân viên
                cancelAddRequest(userManagement);
                break;
            case 3:
                // Xem các yêu cầu thêm đã gửi
                viewSentAddRequests(userManagement);
                break;
            case 4:
                // Thoát menu
                keepManaging = false;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
        }
    }
}

    
//---------------------------------------------------------------------------------------------------------------------    
    // Gửi yêu cầu xóa nhân viên
    public void requestDeleteEmployee(User_Management userManagement) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma so nhan vien muon xoa: ");
        String employeeId = scanner.nextLine();
        System.out.print("Nhap ho ten nhan vien muon xoa: ");
        String fullname = scanner.nextLine();

        User userToDelete = userManagement.findUserByInfo(employeeId, fullname);
        if (userToDelete != null) 
        {
           userManagement.addDeleteEmployeeRequest(userToDelete);
           System.out.println("Da gui yeu cau xoa nhan vien: " + fullname);
        } 
        else 
        {
           System.out.println("Khong tim thay nhan vien voi thong tin da nhap.");
        }
    }

    // Hủy yêu cầu xóa nhân viên
    public void cancelDeleteRequest(User_Management userManagement) 
    {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Nhap ma so nhan vien muon huy yeu cau xoa: ");
       String employeeId = scanner.nextLine();

       userManagement.cancelDeleteEmployeeRequest(employeeId);
    }

    public void requestDeleteEmployeesWithMenu(User_Management userManagement) {
    Scanner scanner = new Scanner(System.in);
    boolean keepManaging = true;

    while (keepManaging) {
        System.out.println("\n--- QUAN LY YEU CAU XOA NHAN VIEN ---");
        System.out.println("Hien co " + userManagement.getDeleteRequests().size() + " yeu cau xoa nhan vien dang cho duyet.");
        System.out.println("1. Gui yeu cau xoa nhan vien");
        System.out.println("2. Huy yeu cau xoa nhan vien");
        System.out.println("3. Xem cac yeu cau xoa da gui");
        System.out.println("4. Thoat ve menu chinh");
        System.out.print("Chon chuc nang: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                // Gửi yêu cầu xóa nhân viên
                requestDeleteEmployee(userManagement);
                break;
            case 2:
                // Hủy yêu cầu xóa nhân viên
                cancelDeleteRequest(userManagement);
                break;
            case 3:
                // Xem các yêu cầu xóa đã gửi
                viewSentDeleteRequests(userManagement);
                break;
            case 4:
                // Thoát menu
                keepManaging = false;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
        }
    }
}

// Xem các yêu cầu xóa đã gửi
public void viewSentDeleteRequests(User_Management userManagement) {
    ArrayList<User> deleteRequests = userManagement.getDeleteRequests();

    if (deleteRequests.isEmpty()) {
        System.out.println("Ban chua gui yeu cau xoa nao.");
    } else {
        System.out.println("\n--- DANH SACH YEU CAU XOA DA GUI ---");
        for (User request : deleteRequests) {
            System.out.println("- ID: " + request.getEmloyeeI() + ", Ten: " + request.getFullname());
        }
    }
}

        
}
