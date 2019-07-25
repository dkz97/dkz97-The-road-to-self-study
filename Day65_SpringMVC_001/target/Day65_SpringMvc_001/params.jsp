<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--测试整数类型的请求参数--%>
    <a href="/params/int?number=10">基本测试</a>

    <%-- 请求参数绑定demo--%>
    <form method="post" action="/params/account">
        账户:<input type="text" name="username"> <br/>
        密码:<input type="text" name="password"> <br/>
        资金:<input type="text" name="money">  <br/>
        <input type="submit" value="提交">
    </form>

    <%--给内部类也传入数值--%>
    <form method="post" action="/params/account">
        账户:<input type="text" name="username"> <br/>
        密码:<input type="text" name="password"> <br/>
        资金:<input type="text" name="money">  <br/>
        用户名称:<input type="text" name="user.uname"> <br/>
        用户年龄:<input type="text" name="user.age"> <br/>
        <input type="submit" value="提交">
    </form>

    <%--给类中中的列表和map也进行传值--%>
    <form method="post" action="/params/account">
        账户:<input type="text" name="username"> <br/>
        密码:<input type="text" name="password"> <br/>
        资金:<input type="text" name="money">  <br/>

        用户名称:<input type="text" name="users[0].uname"> <br/>
        用户年龄:<input type="text" name="users[0].age"> <br/>

        用户名称:<input type="text" name="userHashMap['user1'].uname"> <br/>
        用户年龄:<input type="text" name="userHashMap['user1'].age"> <br/>
        <input type="submit" value="提交">
    </form>


<%--    测试各种注解--%>
    <a href="/params/requestParam?uname=zhangsan"> 测试requestParam注解</a>

    <a href="/params/modelAttribute?uname=zhangsan">测试ModelAttribute注解</a>

<%--测试sessionAttribute注解--%>
    <a href="/params/modeladd">加入参数</a>
    <a href="/params/getattr">获得参数</a>
    <a href="/params/clear">删除参数</a>
</body>
</html>
