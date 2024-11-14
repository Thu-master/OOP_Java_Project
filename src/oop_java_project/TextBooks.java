/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_java_project;

/**
 *
 * @author Thu
 */
public class TextBooks extends Book 
{
    String monHoc;
    
    public TextBooks()
    {
        
    }
            
    public TextBooks(int maSoSach, String tenSach, double giaSach, String monHoc)
    {
        super(maSoSach, tenSach, giaSach);
        this.monHoc = monHoc;
    }
    
    public String getmonHoc()
    {
        return monHoc;
    }
    
    public void setmonHoc(String monHoc)
    {
        this.monHoc = monHoc;
    }
    
    @Override
    public String toString()
    {
        return maSoSach + ";" + tenSach + ";" + giaSach;
    }
}
