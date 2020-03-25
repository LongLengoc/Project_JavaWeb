/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cart;
import Model.Item;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class GiohangController extends HttpServlet {

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
            Product p = new Product();
            String action = request.getParameter("action");
            String xacnhan = request.getParameter("xacnhan");

            // Them san pham moi            
            if (action != null && action.equalsIgnoreCase("add")) {

                // Lay thong tin san pham can them vao
                String mahang = request.getParameter("mahang");
                String tenhang = request.getParameter("tenhang");
                double gia = Double.parseDouble(request.getParameter("gia"));
                int soluong = 1;

                // Tao session gio hang
                HttpSession session = request.getSession(true);
                // Lay thong tin gio hang hien tai
                Cart c = (Cart) session.getAttribute("cart");
                // Neu chua co gio hang <=> c null => tao gio hang moi
                if (c == null) {
                    session.setAttribute("cart", new Cart());
                }
                c = (Cart) session.getAttribute("cart");
                // Them san pham moi vao gio hang
                c.add(new Item(mahang, tenhang, gia, soluong));
                // Ghi de gia tri lai
                session.setAttribute("cart", c);

                RequestDispatcher rd = request.getRequestDispatcher("Giohang.jsp");
                rd.forward(request, response);
            }

            // Xac nhan mua hang
            if (xacnhan != null) {
                request.setAttribute("BuySuccess", "Mua hang thanh cong");
                RequestDispatcher rd = request.getRequestDispatcher("Muahang.jsp");
                rd.forward(request, response);
                /*
                List<Item> lstItem = new ArrayList<>();
                
                // Tao session gio hang
                HttpSession session = request.getSession(true);
                // Lay thong tin gio hang hien tai
                Cart c = (Cart) session.getAttribute("cart");
                lstItem = c.getItems();

                //Tao ma hoa don (ma hoa don dung chung cho db chi tiet hoa don va db hoa don
                Random generator = new Random();
                int mahoadon = generator.nextInt(Integer.MAX_VALUE);

                // Lay thong tin khach hang
                String khachhang = request.getParameter("khachhang");

                // Ghi vao db hoa don
                String ngaytao = "3/25/2020";
                p.taoHoaDon(mahoadon, khachhang, ngaytao);

                // Ghi vao db chi tiet hoa don
                for (int i = 0; i < lstItem.size(); i++) {
                    String mahang1 = lstItem.get(i).getMahang();
                    int soluong1 = lstItem.get(i).getSoluong();
                    p.taoChiTietHoaDon(mahoadon, mahang1, soluong1);
                }

                request.setAttribute("BuySuccess", "Mua hang thanh cong");
                RequestDispatcher rd1 = request.getRequestDispatcher("Muahang.jsp");
                rd1.forward(request, response);
                */
            }
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
