<%-- ＜%@ page isELIgnored＝"true|false"%＞
如果设定为真，那么JSP中的表达式被当成字符串处理。
比如下面这个表达式${2000 % 20}, 在isELIgnored＝"true"时输出为${2000 % 20}，
而isELIgnored＝"false"时输出为100。
Web容器默认isELIgnored＝"false"。--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>登陆成功</h3>
<%--使用el表达式取值--%>
姓名：<input type="text" value=${username}>

<br>
${username }
</body>
</html>
