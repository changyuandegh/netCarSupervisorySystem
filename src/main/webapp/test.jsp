<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/6/10
  Time: 12:18
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no,width=device-width"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="vendor/layui/css/layui.css">
    <script src="js/jquery-2.1.4.js"></script>
    <!--<link rel="stylesheet" href="">-->
    <script src="vendor/layui/layui.js"></script>
    <title>Title</title>
</head>
<body>
<div id="" >
    <button onclick="my.show('中华英雄')">点击</button>
    <button onclick=" alert(my.timestampToShowTime(1403058804000))">点击</button>
    <button id="showtime">showtime</button>
    <div style="width:100%;height:500px;background-color:white">
        <div class="layui-tab" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this">网站设置</li>
                <li>用户基本管理</li>
                <li>权限分配</li>
                <li>全部历史商品管理文字长一点试试</li>
                <li>订单管理</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">1</div>
                <div class="layui-tab-item">2</div>
                <div class="layui-tab-item">3</div>
                <div class="layui-tab-item">4</div>
                <div class="layui-tab-item">5</div>
                <div class="layui-tab-item">6</div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element();
        var url='';
        var socket=new Socket(url);
        socket.open();
        $("i").click(function(){
            console.time();
            alert();
            console.timeEnd();


        });
    });

    $("#showtime").click(function(e){
        console.log("time=="+e.timeStamp);
        alert($(e.target).text());
    });


</script>
</html>
