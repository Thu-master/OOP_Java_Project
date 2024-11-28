/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

import java.util.Scanner;

/**
 *
 * @author Thu
 */
public class Admin extends User
{
    public Admin(String employeeId, String fullname, String role) 
    {
       super(employeeId, fullname, role);
    }

    @Override
    public void showPermissions() 
    {
       System.out.println("Quyen han: Toan quyen trong he thong.");
    }
    
    public void approveAddEmployee(User_Management userManagement) 
    {
        Scanner scanner = new Scanner(System.in);

        if (userManagement.getPendingRequests().isEmpty()) {
            System.out.println("Khong co yeu cau nao cho duyet.");
            return;
        }

        // Hiển thị tất cả các yêu cầu
        System.out.println("\n--- Danh sach cac yeu cau dang cho duyet ---");
        int index = 1;
        for (User pendingUser : userManagement.getPendingRequests()) {
            System.out.println(index + ". Ten: " + pendingUser.getFullname() + ", Ma so: " + pendingUser.getEmloyeeI());
            index++;
        }

        // Chọn yêu cầu để xử lý
        System.out.print("\nNhap so thu tu cua yeu cau muon xu ly: ");
        int requestIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (requestIndex < 0 || requestIndex >= userManagement.getPendingRequests().size()) {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        // Lấy yêu cầu được chọn
        User pendingUser = userManagement.getPendingRequests().get(requestIndex);

        // Admin quyết định
        System.out.println("\nThong tin yeu cau:");
        System.out.println("Ten: " + pendingUser.getFullname() + ", Ma so: " + pendingUser.getEmloyeeI());
        System.out.print("Ban co muon duyet (Y/N)? ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            userManagement.getPendingRequests().remove(requestIndex); // Xóa yêu cầu khỏi danh sách
            userManagement.addUsers(pendingUser); // Thêm nhân viên vào danh sách
            userManagement.writeUserToFile(pendingUser, "List-NV.txt"); // Ghi vào file
            System.out.println("Yeu cau da duoc duyet thanh cong.");
        } else {
            userManagement.getPendingRequests().remove(requestIndex); // Xóa yêu cầu khỏi danh sách
            System.out.println("Yeu cau da bi tu choi.");
        }
    }
}
