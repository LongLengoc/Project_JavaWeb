/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class DathangController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String mahang = request.getParameter("MaHang");
            Product p = new Product();
            
            // Lay thong tin mat hang can mua
            request.setAttribute("mahang", p.select1(mahang));
            
            // Khi bam xac nhan, lay thong tin khach hang va thong tin sp
            if (request.getParameter("xacnhan") != null) {
                String makh = request.getParameter("makh");
                String mahang1 = request.getParameter("mahang");
                String tenhang = request.getParameter("tenhang");
                double gia = Double.parseDouble(request.getParameter("gia"));
                int soluong = Integer.parseInt(request.getParameter("soluong"));

                //Tao ma hoa don (ma hoa don dung chung cho db chi tiet hoa don va db hoa don
                Random generator = new Random();
                int mahoadon = generator.nextInt(Integer.MAX_VALUE);

                //ghi vao db chi tiet hoa don
                p.taoChiTietHoaDon(mahoadon, mahang1, soluong);

                //ghi vao db hoa don
                String ngaytao = "3/13/2020";
                p.taoHoaDon(mahoadon, makh, ngaytao);

                request.setAttribute("BuySuccess", "Mua hang thanh cong");
                RequestDispatcher rd = request.getRequestDispatcher("Muahang.jsp");
                rd.forward(request, response);
            }

            RequestDispatcher rd = request.getRequestDispatcher("Dathang.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
