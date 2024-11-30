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
    
    public void run() {
    boolean keepRunning = true;
    Scanner scanner = new Scanner(System.in);

    while (keepRunning) 
    {
        System.out.println("He thong quan ly nguoi dung da san sang.");

        // Nhập thông tin người dùng
        System.out.print("Nhap ma so nhan vien: ");
        String employeeId = scanner.nextLine();

        System.out.print("Nhap ho ten cua ban: ");
        String fullName = scanner.nextLine();

        // Tìm kiếm người dùng
        User user = userManagement.findUserByInfo(employeeId, fullName);

        if (user == null) 
        {
            System.out.println("Thong tin khong ton tai! Vui long kiem tra lai.");

            // Hỏi người dùng có muốn đăng nhập lại không
            System.out.print("Ban co muon thu lai khong (Y/N): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("Y")) 
            {
                System.out.println("Thoat chuong trinh.");
                keepRunning = false; // Thoát chương trình
                //break;
            }
        } 
        else 
        {
            // Đăng nhập thành công
            System.out.println("\nXin chao, " + user.getFullname() + "!");
            user.showPermissions();
//            showMenu(user); // Hiển thị menu chính
//            keepRunning = false; // Thoát sau khi xử lý menu

            // Chuyển đến menu chính
            boolean backToLogin = showMenu(user);
            if(backToLogin)
            {
                System.out.println("\nQuay lai man hinh dang nhap");
            }
            else
            {
                keepRunning = false;//Thoát chương trình
            }
        }
    }
}
    
    private boolean showMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        Book bookManager = new Book();

        while (keepRunning) {
            switch (user.getRole()) 
            {
                case "Employee":
                    System.out.println("\n--- MENU NHAN VIEN ---");
                    System.out.println("1. Them sach");
                    System.out.println("2. Xoa sach");
                    System.out.println("3. Sua sach");
                    System.out.println("4. Xem sach");
                    System.out.println("5. Thoat");
                    System.out.println("10. Quay lai dang nhap");
                    break;
                case "Manager":
                    System.out.println("\n--- MENU QUAN LY ---");
                    int totalPending = userManagement.getPendingRequests().size();
                    //int approved = userManagement.countApprovedRequests(user.getEmloyeeI());
                    int approvedCount = userManagement.countApprovedRequestsByManager(user.getEmloyeeI());
                    System.out.println("Hien co " + totalPending + " yeu cau dang cho duyet.");
                    System.out.println("Ban co " + approvedCount + " yeu cau da duoc duyet.");
                    System.out.println("1. Them sach");
                    System.out.println("2. Xoa sach");
                    System.out.println("3. Sua sach");
                    System.out.println("4. Gui yeu cau them nhan vien");
                    System.out.println("5. Xoa nhan vien");
                    System.out.println("6. Sua nhan vien");
                    System.out.println("7. Xem sach");
                    System.out.println("8. Huy yeu cau them nhan vien");
                    System.out.println("9. Thoat");
                    System.out.println("10. Quay lai dang nhap");
                    break;
                case "Admin":
                    System.out.println("\n--- MENU BOSS ---");
                    System.out.println("Bạn đang có " + userManagement.getPendingRequests().size() + " yeu cau them nhan vien can duyet.");
                    System.out.println("1. Quan ly nguoi dung");
                    System.out.println("2. Phe duyet yeu cau them nhan vien");
                    System.out.println("3. Them sach");
                    System.out.println("4. Xem sach");
                    System.out.println("5. Xem lich su duyet");
                    System.out.println("9. Thoat");
                    System.out.println("10. Quay lai dang nhap");
                    break;
                default:
                    System.out.println("Chuc vu khong hop le!");
                    return false;
            }

            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) 
            {
                case 1:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                        System.out.println("\n--- Them sach ---");
                        bookManager.docFile();
                        bookManager.ghiFile();
                    } 
                    else 
                    {
                        System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 2:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                        System.out.println("Xoa sach"); // Chưa có chức năng xóa sách
                    } 
                    else
                    {
                        ((Admin) user).approveAddEmployee(userManagement);
                    } 
                    break;
                case 3:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                        System.out.println("Sua sach"); //Chưa có chức năng sửa sách
                    } 
                    else if (user.getRole().equals("Admin"))
                    {
                        System.out.println("\n--- Them sach ---");
                        bookManager.docFile();
                        bookManager.ghiFile();
                    }
                    else
                    {
                        System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 4:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Admin")) 
                    {
                        viewBooks();
                    } 
                    else
                    {
                        System.out.print("Nhap ma nhan vien: ");
                        String empId = scanner.nextLine();
                        System.out.print("Nhap ho ten nhan vien: ");
                        String fullname = scanner.nextLine();
                        User newEmployee = new Employee(empId, fullname, "Employee");
                        ((Manager) user).requestAddEmployee(userManagement, newEmployee);
                        ((Manager) user).requestAddEmployeesWithUpdatedMenu(userManagement);
                    }
                    break;
                case 5:
                    if (user.getRole().equals("Employee")) {
                        keepRunning = false; // Thoát menu
                    } else if (user.getRole().equals("Manager")) 
                    {
                        System.out.println("Xoa nhan vien"); //Chưa có chức năng xóa nhân viên
                    } 
                    else 
                    {
                        userManagement.viewApprovalHistory();
                    }
                    break;
                case 6:
                    if (user.getRole().equals("Manager")) 
                    {
                        System.out.println("Sua nhan vien"); //Chưa có sửa nhân viên
                    } else 
                    {
                        System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 7:
                    if (user.getRole().equals("Manager")) {
                        viewBooks();
                    } else {
                        System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 8:
                    if (user.getRole().equals("Manager")) {
                        ((Manager) user).cancelRequest(userManagement);
                    } else {
                        System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 9:
                    keepRunning = false;
                    break;
                case 10:
                    System.out.println("Quay lai man hinh dang nhap.");
                    return true; // Quay lại màn hình login

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        return false;
}

private void viewBooks() {
    Scanner scanner = new Scanner(System.in);
    Book b = new Book();
    b.docFile();
    boolean backToMainMenu = false;

    while (!backToMainMenu) {
        System.out.println("\n--- MENU XEM SACH ---");
        System.out.println("1: Sach giao khoa lop 1");
        System.out.println("2: Sach giao khoa lop 2");
        System.out.println("3: Sach giao khoa lop 3");
        System.out.println("4: Sach giao khoa lop 4");
        System.out.println("5: Sach giao khoa lop 5");
        System.out.println("6: Sach giao khoa lop 6");
        System.out.println("7: Sach giao khoa lop 7");
        System.out.println("8: Sach giao khoa lop 8");
        System.out.println("9: Sach giao khoa lop 9");
        System.out.println("10: Sach giao khoa lop 10");
        System.out.println("11: Sach giao khoa lop 11");
        System.out.println("12: Sach giao khoa lop 12");
        System.out.println("13: Sach khoa hoc");
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
            case 13:
                displayBooks(b.getSbBook());
                break;
            case 14:
                displayBooks(b.getPsBook());
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
