/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

/**
 *
 * @author Thu
 */
public class Manager extends User
{
    public Manager(String employeeId, String fullname, String role) 
    {
       super(employeeId, fullname, role);
    }

    @Override
    public void showPermissions() 
    {
       System.out.println("Quyen han: Them, xoa, sua sach. Them, xoa, sua nhan vien.");
    }
}
