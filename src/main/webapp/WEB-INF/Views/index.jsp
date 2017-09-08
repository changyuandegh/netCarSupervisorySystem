<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String wsUrl="ws://"+request.getServerName() + ":" + request.getServerPort()+"/webSocketServer";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name=”renderer” content=”webkit” />
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no,width=device-width"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <title>${webTitle}</title>
    <link rel="stylesheet" href="vendor/layui/css/layui.css" type="text/css" media="all">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="vendor/bootstrap_table/bootstrap.min.css" type="text/css" media="all">
    <%--绘制电子围栏--%>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />

    <link rel="stylesheet" href="vendor/bootstrap_table/bootstrap-table.min.css" type="text/css" media="all">
    <link rel="stylesheet" href="vendor/bootstrap_table/bootstrap-table.min.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/base.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/market.css" type="text/css" media="all">
    <%--<link rel="stylesheet" href="vendor/need/laydate.css">--%>
    <%--分页插件--%>
    <link rel="stylesheet" href="vendor/page/page.css">
    <!-- 手风琴样式 -->
    <link rel="stylesheet" href="css/menu-list-style.css" type="text/css" media="all">
    <!-- 环形进度条 -->
    <link rel="stylesheet" href="css/gaugeMeter.css" type="text/css" media="all">

    <link rel="stylesheet" href="css/pop-window.css"type="text/css" media="all">

    <style>
    <%--报警标题头样式--%>
    .index-alarmWindow .layui-layer-title{background:#fdf5f4; color:#f36654; border: none;font-size:16px;}
        .area_select{height:30px;font-size:15px;padding-left:22px;width: 121px;}
</style>
</head>
<body style="background:#F0F3F5;">
<input id="index_basePath" value="<%=wsUrl%>" type="hidden"/>
<div id="mark"></div>
<!-- header -->
<div id="head" >
    <div class="head-left">
        <img id="head-logo" src="./pic/logo2.png">
        <div class="head-tit">${webTitle}</div>
        <div id="head-area">
            <c:if test="${netAreas!=null}">
                <c:choose>
                    <c:when test="${netAreas[0].level==2}">
                        <select id="city" class="area_select">
                        <c:forEach var="city" items="${netAreas}">
                         <option value="${city.code}">${city.name}</option>
                        </c:forEach>
                        </select>
                    </c:when>
                    <c:when test="${netAreas[0].level==3}">
                        <select id="county" class="area_select">
                        <c:forEach var="county" items="${netAreas}">
                         <option value="${city.code}">${city.name}</option>
                        </c:forEach>
                        </select>
                    </c:when>
                    <c:otherwise></c:otherwise>
                </c:choose>
            </c:if>
            <span id="distinction"></span>
        </div>
    </div>
    <!-- userheader -->
    <div class="head-right">
        <div class="head-user">
            <img src="./pic/userhead.png">${sessionScope.loginuser.cname}<span style="font-size:9px">∨</span>
            <img src="./pic/login-out.jpg" id="login-out" onclick="window.location.href='/user/login'">
        </div>
        <!-- setting -->
        <div class="head-set" style="display: none;">
            <img src="./pic/setting.png">设置
        </div>
        <!-- finding -->
        <div class="head-find" style="display: none;">
            <select>
                <option>身份证号</option>
                <option>手机号</option>
                <option>驾驶证号</option>
                <option>企业编号</option>
            </select>
            <input type="text">
        </div>
        <p id='special-find' style="display: none;">特殊车辆查找</p>
    </div>e[
</div>
<!-- 左侧菜单 -->
    <div id="menu-list" >
    <div class="treebox" id="menu-height" style="background-color:rgb(33,44,60)">
        <ul class="menu">
            <c:forEach items="${Menus}" var="menu">
            <li class="level1">
                <c:choose>
                <c:when test="${!empty menu.netAuthorities}">
                    <a href="#none"><em class="ico ${menu.netAuthority.icon}"></em>${menu.netAuthority.title}<i></i></a>
                    <ul class="level2">
                        <c:forEach var="netAuthoritie" items="${menu.netAuthorities}">
                            <li><a href="javascript:;" onclick="addTab('${netAuthoritie.url}','${netAuthoritie.title}')">${netAuthoritie.title}</a></li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    <a href="#none" onclick="addTab('${menu.netAuthority.url}','${menu.netAuthority.title}')"><em class="ico ${menu.netAuthority.icon}"></em>${menu.netAuthority.title}</a>
                    <ul class="level2">
                        <c:forEach var="netAuthoritie" items="${menu.netAuthorities}">
                            <li><a href="javascript:;" onclick="addTab(${netAuthoritie.url})">${netAuthoritie.title}</a></li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
                </c:choose>
                </c:forEach>
        </ul>
    </div>
</div>

<!-- 选项卡+ -->
<div id="tab-list">
    <div id="list-height" class="layui-tab" lay-filter="onelist" lay-allowclose="true" style="position:relative;" >
        <ul class="layui-tab-title" style="background:#fff;">
            <li class="layui-this" lay-id="user/firstpage">首页</li>
        </ul>
        <div class="layui-tab-content" >
               <div id="tab-height" class="layui-tab-item layui-show" style="overflow:scroll;position:absolute;top:33px;left:0;width:100%;">
                   <div class="new-index-top" style="overflow: hidden">
                       <div><div><img src="./pic/hp_today_orders.png"></div><div><p>当日订单数</p><p><c:if test="${statisticsNumData!=null}"><c:out value="${statisticsNumData.orderNum}"/> </c:if></p></div></div>
                       <div><div><img src="./pic/hp_mileage.png"></div><div><p>当日营运里程(km)</p><p><c:if test="${statisticsNumData!=null}"><c:out value="${statisticsNumData.mileageNum}"/> </c:if></p></div></div>
                       <div><div><img src="./pic/hp_today_money.png"></div><div><p>当日营运金额</p><p><c:if test="${statisticsNumData!=null}"><c:out value="${statisticsNumData.moneyNum}"/> </c:if></p></div></div>
                       <div><div><img src="./pic/index/hp_carryPasRate.png"></div><div><p>重载率</p><p><c:if test="${operationProportion!=null}"><c:out value="${operationProportion.value}"/> </c:if></p></div></div>
                       <div><div><img src="./pic/index/hp_warning.png"></div><div><p>当日未处理报警数</p><p><c:if test="${alarmNum!=null}"><c:out value="${alarmNum}"/></c:if></p></div></div>
                       <div>
                           <p>司机总数：<c:if test="${statisticsNumData!=null}"><c:out value="${statisticsNumData.driverNum}"/> </c:if></p>
                           <p>乘客总数：<c:if test="${statisticsNumData!=null}"><c:out value="${statisticsNumData.psgNum}"/> </c:if></p>
                       </div>
                   </div>
                   <div id="index-nth2">
                       <div>
                           <center class="index-nth2-left">
                               <center><div></div></center>
                               <p>车辆在线率</p>
                               <%--name="<c:if test="${signProportion!=null}"><c:out value="${signProportion.driverNum}"/></c:if>"--%>
                               <div class="prg-cont rad-prg" id="car-online" name="<c:if test="${signProportion!=null}"><c:out value="${signProportion.value}"/></c:if>" ></div>
                           </center>
                           <center class="index-nth2-left">
                               <center><div></div></center>
                               <p>司机签到率</p>
                               <%--name="<c:if test="${signProportion!=null}"><c:out value="${signProportion.driverNum}"/></c:if>"--%>
                               <div class="prg-cont rad-prg" id="driver-sign" name="<c:if test="${signProportion!=null}"><c:out value="${signProportion.value}"/></c:if>" ></div>
                           </center>
                           <center class="index-nth2-left">
                               <center><div></div></center>
                               <p>用户活跃率</p>
                               <%--name="<c:if test="${userLiveness!=null}"><c:out value="${userLiveness.driverNum}"/> </c:if>"--%>
                               <div class="prg-cont rad-prg" id="user-active" name="<c:if test="${userLiveness!=null}"><c:out value="${userLiveness.value}"/></c:if>"></div>
                           </center>
                       </div>

                       <div>
                           <p>各公司订单比</p>
                           <div id="canvasDiv"  data=${companyProportion}></div>
                       </div>
                   </div>
                   <div class="index-nth3">
                       <center>
                           <p>叫车量和订单量(昨日时间分布)</p>
                           <div id="canvasDiv2" data=${timeStatistics} ></div>
                       </center>
                       <center>
                           <p>叫车和订单量(各公司)</p>
                           <div id="canvasDiv3" data=${companyStatistics}></div>
                       </center>
                   </div>

                   <!-- 热力图 -->
                   <div class="index-nth4">
                       <div>热力图 <div id="index-quyu">
                           <div id="index-orderHeat" data=${orderPoint}>订单</div>
                           <div id="index-driverHeat">司机 (在线)</div>
                           <div id="index-psgHeat">乘客 (在线)</div>
                       </div>

                       </div>
                       <div id="indexmap"></div>
                       <div id="indexmap-set">
                           <div>
                               <div id="indexmap-blow"><img src="./pic/index/add.png"></div>
                               <div id="indexmap-shrink"><img src="./pic/index/jian.png"></div>
                           </div>
                           <div id="indexmap-getlocation"><img src="./pic/index/point.png"></div>
                       </div>
                   </div>
                   <div class="index-bottom-1" style="background:#989899;text-align:center;padding:22px 0 33px;width:100%;height:17px;color:#ffffff;font-size:12px;">
                       copyright&nbsp;&copy;&nbsp;2004-2017 河南九九出行网络科技有限公司
                   </div>
               </div>

        </div>
        <%--<div id="bottom-first" style="background:#252628;width:100%;height:116px;text-align:center;">--%>
            <%--<img src="../../pic/hp_top_logo.png" alt="" style="margin:16px 0 6px;">--%>
            <%--<p style="color:rgb(219,219,219);">copyright&nbsp;&copy;&nbsp;2004-2017 河南九九出行网络科技有限公司</p>--%>
        <%--</div>--%>
    </div>
</div>
<%--报警弹窗--%>
<%--<div id="index_alarmWindow" style="width:400px;height:260px;border:1px #f5f7fa solid;font-size:12px;display:none">--%>
    <%--<div style="">--%>
        <%--<table>--%>
            <%--<tbody style="text-align: center">--%>
            <%--<tr>--%>
               <%--<td style="text-align:center;">司机报警<span id="index-alarWindowTime">&nbsp;12:30:32</span></td>--%>
               <%--<td>豫AT0001</td>--%>
            <%--</tr>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>
<%--</div>--%>
<%--首页--%>

</body>
</html>
<script src="js/jquery-2.1.4.js"></script>
<!-- 手风琴菜单效果 -->
<script src="js/easing.js"></script>
<!-- 第三方 -->
<script src="vendor/layer.js"></script>
<script src="vendor/layui/layui.js"></script>
<script src="vendor/bootstrap_table/bootstrap.min.js"></script>
<script src="vendor/bootstrap_table/bootstrap-table.min.js"></script>
<script src="vendor/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
<%--layuidate--%>
<%--<script src="vendor/laydate.js"></script>--%>
<%--百度map--%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Fp7nTleD8icWOnW7XmkSAOEtU5bOB6wT"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
<%--绘制电子围栏--%>
<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
<!-- 环形进度条 -->
<script src="js/jquery.AshAlom.gaugeMeter-2.0.0.min.js"></script>
<!-- ichart.1.2.1.min -->
<script src="js/ichart.1.2.1.min.js"></script>
<script src="js/radialIndicator.js"></script>
<%--fence--%>
<script src="vendor/page/page.js"></script>
<%--聚合map--%>
<script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js"></script>
<%--评分--%>
<script type="text/javascript" src="vendor/raty-2.5.2/lib/jquery.raty.min.js"></script>
<script type="text/javascript">
    //                    $('.level2>li').click(function(){
    //                        $(this).css('border-left','5px solid #1a91eb').find('a').css('color','#1a91eb');
    //                        $(this).siblings().css('border-left','5px solid').find('a').css('color','#fff');
    //                    })

    $('#index-quyu>div').click(function(){
        $(this).css('background','linear-gradient(to top, #1991eb, #2da1f8)').css('color','#fff').siblings().css('background','linear-gradient(to top, #f2f4f7, #ffffff)').css('color','#354052');
    })


//==========================================
    // 判断浏览器的类型
    // 判断IE浏览器

    var xuan = $(window).height() -110;
    var screenWidth = $(window).width();
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){

        if(screenWidth > 1400){
            $('#menu-height').css('height',xuan);
            var hei=xuan+102-48;
            $('#tab-height').css('height',hei);
        }else{
            var he=xuan+102-80;
            $('#tab-height').css('height',he);
            $('#menu-height').css('height',xuan);
        }

    }
    // 判断Chrome
   else if(navigator.userAgent.indexOf("Chrome") >0)
   {
       var he1=xuan+102-97-27;
       $('#tab-height').css('height',he1);
       $('#menu-height').css('height',xuan);
   }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
        var he2=xuan+102-100-12;
        $('#tab-height').css('height',he2);
        var xuan1 = xuan + 13;
        $('#menu-height').css('height',xuan1);
    }

</script>
<script type="text/javascript" src="js/index/index.js"></script>