/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
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
public class UserController extends HttpServlet {

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

            User u = new User();

            //Lay thong tin cua account tu form
            String acc = request.getParameter("account").trim();
            String pass = request.getParameter("password");
            String name = request.getParameter("name");
            int gender = 0;
            if ("Male".equals(request.getParameter("gender"))) {
                gender = 1;
            }
            if ("Female".equals(request.getParameter("gender"))) {
                gender = 0;
            }
            String address = request.getParameter("address");
            String DOB = request.getParameter("dob");
            if (obj == null) {
                // Access denied
                // Quay lai trang login
                request.setAttribute("AccessDenied", "Vui long dang nhap de thuc hien chuc nang nay");
                RequestDispatcher rd = request.getRequestDispatcher("Dangnhap.jsp");
                rd.forward(request, response);
            } else {

                if (request.getParameter("dangki") != null) {

                    //Yeu cau lam them : check duplicate
                    if (u.checkDuplicate(acc) == false) {

                        // Ghi thong tin tai khoan vao db
                        u.insert(acc, pass, name, gender, address, DOB);
                        request.setAttribute("CreateUserSuccess", "Create User successfully");
                    } else {
                        request.setAttribute("CreateUserFail", "Create User fail");
                    }
                    //u.insert(acc, pass, name, gender, address, DOB);
                    //request.setAttribute("CreateUserSuccess", "Create User successfully");
                }
                //Lam them yeu cau : Hien thi danh sach cac user
                if (request.getParameter("show") != null) {
                    request.setAttribute("lstUser", u.selectAll());
                }
                // request.setAttribute("lstUser", u.selectAll());
                RequestDispatcher rd = request.getRequestDispatcher("Dangkitaikhoan.jsp");
                //RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
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
