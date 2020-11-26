<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>IDNO</th>
    </tr>

    <c:forEach items="${blogs}" var="blog">
        <tr>
            <td>${blog.id}</td>
            <td>${blog.name}</td>
            <td>${blog.idNo}</td>
            <td>
                <a href="">UPDATE</a>
                <a href="">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
