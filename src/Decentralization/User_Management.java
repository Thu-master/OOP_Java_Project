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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
    private HashMap<String, String> requestStatuses = new HashMap<>();
    private ArrayList<User> deleteRequests = new ArrayList<>();


    public User_Management() 
    {
        users = new ArrayList<>();
        pendingRequests = new ArrayList<>();
        approvedNotifications = new HashMap<>();
    }

    // Đọc danh sách từ file
    public void loadUsersFromFile(String filePath) 
    {
        users.clear(); // Làm trống danh sách trước khi tải lại
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split("-");
                if (parts.length == 3) 
                {
                    String employeeId = parts[0].trim();
                    String fullname = parts[1].trim();
                    String role = parts[2].trim();

                    // Tạo đối tượng dựa trên chức vụ
                    switch (role) 
                    {
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
        }
        catch (IOException e) 
        {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // Tìm người dùng theo mã số nhân viên và họ tên
    public User findUserByInfo(String employeeId, String fullName) 
    {
        for (User user : users) 
        {
            if(user.getEmloyeeI().equalsIgnoreCase(employeeId) &&
                user.getFullname().equalsIgnoreCase(fullName)) 
            {
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
    
    public void approveRequest() 
    {
        Scanner scanner = new Scanner(System.in);

        if (pendingRequests.isEmpty()) 
        {
            System.out.println("Khong co yeu cau nao cho duyet.");
            return;
        }

        System.out.println("\n--- Danh sach cac yeu cau dang cho duyet ---");
        int index = 1;
        for(User pendingUser : pendingRequests) 
        {
            System.out.println(index + ". Ten: " + pendingUser.getFullname() + ", Ma so: " + pendingUser.getEmloyeeI());
            index++;
        }

        System.out.print("\nNhap so thu tu cua yeu cau muon xu ly: ");
        int requestIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if(requestIndex < 0 || requestIndex >= pendingRequests.size()) 
        {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        User pendingUser = pendingRequests.get(requestIndex);

        System.out.println("\nThong tin yeu cau:");
        System.out.println("Ten: " + pendingUser.getFullname() + ", Ma so: " + pendingUser.getEmloyeeI());
        System.out.print("Ban co muon duyet (Y/N)? ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) 
        {
            pendingRequests.remove(requestIndex);
            users.add(pendingUser);
            addApprovedNotification(pendingUser.getEmloyeeI(), "Yeu cau cua ban da duoc Admin duyet.");
            writeUserToFile(pendingUser, "List-NV.txt");

            // Ghi lịch sử phê duyệt với thời gian thực
            String approvalMessage = "Admin da duyet nhan vien: " + pendingUser.getFullname() + " (ID: " + pendingUser.getEmloyeeI() + ")";
            writeApprovalHistory(approvalMessage);

            System.out.println("Yeu cau da duoc duyet thanh cong.");
        } 
        else 
        {
            pendingRequests.remove(requestIndex);

            // Ghi lịch sử từ chối với thời gian thực
            String rejectionMessage = "Admin da tu choi nhan vien: " + pendingUser.getFullname() + " (ID: " + pendingUser.getEmloyeeI() + ")";
            writeApprovalHistory(rejectionMessage);

            System.out.println("Yeu cau da bi tu choi.");
        }
    }


    
    // Phương thức ghi nhân viên vào file
    public void writeUserToFile(User user, String filePath) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) 
        {
            writer.write(user.getEmloyeeI() + "-" + user.getFullname() + "-" + user.getRole());
            writer.newLine(); // Thêm dòng mới
            System.out.println("Thong tin nhan vien moi da duoc ghi vao file.");
        } 
        catch(IOException e) 
        {
            System.out.println("Loi khi ghi thong tin nhan vien vao file: " + e.getMessage());
        }
    }
    
    public ArrayList<User> getPendingRequests() 
    {
        return pendingRequests;
    }
    
    public void addApprovedNotification(String employeeId, String message) 
    {
        approvedNotifications.putIfAbsent(employeeId, new ArrayList<>());
        approvedNotifications.get(employeeId).add(message);
        System.out.println("Thong bao da duoc luu cho nhân viên: " + employeeId);
    }

    
    public void writeApprovalHistory(String message) 
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("approval_history.txt", true))) 
        {
            // Thêm thời gian vào thông điệp
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + timestamp + "] " + message);
            writer.newLine();
            System.out.println("Lich su duyet da duoc luu lai.");
        } 
        catch(IOException e) 
        {
            System.out.println("Loi khi ghi lich su duyet: " + e.getMessage());
        }
    }

    public void viewApprovalHistory() 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("approval_history.txt"))) 
        {
            String line;
            System.out.println("\n--- Lich su duyet ---");
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
        catch(IOException e) 
        {
            System.out.println("Loi khi doc lich su duyet: " + e.getMessage());
        }
    }


    public void cancelEmployeeRequest(String employeeId) 
    {
        boolean removed = pendingRequests.removeIf(req -> req.getEmloyeeI().equals(employeeId));
        if (removed) 
        {
            System.out.println("Yeu cau cho nhan vien ID: " + employeeId + " da duoc huy.");
        } 
        else 
        {
            System.out.println("Khong tim thay yeu cau voi ID: " + employeeId);
        }
    }
        
    public String getManagerIdForEmployee(String employeeId) 
    {
        // Logic tìm Manager liên quan đến Employee (nếu có)
        for (User user : users) {
            if (user instanceof Manager && user.getEmloyeeI().equals(employeeId)) 
            {
                return user.getEmloyeeI();
            }
        }
        return null; // Không tìm thấy
    }

// ----------------------------------------------------------------------------------------------------------------------------------   
    
    // Gửi yêu cầu xóa nhân viên
    public void addDeleteEmployeeRequest(User user) 
    {
       deleteRequests.add(user);
       System.out.println("Yêu cầu xóa nhân viên đã được gửi lên Admin!");
    }

    // Hủy yêu cầu xóa nhân viên
    public void cancelDeleteEmployeeRequest(String employeeId) 
    {
        boolean removed = deleteRequests.removeIf(req -> req.getEmloyeeI().equals(employeeId));
        if (removed) 
        {
           System.out.println("Yêu cầu xóa nhân viên với ID: " + employeeId + " đã được hủy.");
        } 
        else 
        {
           System.out.println("Không tìm thấy yêu cầu xóa với ID: " + employeeId);
        }
    }

    // Lấy danh sách yêu cầu xóa
    public ArrayList<User> getDeleteRequests() 
    {
       return deleteRequests;
    }

    private void updateEmployeeFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("List-NV.txt"))) {
        for (User user : users) {
            writer.write(user.getEmloyeeI() + "-" + user.getFullname() + "-" + user.getRole());
            writer.newLine(); // Thêm dòng mới
        }
        System.out.println("File List-NV.txt đã được cập nhật.");
    } catch (IOException e) {
        System.out.println("Lỗi khi cập nhật file: " + e.getMessage());
    }
}

    public void approveDeleteEmployee(User_Management userManagement) 
    {
        if (deleteRequests.isEmpty()) 
        {
           System.out.println("Khong co yeu cau xoa nhan vien nao dang cho.");
           return;
        }

        System.out.println("\n--- Danh sach yeu cau xoa nhan vien ---");
        int index = 1;
        for (User user : deleteRequests) 
        {
            System.out.println(index + ". ID: " + user.getEmloyeeI() + ", Ten: " + user.getFullname());
            index++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so thu tu cua yeu cau muon xu ly: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice >= 0 && choice < deleteRequests.size()) {
            User userToDelete = deleteRequests.get(choice);
            System.out.println("Ban co chac chan muon xoa nhan vien: " + userToDelete.getFullname() + " (Y/N)?");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) 
            {
                //Xóa nhân viên khỏi danh sách
                deleteRequests.remove(choice);
                users.removeIf(user -> user.getEmloyeeI().equals(userToDelete.getEmloyeeI()));
                
                //Cập nhật file   
                updateEmployeeFile();  
                
                //Ghi lịch sử phê duyệt
                writeApprovalHistory("Admin đã xóa nhân viên: " + userToDelete.getFullname() + " (ID: " + userToDelete.getEmloyeeI() + ")");
                System.out.println("Nhan vien da duoc xoa.");
            } 
            else 
            {
                //Ghi lịch sử từ chối
                writeApprovalHistory("Admin đã từ chối yêu cầu xóa nhân viên: " + userToDelete.getFullname() + " (ID: " + userToDelete.getEmloyeeI() + ")");
                System.out.println("Yeu cau khong duoc xu ly.");
            }
        } 
        else 
        {
            System.out.println("Lua chon khong hop le.");
        }
    }

// ----------------------------------------------------------------------------------------------------------------------------------  
    //Admin
    public ArrayList<User> getUsers() 
    {
       return users;
    }

    
    
}
