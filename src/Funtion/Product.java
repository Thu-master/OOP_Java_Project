/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;

/**
 *
 * @author Thu
 */
public class Product 
{
//Đây là lớp cha chung cho các loại mặt hàng.  
    String id;
    String name;
    double price;
    int quantity;
    
    public Product()
    {
        
    }
    
    public Product(String id, String name, double price, int quantity) 
    {
       this.id = id;
       this.name = name;
       this.price = price;
       this.quantity = quantity;
    }
    
    // Getters và setters
    public String getId() 
    { 
       return id; 
    }
    public String getName() 
    { 
       return name; 
    }
    public double getPrice() 
    { 
       return price; 
    }
    public int getQuantity() 
    { 
       return quantity; 
    }
    
    public void displayInfo() 
    {
       System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity);
    }
    
}
