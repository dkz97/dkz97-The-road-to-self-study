<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="account/demo01" >测试SpringMvc配置</a><br/>
<a href="account/ssm" >测试SpringMvc配置</a>


    <h3>测试银行转行案例</h3><br/>

    <form method="post" action="account/transfer">
        输入账号1:<input type="text" name="name1"><br/>
        输入账号2:<input type="text" name="name2"><br/>
        输入金额:<input type="text" name="money"><br/>
        <input type="submit" value="提交"><br/>
    </form>
</body>
</html>
