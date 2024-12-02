/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;


import Funtion.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Thu
 */
public class Book extends Product{

    private static void add(Book b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //Kế thừa từ Product và bổ sung các thông tin về sách.    
    private String author;
    private String type;
    ArrayList<Book> BookList = new ArrayList<>();
    
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
            BookList.clear();
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
                    BookList.add(new Book(type,id,name,price,quantity,author));
                }
            }
            br.close();
            fr.close();
        }catch(Exception e){
            System.out.println("Khong the doc File");
        }
    }
    
    public ArrayList<Book> getBookList() {
        return BookList;
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
    
    public void ThemSachVaGhiFile(){
        Scanner sc = new Scanner(System.in);
        Book newBook = nhapSach();
        if (kiemTraIdVaTen(newBook.getId(), newBook.getName())) {
            System.out.println("Sach co ma so hoac ten đa ton tai, khong the them sach nay.");
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter("sach.txt", true))) {
                pw.println(newBook.toString());
                BookList.add(newBook); 
                System.out.println("Sach mmi da duoc ghi vao file va them vao danh sach.");
            } catch (Exception e) {
                System.out.println("Không thể ghi file.");
            }
        }
    }
    
    public boolean kiemTraIdVaTen(String id, String name) {
        for (Book book : BookList) {
            if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void viewBooks() 
    {
        Scanner scanner = new Scanner(System.in);
        Book b = new Book();
        b.docFile();
        boolean backToMainMenu = false;

        while (!backToMainMenu) 
        {
           System.out.println("\n--- MENU XEM SACH ---");
           System.out.println("1: Sach giao khoa lop 1");
           System.out.println("2: Sach giao khoa lop 2");
           System.out.println("3: Sach giao khoa lop 3");
           System.out.println("4: Sach giao khoa lop 4");
           System.out.println("5: Sach giao khoa lop 5");
           System.out.println("6: Sach giao khoa lop 6");
           System.out.println("7: Sach giao khoa lop 7");
           System.out.println("8: Sach giao khoa lop 8");
           System.out.println("9: Sach giao khoa lop 9");
           System.out.println("10: Sach giao khoa lop 10");
           System.out.println("11: Sach giao khoa lop 11");
           System.out.println("12: Sach giao khoa lop 12");
           System.out.println("13: Sach khoa hoc");
           System.out.println("14: Sach tam ly");
           System.out.println("15: Sach tinh cam");
           System.out.println("16: Sach tieu thuyet");
           System.out.println("0: Quay lai");

           System.out.print("Chon loai sach: ");
           int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) 
            {
                case 1:
//                   displayBooks(b.getGk1Book());
                   break;
                case 2:
//                   displayBooks(b.getGk2Book());
                   break;
                case 3:
//                   displayBooks(b.getGk3Book());
                   break;
                case 4:
//                  displayBooks(b.getGk4Book());
                   break;
                case 5:
//                   displayBooks(b.getGk5Book());
                   break;
                case 6:
//                   displayBooks(b.getGk6Book());
                   break;
                case 7:
//                   displayBooks(b.getGk7Book());
                   break;
                case 8:
//                   displayBooks(b.getGk8Book());
                   break;
                case 9:
//                   displayBooks(b.getGk9Book());
                   break;
                case 10:
 //                  displayBooks(b.getGk10Book());
                   break;
                case 11:
//                   displayBooks(b.getGk11Book());
                   break;
                case 12:
//                   displayBooks(b.getGk12Book());
                   break;
                case 13:
//                   displayBooks(b.getSbBook());
                   break;
                case 14:
//                   displayBooks(b.getPsBook());
                   break;
                case 15:
//                    displayBooks(b.getRmBook());
                    break;
                case 16:
//                    displayBooks(b.getNvBook());
                    break;
                case 0:
                   backToMainMenu = true;
                   break;
                default:
                   System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public void displayBooks(ArrayList<Book> books) 
    {
        System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
        for (Book book : books) 
        {
            System.out.printf("%-7s %-7s %-55s %-15.2f %-10s %-20s\n",
                    book.getType(), book.getId(), book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor());
        }
    }
    
    public void xoaSachTheoIDHoacTen(){//Hàm xóa sách theo id hoặc tên
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID hoac ten sach can xoa: ");
        String input = sc.nextLine().trim();
        boolean found = false;
        
        for (int i = 0; i < BookList.size(); i++) {
            Book book = BookList.get(i);
            if (book.getId().equalsIgnoreCase(input) || book.getName().equalsIgnoreCase(input)) {
                BookList.remove(i);
                found = true;
                break;
            }
        }

        if (found){
            try{
                File f = new File("sach.txt");
                FileWriter fw = new FileWriter(f, false);
                PrintWriter pw = new PrintWriter(fw);

                for (Book book : BookList) {
                    pw.println(book.toString());
                }
                pw.close();
                fw.close();
                System.out.println("Da xoa sach va cap nhat file thanh cong.");
            }catch (Exception e){
                System.out.println("Khong the cap nhat file.");
            }
        }else System.out.println("Khong tim thay sach co ID hoac ten nhu vay.");
    }
    
    public void capNhatSachVaGhiFile(){//Hàm yêu cầu nhập id hoặc tên để tìm sách, xong rồi sẽ cập nhật
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID hoac ten sach can cap nhat: ");
        String input = sc.nextLine().trim();

        boolean found = false;
        docFile();

        for (Book book : BookList) {
            if (book.getId().equalsIgnoreCase(input) || book.getName().equalsIgnoreCase(input)) {
                System.out.println("Tim thay sach:");

                System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", 
                              "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");

                System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                              book.getType(), book.getId(), book.getName(), 
                              book.getPrice(), book.getQuantity(), book.getAuthor());

                System.out.println("Nhap thong tin moi (nhan Enter de giu nguyen gia tri cu):");

                System.out.print("Loai sach cu (" + book.getType() + "), nhap loai sach moi: ");
                String newType = sc.nextLine().trim();
                if (!newType.isEmpty()) book.setType(newType);

                System.out.print("Ma so cu (" + book.getId() + "), nhap ma so moi: ");
                String newId = sc.nextLine().trim();
                if (!newId.isEmpty()) book.setId(newId);

             System.out.print("Ten cu (" + book.getName() + "), nhap ten moi: ");
                String newName = sc.nextLine().trim();
                if (!newName.isEmpty()) book.setName(newName);

                System.out.print("Gia cu (" + book.getPrice() + "), nhap gia moi: ");
                String newPriceStr = sc.nextLine().trim();
                if (!newPriceStr.isEmpty()){
                    double newPrice = Double.parseDouble(newPriceStr);
                    book.setPrice(newPrice);
                }

                System.out.print("So luong cu (" + book.getQuantity() + "), nhap so luong moi: ");
                String newQuantityStr = sc.nextLine().trim();
                if (!newQuantityStr.isEmpty()){
                    int newQuantity = Integer.parseInt(newQuantityStr);
                    book.setQuantity(newQuantity);
                }

                System.out.print("Tac gia cu (" + book.getAuthor() + "), nhap tac gia moi: ");
                String newAuthor = sc.nextLine().trim();
                if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);

                System.out.println("Cap nhat thong tin thanh cong!");
                found = true;
                break; 
            }
        }

        if (found){
            try {
                File f = new File("sach.txt");
                FileWriter fw = new FileWriter(f, false);
                PrintWriter pw = new PrintWriter(fw);

                for (Book book : BookList) {
                    pw.println(book.toString());
                }
                pw.close();
                fw.close();
                System.out.println("Cap nhat file thanh cong!");
            }catch (Exception e){
                System.out.println("Khong the cap nhat file.");
            }
        }else{
            System.out.println("Khong tim thay sach co ID hoac ten nhu vay.");
        }
    }
    
    public void TimKiem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin sach can tim (ID, ten sach hoac ten tac gia): ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Vui long nhap it nhat mot gia tri de tim kiem!");
            return;
        }
        
        docFile();

        boolean found = false;
        System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n",
            "Loai", "ID", "Ten", "Gia", "So luong", "Tac gia");

        for (Book book : BookList){ 
            boolean matchId = book.getId() != null && book.getId().equalsIgnoreCase(input);
            boolean matchName = book.getName() != null && book.getName().equalsIgnoreCase(input);
            boolean matchAuthor = book.getAuthor() != null && book.getAuthor().equalsIgnoreCase(input);

            if (matchId || matchName || matchAuthor){
                System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                        book.getType(), book.getId(), book.getName(),
                        book.getPrice(), book.getQuantity(), book.getAuthor());
                found = true;
            }
        }

        if (!found){
            System.out.println("Khong tim thay sach phu hop!");
        }
    }
    
    public void InSachTheoLoai(String type) {
        ArrayList<Book> filteredBooks = new ArrayList<>();
        for (Book book : BookList) {
            if (book.getType().equalsIgnoreCase(type)) {
                filteredBooks.add(book);
            }
        }

        if (filteredBooks.isEmpty()) {
            System.out.println("Khong tim thay sach thuoc loai: " + type);
        } else {
            System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", 
                    "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
            for (Book book : filteredBooks) {
                System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                        book.getType(), book.getId(), book.getName(),
                        book.getPrice(), book.getQuantity(), book.getAuthor());
            }
        }
    }
    
    public void displayBookTypes(){ //Hiển thị loại sách có trong File
        Set<String> types = new HashSet<>();
        for (Book book : BookList) {
            types.add(book.getType()); 
        }

        System.out.println("--- Cac loai sach ---");
        int i = 1;
        for (String type : types) {
            System.out.println(i + ". " + type);
            i++;
        }
    }
    
    public void sortBooksById(ArrayList<Book> books){ //Sắp xếp sách theo mã số sách
        books.sort(Comparator.comparing(Book::getId));
    }

    
    public void sortBooksByName(ArrayList<Book> books){ //Sắp xếp sách theo tên sách
        books.sort(Comparator.comparing(Book::getName));
    }
  
}
