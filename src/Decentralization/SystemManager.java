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
        Scanner sc = new Scanner(System.in);

        while (keepRunning) 
        {
           System.out.println("He thong quan ly nguoi dung da san sang.");

           // Nhập thông tin người dùng
           System.out.print("Nhap ma so nhan vien: ");
           String employeeId = sc.nextLine();

           System.out.print("Nhap ho ten cua ban: ");
           String fullName = sc.nextLine();

           // Tìm kiếm người dùng
           User user = userManagement.findUserByInfo(employeeId, fullName);

           if (user == null) 
           {
               System.out.println("Thong tin khong ton tai! Vui long kiem tra lai.");

               // Hỏi người dùng có muốn đăng nhập lại không
               System.out.print("Ban co muon thu lai khong (Y/N): ");
               String choice = sc.nextLine();

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
               setCurrentUser(user);
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
           
//if (user != null) {
//    // Đăng nhập thành công
//    setCurrentUser(user); // Lưu trạng thái người dùng hiện tại
//    System.out.println("\nXin chao, " + user.getFullname() + "!");
//    user.showPermissions();
//
//    boolean backToLogin = showMenu(user); // Hiển thị menu chính
//    if (backToLogin) {
//        System.out.println("\nQuay lai man hinh dang nhap");
//    } else {
//        keepRunning = false; // Thoát chương trình
//    }
//} else {
//    System.out.println("Thong tin khong ton tai! Vui long kiem tra lai.");
//    System.out.print("Ban co muon thu lai khong(Y/N): ");
//    String choice = sc.nextLine();
//
//    if (!choice.equalsIgnoreCase("Y")) {
//        System.out.println("Thoat chuong trinh.");
//        keepRunning = false;
//    }
//}
        }
    }
    
    private boolean showMenu(User user) 
    {
       Scanner sc = new Scanner(System.in);
       boolean keepRunning = true;
       Book bookManager = new Book(userManagement);   // Tạo đối tượng Book, truyền userManagement
       
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
                   System.out.println("20. Dang xuat");
                   System.out.println("0. Thoat");
                   break;
                case "Manager":
                   System.out.println("\n--- MENU QUAN LY ---");
                   System.out.println("1. Quan ly sach");
                   System.out.println("2. Quan ly yeu cau them nhan vien");
                   System.out.println("3. Quan ly yeu cau xoa nhan vien");
                   System.out.println("4. Mua sach");
                   System.out.println("5. Xem ma giam gia");
                   System.out.println("20. Dang xuat");
                   System.out.println("0. Thoat");
                   break;
                case "Admin":
                   System.out.println("\n--- MENU BOSS ---");
                   System.out.println("1. Quan ly nhan vien");
                   System.out.println("2. Quan ly sach");
                   System.out.println("3. Quan ly ma giam gia");
                   System.out.println("4. Quan ly doanh so ban hang");
                   System.out.println("20. Dang xuat");
                   System.out.println("0. Thoat");
                   break;
                default:
                   System.out.println("Chuc vu khong hop le!");
                   return false;
            }

            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) 
            {
                case 0:
                    System.out.print("Ban co chac chan muon thoat chuong trinh? (Y/N): ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        System.out.println("Dang thoat chuong trinh... Tam biet!");
                        System.exit(0);
                    } else {
                        System.out.println("Huy thao tac thoat.");
                    }
                    break;
                case 1:
                    if(user.getRole().equals("Employee"))
                    {
                       System.out.println("\n--- Them sach ---");   //Thêm sách (Employee)
                       bookManager.docFile();
                       bookManager.ThemSachVaGhiFile();
                    }
                    else if (user.getRole().equals("Manager")) 
                    {
                        
                        bookManager.manageBooksWithMenu(); // Gọi menu quản lý sách(Manager)
                    }
                    else
                    {
                        ((Admin) user).manageUsersWithMenu(userManagement); //Gọi menu quản lý nguoi dung.(Admin)
                    }

                    break;
                case 2:
                    if (user.getRole().equals("Employee")) 
                    {
                       bookManager.docFile();   //Chức năng xóa sách(Employee)
                       bookManager.xoaSachTheoIDHoacTen();
                    } 
                    else if(user.getRole().equals("Manager"))
                    {
                       ((Manager) user).requestAddEmployeesWithMenu(userManagement); //Gọi menu quản lý yêu cầu thêm nhân viên.(Manager)
                    } 
                    else
                    {
                        bookManager.manageBooksWithMenu();  //Gọi menu quản lý sách(Admin)
                    }
                    break;
                case 3:
                    if (user.getRole().equals("Employee")) 
                    {                     
                       System.out.println("\n--- Sua sach ---");    //Sửa sách(Employee).
                       bookManager.docFile();
                       bookManager.capNhatSachVaGhiFile();
                    } 
                    else if (user.getRole().equals("Manager"))
                    {
                        ((Manager) user).cancelAddRequest(userManagement); //Gọi menu quản lý yêu cầu xóa nhân viên.(Manager)
                    }
                    else
                    {
                    }
                    break;
                case 4:
                    if (user.getRole().equals("Manager")) 
                    {
                        bookManager.muaSach(); // Gọi chức năng mua sách
                    } 
                    else if(user.getRole().equals("Admin"))
                    {
                        ((Admin) user).manageSales(); // Gọi phương thức thống kê doanh số
                        break;
                    }
                    break;
                case 5:
                    if (user.getRole().equals("Employee")) 
                    {
                    } 
                    else if(user.getRole().equals("Manager")) 
                    { 
                        break;
                    } 
                    else 
                    {
                    }
                    break;
                case 6:
                    if(user.getRole().equals("Admin")) 
                    {
                        
                    } 
                    else 
                    {
                       System.out.println("Chuc nang khong hop le!");
                    }
                    break;
                case 7:
                    if (user.getRole().equals("Manager")) 
                    {                      
                    } 
                    else 
                    {
                    }
                    break;
                case 8:
                    if (user.getRole().equals("Manager")) 
                    {
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
    
//-------------------------------------------------------------------------------------------------
    private static User currentUser; // Biến tĩnh lưu trạng thái người dùng hiện tại

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
