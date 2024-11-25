/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_java_project;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Book extends Product{
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
    private String type;
    ArrayList<Book> gk1Book = new ArrayList<Book>();
    ArrayList<Book> gk2Book = new ArrayList<Book>();
    ArrayList<Book> gk3Book = new ArrayList<Book>();
    ArrayList<Book> gk4Book = new ArrayList<Book>();
    ArrayList<Book> gk5Book = new ArrayList<Book>();
    ArrayList<Book> gk6Book = new ArrayList<Book>();
    public Book() 
    {
        
    }

    public Book(String type, String id, String name, double price, int quantity, String author) 
    {
       super(id, name, price, quantity);
       this.type = type;
       this.author = author;
    }

    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getAuthor() 
    { 
       return author; 
    }
    public void setAuthor(String author) 
    { 
       this.author = author; 
    }

    @Override
    public void displayInfo() 
    {
       super.displayInfo();
       System.out.println("Author: " + author);
    }

    @Override
    public String toString() 
    {
       return getType() + ";" + getId() + ";" + getName() + ";" + getPrice() + ";" + getQuantity() + ";" + author;
    }
    
    public void docFile(){
        try{
            File f = new File ("sach.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line ;
            while((line = br.readLine())!=null){
                if (line.trim().equals("")){
                    continue;
                }
                String[] parts = line.split("[;]+");
                if (parts.length == 6) {
                    String type = parts[0];
                    String id = parts[1];
                    String name = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    String author = parts[5];
                    Book b = new Book(type,id,name,price,quantity,author);
                    if (type.equals("GK1")) {
                        gk1Book.add(b);
                    }else if (type.equals("GK2")){
                        gk2Book.add(b);
                    }else if (type.equals("GK3")){
                        gk3Book.add(b);
                    }else if (type.equals("GK4")){
                        gk4Book.add(b);
                    }else if (type.equals("GK5")){
                        gk5Book.add(b);
                    }else if (type.equals("GK6")){
                        gk6Book.add(b);
                    }
                }
            }
            br.close();
            fr.close();
        }catch(Exception e){
            System.out.println("Khong the doc File");
        }
    }
    
    public ArrayList<Book> getGk1Book() {
        return gk1Book;
    }

    public ArrayList<Book> getGk2Book() {
        return gk2Book;
    }
    
    public ArrayList<Book> getGk3Book() {
        return gk3Book;
    }
    
    public ArrayList<Book> getGk4Book() {
        return gk4Book;
    }
    
    public ArrayList<Book> getGk5Book() {
        return gk5Book;
    }
    
    public ArrayList<Book> getGk6Book() {
        return gk6Book;
    }
    
}
