<%-- 
    Document   : Capnhatkhachang
    Created on : Mar 8, 2020, 1:08:17 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cap nhat thong tin khach hang</title>
    </head>
    <body>
        <h1>Cap nhat thong tin khach hang</h1>
        <form action="update" method="GET">
            <c:if test="${not empty kh}">

                <table border="1">
                    <tr>
                        <td>Ma khach hang</td>
                        <td><input type="text" name="Makh" value="${kh.maKH}"></td>
                    </tr>
                    <tr>
                        <td>Ten khach hang</td>
                        <td><input type="text" name="Tenkh" value="${kh.tenKH}"></td>
                    </tr>
                    <tr>
                        <td>Gioi tinh</td>
                        <td>
                            <input type="radio" name="gender" value="Male"/> Nam
                            <input type="radio" name="gender" value="Female"/> Nu
                        </td>
                    </tr>
                    <tr>
                        <td>Dia chi</td>
                        <td><input type="text" name="Diachi" value="${kh.diachi}"></td>
                    </tr>
                    <tr>
                        <td>Ngay sinh</td>
                        <td><input type="text" name="Ngaysinh" value="${kh.DOB}"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="capnhat" value="Cap nhat thong tin"></td>
                        <td><input type="reset" value="Reset"></td>
                    </tr>
                </table>

            </c:if>
            <br>
            <a href="Trangchu.jsp">Trang chu</a>
        </form>
    </body>
</html>
