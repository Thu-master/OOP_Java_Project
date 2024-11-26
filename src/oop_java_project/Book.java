/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_java_project;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
    ArrayList<Book> gk7Book = new ArrayList<Book>();
    ArrayList<Book> gk8Book = new ArrayList<Book>();
    ArrayList<Book> gk9Book = new ArrayList<Book>();
    ArrayList<Book> gk10Book = new ArrayList<Book>();
    ArrayList<Book> gk11Book = new ArrayList<Book>();
    ArrayList<Book> gk12Book = new ArrayList<Book>();
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
                    }else if (type.equals("GK7")){
                        gk7Book.add(b);
                    }else if (type.equals("GK8")){
                        gk8Book.add(b);
                    }else if (type.equals("GK9")){
                        gk9Book.add(b);
                    }else if (type.equals("GK10")){
                        gk10Book.add(b);
                    }else if (type.equals("GK11")){
                        gk11Book.add(b);
                    }else if (type.equals("GK12")){
                        gk12Book.add(b);
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
    
    public ArrayList<Book> getGk7Book() {
        return gk7Book;
    }
    
    public ArrayList<Book> getGk8Book() {
        return gk8Book;
    }
    
    public ArrayList<Book> getGk9Book() {
        return gk9Book;
    }
    
    public ArrayList<Book> getGk10Book() {
        return gk10Book;
    }
    
    public ArrayList<Book> getGk11Book() {
        return gk11Book;
    }
    
    public ArrayList<Book> getGk12Book() {
        return gk12Book;
    }
    
    public Book nhapSach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap loai sach:");
        String type = sc.nextLine();
        System.out.println("Nhap ma so sach: ");
        String id = sc.nextLine();
        System.out.println("Nhap ten sach: ");
        String name = sc.nextLine();
        System.out.println("Nhap gia sach: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten tac gia: ");
        String author = sc.nextLine();
        return new Book(type, id, name, price, quantity, author);
    }
    
    public void ghiFile(){
        try{
            File f = new File("sach.txt");
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pw = new PrintWriter(fw);
            Book newBook = nhapSach();
            if (kiemTraIdVaTen(newBook.getId(), newBook.getName())){
                System.out.println("Sach co ma so hoac ten da ton tai, khong the them sach nay.");
            }else{
                pw.println(newBook.getType() + ";" + newBook.getId() + ";" + newBook.getName() + ";" 
                    + newBook.getPrice() + ";" + newBook.getQuantity() + ";" + newBook.getAuthor());
                
                if(newBook.getType().equals("GK1")){
                    gk1Book.add(newBook);
                }else if (newBook.getType().equals("GK2")){
                    gk2Book.add(newBook);
                }else if (newBook.getType().equals("GK3")){
                    gk3Book.add(newBook);
                }else if (newBook.getType().equals("GK4")){
                    gk4Book.add(newBook);
                }else if (newBook.getType().equals("GK5")){
                    gk5Book.add(newBook);
                }else if (newBook.getType().equals("GK6")){
                    gk6Book.add(newBook);
                }else if (newBook.getType().equals("GK7")){
                    gk7Book.add(newBook);
                }else if (newBook.getType().equals("GK8")){
                    gk8Book.add(newBook);
                }else if (newBook.getType().equals("GK9")){
                    gk9Book.add(newBook);
                }else if (newBook.getType().equals("GK10")){
                    gk10Book.add(newBook);
                }else if (newBook.getType().equals("GK11")){
                    gk11Book.add(newBook);
                }else if (newBook.getType().equals("GK12")){
                    gk12Book.add(newBook);
                }
                System.out.println("Sach moi da duoc ghi vao file va them vao danh sach.");
            }
            fw.close();
            pw.close();
        }catch(Exception e){
            System.out.println("Khong the ghi File");
        }
    }
    
    public boolean kiemTraIdVaTen(String id, String name) {//Ham kiem tra id va ten
        for (Book book : gk1Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk2Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk3Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk4Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk5Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk6Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk7Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk8Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk9Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk10Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk11Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Book book : gk12Book) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
