<%@ page import="Case_Demo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 在request域中有一个存User对象的List集合，使用jstl+el将list集合数据展示到jsp页面表格table中 -->
<html>
<head>
    <title>CaseDemo</title>
</head>
<body>

    <%-- 先创建User对象和加入到list集合中，然后把list集合放到request域中 --%>
    <%
        User zhangsan_user = new User(1,"zhangsan","123456");
        User lisi_user = new User(2,"lisi","654321");
        User wangwu_user = new User(3,"wangwu","1234");

        ArrayList<User> list = new ArrayList<>();
        list.add(zhangsan_user);
        list.add(lisi_user);
        list.add(wangwu_user);


        request.setAttribute("list",list);
    %>

    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>
        </tr>


        <c:forEach items="${list}" var="user" varStatus="s">
            <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="red">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
            </c:if>

            <c:if test="${s.count % 2 != 0}">
                <tr bgcolor="orange">
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                </tr>
            </c:if>

        </c:forEach>

    </table>
</body>
</html>
