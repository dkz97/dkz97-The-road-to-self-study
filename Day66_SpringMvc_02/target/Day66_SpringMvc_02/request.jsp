<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request</title>

<%--  配置js文件  --%>
    <script src="js/jquery.min.js"></script>

    <script>
        <%--首先要让页面加载完毕，然后加载完毕后，设置button，点击就发送--%>
        $(function () {
            $("#btn").click(function () {
                // 点击后进行要做的事情
                // $.ajax 开启发送ajax请求，需要配置多个头文件
                $.ajax({
                    url:"user/testResponseJson", // 发送地址
                    contentType:"application/json;charset=UTF-8", // 发送消息类型
                    data:'{"username":"张三","password":"123","age":"20"}', // 发送的请求体，为json数据
                    dataType:"json", // 接收的请求数据类型
                    type:"post", // 请求方法
                    // 成功后的回调函数
                    success:function (data) {
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                        alert("回调函数成功");
                    }
                });
            });
        });

    </script>
</head>
<body>

<%--  主要是用来测试发送ajax请求发送Json数据，然后响应体也是返回json数据，  --%>


    <input type="button" value="测试ajax请求，发送json数据" id="btn">
</body>
</html>
