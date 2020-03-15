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
public class Khachhang {
    private String MaKH;
    private String TenKH;
    private int gioitinh;
    private String Diachi;
    private Date DOB;
    
    Connection con;
    Statement stm;
    ResultSet rs;
    
    public Khachhang() {
        try {
            con = (new DBContext()).getConnection();
            System.out.println("Connect successfully");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public Khachhang(String MaKH, String TenKH, int gioitinh, String Diachi, Date DOB) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.gioitinh = gioitinh;
        this.Diachi = Diachi;
        this.DOB = DOB;
        
        try {
            con = (new DBContext()).getConnection();
            System.out.println("Connect successfully");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    // Insert thong tin khach hang vao tblKhachHang
    public void insert(String Makh, String Tenkh, int gioitinh, String diachi, String DOB) throws Exception {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String str = "Insert into tblKhachHang values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(str);
            
            ps.setString(1, Makh);
            ps.setString(2, Tenkh);
            ps.setInt(3, gioitinh);
            ps.setString(4, diachi);
            ps.setString(5, DOB);
            
            ps.executeUpdate();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Lay ra toan bo thong tin cua khach hang
    public List<Khachhang> selectAll() throws Exception {
        List<Khachhang> lst = new ArrayList<>();
        
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * from tblKhachHang";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String Makh = rs.getString(1);
                String Tenkh = rs.getString(2);
                int gioitinh = rs.getInt(3);
                String diachi = rs.getString(4);
                Date dob = rs.getDate(5);
                
                Khachhang kh = new Khachhang(Makh, Tenkh, gioitinh, diachi, dob);
                lst.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return lst;
    }
    
    // Lay ra thong tin cua 1 khach hang
    public Khachhang select1(String maKH) throws Exception {
        Khachhang kh = new Khachhang();
        
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * from tblKhachHang where MaKH = '"+maKH+"'";
            rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                String Makh = rs.getString(1);
                String Tenkh = rs.getString(2);
                int gioitinh = rs.getInt(3);
                String diachi = rs.getString(4);
                Date dob = rs.getDate(5);
                
                kh = new Khachhang(Makh, Tenkh, gioitinh, diachi, dob);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return kh;
    }
    
    // Update thong tin cua khach hang
    public void update(String Makh, String Tenkh, int gioitinh, String diachi, String DOB) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "Update tblKhachHang set TenKH = '"+Tenkh+"', GT = '"+gioitinh+"', Diachi = '"+diachi+"', NgaySinh = '"+DOB+"' where MaKH = '"+Makh+"'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    // Xoa khach hang khoi db
    public void delete(String Makh) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "Delete from tblKhachHang where MaKH = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Makh);
        ps.execute();
        ps.close();
        con.close();
    }
}
