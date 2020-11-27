<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <th>SEX</th>
        <th>OPERATION(<a href="add">ADD</a>)</th>
    </tr>

    <c:forEach items="${blogs}" var="blog">
        <tr>
            <td>${blog.id}</td>
            <td>${blog.name}</td>
            <td>${blog.idNo}</td>
            <td>${blog.sex==0?'女':'男'}</td>
            <td>
                <a href="update/${blog.id}">UPDATE</a>
                <a href="delete/${blog.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
