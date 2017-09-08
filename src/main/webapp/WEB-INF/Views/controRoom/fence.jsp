<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/5/11
  Time: 09:49
  电子围栏
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
</head>
<body>
<div style="position:relative;">
<div id="fence-map"></div>
<%--<div class="indexmap-set" style="bottom:10px;">
    <div>
        <div class="indexmap-blow"><img src="./pic/index/add.png"></div>
        <div class="indexmap-shrink"><img src="./pic/index/jian.png" style="margin-top:8px;"></div>
    </div>
    <div class="indexmap-getlocation" style="margin-top:0px;"><img src="./pic/index/point.png"></div>
</div>--%>
<div id="fence-set">
    <div>
        <div id="fence-add">
            <img src="./pic/fence/new_fence.png">&nbsp;新增
        </div>
        <div id="fence-search">
            <img src="./pic/fence/search_fence_dis.png">&nbsp;搜索
        </div>
        <img id="fence-shrink" shrink='' src="./pic/fence/fold_up.png">
    </div>
    <div id="fence-append-2" style="display:none">
        <div id="fence-list">
            <select id="fence_selectType" class="selectStyle" style="height:28px;">
                <option value="2">重点区域</option>
                <option value="1">禁入区域</option>
                <option value="0">禁出区域</option>
            </select>
            <select id="fence_selectShape" class="selectStyle" style="height:28px;">
                <option value="0">圆形</option>
                <option value="1">多边形</option>
            </select>
            <input id="fence_searchName" type="text" style="height:25px;width:142px;line-height:15px;"  placeholder="围栏名称">
            <input id="fence_fenceSearch" type="button" style="background-color: #1A91EB;color:white;height:22px;border-radius:4px;border:none;font-style:normal;font-family:inherit;font-size:12px;width:43px;text-align:center;line-height:15px;" value="查&nbsp;询"/>
        </div>
        <div id="fence-all-content">
            <%--<div class="fence-content" type='多边形' points='[{"lng":116.420026,"lat":39.917822},{"lng":116.419163,"lat":39.908137},{"lng":116.411689,"lat":39.909853},{"lng":116.413702,"lat":39.920257},{"lng":116.421463,"lat":39.919483}]'>--%>
                <%--<div class="fence-tit">郑州火车站方圆1公里</div>--%>
                <%--<div><p class="fence-area">重点区域</p><p>多边形</p>--%>
                    <%--<p class="fence-time">2015/05/01～2015/05/05</p>--%>
                <%--</div>--%>
                <%--<img src="./pic/fence/edit.png" class="fence-do-edit">--%>
                <%--<img src="./pic/fence/delete.png" class="fence-do-delete">--%>
            <%--</div>
            <div class="fence-content" type="圆形" points='{"lng":116.416073,"lat":39.918099}/513.2092691553561'>
            <div class="fence-tit">郑州火车站方圆2公里</div>
            <div><p class="fence-area">重点区域</p><p>圆形</p><p class="fence-time">2015/05/01～2015/05/05</p></div>
            <img src="./pic/fence/edit.png" class="fence-do-edit">
            <img src="./pic/fence/delete.png" class="fence-do-delete">
        </div>--%>
            <p class="clear"></p>
        </div>
        <ul class="page" maxshowpageitem="3" pagelistcount="5" id="page"></ul>
        <%--maxshowpageitem="5" pagelistcount="10" --%>
        <%--<center id="fence-page">--%>
            <%--<div>首页</div>--%>
            <%--<div>上一页</div>--%>
            <%--<div>1</div>--%>
            <%--<div class="now-page">2</div>--%>
            <%--<div>3</div>--%>
            <%--<div>4</div>--%>
            <%--<div>下一页</div>--%>
        <%--</center>--%>
    </div>
    <div id="fence-append-1">
        <div class="fence-add-list">
            围栏类型：<select class="selectStyle">
            <option value="2">重点区域</option>
            <option value="0">禁出</option>
            <option value="1">禁入</option>
        </select>
        </div>
        <div class="fence-add-list">
            围栏名称：<input id="fence-name" type="text" placeholder="输入围栏名称"><span id="fence-notice"><img src="./pic/popup-window/form_alert.png">请输入名称</span>
        </div>
        <div class="fence-add-list fence-date">
            有效期：&nbsp;&nbsp;&nbsp; <input  class="layui-input" placeholder="开始日期" id="fence_addSDate"> -
            <input class="layui-input"  placeholder="结束日期" id="fence_addEDate"><span id="fence-time-notice"><img src="./pic/popup-window/form_alert.png">日期不能为空</span>
        </div>
        <div id="fence-clear">清空地图</div>
        <div id="fence-save">保存</div>
    </div>
</div>
<div id="fence-edit">
    <div>编辑围栏 <div class="fence-close">X</div></div>
    <div class="fence-add-list">
        围栏类型：<select id="fence_type" class="selectStyle" readonly="readonly">
        <option value="0">禁入区域</option>
        <option value="1">进入区域</option>
        <option value="2">重点区域</option>
    </select>
    </div>
    <div class="fence-add-list">
        围栏名称：<input id="fence-edit-name" type="text" placeholder="输入围栏名称">
    </div>
    <div class="fence-add-list fence-date">
        有效期：&nbsp;&nbsp;&nbsp; <input  class="layui-input"  id="fence-edit-s"> -
        <input class="layui-input"  id="fence-edit-e">
    </div>
    <div id="fence-over">完成</div>
    <div id="fence-cancel">取消</div>
</div>
<div id="fence_window-sure" style="display:none;position:fixed;top:40%;margin-left:30%;width:260px;height:248px;background: #fff;z-index:99;overflow:hide;border-radius:5px;padding-top: 30px;">
<center><img src="./pic/popup-window/window-notice.png">
<p>确定删除?</p>
<p>此操作不可逆</p>
</center>
<center id="fence-sure-bottom">
<div>确认</div>
<div>取消</div>
</center>
<div class="window-close" onclick="$(this).parent().hide();"><img src="./pic/tab_close.png"></div>
</div>
</div>
<script type="text/javascript" src="js/controRoom/fence.js"></script>
<script type="text/javascript">
    //========================================
    var xuan = $(window).height();
    //判断360浏览器
    var screenWidth = $(window).width();
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        if(screenWidth > 1400){
            var he=xuan-61;
            $('#fence-map').css('height',he);
        }else{
            var he1=xuan-38-55;
            $('#fence-map').css('height',he1);
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
            var he2=xuan-38-106;
            $('#fence-map').css('height',he2);
    }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
            var he3=xuan-38-100;
            $('#fence-map').css('height',he3);
    }


</script>
</body>
</html>
