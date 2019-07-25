<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--文件上传的案例
        1.method 需要是post
        2.enctype 需要是multipart/form-data --%>
    <form method="post" action="/file/upload" enctype="multipart/form-data">
        <input type="file" value="文件上传" name="upload"> <br/>
        <input type="submit" value="提交">
    </form>


    <form method="post" action="/file/springmvcupload" enctype="multipart/form-data">
        基于SpringMvc文件上传<input type="file" name="upload"> <br/>
        <input type="submit" value="上传">
    </form>


    <form method="post" action="/file/uploadServer" enctype="multipart/form-data">
        文件上传到别的服务器<input type="file" name="upload"> <br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
