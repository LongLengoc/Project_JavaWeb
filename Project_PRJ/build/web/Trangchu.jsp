<%-- 
    Document   : Home
    Created on : Mar 8, 2020, 9:16:58 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <h1>Home page</h1>
        <c:if test="${not empty CreateUserSuccess}">
            <h3 style="color: brown;">${CreateUserSuccess}</h3>
        </c:if>
        <c:if test="${not empty Loginsuccess}">
            <h3 style="color: brown;">${Loginsuccess}</h3>
        </c:if>
        <c:if test="${not empty CreateUserFail}">
            <h3 style="color: brown;">${CreateUserFail}</h3>
        </c:if>
        <c:if test="${not empty CreateKhSuccess}">
            <h3 style="color: brown;">${CreateKhSuccess}</h3>
        </c:if>
        <c:if test="${not empty UpdateKHSuccess}">
            <h3 style="color: brown;">${UpdateKHSuccess}</h3>
        </c:if>
        <c:if test="${not empty DeleteKHSuccess}">
            <h3 style="color: brown;">${DeleteKHSuccess}</h3>
        </c:if>

        <a href="Themkhachhang.jsp">Them khach hang moi</a><br>
        <a href="Hienthikhachhang.jsp">Hien thi khach hang</a><br>
        <a href="Dangkitaikhoan.jsp">Dang ki tai khoan</a><br>
        <a href="Muahang.jsp">Mua hang</a><br>
        <a href="Themsanpham.jsp">Them san pham</a>

    </body>
</html>
