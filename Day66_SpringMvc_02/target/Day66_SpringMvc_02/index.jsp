<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="/user/testString" >测试返回值为String</a> <br/>
    <a href="/user/testVoid">测试返回值为Void</a> <br/>
    <a href="/user/testModelAndView">测试返回值为ModelAndView</a><br/>
    <a href="/user/testForwardAndRedirect">测试SpringMvc的转发和重定向</a><br/>

    <a href="/user/testError" >模拟异常</a> <br/>

    <a href="/user/testInterceptor" > 模拟拦截器</a>

</body>
</html>
