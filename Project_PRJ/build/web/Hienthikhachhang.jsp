<%-- 
    Document   : Hienthikhachhang
    Created on : Mar 8, 2020, 10:30:19 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hien thi thong tin khach hang</title>
    </head>
    <body>
        <h1>Hien thi thong tin khach hang</h1>
        <form action="EditKhachHangController" method="GET">
            <input type="submit" name="selectAll" value="Hien thi thong tin khach hang">
            <table border="1">
                <c:if test="${not empty lstKh}">
                    <tr>
                        <td>Ma khach hang</td>
                        <td>Ten khach hang</td>
                        <td>Gioi tinh</td>
                        <td>Dia chi</td>
                        <td>Ngay sinh</td>
                        <td></td>
                    </tr>
                    <c:forEach var="s" items="${lstKh}">
                        <tr>
                            <td>${s.maKH}</td>
                            <td>${s.tenKH}</td>
                            <td>${s.gioitinh}</td>
                            <td>${s.diachi}</td>
                            <td>${s.DOB}</td>
                            <td>
                                <a href="update?maKH=${s.maKH}">Update</a>
                                <a href="delete?maKH=${s.maKH}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            <br>
            <a href="Trangchu.jsp">Trang chu</a>
        </form>
    </body>
</html>
