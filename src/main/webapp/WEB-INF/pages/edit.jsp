<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加...</title>
</head>
<body>

<form action="/blog/updateSave" method="post">
    <table>
        <input type="hidden" name="id" value="${blog.id}">
        <tr>
            <td>NAME</td>
            <td><input type="text" name="name" value="${blog.name}"></td>
        </tr>
        <tr>
            <td>IDNO</td>
            <td><input type="text" name="idNo" value="${blog.idNo}"></td>
        </tr>
        <tr>
            <td>SEX</td>
            <%--回显方式一--%>
            <%--            <td><input type="radio" name="sex" value=0 ${blog.sex==0?'checked':''}>女
                            <input type="radio" name="sex" value=1 ${blog.sex==1?'checked':''}>男
                        </td>--%>
            <%--回显方式二--%>
            <td><input type="radio" name="sex" value=0 <c:if test="${blog.sex==0}">checked="checked"</c:if>>女
                <input type="radio" name="sex" value=1 <c:if test="${blog.sex==1}">checked="checked"</c:if>>男
            </td>
        </tr>
        <tr>
            <td>BOOK</td>
            <td><select name="bookId" id="bookId">
                <option value="">请选择</option>
                </option>
                <c:forEach items="${books}" var="book">
                    <%--回显--%>
                    <option value="${book.id}" ${blog.bookId == book.id?'selected':''}>${book.name}</option>
                    </option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
