<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/29
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>测试绑定json</title>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
          $("#btn").click(function(){
               $.ajax({
                   url:"json.do",
                   type:"POST",
                   dataType:"json",
                   contentType: "application/json;charset=UTF-8",
                   data:JSON.stringify({username:$("#userName").val(),gender:$("#gender").val()}),
                   success: function () {
                       alert("ok");
                   },
                    error:function(e){
                        alert(e);
                    }
               });
           }) ;

        });

    </script>
</head>
<body>


<form>
    姓名：<input type="text" name="userName" id="userName">
    性别：<input type="text" name="gender" id="gender">
</form>
<button id="btn">按钮</button>

</body>
</html>
