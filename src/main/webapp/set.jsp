<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/29
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set绑定数据</title>
</head>
<body>
<form action="set" method="post">
    <input name="addressSet[0].number" value="003" /><br>
    <input name="addressSet[0].street" value="xx街道" /><br>
    <input name="addressSet[1].number" value="004" /><br>
    <input name="addressSet[1].street" value="xx路口" /><br>
    <input name="addressSet[2].number" value="005" /><br>
    <input name="addressSet[2].street" value="xx巷子" /><br>
    <input type="submit" value="Save" />
</form>

</body>
</html>
