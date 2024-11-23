/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

/**
 *
 * @author Thu
 */
public class Employee extends User
{
    //để quản lý thông tin nhân viên, như ID, tên, chức vụ (nhân viên bán hàng, quản lý, thủ kho), và thông tin liên lạc.
    //Phân quyền nhân viên: Tùy thuộc vào chức vụ, bạn có thể giới hạn quyền truy cập để chỉ cho phép một số nhân viên nhất định thực hiện các thao tác như nhập hàng, quản lý đơn hàng, hoặc xem báo cáo.
    public Employee(String employeeId, String fullname, String role) 
    {
        super(employeeId, fullname, role);
    }

    @Override
    public void showPermissions() 
    {
       System.out.println("Quyen han: Them, xoa, sua sach.");
    }
}
