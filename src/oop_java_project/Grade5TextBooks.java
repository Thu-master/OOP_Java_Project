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
 * @author Thanh
 */
public class Grade5TextBooks extends Book {
    String loaiSach = "GK5";
    ArrayList<Book> list5 = new ArrayList<Book>();
    
    public Grade5TextBooks()
    {
        
    }
            
    public Grade5TextBooks(String loaiSach, int maSoSach, String tenSach, double giaSach)
    {
        super(maSoSach, tenSach, giaSach);
        this.loaiSach = loaiSach;
    }
    
    @Override
    public String toString()
    {
        return loaiSach + ";" + super.toString();
    }
    
    public void docFile(){
        try{
            File f = new File ("sachGiaoKhoaLop5.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line ;
            while((line = br.readLine())!=null){
                if (line.trim().equals("")){
                    continue;
                }
                String []arr = line.split("[;]+");
                Grade5TextBooks tb5 = new Grade5TextBooks(arr[0].trim(),
                        Integer.parseInt(arr[1].trim()), arr[2].trim(), Double.parseDouble(arr[3].trim()));
                list5.add(tb5);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            System.out.println("Khong the doc File");
        }
    }
    
    public void outPut(){
        for (Book sb: list5){
            System.out.println(sb);
        }
    }
    
    public void inTieuDe(){
        System.out.println("MaSach\tTenSach\tGiaSach");
    }
    
    public void ghiFile(){
        try{
            File f = new File("sachGiaoKhoaLop5.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Book tb1: list5){
                pw.println(tb1);
            }
            fw.close();
            pw.close();
        }catch(Exception e){
            System.out.println("Khong the ghi File");
        }
    }
    
    public void themSach(){
        String ans = "Y";
        do{
            Grade5TextBooks tb5 = new Grade5TextBooks();
            Scanner sc = new Scanner(System.in);
            tb5.nhapThemSach();
            
            if(!KiemTraMaSo(tb5)){
                list5.add(tb5);
            }else System.out.println("Ma so trung nhau");
            
            System.out.println("Ban co muon nhap tiep khong: ");
            ans = sc.nextLine();
            
        }while(ans.equalsIgnoreCase("Y"));
        
    }
    public boolean KiemTraMaSo(Book b){
        for (Book b1: list5){
            if(b.maSoSach==b1.maSoSach){
                return true;
            }
        }
        return false;
    }
    
    public void inDanhSach(){
        for (Book b: list5){
            
            System.out.println("GK1-" + b.maSoSach + "\t" + b.tenSach + "\t" + b.giaSach);
        } 
    } 
}
