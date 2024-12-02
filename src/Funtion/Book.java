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
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Book extends Product{
    //Kế thừa từ Product và bổ sung các thông tin về sách.    
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
    ArrayList<Book> sbBook = new ArrayList<Book>();
    ArrayList<Book> psBook = new ArrayList<Book>();
    ArrayList<Book> rmBook = new ArrayList<Book>();
    ArrayList<Book> nvBook = new ArrayList<Book>();
    
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
                    }else if (type.equals("SB")){
                        sbBook.add(b);
                    }else if (type.equals("PSB")){
                        psBook.add(b);
                    }else if (type.equals("RMB")){
                        rmBook.add(b);
                    }else if (type.equals("NV")){
                        nvBook.add(b);
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
    
    public ArrayList<Book> getSbBook() {
        return sbBook;
    }
    
    public ArrayList<Book> getPsBook() {
        return psBook;
    }
    
    public ArrayList<Book> getRmBook() {
        return rmBook;
    }
    
    public ArrayList<Book> getNvBook() {
        return nvBook;
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
                }else if (newBook.getType().equals("SB")){
                    sbBook.add(newBook);
                }else if (newBook.getType().equals("PSB")){
                    psBook.add(newBook);
                }else if (newBook.getType().equals("RMB")){
                    rmBook.add(newBook);
                }else if (newBook.getType().equals("NV")){
                    nvBook.add(newBook);
                }
                System.out.println("Sach moi da duoc ghi vao file va them vao danh sach.");
            }
            fw.close();
            pw.close();
        }catch(Exception e){
            System.out.println("Khong the ghi File");
        }
    }
    
    public boolean kiemTraIdVaTen(String id, String name){
        ArrayList<ArrayList<Book>> allbooks = new ArrayList<>();
        allbooks.add(gk1Book);
        allbooks.add(gk2Book);
        allbooks.add(gk3Book);
        allbooks.add(gk4Book);
        allbooks.add(gk5Book);
        allbooks.add(gk6Book);
        allbooks.add(gk7Book);
        allbooks.add(gk8Book);
        allbooks.add(gk9Book);
        allbooks.add(gk10Book);
        allbooks.add(gk11Book);
        allbooks.add(gk12Book);
        allbooks.add(sbBook);
        allbooks.add(psBook);
        allbooks.add(rmBook);
        allbooks.add(nvBook);

        for (ArrayList<Book> danhSach : allbooks){
            for (Book book : danhSach){
                if (book.getId().equalsIgnoreCase(id) || book.getName().equalsIgnoreCase(name)){
                    return true;
                }
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
                   displayBooks(b.getGk1Book());
                   break;
                case 2:
                   displayBooks(b.getGk2Book());
                   break;
                case 3:
                   displayBooks(b.getGk3Book());
                   break;
                case 4:
                   displayBooks(b.getGk4Book());
                   break;
                case 5:
                   displayBooks(b.getGk5Book());
                   break;
                case 6:
                   displayBooks(b.getGk6Book());
                   break;
                case 7:
                   displayBooks(b.getGk7Book());
                   break;
                case 8:
                   displayBooks(b.getGk8Book());
                   break;
                case 9:
                   displayBooks(b.getGk9Book());
                   break;
                case 10:
                   displayBooks(b.getGk10Book());
                   break;
                case 11:
                   displayBooks(b.getGk11Book());
                   break;
                case 12:
                   displayBooks(b.getGk12Book());
                   break;
                case 13:
                   displayBooks(b.getSbBook());
                   break;
                case 14:
                   displayBooks(b.getPsBook());
                   break;
                case 15:
                    displayBooks(b.getRmBook());
                    break;
                case 16:
                    displayBooks(b.getNvBook());
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
        ArrayList<ArrayList<Book>> allBooks = new ArrayList<>();
        allBooks.add(gk1Book);
        allBooks.add(gk2Book);
        allBooks.add(gk3Book);
        allBooks.add(gk4Book);
        allBooks.add(gk5Book);
        allBooks.add(gk6Book);
        allBooks.add(gk7Book);
        allBooks.add(gk8Book);
        allBooks.add(gk9Book);
        allBooks.add(gk10Book);
        allBooks.add(gk11Book);
        allBooks.add(gk12Book);
        allBooks.add(sbBook);
        allBooks.add(psBook);
        allBooks.add(rmBook);
        allBooks.add(nvBook);
        
        for (ArrayList<Book> books : allBooks){
            for (int i = 0; i < books.size(); i++){
                Book b = books.get(i);
                if (b.getId().equalsIgnoreCase(input) || b.getName().equalsIgnoreCase(input)) {
                    books.remove(i);
                    found = true;
                    break;
                }
            }
        }

        if (found){
            try{
            
                File f = new File("sach.txt");
                FileWriter fw = new FileWriter(f, false);
                PrintWriter pw = new PrintWriter(fw);

                for (ArrayList<Book> books : allBooks) {
                    for (Book book : books) {
                        pw.println(book.toString());
                    }
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
        ArrayList<ArrayList<Book>> allBooks = new ArrayList<>();
        allBooks.add(gk1Book);
        allBooks.add(gk2Book);
        allBooks.add(gk3Book);
        allBooks.add(gk4Book);
        allBooks.add(gk5Book);
        allBooks.add(gk6Book);
        allBooks.add(gk7Book);
        allBooks.add(gk8Book);
        allBooks.add(gk9Book);
        allBooks.add(gk10Book);
        allBooks.add(gk11Book);
        allBooks.add(gk12Book);
        allBooks.add(sbBook);
        allBooks.add(psBook);
        allBooks.add(rmBook);
        allBooks.add(nvBook);

        for (ArrayList<Book> books : allBooks){
            for (Book book : books){
                if (book.getId().equalsIgnoreCase(input) || book.getName().equalsIgnoreCase(input)) {
                    System.out.println("Tim thay sach:");
                    
                    System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n", "Loai", "Ma so", "Ten sach", "Gia", "So luong", "Tac gia");
                    
                    System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                            book.getType(), book.getId(), book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor());

                    System.out.println("Nhap thong tin moi (nhan Enter de giu nguyen gia tri cu):");
                    System.out.print("Loai sach cu (" + book.getType() + "), nhap loai sach moi: ");
                    String newType = sc.nextLine().trim();
                    if(!newType.isEmpty()) book.setType(newType); //Nhấp enter để giữ lại giá trị cũ và nhập loại mới thì sẽ thành loại mới

                    System.out.print("Ma so cu (" + book.getId() + "), nhap ma so moi: ");
                    String newId = sc.nextLine().trim();
                    if (!newId.isEmpty()) book.setId(newId);

                    System.out.print("Ten cu (" + book.getName() + "), nhap ten moi: ");
                    String newName = sc.nextLine().trim();
                    if (!newName.isEmpty()) book.setName(newName);

                    System.out.print("Gia cu (" + book.getPrice() + "), nhap gia moi: ");
                    String newPriceStr = sc.nextLine().trim();
                    if(!newPriceStr.isEmpty()){
                        double newPrice = Double.parseDouble(newPriceStr);
                        book.setPrice(newPrice);
                    }

                    System.out.print("So luong cu (" + book.getQuantity() + "), nhap so luong moi: ");
                    String newQuantityStr = sc.nextLine().trim();
                    if (!newQuantityStr.isEmpty()) {
                        int newQuantity = Integer.parseInt(newQuantityStr);
                        book.setQuantity(newQuantity);
                    }

                    System.out.print("Tac gia cu (" + book.getAuthor() + "), nhap tac gio moi: ");
                    String newAuthor = sc.nextLine().trim();
                    if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);

                    System.out.println("Cap nhat thong tin thanh cong!");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (found) {
            try{
                File f = new File("sach.txt");
                FileWriter fw = new FileWriter(f, false);
                PrintWriter pw = new PrintWriter(fw);

                for (ArrayList<Book> books : allBooks) {
                    for (Book book : books) {
                        pw.println(book.toString());
                    }
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

        ArrayList<ArrayList<Book>> allBooks = new ArrayList<>();
        allBooks.add(gk1Book);
        allBooks.add(gk2Book);
        allBooks.add(gk3Book);
        allBooks.add(gk4Book);
        allBooks.add(gk5Book);
        allBooks.add(gk6Book);
        allBooks.add(gk7Book);
        allBooks.add(gk8Book);
        allBooks.add(gk9Book);
        allBooks.add(gk10Book);
        allBooks.add(gk11Book);
        allBooks.add(gk12Book);
        allBooks.add(sbBook);
        allBooks.add(psBook);
        allBooks.add(rmBook);
        allBooks.add(nvBook);

        for (ArrayList<Book> danhSach : allBooks){
            if (danhSach == null) continue;

            for (Book book : danhSach){
                boolean matchId = book.getId() != null && book.getId().equalsIgnoreCase(input);
                boolean matchName = book.getName() != null && book.getName().equalsIgnoreCase(input);
                boolean matchAuthor = book.getAuthor() != null && book.getAuthor().equalsIgnoreCase(input);

                if (matchId || matchName || matchAuthor){ // Nếu một trong 3 thuộc tính giống với sách có trong file thì sẽ in ra cuốn sách đó
                    System.out.printf("%-7s %-7s %-55s %-15s %-10s %-20s\n",
                            "Loai", "ID", "Ten", "Gia", "So luong", "Tac gia");
                
                    System.out.printf("%-7s %-7s %-55s %-15.2f %-10d %-20s\n",
                            book.getType(), book.getId(), book.getName(),
                            book.getPrice(), book.getQuantity(), book.getAuthor());
                    return;
                }
            }
        }
        System.out.println("Khong tim thay sach phu hop!");
    }
  
}
