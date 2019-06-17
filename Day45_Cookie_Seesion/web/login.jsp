<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-06-17
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <style>
        div{
            padding-top: 10px;
            margin-left: 5px;
        }

        #img{
            padding-top: 5px;
            padding-left: 10px;
        }

    </style>

</head>
<body>



    <form action="/day45/login" method="post">
        <div>用户名<input type="text" name="username"></div>
        <div>密码<input type="text" name="password"></div>
        <div>验证码<input type="text" name="authCode"></div>
        <img id="img" src="/day45/code">
        <a id="a_img" href="#">点击更新</a>

        <br>
        <input type="submit" name="admit">
    </form>

    <script>
        // 获取图片和超链接的对象
        var img = document.getElementById("img");
        var a_img = document.getElementById("a_img");
        // 定义单击事件的函数
        var img_update = function() {
            // 通过时间戳来确定不一样的时间
            var date = new Date().getTime();

            img.src = "/day45/code?"+date;
        };

        //给超链接和图片都增加onclick时间
        img.onclick = img_update;

        a_img.onclick = img_update;
    </script>
</body>
</html>
