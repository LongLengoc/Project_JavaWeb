<%-- 
    Document   : Themsanpham
    Created on : Mar 15, 2020, 10:56:12 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Them san pham moi</title>
    </head>
    <body>
        <c:if test="${not empty AddProductSuccess}">
            <h3 style="color: brown;">${AddProductSuccess}</h3>
        </c:if>

        <h1>Them san pham moi</h1>
        <form action="ThemsanphamController" method="GET">
            <c:if test="${not empty UpdateProSuccess}">
                <h3 style="color: brown;">${UpdateProSuccess}</h3>
            </c:if>
            <c:if test="${not empty DeleteProSuccess}">
                <h3 style="color: brown;">${DeleteProSuccess}</h3>
            </c:if>
            <table border="1">
                <tr>
                    <td>Ma hang</td>
                    <td><input type="text" name="mahang"></td>
                </tr>
                <tr>
                    <td>Ten hang</td>
                    <td><input type="text" name="tenhang"></td>
                </tr>
                <tr>
                    <td>DVT</td>
                    <td><input type="text" name="dvt"></td>
                </tr>
                <tr>
                    <td>Gia</td>
                    <td><input type="text" name="gia"></td>
                </tr>
                <tr>
                    <td>Hinh anh</td>
                    <td><input type="text" name="hinhanh"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="add" value="Them san pham"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
            <br>
            <input type="submit" name="show" value="Hien thi toan bo san pham">
            <table border="1">

                <c:if test="${not empty lst}">
                    <tr>
                        <td>Ma hang</td>
                        <td>Ten hang</td>
                        <td>DVT</td>
                        <td>Gia</td>
                        <td>Hinh anh</td>
                        <td></td>
                    </tr>
                    <c:forEach var="s" items="${lst}">
                        <tr>
                            <td>${s.code}</td>
                            <td>${s.name}</td>
                            <td>${s.unit}</td>
                            <td>${s.price}</td>
                            <td>${s.image}</td>
                            <td>
                                <a href="UpdateSanphamController?mahang=${s.code}">Chinh sua</a>
                                <a href="DeleteSanPhamController?mahang=${s.code}">Xoa</a>
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
