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
public class ScienceBook extends Book {
    String loaiSach = "SB";
    ArrayList<Book> list = new ArrayList<Book>();
    public ScienceBook(){
        
    }
    
    public ScienceBook(String loaiSach, int maSoSach, String tenSach, double giaSach){
        super(maSoSach,tenSach,giaSach);
        this.loaiSach = loaiSach;
    }
    
    @Override
    public String toString(){
        return loaiSach + ";" + maSoSach + ";" + tenSach + ";" + giaSach;
    }
    
    public void docFile(){
        try{
            File f = new File ("sachKhoaHoc.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line ;
            while((line = br.readLine())!=null){
                if (line.trim().equals("")){
                    continue;
                }
                String []arr = line.split("[;]+");
                ScienceBook sb = new ScienceBook(arr[0].trim(),
                        Integer.parseInt(arr[1].trim()), arr[2].trim(), Double.parseDouble(arr[3].trim()));
                list.add(sb);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            System.out.println("Khong the doc File");
        }
    }
    
    public void outPut(){
        for (Book sb: list){
            System.out.println(sb);
        }
    }
    
    public void inTieuDe(){
        System.out.println("MaSach\tTenSach\tGiaSach");
    }
    
    public void ghiFile(){
        try{
            File f = new File("sachKhoaHoc.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Book sb: list){
                pw.println(sb);
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
            ScienceBook sb = new ScienceBook();
            Scanner sc = new Scanner(System.in);
            sb.nhapThemSach();
            
            if(!KiemTraMaSo(sb)){
                list.add(sb);
            }else System.out.println("Ma so trung nhau");
            
            System.out.println("Ban co muon nhap tiep khong: ");
            ans = sc.nextLine();
            
        }while(ans.equalsIgnoreCase("Y"));
        
    }
    public boolean KiemTraMaSo(Book b){
        for (Book b1: list){
            if(b.maSoSach==b1.maSoSach){
                return true;
            }
        }
        return false;
    }
    
}
