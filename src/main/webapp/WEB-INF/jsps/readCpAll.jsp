<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="lhp.pojo.C_P" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查阅操作记录</title>
</head>
<body style="background-image: url('/img/6.jpg');">
<form  >
    操作记录列表：
    <table width="100%" border=1>
        <tr>
            <td>姓名</td>
            <td>操作</td>
            <td>货物名</td>
            <td>数量</td>
            <td></td>
        </tr>
        <c:forEach items="${cpAllList}" var="item">
            <tr>
                <td>${item.userName}</td>
                <td>${item.operation}</td>
                <td>${item.cargoName}</td>
                <td>${item.number }</td>
                <td><a href="deleteCp?userName=${item.userName}&&cargoName=${item.cargoName}&&operation=${item.operation}&&number=${item.number}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
