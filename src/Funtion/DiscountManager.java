/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 *
 * @author Thu
 */
public class DiscountManager 
{
    private static final String DISCOUNT_FILE = "discounts.txt";
    private Map<String, Discount> discountMap = new HashMap<>();

    public DiscountManager() {
        loadDiscounts();
    }

    public void addDiscount(String code, String description, int minBooks, double minAmount, double discountAmount) {
        Discount discount = new Discount(code, description, minBooks, minAmount, discountAmount);
        discountMap.put(code, discount);
        saveDiscounts();
    }

    public void deleteDiscount(String code) {
        if (discountMap.containsKey(code)) {
            discountMap.remove(code);
            saveDiscounts();
            System.out.println("Xoa ma giam gia thanh cong!");
        } else {
            System.out.println("Khong tim thay ma giam gia!");
        }
    }

    public void modifyDiscount(String code, String description, int minBooks, double minAmount, double discountAmount) {
        if (discountMap.containsKey(code)) {
            Discount discount = discountMap.get(code);
            discount.setDescription(description);
            discount.setMinBooks(minBooks);
            discount.setMinAmount(minAmount);
            discount.setDiscountAmount(discountAmount);
            saveDiscounts();
            System.out.println("Sua ma giam gia thanh cong!");
        } else {
            System.out.println("Khong tim thay ma giam gia!");
        }
    }

    public Discount getDiscount(String code) {
        return discountMap.get(code);
    }

    public void displayDiscounts() {
        System.out.println("\n--- Danh sach ma giam gia ---");
        for (Discount discount : discountMap.values()) {
            System.out.println(discount);
        }
    }

    private void loadDiscounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(DISCOUNT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Discount discount = new Discount(
                        parts[0].trim(),
                        parts[1].trim(),
                        Integer.parseInt(parts[2].trim()),
                        Double.parseDouble(parts[3].trim()),
                        Double.parseDouble(parts[4].trim())
                    );
                    discountMap.put(discount.getCode(), discount);
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the doc file ma giam gia: " + e.getMessage());
        }
    }

    private void saveDiscounts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DISCOUNT_FILE))) {
            for (Discount discount : discountMap.values()) {
                bw.write(discount.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Khong the ghi file ma giam gia: " + e.getMessage());
        }
    }
}
