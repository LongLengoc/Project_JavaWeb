<%-- 
    Document   : Themkhachhang
    Created on : Mar 8, 2020, 1:00:01 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dang ki khach hang</title>
    </head>
    <body>
        <h1>Dang ki khach hang</h1>
        <form action="AddKhachHangController" method="GET">
            <table border="1">
                <tr>
                    <td>Ma khach hang</td>
                    <td><input type="text" name="Makh"></td>
                </tr>
                <tr>
                    <td>Ten khach hang</td>
                    <td><input type="text" name="Tenkh"></td>
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
                    <td><input type="text" name="Diachi"></td>
                </tr>
                <tr>
                    <td>Ngay sinh</td>
                    <td><input type="text" name="Ngaysinh"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="tao" value="Tao khach hang"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
            <br>
            <a href="Muahang.jsp">Mua hang</a>
        </form>
    </body>
</html>
