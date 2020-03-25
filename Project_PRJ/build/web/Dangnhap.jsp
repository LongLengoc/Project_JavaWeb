<%-- 
    Document   : Dangnhap
    Created on : Mar 14, 2020, 11:12:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dang nhap</title>
    </head>
    <body>
        <h1>Dang nhap</h1>
        <form action="DangnhapController" method="GET">
            <c:if test="${not empty Loginfail}">
                <h3 style="color: red;">${Loginfail}</h3>
            </c:if>
            <c:if test="${not empty AccessDenied}">
                <h3 style="color: red;">${AccessDenied}</h3>
            </c:if>
            <table>
                <tr>
                    <td>Ten dang nhap</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Mat khau</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="login" value="Dang nhap"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
