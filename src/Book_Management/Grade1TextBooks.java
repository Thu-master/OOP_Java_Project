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
 * @author Thu
 */
public class Grade1TextBooks extends Book 
{
//    String loaiSach = "GK1";
//    ArrayList<Book> list1 = new ArrayList<Book>();
//    
//    public Grade1TextBooks()
//    {
//        
//    }
//            
//    public Grade1TextBooks(String loaiSach, int maSoSach, String tenSach, double giaSach)
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
//            File f = new File ("sachGiaoKhoaLop1.txt");
//            FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//            String line ;
//            while((line = br.readLine())!=null){
//                if (line.trim().equals("")){
//                    continue;
//                }
//                String []arr = line.split("[;]+");
//                Grade1TextBooks tb1 = new Grade1TextBooks(arr[0].trim(),
//                        Integer.parseInt(arr[1].trim()), arr[2].trim(), Double.parseDouble(arr[3].trim()));
//                list1.add(tb1);
//            }
//            br.close();
//            fr.close();
//        }catch(Exception e){
//            System.out.println("Khong the doc File");
//        }
//    }
//    
//    public void outPut(){
//        for (Book sb: list1){
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
//            File f = new File("sachGiaoKhoaLop1.txt");
//            FileWriter fw = new FileWriter(f);
//            PrintWriter pw = new PrintWriter(fw);
//            for(Book tb1: list1){
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
//            Grade1TextBooks tb1 = new Grade1TextBooks();
//            Scanner sc = new Scanner(System.in);
//            tb1.nhapThemSach();
//            
//            if(!KiemTraMaSo(tb1)){
//                list1.add(tb1);
//            }else System.out.println("Ma so trung nhau");
//            
//            System.out.println("Ban co muon nhap tiep khong: ");
//            ans = sc.nextLine();
//            
//        }while(ans.equalsIgnoreCase("Y"));
//        
//    }
//    public boolean KiemTraMaSo(Book b){
//        for (Book b1: list1){
//            if(b.maSoSach==b1.maSoSach){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public void inDanhSach(){
//        for (Book b: list1){
//            
//            System.out.println("GK1-" + b.maSoSach + "\t" + b.tenSach + "\t" + b.giaSach);
//        } 
//    } 
    
        private ArrayList<Book> list1 = new ArrayList<>();

    public Grade1TextBooks() 
    {
        
    }

    public Grade1TextBooks(String type, String id, String name, double price, int quantity, String author) 
    {
       super(type, id, name, price, quantity, author);
    }
    public void readFile(String filePath) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length == 4) 
                {
                    String type = parts[0].trim();   // Loại sách
                    String id = parts[1].trim();     // Mã sách
                    String name = parts[2].trim();   // Tên sách
                    double price = Double.parseDouble(parts[3].trim()); // Giá sách

                    // Tạo đối tượng sách
                    Book book = new Grade1TextBooks(type, id, name, price, 1, "N/A");
                    list1.add(book);
                } 
                else 
                {
                    System.out.println("Dong khong hop le: " + line);
                }
            }
        }
        catch (Exception e) 
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void writeFile(String filePath) 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) 
        {
             for (Book book : list1) 
             { // `list1` là danh sách lưu trữ sách
                 writer.println(book.getType() + ";" + book.getId() + ";" + book.getName() + ";" + book.getPrice());
             }
             System.out.println("File updated successfully!");
        } 
        catch (Exception e) 
        {
             System.out.println("Error writing to file: " + e.getMessage());
        }
    }

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

        Book book = new Grade1TextBooks(type, id, name, price, quantity, author);
        list1.add(book);
    }

    public void displayBooks() 
    {
        System.out.println("Type\tID\tName\tPrice\tQuantity\tAuthor");
        for (Book book : list1) 
        {
            System.out.println(book.getId() + "\t" + book.getName() + "\t" 
                + book.getPrice() + "\t" + book.getQuantity() + "\t" + book.getAuthor());
        }
    }
}
