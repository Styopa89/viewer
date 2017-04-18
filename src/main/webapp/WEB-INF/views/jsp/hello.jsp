<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="java.sql.*,servlet.ConnectionManeger"%>--%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="title.dbPage" /></title>
</head>
<body>
<h1><fmt:message key="label.dbWellcome" /></h1>

<form action="ServiseLayer" method="POST">
    <table border="0">
        <tbody>
        <tr>
            <td> <b><fmt:message key="label.firstName" /></b></td>
            <td> <input type="text" name="firstName"  size="20" /><br></td>
        </tr>
        <tr>
            <td><b><fmt:message key="label.lastName" /></b></td>
            <td>  <input type="text" name="lastName"  size="20" /></td>
        </tr>
        <tr>
            <td><b><fmt:message key="label.sex" /></b></td>
            <td>  <select name="sex">
                <option>Man</option>
                <option>Woman</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>  <input type="submit" value= <fmt:message key="button.submit" /> /></td>
            <td>  <a href="Controller"><input type="button" value=<fmt:message key="button.back" /> /></a> </td>
        </tr>

    </table>
</form>

</body>
</html>