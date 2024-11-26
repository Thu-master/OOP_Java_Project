/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oop_java_project;

//import Decentralization.Admin;

import Decentralization.Book;
import java.util.ArrayList;

import Decentralization.Employee;
import Decentralization.Manager;
import Decentralization.SystemManager;
import Decentralization.User_Management;
import Decentralization.User;
import java.util.Scanner;

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
        Book b = new Book();
        b.docFile();
        ArrayList<Book> gk1Books = b.getGk1Book();
        ArrayList<Book> gk2Books = b.getGk2Book();
        ArrayList<Book> gk3Books = b.getGk3Book();
        ArrayList<Book> gk4Books = b.getGk4Book();
        ArrayList<Book> gk5Books = b.getGk5Book();
        ArrayList<Book> gk6Books = b.getGk6Book();
        ArrayList<Book> gk7Books = b.getGk7Book();
        ArrayList<Book> gk8Books = b.getGk8Book();
        ArrayList<Book> gk9Books = b.getGk9Book();
        ArrayList<Book> gk10Books = b.getGk10Book();
        ArrayList<Book> gk11Books = b.getGk11Book();
        ArrayList<Book> gk12Books = b.getGk12Book();
        
//        b.ghiFile(); //Ham nay la ham ghi file
        
        String ans;
        do{
            Scanner sc = new Scanner(System.in);
            int luachon = 0;
            System.out.println("Nhap so tuong tu de xem tung loai sach");
            System.out.println("1: Giao khoa lop 1");
            System.out.println("2: Giao khoa lop 2");
            System.out.println("3: Giao khoa lop 3");
            System.out.println("4: Giao khoa lop 4");
            System.out.println("5: Giao khoa lop 5");
            System.out.println("6: Giao khoa lop 6");
            System.out.println("7: Giao khoa lop 7");
            System.out.println("3: Giao khoa lop 8");
            System.out.println("4: Giao khoa lop 9");
            System.out.println("5: Giao khoa lop 10");
            System.out.println("6: Giao khoa lop 11");
            System.out.println("7: Giao khoa lop 12");
            System.out.println("Hay nhap so: ");
            try{
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon){
                case 1:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk1Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk2Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 3:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk3Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 4:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk4Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 5:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk5Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 6:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk6Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 7:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk7Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 8:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk8Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 9:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk9Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 10:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk10Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 11:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk11Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                case 12:
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s %-10s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong" , "Tac gia");
                    for (Book book : gk12Books){
                    System.out.printf("%-10s %-10s %-30s %-10.2f %-10s %-20s\n", book.getType(), book.getId(), book.getName(), 
                                book.getPrice(),book.getQuantity(),book.getAuthor());
                    }
                    break;
                default: System.out.println("So vua nhap khong hop le"); break;
                }
            }catch (Exception e){
                System.out.println("Khong lop le" + e.getMessage());
            }
            System.out.println("Ban co muon xem tiep khong (Y/N): ");
            ans = sc.nextLine();
        }while(ans.equalsIgnoreCase("Y"));
 
        
        
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
        SystemManager systemManager = new SystemManager();
        systemManager.run();
        
    }   
    
}
