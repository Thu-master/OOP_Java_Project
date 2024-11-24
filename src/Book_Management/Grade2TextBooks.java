/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book_Management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thanh
 */
public class Grade2TextBooks extends Book {
//    String loaiSach = "GK2";
//    ArrayList<Book> list2 = new ArrayList<Book>();
//    
//    public Grade2TextBooks()
//    {
//        
//    }
//            
//    public Grade2TextBooks(String loaiSach, int maSoSach, String tenSach, double giaSach)
//    {
//        super(maSoSach, tenSach, giaSach);
//        this.loaiSach = loaiSach;
//    }
//    
//    @Override
//    public String toString()
//    {
//        return loaiSach + ";" + super.toString();
//    }
//    
//    public void docFile(){
//        try{
//            File f = new File ("sachGiaoKhoaLop2.txt");
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            String line ;
//            while((line = br.readLine())!=null){
//                if (line.trim().equals("")){
//                    continue;
//                }
//                String []arr = line.split("[;]+");
//                Grade2TextBooks tb2 = new Grade2TextBooks(arr[0].trim(),
//                        Integer.parseInt(arr[1].trim()), arr[2].trim(), Double.parseDouble(arr[3].trim()));
//                list2.add(tb2);
//            }
//            br.close();
//            fr.close();
//        }catch(Exception e){
//            System.out.println("Khong the doc File");
//        }
//    }
//    
//    public void outPut(){
//        for (Book sb: list2){
//            System.out.println(sb);
//        }
//    }
//    
//    public void inTieuDe(){
//        System.out.println("MaSach\tTenSach\tGiaSach");
//    }
//    
//    public void ghiFile(){
//        try{
//            File f = new File("sachGiaoKhoaLop.txt");
//            FileWriter fw = new FileWriter(f);
//            PrintWriter pw = new PrintWriter(fw);
//            for(Book tb1: list2){
//                pw.println(tb1);
//            }
//            fw.close();
//            pw.close();
//        }catch(Exception e){
//            System.out.println("Khong the ghi File");
//        }
//    }
//    
//    public void themSach(){
//        String ans = "Y";
//        do{
//            Grade2TextBooks tb2 = new Grade2TextBooks();
//            Scanner sc = new Scanner(System.in);
//            tb2.nhapThemSach();
//            
//            if(!KiemTraMaSo(tb2)){
//                list2.add(tb2);
//            }else System.out.println("Ma so trung nhau");
//            
//            System.out.println("Ban co muon nhap tiep khong: ");
//            ans = sc.nextLine();
//            
//        }while(ans.equalsIgnoreCase("Y"));
//        
//    }
//    public boolean KiemTraMaSo(Book b){
//        for (Book b1: list2){
//            if(b.maSoSach==b1.maSoSach){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public void inDanhSach(){
//        for (Book b: list2){
//            
//            System.out.println("GK1-" + b.maSoSach + "\t" + b.tenSach + "\t" + b.giaSach);
//        } 
//    } 
    
    
        private ArrayList<Book> list2 = new ArrayList<>();

    public Grade2TextBooks() {}

    public Grade2TextBooks(String id, String name, double price, int quantity, String author) {
        super(id, name, price, quantity, author);
    }

    public void readFile(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống

            // Tách thông tin sách theo dấu ";"
            String[] parts = line.split(";");
            if (parts.length == 4) {
                String type = parts[0].trim();    // Loại sách (ví dụ: GK1)
                String id = parts[1].trim();      // Mã sách
                String name = parts[2].trim();    // Tên sách
                double price = Double.parseDouble(parts[3].trim()); // Giá sách

                // Tạo đối tượng Book (hoặc lớp con tương ứng)
                Book book = new Grade1TextBooks(id, name, price, 1, "N/A"); // Quantity = 1, Author = N/A
                list2.add(book);
            } else {
                System.out.println("Dòng không hợp lệ: " + line);
            }
        }
    } catch (Exception e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
    }

    public void writeFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Book book : list2) {
                writer.println(book);
            }
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter book name: ");
        String name = scanner.nextLine();
        System.out.println("Enter book price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter book quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter book author: ");
        String author = scanner.nextLine();

        Book book = new Grade2TextBooks(id, name, price, quantity, author);
        list2.add(book);
    }

    public void displayBooks() 
    {
        System.out.println("Type\tID\tName\tPrice\tQuantity\tAuthor");
        for (Book book : list2) 
        {
            System.out.println(book.getId() + "\t" + book.getName() + "\t" 
                + book.getPrice() + "\t" + book.getQuantity() + "\t" + book.getAuthor());
        }
    }
}
