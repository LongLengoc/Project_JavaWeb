<%-- 
    Document   : Muahang
    Created on : Mar 8, 2020, 4:04:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mua hang</title>
    </head>
    <body>
        <h1>Trang mua hang</h1>
        <form action="MuaHangController" method="GET">
            <c:if test="${not empty CreateKhSuccess}">
                <h3 style="color: brown;">${CreateKhSuccess}</h3>
            </c:if>
            <c:if test="${not empty BuySuccess}">
                <h3 style="color: brown;">${BuySuccess}</h3>
            </c:if>
            <c:if test="${not empty MuaHangSuccess}">
                <h3 style="color: brown;">${MuaHangSuccess}</h3>
            </c:if>

            <h3>Mot so mat hang noi bat</h3>
            <table border="1">
                <tr>
                    <td>Ma hang</td>
                    <td>Ten hang</td>
                    <td>DVT</td>
                    <td>Gia (USD)</td>
                    <td>Hinh anh</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><a href="ChitietsanphamController?MaHang=M01">M01</a></td>
                    <td><a href="ChitietsanphamController?MaHang=M01">May tinh Asus</a></td>
                    <td>Chiec</td>
                    <td>2000</td>
                    <td>Asus.jpeg</td>
                    <td>
                        <a href="DathangController?MaHang=M01">Mua hang</a>
                    </td>
                    <c:url var="buy" value="GiohangController">
                        <c:param name="mahang" value="M01"></c:param>
                        <c:param name="tenhang" value="May tinh Asus"></c:param>
                        <c:param name="gia" value="2000"></c:param>
                        <c:param name="action" value="add"></c:param>
                    </c:url>
                    <td>
                        <a href="${buy}">Them vao gio hang</a>
                    </td>
                </tr>
                <tr>
                    <td><a href="ChitietsanphamController?MaHang=M02">M02</a></td>
                    <td><a href="ChitietsanphamController?MaHang=M02">May tinh Asus2</a></td>
                    <td>Chiec</td>
                    <td>1900</td>
                    <td>Asus1.jpeg</td>
                    <td>
                        <a href="DathangController?MaHang=M02">Mua hang</a>
                    </td>
                    <c:url var="buy" value="GiohangController">
                        <c:param name="mahang" value="M02"></c:param>
                        <c:param name="tenhang" value="May tinh Asus2"></c:param>
                        <c:param name="gia" value="1900"></c:param>
                        <c:param name="action" value="add"></c:param>
                    </c:url>
                    <td>
                        <a href="${buy}">Them vao gio hang</a>
                    </td>
                </tr>
            </table>
            <br>
            <br>
            <input type="submit" name="show" value="Hien thi tat ca san pham"><br>
            <c:if test="${not empty product}">
                <table border="1">
                    <tr>
                        <td>Ma hang</td>
                        <td>Ten hang</td>
                        <td>DVT</td>
                        <td>Gia (USD)</td>
                        <td>Hinh anh</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach var="s" items="${product}">
                        <tr>
                            <td><a href="ChitietsanphamController?MaHang=${s.code}">${s.code}</a></td>
                            <td><a href="ChitietsanphamController?MaHang=${s.code}">${s.name}</a></td>
                            <td>${s.unit}</td>
                            <td>${s.price}</td>
                            <td>${s.image}</td>
                            <td>
                                <a href="DathangController?MaHang=${s.code}">Mua hang</a>
                            </td>
                            <c:url var="buy" value="GiohangController">
                                <c:param name="mahang" value="${s.code}"></c:param>
                                <c:param name="tenhang" value="${s.name}"></c:param>
                                <c:param name="gia" value="${s.price}"></c:param>
                                <c:param name="action" value="add"></c:param>
                            </c:url>
                            <td>
                                <a href="${buy}">Them vao gio hang</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <br>
            <input type="text" name="timkiem">
            <input type="submit" name="search" value="Tim kiem">
            <br><br><br>
            <c:if test="${not empty lstpro}">
                <table border="1">
                    <tr>
                        <td>Ma hang</td>
                        <td>Ten hang</td>
                        <td>DVT</td>
                        <td>Gia (USD)</td>
                        <td>Hinh anh</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach var="s" items="${lstpro}">
                        <tr>
                            <td><a href="ChitietsanphamController?MaHang=${s.code}">${s.code}</a></td>
                            <td><a href="ChitietsanphamController?MaHang=${s.code}">${s.name}</a></td>
                            <td>${s.unit}</td>
                            <td>${s.price}</td>
                            <td>${s.image}</td>
                            <td>
                                <a href="DathangController?MaHang=${s.code}">Mua hang</a>
                            </td>
                            <c:url var="buy" value="GiohangController">
                                <c:param name="mahang" value="${s.code}"></c:param>
                                <c:param name="tenhang" value="${s.name}"></c:param>
                                <c:param name="gia" value="${s.price}"></c:param>
                                <c:param name="action" value="add"></c:param>
                            </c:url>
                            <td>
                                <a href="${buy}">Them vao gio hang</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            <br><br><br>
            <a href="Dangnhap.jsp">Dang nhap</a><br>
            <a href="Themkhachhang.jsp">Dang ki khach hang moi</a><br>
            <a href="Giohang.jsp">Gio hang</a><br>
            <a href="Trangchu.jsp">Trang chu</a>
        </form>
    </body>
</html>
