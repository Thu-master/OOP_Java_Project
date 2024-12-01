/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import Funtion.Book;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class SystemManager 
{
    private User_Management userManagement; // Quản lý người dùng
    private Scanner scanner;                // Nhập dữ liệu từ bàn phím

    public SystemManager() 
    {
       userManagement = new User_Management();
       scanner = new Scanner(System.in);

       // Nạp dữ liệu từ file
       String filePath = "List-NV.txt"; // Đường dẫn tới file
       userManagement.loadUsersFromFile(filePath);
    }
    
    public void run() 
    {
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
    //           showMenu(user); // Hiển thị menu chính
    //           keepRunning = false; // Thoát sau khi xử lý menu

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
    
    private boolean showMenu(User user) 
    {
       Scanner scanner = new Scanner(System.in);
       boolean keepRunning = true;
       Book bookManager = new Book();
        while (keepRunning) 
        {
            switch (user.getRole()) 
            {
                case "Employee":
                   System.out.println("\n--- MENU NHAN VIEN ---");
                   System.out.println("1. Them sach");
                   System.out.println("2. Xoa sach");
                   System.out.println("3. Sua sach");
                   System.out.println("4. Xem sach");                  
                   System.out.println("20. Quay lai dang nhap");
                   System.out.println("0. Thoat");
                   break;
                case "Manager":
                   System.out.println("\n--- MENU QUAN LY ---");
                   System.out.println("1. Them sach");
                   System.out.println("2. Xoa sach");
                   System.out.println("3. Sua sach");
                   System.out.println("4. Xem sach");
                   System.out.println("5. Quan ly yeu cau them nhan vien");
                   System.out.println("6. Quan ly yeu cau xoa nhan vien");
                   System.out.println("9. Xem sach");
                   System.out.println("10. Huy yeu cau them nhan vien");
                   System.out.println("20. Quay lai dang nhap");
                   System.out.println("0. Thoat");
                   break;
                case "Admin":
                   System.out.println("\n--- MENU BOSS ---");
                   System.out.println("Ban dang co " + userManagement.getPendingRequests().size() + " yeu cau them nhan vien can duyet.");
                   System.out.println("Ban dang co " + userManagement.getDeleteRequests().size() + " yeu cau xoa nhan vien can duyet.");
                   System.out.println("1. Quan ly nguoi dung");
                   System.out.println("2. Phe duyet yeu cau them nhan vien");
                   System.out.println("3. Phe duyet yeu cau xoa nhan vien");
                   System.out.println("5. Xem lich su duyet"); 
                   System.out.println("7. Them sach");
                   System.out.println("8. Xoa sach");
                   System.out.println("9. Sua sach");
                   System.out.println("10. Xem sach");         
                   System.out.println("20. Quay lai dang nhap");
                   System.out.println("0. Thoat");
                   break;
                default:
                   System.out.println("Chuc vu khong hop le!");
                   return false;
            }

            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) 
            {
                case 0:
                   keepRunning = false; // Thoát menu
                   break;
                case 1:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                       System.out.println("\n--- Them sach ---");   //Thêm sách 
                       bookManager.docFile();
                       bookManager.ThemSachVaGhiFile();
                    } 
                    else 
                    {
                        //Admin quản lý người dùng
                       ((Admin) user).manageUsersWithMenu(userManagement);
                    }
                    break;
                case 2:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                       System.out.println("Xoa sach"); // Chưa có chức năng xóa sách
                    } 
                    else
                    {
                       ((Admin) user).approveAddEmployee(userManagement); //Phê duyệt yêu cầu thêm nhân viên.
                    } 
                    break;
                case 3:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                       System.out.println("Sua sach"); //Chưa có chức năng sửa sách
                    } 
                    else if (user.getRole().equals("Admin"))
                    {
                       userManagement.approveDeleteEmployee(userManagement);    //Phê duyệt xóa nhân viên.
                    }
                    else
                    {
                       System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 4:
                    if (user.getRole().equals("Employee") || user.getRole().equals("Manager")) 
                    {
                       bookManager.viewBooks();
                    } 
                    break;
                case 5:
                    if (user.getRole().equals("Employee")) 
                    {
                       //keepRunning = false; // Thoát menu
                    } 
                    else if(user.getRole().equals("Manager")) //Yêu cầu thêm nhân viên.
                    {
                       ((Manager) user).requestAddEmployeesWithMenu(userManagement);
                    break;

                    } 
                    else 
                    {
                       userManagement.viewApprovalHistory();
                    }
                    break;
                case 6:
                    if(user.getRole().equals("Manager")) 
                    {
                       ((Manager) user).cancelAddRequest(userManagement);  //Hủy yêu cầu thêm nhân viên.
                    } 
                    else 
                    {
                       System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 7:
                    if (user.getRole().equals("Manager")) 
                    {                      
                       ((Manager) user).requestDeleteEmployeesWithMenu(userManagement);  //Yêu cầu xóa nhân viên.
                    } 
                    else 
                    {
                       System.out.println("\n--- Them sach ---");   // Thêm sách
                       bookManager.docFile();
                       bookManager.ThemSachVaGhiFile();
                    }
                    break;
                case 8:
                    if (user.getRole().equals("Manager")) 
                    {
                       ((Manager) user).cancelDeleteRequest(userManagement);    //Hủy yêu cầu xóa nhân viên.
                    } 
                    else 
                    {
                       System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 9:
                    System.out.println("Chua co chuc nang nay.");
                case 10:
                    if (user.getRole().equals("Manager"))
                    {
                       bookManager.viewBooks();
                    }
                    break;
                case 20:
                    System.out.println("Quay lai man hinh dang nhap.");
                    return true; // Quay lại màn hình login
                default:
                   System.out.println("Lua chon khong hop le!");
            }
        }
        return false;
    }
}
