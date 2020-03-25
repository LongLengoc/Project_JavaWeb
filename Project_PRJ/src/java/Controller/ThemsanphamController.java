/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ThemsanphamController extends HttpServlet {

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
            // Lay thong tin dang nhap
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("login");

            Product p = new Product();
            if (obj == null) {
                // Access denied
                // quay lai trang login
                request.setAttribute("AccessDenied", "Vui long dang nhap de thuc hien chuc nang nay");
                RequestDispatcher rd = request.getRequestDispatcher("Dangnhap.jsp");
                rd.forward(request, response);
            } else {
                // Access acceptd

                // Them thong tin san pham vao database
                if (request.getParameter("add") != null) {
                    //Lay thong tin san pham tu form
                    String mahang = request.getParameter("mahang");
                    String tenhang = request.getParameter("tenhang");
                    String dvt = request.getParameter("dvt");
                    String g = request.getParameter("gia");
                    int gia = Integer.parseInt(g);
                    String hinhanh = request.getParameter("hinhanh");
                    p.insert(mahang, tenhang, dvt, gia, hinhanh);
                    request.setAttribute("AddProductSuccess", "Them san pham moi thanh cong");
                }

                // Hien thi toan bo thong tin san pham
                if (request.getParameter("show") != null) {
                    request.setAttribute("lst", p.getListProduct());
                }

                RequestDispatcher rd = request.getRequestDispatcher("Themsanpham.jsp");
                rd.forward(request, response);
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
