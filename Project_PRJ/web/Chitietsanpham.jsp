<%-- 
    Document   : Chitietsanpham
    Created on : Mar 15, 2020, 10:21:14 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiet san pham</title>
    </head>
    <body>
        <h1>Chi tiet san pham</h1>
        <form action="ChitietsanphamController" method="GET">
            <c:if test="${not empty product}">
                <table border="1">
                    <tr>
                        <td>Ma hang</td>
                        <td>Ten hang</td>
                        <td>DVT</td>
                        <td>Gia (USD)</td>
                        <td>Hinh anh</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>${product.code}</td>
                        <td>${product.name}</td>
                        <td>${product.unit}</td>
                        <td>${product.price}</td>
                        <td>${product.image}</td>
                        <td>
                            <a href="DathangController?MaHang=${product.code}">Mua hang</a>
                        </td>
                    </tr>
                </table>
            </c:if>
            <br>
            <a href="Muahang.jsp">Quay lai mua hang</a>
        </form>
    </body>
</html>
