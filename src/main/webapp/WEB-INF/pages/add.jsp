<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加...</title>
</head>
<body>

<form action="save" method="post">
    <table>
        <tr>
            <td>NAME</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>IDNO</td>
            <td><input type="text" name="idNo"></td>
        </tr>
        <tr>
            <td>BOOK</td>
            <td><select name="book.id" id="id">
                <option value="">请选择</option>
                </option>
                <c:forEach items="${books}" var="book">
                    <option value="${book.id}">${book.name}</option>
                    </option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="保存"></td>
        </tr>
    </table>
</form>
</body>
</html>
