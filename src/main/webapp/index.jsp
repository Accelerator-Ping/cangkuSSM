<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


<html>
<head>
    <title>Welcome</title>
</head>

<body style="background-image: url('/img/2.jpg');">
<form action="login_check" method="post">
    <table width="202" border="0" align="center" cellpadding="05" cellspacing="0" id="logintable">
        <tr >
            <td colspan="2" width="192"><div class="message">登录</div></td>
        </tr>
        <tr>
            <td colspan="2" ><input  name="name" type="text" id="name" value="" placeholder="用户名"></td>
        </tr>
        <tr>
            <td colspan="2" ><input  name="password" type="password" id="password" value="" placeholder="密码"></td>
        </tr>
        <tr>
            <td colspan="2">
                <select name="identity">
                    <option value="管理员">管理员</option>
                    <option value="老板">老板</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>