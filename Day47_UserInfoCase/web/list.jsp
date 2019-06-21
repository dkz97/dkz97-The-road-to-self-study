<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }


        #a_row {
            float: right;
            padding-right: 20px;
            padding-top: 8px;
        }
    </style>

    <script>
        // 删除按钮的判断提示
        function deleteUser(id) {
            if (confirm("您确定要删除吗")){
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id="+id;
            }
        }

        // 等页面加载完成后再执行代码
        window.onload = function() {
            // 获取第一个按钮的对象，然后设置单击事件，让一点就下面的按钮跟着一起
            var firstck = document.getElementById("firstck");


            // 获取删除选中的对象，绑定单击事件
            var delSelect = document.getElementById("delSelect");
            delSelect.onclick = function() {
                var uids = document.getElementsByName("uid");
                var falg = false;
                for (var i = 0; i<uids.length;i++) {
                    if (uids[i].checked) {
                        falg = true;
                        break;
                    }
                }
                if (falg) {
                    if (confirm("您确定要删除吗")) {
                        // 获取表单对象
                        var form = document.getElementById("form");
                        // 提交表单
                        form.submit();
                    }
                } else {
                    alert("请先选中")
                }
            };

            firstck.onclick = function() {
              var uids = document.getElementsByName("uid");
              for (var i = 0; i<uids.length;i++) {
                  uids[i].checked = this.checked;
              }
            };
        }


    </script>
</head>
<body>
<div class="container">


    <h3 style="text-align: center">用户信息列表</h3>



    <div class="row" >

        <div>
            <form class="navbar-form navbar-left" role="search" method="post" action="${pageContext.request.contextPath}/pageServlet?currentPage=1&rows=5">
                <div class="form-group">
                    <label for="name1">姓名</label>
                    <input type="text" class="form-control" value="${condition.name[0]}" id="name1" name="name" placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="address1">籍贯</label>
                    <input type="text" class="form-control" value="${condition.address[0]}" id="address1" name="address" placeholder="请输入籍贯">
                </div>
                <div class="form-group">
                    <label for="email1">邮箱</label>
                    <input type="text" class="form-control" value="${condition.email[0]}" id="email1" name="email" placeholder="请输入邮箱">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>

        <div  id="a_row">
            <a class="btn btn-primary" href="add.jsp">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="delSelect">删除选中</a>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/delSelectServlet" method="post" id="form" >
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th id="check"><input type="checkbox" id="firstck"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${page.list}" var="user" varStatus="s">
            <tr>
                <th><input type="checkbox" name="uid" value="${user.id}" ></th>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm"  href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${page.currentPage == 1}">
                    <li class="disabled">
                </c:if>
                    <c:if test="${page.currentPage != 1}">
                            <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${page.currentPage - 1}&rows=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" var="i" end="${page.totalPage}">
                    <c:if test="${page.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/pageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.eamil[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/pageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.eamil[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                    <c:if test="${page.currentPage == page.totalPage}">
                        <li class="disable">
                    </c:if>
                        <c:if test="${page.currentPage != page.totalPage}">
                        <li >
                    </c:if>

                    <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${page.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.eamil[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 27px;margin-left:5px;">
                    共${page.totalCount}条数据，共${page.totalPage}页

                </span>
            </ul>
        </nav>
    </div>

</div>
</body>
</html>
