/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;

/**
 *
 * @author Thu
 */
public class Discount 
{
    private String code;
    private String description;
    private int minBooks;
    private double minAmount;
    private double discountAmount;

    public Discount(String code, String description, int minBooks, double minAmount, double discountAmount) {
        this.code = code;
        this.description = description;
        this.minBooks = minBooks;
        this.minAmount = minAmount;
        this.discountAmount = discountAmount;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinBooks() {
        return minBooks;
    }

    public void setMinBooks(int minBooks) {
        this.minBooks = minBooks;
    }

    public double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Ma: " + code + ", Mo ta: " + description + ", Sach toi thieu: " + minBooks +
               ", Gia tri toi thieu: " + minAmount + ", Giam: " + discountAmount;
    }

    public String toFileString() {
        return code + "," + description + "," + minBooks + "," + minAmount + "," + discountAmount;
    }
}
