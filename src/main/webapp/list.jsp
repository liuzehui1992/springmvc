<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/29
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试list</title>
</head>
<body>

        <form action="list" method="post">
            <input name="addressList[0].number" value="001" /><br>
            <input name="addressList[0].street" value="xx街道" /><br>
            <input name="addressList[1].number" value="002" /><br>
            <input name="addressList[1].street" value="xx路口" /><br>
            <input type="submit" value="Save" />
        </form>

</body>
</html>
