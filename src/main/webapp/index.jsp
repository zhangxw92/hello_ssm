<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Hello World!</h2>


<a href="getBlog">查询Blog</a>

<a href="login?username=admin&password=123456">登陆</a>

<%--<form action="testpost" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="测试DELETE">
</form>

<form action="testpost" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="测试put">
</form>--%>

<form action="submit" method="POST">
    <%--
        姓名：<input type="text" name="name"/>
    --%>
    密码：<input type="text" name="password"/>
    <input type="submit" value="提交">
</form>

<a href="testget/101">测试get</a>
</body>
</html>
