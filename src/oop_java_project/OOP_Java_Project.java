/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oop_java_project;

//import Decentralization.Admin;
//import Decentralization.Employee;
//import Decentralization.Manager;
import Book_Management.Grade1TextBooks;
import Book_Management.ScienceBook;
import Decentralization.SystemManager;
//import Decentralization.User_Management;
//import Decentralization.User;
//import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class OOP_Java_Project 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // main để gọi các class con or blab blab blab
        /*    Grade5TextBooks tb3 = new Grade5TextBooks();
            tb3.inTieuDe();
            tb3.docFile();
            tb3.inDanhSach();
            
            tb3.themSach();
            tb3.ghiFile();
            tb3.inDanhSach();*/
        
//        User_Management userManager = new User_Management();
//
//        // Đọc danh sách người dùng từ file
//        String filePath = "List-NV.txt"; // Đường dẫn tới file
//        userManager.loadUsersFromFile(filePath);
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Nhap ma so nhan vien: ");
//        String employeeId = scanner.nextLine();
//
//        System.out.print("Nhap ho ten cua ban: ");
//        String fullName = scanner.nextLine();
//
//        // Tìm người dùng
//        User user = userManager.findUserByInfo(employeeId, fullName);
//        if (user == null) {
//            System.out.println("Thong tin khong ton tai!");
//            return;
//        }
//
//        // Hiển thị quyền hạn
//        System.out.println("Xin chao, " + user.getFullname() + "!");
//        user.showPermissions();
        
//        SystemManager systemManager = new SystemManager();
//        systemManager.run();
        
        Grade1TextBooks grade1 = new Grade1TextBooks();
        grade1.readFile("sachGiaoKhoaLop1.txt");
        grade1.displayBooks();

        grade1.addBook();
        grade1.writeFile("sachGiaoKhoaLop1.txt");
        
        ScienceBook scienceBooks = new ScienceBook();
        // Đọc dữ liệu từ file
        scienceBooks.readFile("sachKhoaHoc.txt");

        // Hiển thị danh sách sách khoa học
        scienceBooks.displayBooks();

        // Thêm sách mới
        scienceBooks.addBook();

        // Ghi danh sách vào file
        scienceBooks.writeFile("sachKhoaHoc.txt");
    }   
    
}
