<%-- 
    Document   : Capnhatsanpham
    Created on : Mar 15, 2020, 1:37:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cap nhat san pham</title>
    </head>
    <body>
        <h1>Cap nhat san pham</h1>
        <form action="UpdateSanphamController" method="GET">
            <c:if test="${not empty product1}">
                <table border="1">
                    <tr>
                        <td>Ma hang</td>
                        <td><input type="text" name="mahang" value="${product1.code}"</td>
                    </tr>
                    <tr>
                        <td>Ten hang</td>
                        <td><input type="text" name="tenhang" value="${product1.name}"</td>
                    </tr>
                    <tr>
                        <td>DVT</td>
                        <td><input type="text" name="dvt" value="${product1.unit}"</td>
                    </tr>
                    <tr>
                        <td>Gia</td>
                        <td><input type="text" name="gia" value="${product1.price}"</td>
                    </tr>
                    <tr>
                        <td>Hinh anh</td>
                        <td><input type="text" name="hinhanh" value="${product1.image}"</td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="capnhat" value="Cap nhat"></td>
                        <td><input type="reset" value="Reset"</td>
                    </tr>
                </table>
            </c:if>
            <br>
            <a href="Trangchu.jsp">Trang chu</a>
        </form>
    </body>
</html>
