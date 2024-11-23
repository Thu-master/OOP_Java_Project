/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decentralization;

/**
 *
 * @author Thu
 */
public abstract class User 
{
    // Lớp User (Cha)
    protected String employeeId;
    protected String fullname;
    protected String role;

    public User(String employeeId, String fullname, String role) 
    {
        this.employeeId = employeeId;
        this.fullname = fullname;
        this.role = role;
    }

    public String getEmloyeeI() 
    {
        return employeeId;
    }

    public String getFullname() 
    {
        return fullname;
    }
    
    public String getRole()
    {
        return role;
    }

    // Phương thức trừu tượng cho quyền hạn
    public abstract void showPermissions();
}
