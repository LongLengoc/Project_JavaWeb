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

/**
 *
 * @author Admin
 */
public class Product {

    private String code, name, unit, image;
    private int price;

    Connection con;
    Statement stm;
    ResultSet rs;

    public Product() {
        try {
            con = (new DBContext()).getConnection();
            System.out.println("Connect successfully");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public Product(String code, String name, String unit, String image, int price) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.image = image;
        this.price = price;

        try {
            con = (new DBContext()).getConnection();
            System.out.println("Connect successfully");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    // Lay ra thong tin cua toan bo san pham
    public ArrayList<Product> getListProduct() {
        ArrayList<Product> lst = new ArrayList<>();

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "Select * from tblMatHang";
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String code = rs.getString(1); //cot so 1
                String name = rs.getString(2); //cot so 2
                String unit = rs.getString(3);
                int price = rs.getInt(4);
                String image = rs.getString(5);
                Product P = new Product(code, name, unit, image, price);
                lst.add(P);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }
    
    // Lay ra thong tin cua mot san pham
    public Product select1(String mahang) throws Exception {
        Product p = new Product();
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "Select * from tblMatHang where MaHang = '" + mahang + "'";
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String code = rs.getString(1); //cot so 1
                String name = rs.getString(2); //cot so 2
                String unit = rs.getString(3);
                int price = rs.getInt(4);
                String image = rs.getString(5);

                p = new Product(code, name, unit, image, price);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    // Tao Chi tiet hoa don
    public void taoChiTietHoaDon(int mahoadon, String mahang, int soluong) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String str = "Insert into tblChitietHD values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(str);

        ps.setInt(1, mahoadon);
        ps.setInt(2, mahoadon);
        ps.setString(3, mahang);
        ps.setInt(4, soluong);

        ps.executeUpdate();
        //ps.close();
        //con.close();
    }
    
    // Tao hoa don
    public void taoHoaDon(int mahoadon, String makh, String ngaytao) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String str = "Insert into tblHoadon values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(str);
        
        ps.setInt(1, mahoadon);
        ps.setString(2, makh);
        ps.setString(3, ngaytao);
        
        ps.executeUpdate();
        //ps.close();
        //con.close();
    }
    
    // Them san pham vao bang tblMathang
    public void insert(String mahang, String tenhang, String dvt, int gia, String hinhanh) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String str = "Insert into tblMatHang values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(str);
        
        ps.setString(1, mahang);
        ps.setString(2, tenhang);
        ps.setString(3, dvt);
        ps.setInt(4, gia);
        ps.setString(5, hinhanh);
        
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    // Cap nhat thong tin san pham
    public void update(String mahang, String tenhang, String dvt, int gia, String hinhanh) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "Update tblMatHang set Tenhang = '"+tenhang+"', DVT = '"+dvt+"', Gia = '"+gia+"', Hinhanh = '"+hinhanh+"' where MaHang = '"+mahang+"'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    // Xoa san pham
    public void delete(String mahang) throws Exception {
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "Delete from tblMatHang where MaHang = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, mahang);
        ps.execute();
        ps.close();
        con.close();
    }
    
    // Tim kiem san pham bang ten
    public ArrayList<Product> searchproduct(String tenhang) throws Exception {
        ArrayList<Product> lstpro = new ArrayList<>();
        
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "Select * from tblMatHang where Tenhang like '%" + tenhang + "%'";
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String code = rs.getString(1); //cot so 1
                String name = rs.getString(2); //cot so 2
                String unit = rs.getString(3);
                int price = rs.getInt(4);
                String image = rs.getString(5);
                Product p = new Product();
                p = new Product(code, name, unit, image, price);
                lstpro.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstpro;
    }
}
