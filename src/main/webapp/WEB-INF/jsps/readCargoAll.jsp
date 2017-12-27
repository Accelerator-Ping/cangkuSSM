<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/12/6
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好，管理员${requestScope.person.name}
    </title>
</head>
<body style="background-image: url('/img/6.jpg');">
<form  >
    货物列表：
    <table width="100%" border=1>
        <tr>
            <td>货物名</td>
            <td>类型</td>
            <td>数量</td>
            <td>    </td>
            <td>    </td>
        </tr>
        <c:forEach items="${cargoList}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.type}</td>
                <td>${item.num}</td>
                <td><a href="deleteCargo/${item.name}">删除</a></td>
                <td><a href="turing/${item.name}">修改</a> </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><a href="turning2">添加货物</a></td>
            <td colspan="2"><a href="findByName">查询记录</a> </td>
            <td colspan="2"><a href="turning4">修改密码</a> </td>
        </tr>
    </table>
</form>
</body>
</html>
