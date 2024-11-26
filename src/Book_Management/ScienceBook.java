/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book_Management;

import Funtion.Book;
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
public class ScienceBook extends Book {
//    String loaiSach = "SB";
//    ArrayList<Book> list13 = new ArrayList<Book>();
//    public ScienceBook(){
//        
//    }
//    
//    public ScienceBook(String loaiSach, int maSoSach, String tenSach, double giaSach){
//        super(maSoSach,tenSach,giaSach);
//        this.loaiSach = loaiSach;
//    }
//    
//    @Override
//    public String toString(){
//        return loaiSach + ";" + super.toString();
//    }
//    
//    public void docFile(){
//        try{
//            File f = new File ("sachKhoaHoc.txt");
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            String line ;
//            while((line = br.readLine())!=null){
//                if (line.trim().equals("")){
//                    continue;
//                }
//                String []arr = line.split("[;]+");
//                ScienceBook sb = new ScienceBook(arr[0].trim(),
//                        Integer.parseInt(arr[1].trim()), arr[2].trim(), Double.parseDouble(arr[3].trim()));
//                list13.add(sb);
//            }
//            br.close();
//            fr.close();
//        }catch(Exception e){
//            System.out.println("Khong the doc File");
//        }
//    }
//    
//    public void outPut(){
//        for (Book sb: list13){
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
//            File f = new File("sachKhoaHoc.txt");
//            FileWriter fw = new FileWriter(f);
//            PrintWriter pw = new PrintWriter(fw);
//            for(Book sb: list13){
//                pw.println(sb);
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
//            ScienceBook sb = new ScienceBook();
//            Scanner sc = new Scanner(System.in);
//            sb.nhapThemSach();
//            
//            if(!KiemTraMaSo(sb)){
//                list13.add(sb);
//            }else System.out.println("Ma so trung nhau");
//            
//            System.out.println("Ban co muon nhap tiep khong: ");
//            ans = sc.nextLine();
//            
//        }while(ans.equalsIgnoreCase("Y"));
//        
//    }
//    public boolean KiemTraMaSo(Book b){
//        for (Book b1: list13){
//            if(b.maSoSach==b1.maSoSach){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public void inDanhSach(){
//        for (Book b: list13){
//            
//            System.out.println("SB-" + b.maSoSach + "\t" + b.tenSach + "\t" + b.giaSach);
//        } 
//    }  
    
/*    private ArrayList<Book> list = new ArrayList<>();

    public ScienceBook() {super(arr[0].trim(), Integer.parseInt(arr[1].trim()), arr[2].trim(), Double.parseDouble(arr[3].trim()));
}

    public ScienceBook(String type, String id, String name, double price, int quantity, String author) 
    {
        super(type,id, name, price, quantity, author);
    }
    
    // Đọc dữ liệu từ file
    public void readFile(String filePath) 
    {
       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length == 4) 
                {
                    String type = parts[0].trim();   // Loại sách
                    String id = parts[1].trim();     // Mã sách
                    String name = parts[2].trim();   // Tên sách
                    double price = Double.parseDouble(parts[3].trim()); // Giá sách

                   // Tạo đối tượng sách
                    Book book = new ScienceBook(type, id, name, price, 0, type);
                    list.add(book);
                } 
                else 
                {
                    System.out.println("Dòng không hợp lệ: " + line);
                }
            }
        } 
       catch (Exception e) 
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Ghi dữ liệu vào file
    public void writeFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Book book : list) {
                writer.println(book);
            }
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Thêm sách vào danh sách
    public void addBook() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book type (e.g., GK1, GK2): ");
        String type = scanner.nextLine();
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

        Book book = new ScienceBook(type, id, name, price, quantity, author);
        list.add(book);
    }

    // Hiển thị danh sách sách
    public void displayBooks() 
    {
       System.out.println("Type\tID\tName\tPrice\tQuantity\tAuthor");
       for (Book book : list) 
       {
          System.out.println(book.getType() + "\t" + book.getId() + "\t" + book.getName() + "\t" 
               + book.getPrice() + "\t" + book.getQuantity() + "\t" + book.getAuthor());
       }
    }
*/
}
