/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class User {

    private String account;
    private String pass;
    private String name;
    private int Gender;
    private String address;
    private Date DOB;

    Connection con;
    Statement stm;
    ResultSet rs;

    public User() {
        try {
            con = (new DBContext()).getConnection();
            System.out.println("Connect successfully");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public User(String account, String pass, String name, int Gender, String address, Date DOB) {
        this.account = account;
        this.pass = pass;
        this.name = name;
        this.Gender = Gender;
        this.address = address;
        this.DOB = DOB;

        try {
            con = (new DBContext()).getConnection();
            System.out.println("Connect successfully");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    // Insert user vao db
    public void insert(String acc, String pass, String name, int gender, String address, String DOB) throws Exception {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "Insert into tblUser values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSelect);

            ps.setString(1, acc);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setInt(4, gender);
            ps.setString(5, address);
            ps.setString(6, DOB);

            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Ham check duplocate account
    public boolean checkDuplicate(String account) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "Select * from tblUser where account = '" + account + "'";
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            return true;
        }
        return false;
    }
    
    // Lay ra thong tin cua cac user
    public List<User> selectAll() throws Exception {
        List<User> lst = new ArrayList<>();
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * from tblUser";
            rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                String account = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                int gender = rs.getInt(4);
                String address = rs.getString(5);
                Date dob = rs.getDate(6);
                
                User u = new User(account, password, name, gender, address, dob);
                lst.add(u);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public boolean checkLogin(String username, String password) throws Exception {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * from tblUser where account = '"+username+"' and pass = '"+password+"'";
            rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
