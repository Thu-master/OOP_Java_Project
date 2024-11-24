/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book_Management;

import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Book extends Product
{
    //Kế thừa từ Product và bổ sung các thông tin về sách.
    
//    int maSoSach;
//    String tenSach;
//    String tacGia;
//    double giaSach;
//    
//    public Book(){
//        
//    }
//    
//    public Book(int maSoSach, String tenSach, double giaSach){
//        this.maSoSach = maSoSach;
//        this.tenSach = tenSach;
//        this.giaSach = giaSach;
//    }
//    
//    @Override
//    public String toString(){
//        return maSoSach + ";" + tenSach + ";" + giaSach;
//    }
//    
//    public void nhapThemSach(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap ma so: ");
//        maSoSach = Integer.parseInt(sc.nextLine());
//        System.out.println("Nhap ten sach: ");
//        tenSach = sc.nextLine();
//        System.out.println("Nhap gia tien: ");
//        giaSach = Double.parseDouble(sc.nextLine());
//    }
    
//    private String author;
//
//    public Book() {}
//
//    public Book(String id, String name, double price, int quantity, String author) 
//    {
//       super(id, name, price, quantity);
//       this.author = author;
//    }
//
//    public String getAuthor() 
//    { 
//       return author; 
//    }
//    public void setAuthor(String author) 
//    { 
//       this.author = author; 
//    }
//
//    @Override
//    public void displayInfo() 
//    {
//       super.displayInfo();
//       System.out.println("Author: " + author);
//    }
//
//    public String toString() 
//    {
//       return getId() + ";" + getName() + ";" + getPrice() + ";" + getQuantity() + ";" + author;
//    }
    
        private String author;

    public Book() {}

    public Book(String id, String name, double price, int quantity, String author) {
        super(id, name, price, quantity);
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
    }

    @Override
    public String toString() {
        return getId() + ";" + getName() + ";" + getPrice() + ";" + getQuantity() + ";" + author;
    }
}
