<%-- 
    Document   : Giohang
    Created on : Mar 24, 2020, 8:48:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gio hang</title>
    </head>
    <body>
        <h1>Gio hang cua ban</h1>
        <form action="GiohangController" method="GET">
            <c:if test="${empty sessionScope.cart}">
                <h3>Gio hang hien tai cua ban dang trong, hay quay lai <a href="Muahang.jsp">mua hang</a></h3>
            </c:if>
            <c:if test="${not empty sessionScope.cart}">
                <table border="1">
                    <tr>
                        <td>Ma hang</td>
                        <td>Ten hang</td>
                        <td>Gia</td>
                        <td>So luong</td>
                        <td>Don gia</td>
                    </tr>
                    <c:forEach var="x" items="${sessionScope.cart.items}">
                        <tr>
                            <td>${x.mahang}</td>
                            <td>${x.tenhang}</td>
                            <td>${x.gia}</td>
                            <td>${x.soluong}</td>
                            <td>${x.gia * x.soluong}</td>
                        </tr>
                    </c:forEach>                    
                    <tr>
                        <td colspan="5">Total: ${sessionScope.cart.amount}</td>
                    </tr>
                </table> 
                <br>
                <br><br>    
                <h3>Thanh toan don hang</h3>
                <br><br>
                <table border="1">
                    <tr>
                        <td>Ten khach hang</td>
                        <td><input type="text" name="khachhang"></td>
                    <tr>
                        <td>So dien thoai</td>
                        <td><input type="text" name="sodienthoai"></td>
                    </tr>  
                    <tr>
                        <td>Dia chi lien he</td>
                        <td><input type="text" name="diachi"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="xacnhan" value="Xac nhan mua hang"></td>
                        <td></td>
                    </tr>
                </table>
            </c:if>

            <br>
            <a href="Muahang.jsp">Tiep tuc mua hang</a><br>
        </form>
    </body>
</html>
