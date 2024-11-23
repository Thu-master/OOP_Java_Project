/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Thu
 */
public class User_Management 
{
        private ArrayList<User> users;

    public User_Management() {
        users = new ArrayList<>();
    }

    // Đọc danh sách từ file
    public void loadUsersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 3) {
                    String employeeId = parts[0].trim();
                    String fullname = parts[1].trim();
                    String role = parts[2].trim();

                    // Tạo đối tượng dựa trên chức vụ
                    switch (role) {
                        case "Admin":
                            users.add(new Admin(employeeId, fullname, role));
                            break;
                        case "Manager":
                            users.add(new Manager(employeeId, fullname, role));
                            break;
                        case "Employee":
                            users.add(new Employee(employeeId, fullname, role));
                            break;
                        default:
                            System.out.println("Chuc vu khong hop le: " + role);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // Tìm người dùng theo mã số nhân viên và họ tên
    public User findUserByInfo(String employeeId, String fullName) {
        for (User user : users) {
            if (user.getEmloyeeI().equalsIgnoreCase(employeeId) &&
                user.getFullname().equalsIgnoreCase(fullName)) {
                return user;
            }
        }
        return null;
    }
}
