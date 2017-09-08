<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script  src="<%=basePath%>js/jquery-2.1.4.js"></script>
    <!--<link rel="stylesheet" href="">-->
    <!--<script src=""></script>-->
    <style type="text/css">
       html,body{
            height: 100%;
            width: 100%;
            margin: 0;
           font-style: normal;
           font-family: Palatino;
            background-image: url("pic/login/lg_bg.png");
           background-position: center;
           background-repeat: no-repeat;
            text-align: center;
        }
.head_logo{
    text-align: left;
    width:100%;
    height: 64px;
    font-size:30px;
    color: white;
}
        .left{
            height: 100%;
            width:15%;
            float: left;
            margin: 0;
        }

        .center{
            height: 100%;
            width:70%;
            float: left;

        }

        .right{

            float: left;
            height: 100%;
            width: 15%;
        }
        .center_left{
            margin-top:100px;
            width:50%;
            height: 420px;
            float: left;
            /*border-bottom: 30px #CCC solid;*/
        }
       .center_right{
           margin-top:100px;
           width:50%;
           height: 420px;
           /*border-bottom: 30px #CCC solid;*/
           float: left;
       }
       .div_from{
           background-color:white;
           border-radius: 5px;
           width:370px;
           height: 360px;
           text-align: center;
       }

        .input_text_name{
            padding-left:5px;
            width: 300px;
            height: 40px;
            font-size:14px;
            border-radius:3px 3px 0px 0px;
            border: 0.2px #CCC solid;
            border-bottom: none;
            color:#354052;
        }
       .input_text_pass{
           padding-left:5px;
           width: 300px;
           height: 40px;
           font-size:14px;
           border-radius:0px 0px 3px 3px;
           border: 0.2px #CCC solid;
           color:#354052;
       }

       .submit{
           width: 300px;
           height: 40px;
           font-size:20px;
           border-radius:2px;
           background-color:#1A91EB;
           color: white;
           border:none;
       }


    </style>
    <title><c:out value="${applicationScope.get('webTitle')}"/></title>
</head>
<body >
<div class="left">
    <div style="float:right;height:100%;width:30px;"></div>
</div>
<%--center--%>
<div class="center">
    <div style="height:100%;width: 100%;">
        <%--<div class="head_logo"><div><img src="pic/login/login_logo.png" style="vertical-align: bottom ;"/>&nbsp;${webTitle}</div></div>--%>
    <div class="center_left">
        <div style="float: left;padding-top: 100px;">
        <img src="pic/login/lg_left.png" width="500" height="360"/>
        </div>
    </div>
    <div class="center_right">
        <div style="float:right;padding-top: 100px;">
            <div class="div_from" style="">
                <form action="user/dologin" method="post">
                <div style="width:100px;height:30px;"></div>
                <div class="fontlogin"><label style="font-size:24px;color:#354052">登&nbsp;录</label></div>
                <div style="height:30px;width:300px;"><div id="trip_mess" style="padding-left:30px;text-align:left;display:none;"><img src="pic/login/form_alert.png" style="vertical-align: text-bottom;"/><span id="trip_value">${reg}</span></div></div>
                <div>
                    <input name="name" type="text" required="required" class="input_text_name" placeholder="&nbsp;&nbsp;帐&nbsp;号">
                    <input name="pass" type="password" required="required" class="input_text_pass" placeholder="&nbsp;&nbsp;密&nbsp;码">
                </div>
                <div style="margin-top:30px;"><input class="submit" type="submit" value="登录"></div>
                </form>
            </div>
        </div>
    </div>
    </div>
</div>
</body>
<script type="text/javascript">
var mess= $("#trip_value").text();
    if(mess.length!=0&&mess!=''){
       $("#trip_mess").show();
    }else{
        $("#trip_mess").hide();
    }
</script>
</html>
