<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/11/24
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新货物</title>
</head>
<body style="background-image: url('./res/5.jpg');">
<%

    String  s= (String) request.getAttribute("name");
    request.getSession(true).setAttribute("cargoname",s);
%>
<form action="/upDateCargo1" method="post">
    <tr>
        <td>您要更改的是:<%=request.getAttribute("name")%></td>
    </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <td>数量</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="确定"></td>
        </tr>
    </table>
</form>
</body>
</html>
