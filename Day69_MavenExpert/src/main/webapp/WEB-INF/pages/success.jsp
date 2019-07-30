<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>测试成功</h3><br/>
    <table >
        <tr>
            <td>id</td>
            <td>名称</td>
            <td>定价</td>
            <td>创建时间</td>
            <td>信息</td>
        </tr>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.createtime}</td>
            <td>${item.detail}</td>
        </tr>
    </table>

</body>
</html>
