<%-- 
    Document   : Dathang
    Created on : Mar 8, 2020, 4:42:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dat hang</title>
    </head>
    <body>
        <h1>Dat hang san pham</h1>
        <form action="DathangController" method="GET">
            <c:if test="${not empty mahang}">
                <table border="1">
                    <tr>
                        <td>Ma KH</td>
                        <td><input type="text" name="makh" value=""></td>
                    </tr>
                    <tr>
                        <td>Ma hang</td>
                        <td><input type="text" name="mahang" value="${mahang.code}"></td>
                    </tr>
                    <tr>
                        <td>Ten hang</td>
                        <td><input type="text" name="tenhang" value="${mahang.name}"></td>
                    </tr>
                    <tr>
                        <td>Gia</td>
                        <td><input type="text" name="gia" value="${mahang.price}"></td>
                    </tr>
                    <tr>
                        <td>So luong</td>
                        <td><input type="text" name="soluong" value=""></td>
                    </tr>
                </table>
            </c:if>
            <input type="submit" name="xacnhan" value="Xac nhan">
            <br>
            <a href="Muahang.jsp">Quay lai mua hang</a>
        </form>
    </body>
</html>
