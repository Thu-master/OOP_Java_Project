/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_java_project;

import Temp_Class.Product;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Book
{
    //Kế thừa từ Product và bổ sung các thông tin về sách.
    int maSoSach;
    String tenSach;
    double giaSach;
    
    public Book(){
        
    }
    
    public Book(int maSoSach, String tenSach, double giaSach){
        this.maSoSach = maSoSach;
        this.tenSach = tenSach;
        this.giaSach = giaSach;
    }
    
    @Override
    public String toString(){
        return maSoSach + ";" + tenSach + ";" + giaSach;
    }
    
    public void nhapThemSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma so: ");
        maSoSach = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.println("Nhap gia tien: ");
        giaSach = Double.parseDouble(sc.nextLine());
    }
}
