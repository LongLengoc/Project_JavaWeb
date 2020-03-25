<%-- 
    Document   : Dangkitaikhoan
    Created on : Mar 8, 2020, 12:25:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dang ki tai khoan</title>
    </head>
    <body>
        <h1>Dang ki tai khoan</h1>
        <form action="UserController" method="GET">
            <table border="1">
                <tr>
                    <td>Account</td>
                    <td><input type="text" name="account"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="gender" value="Male"/> Male
                        <input type="radio" name="gender" value="Female"/> Female
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td><input type="text" name="dob"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="dangki" value="Dang ki"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
            
            <input type="submit" name="show" value="Hien">
            <c:if test="${not empty lstUser}">
                <table border="1">
                    <tr>
                        <td>Account</td>
                        <td>Password</td>
                        <td>Name</td>
                        <td>Gender</td>
                        <td>Address</td>
                        <td>DOB</td>
                    </tr>
                    <c:forEach var="s" items="${lstUser}">
                        <tr>
                            <td>${s.account}</td>
                            <td>${s.getPass()}</td>
                            <td>${s.getName()}</td>
                            <td>${s.getGender()}</td>
                            <td>${s.getAddress()}</td>
                            <td>${ss.getDOB()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <br>
            <a href="Trangchu.jsp">Trang chu</a>
        </form>
    </body>
</html>
