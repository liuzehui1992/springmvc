<%--
  Created by IntelliJ IDEA.
  User: liuzehui
  Date: 2016/6/30
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form-json</title>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                 url:"form",
                    type:"POST",
                    data:$("#form").serialize(),
                    success:function(){
                        alert("ok")
                    },
                    error:function(e){
                        alert(e)
                    }
                });
               // alert($("#form").serialize());
            })
        });

    </script>
</head>
<body>

<form id="form">
    姓名： <input type="text" name="username"><br>
    性别： <input type="text" name="gender"><br>
    <button id="btn">按钮</button>
</form>

</body>
</html>
