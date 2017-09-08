<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/4/25
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name=”renderer” content=”webkit” />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no,width=device-width"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <title></title>
    <script type="text/javascript">
        function ckload() {
            if (window.applicationCache) {
                window.location.href = "user/login";
            }
        }
        ckload();

    </script>

</head>
<body oncontextmenu="return false" onselectstart="return false">

<%--<div id="context">--%>

<%--</div>--%>
<%--<div>--%>
    <%--<button onclick="my.show('指定弹出内容')" >弹出</button>--%>
    <%--<button onclick="my.hide()" >隐藏</button>--%>
<%--</div>--%>

<div id="trip" style="width:100%;height:100%;padding-top:100px;padding-left:200px;">
    <div>
        <label style="color:blue;font-size:30px;">您的浏览器版本过低,请升级您的浏览器！</label>
        <label style="color:red;font-size:18px;"></label>
    </div>
</div>
</body>
<script>

    //my.show();
</script>
</html>
