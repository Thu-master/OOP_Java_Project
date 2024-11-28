/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class User_Management 
{
        private ArrayList<User> users;
        private ArrayList<User> pendingRequests;
        private HashMap<String, ArrayList<String>> approvedNotifications = new HashMap<>();


    public User_Management() {
        users = new ArrayList<>();
        pendingRequests = new ArrayList<>();
        approvedNotifications = new HashMap<>();
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
    
    public void addEmployeeRequest(User user)
    {
        pendingRequests.add(user);
        System.out.println("Yeu cau them nhan vat da duoc gui len sep!\nCho duyet!");
    }
    
public void approveRequest() {
    Scanner scanner = new Scanner(System.in);

    if (pendingRequests.isEmpty()) {
        System.out.println("Khong co yeu cau nao cho duyet.");
        return;
    }

    // Hiển thị tất cả các yêu cầu
    System.out.println("\n--- Danh sach cac yeu cau dang cho duyet ---");
    int index = 1;
    for (User pendingUser : pendingRequests) {
        System.out.println(index + ". Ten: " + pendingUser.getFullname() + ", Ma so: " + pendingUser.getEmloyeeI());
        index++;
    }

    // Admin chọn yêu cầu để xử lý
    System.out.print("\nNhap so thu tu cua yeu cau muon xu ly: ");
    int requestIndex = Integer.parseInt(scanner.nextLine()) - 1;

    if (requestIndex < 0 || requestIndex >= pendingRequests.size()) {
        System.out.println("Lua chon khong hop le!");
        return;
    }

    // Lấy yêu cầu được chọn
    User pendingUser = pendingRequests.get(requestIndex);

    // Xác nhận từ Admin
    System.out.println("\nThong tin yeu cau:");
    System.out.println("Ten: " + pendingUser.getFullname() + ", Ma so: " + pendingUser.getEmloyeeI());
    System.out.print("Ban co muon duyet (Y/N)? ");
    String choice = scanner.nextLine();

    if (choice.equalsIgnoreCase("Y")) {
        // Phê duyệt yêu cầu
        pendingRequests.remove(requestIndex);
        users.add(pendingUser); // Thêm vào danh sách nhân viên
        addApprovedNotification(pendingUser.getEmloyeeI(), "Yeu cau cua ban da duoc Admin duyet.");
        writeUserToFile(pendingUser, "List-NV.txt"); // Ghi vào file
        System.out.println("Yeu cau da duoc duyet thanh cong.");
    } else {
        // Từ chối yêu cầu
        pendingRequests.remove(requestIndex);
        System.out.println("Yeu cau da bi tu choi.");
    }
}
    
    // Phương thức ghi nhân viên vào file
    public void writeUserToFile(User user, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getEmloyeeI() + "-" + user.getFullname() + "-" + user.getRole());
            writer.newLine(); // Thêm dòng mới
            System.out.println("Thong tin nhan vien moi da duoc ghi vao file.");
        } catch (IOException e) {
            System.out.println("Loi khi ghi thong tin nhan vien vao file: " + e.getMessage());
        }
    }
    
    public void addUsers(User user)
    {
        users.add(user);
        System.out.println("Nhan vien mơi da duoc them vao danh sach.");
    }
    
    public ArrayList<User> getPendingRequests() 
    {
        return pendingRequests;
    }
    
    public void addApprovedNotification(String employeeId, String message) {
        // Kiểm tra nếu nhân viên chưa có thông báo nào
        approvedNotifications.putIfAbsent(employeeId, new ArrayList<>());
        approvedNotifications.get(employeeId).add(message);
        System.out.println("Thong bao da duoc luu cho nhan vien: " + employeeId);
    }
    
    public ArrayList<String> getApprovedNotifications(String employeeId) {
    return approvedNotifications.getOrDefault(employeeId, new ArrayList<>());
}
    public void clearNotifications(String employeeId) {
    approvedNotifications.remove(employeeId); // Xóa tất cả thông báo của nhân viên
}


}
