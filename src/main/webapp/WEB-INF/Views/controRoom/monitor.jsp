<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/5/17
  Time: 08:56
  To change this template use File | Settings | File Templates.
  监控页面
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
    <title>实时监控</title>
    <style>
        #monitor-paging{
            font-size:12px;
        }

    </style>
</head>
<body>
<div id="car_monin" style="width:100%; position:relative;">
    <div id="car_monitring" style="width: 29.5%;float: left;height: 100%;">
        <div id="monitoring-left" style="width:100%;" >
        <div id="haaa" style="overflow: hidden">
            <div class="monitoring-tit">定位车辆
                <img src="./pic/monitoring/refresh.png">
            </div>
            <div class="monitoring-company">
                <p>查看公司车辆</p>
                <select id="monitor_SelectCompany" class="selectStyle" style="width:160px;height:28px;font-size:14px">
                </select>
                <div id="monitor_searchCompanyGps" class="search-buttom">查询</div>
            </div>
            <div class="monitoring-company" style="border:none">
                <p>车辆跟踪</p>
                <input id="monitor_searchCarValue" type="text" class="input-style"  placeholder="输入车牌号">
                <div id="monitor_searchCarbtn" class="search-buttom" style="padding:4px 10px 4px 10px;margin:0; line-height:normal;width:auto">查询</div>
                <p style="margin-top:10px"><label><input id="monitor_showTranceCheckBtn" type="checkbox"
                                                         checked="checked">显示轨迹</label>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label><input id="monitor_lockShowCheckBtn" type="checkbox" checked="checked">锁定视角</label></p>
            </div>
        </div>
        <div id="hbbb" style="overflow: scroll" >
            <div class="monitoring-tit">当日报警
                <select id="monitor-alarmTypeSelect" class="selectStyle" style="height:28px;font-size:14px;width:120px;">
                    <option value="1">司机紧急报警</option>
                    <option value="2">集体停运</option>
                    <option value="3">聚集报警</option>
                    <option value="4">重点区域报警</option>
                    <option value="5">围栏禁入</option>
                    <option value="6">跨区经营</option>
                    <option value="7">出城报警</option>
                    <option value="8">人车分离</option>
                    <option value="9">超速</option>
                    <option value="10">计价异常</option>
                </select>
                <div class="monitor-dingyue" style="float:right;width:60px;text-indent:0px;color:#7f8fa4;font-size:14px">报警订阅
                </div>
                <img class="monitor-dingyue" src="./pic/monitoring/setting.png" style="width:23px;margin-top:8px">
            </div>
            <div id="monitor-listContext" style="width:100%;height:340px;overflow-y:scroll">
                <div id="monitor-nextshow"></div>
            </div>
            <ul class="page" maxshowpageitem="5" pagelistcount="10" id="monitor-paging"></ul>
            <%--<div class="monitoring-list">--%>
            <%--<div>在“河北省保定市”经营</div>--%>
            <%--<div>跨区经营&nbsp;&nbsp;报警人:李某某&nbsp;&nbsp;12:20</div>--%>
            <%--</div>--%>
            <%--<div class="monitoring-list">--%>
            <%--<div>在“河北省保定市”经营</div>--%>
            <%--<div>跨区经营&nbsp;&nbsp;报警人:李某某&nbsp;&nbsp;12:20</div>--%>
            <%--</div>--%>
            <%--<div class="monitoring-list">--%>
            <%--<div>在“河北省保定市”经营</div>--%>
            <%--<div>跨区经营&nbsp;&nbsp;报警人:李某某&nbsp;&nbsp;12:20</div>--%>
            <%--</div>--%>

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
        </div>
        <div id="warning-set" style="width: 100%">
        <div>报警订阅
            <div style="margin-right:10px" class="warning-close" onclick="$('#warning-set').hide();">X</div>
            <div><span id="monitor-selectAllalarm">全选</span>／<span id="monitor-notSelectalarm">全不选</span></div>
        </div>
        <div class="warning-check">
            <div><label>司机紧急报警 <input type="checkbox" name="1"></label></div>
            <div><label>集体停运 <input type="checkbox"  name="2"></label></div>
            <div><label>聚集报警 <input type="checkbox" name="3"></label></div>
            <div><label>重点区域报警 <input type="checkbox" name="4"></label></div>
            <div><label>禁入报警 <input type="checkbox" name="5"></label></div>
            <div><label>跨区经营 <input type="checkbox" name="6"></label></div>
        </div>
        <div class="warning-check" style="border-left:1px solid #dfdfdf">
            <div><label>出城报警 <input type="checkbox" name="7"></label></div>
            <div><label>人车分离 <input type="checkbox" name="8"></label></div>
            <div><label>超速 <input type="checkbox" name="9"></label></div>
            <div><label>计价异常 <input type="checkbox" name="10"></label></div>
            </div>
            <div id="monitor-fenceSubmit">确认
            </div>
            <div id="monitor-fenceClear" onclick="$('#warning-set').hide();">取消</div>
        </div>
    </div>
    <div id="monitoring-right" style="margin-left:0.5%;width:69%;float:left;margin-right:1%;border-radius: 4px;height: 100%">
        <div style="position:relative;width:100%;height:100%">
            <div id="monitoring-map" style="width:100%;height:100%;">
            </div>
            <div id="monitoring-time" style="width:187px;height: 68px;position:absolute;left:0px;top:0px">
                <div><img src="pic/monitoring/current_be_monitored.png">当前监控:<span id="monitro_monitorName"></span></div>
                <div><img src="pic/monitoring/monitor_time.png">监控时长:<span id="monitro_monitorTime" title="1"></span></div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">

    var xuan = $(window).height();
    var screenWidth = $(window).width();
    //判断360浏览器
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        $('#car_monin').css('height',he);

        if(screenWidth > 1400){
            var hei=xuan-65;
            $('#car_monin').css('height',hei);
            $('#hbbb').css('height','53.5%');
            $('#haaa').css('height', '45%');
            console.log($('#hbbb').css('height'));
        }else{
            var he=xuan-102;
            $('#car_monin').css('height',he);
            $('#hbbb').css('height','50.5%');
            $('#haaa').css('height', '48%');
            console.log($('#hbbb').css('height'));
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
        if(screenWidth > 1400){
            console.log('wwwwwwwwwwwwwwwwwwwwww');
            $('#car_monin').css('height','833px');
        }else{
            var he1=xuan-102-20;
            $('#car_monin').css('height',he1);
            $('#hbbb').css('height','50.5%');
            $('#haaa').css('height', '48%');
        }

    }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
        var he2=xuan-102-50;
        $('#car_monin').css('height',he2);
        $('#hbbb').css('height','50.5%');
        $('#haaa').css('height', '49%');
    }

    //=========================================================================
    var socket;//
    var monitor_map;//map
    $('#monitor-listContext').delegate('.monitoring-list','click',function () {
        $(this).css('background', '#e1eef5').siblings().css('background', '#fff');
    })
    //$('#monitoring-left').css('height', (window.screen.availHeight - 230) + 'px');


    setTimeout(function () {
        monitor_map = new BMap.Map("monitoring-map");
        var point = new BMap.Point(113.67, 34.75);
        monitor_map.centerAndZoom("河南省",13);
        monitor_map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        var myIcon = new BMap.Icon("./pic/monitoring/start_place.png", new BMap.Size(24, 90));
        //var marker2 = new BMap.Marker(point, {icon: myIcon});  // 创建标注
 //       monitor_map.addOverlay(marker2);
        var opts = {
            position: point,    // 指定文本标注所在的地理位置
//            offset: new BMap.Size(-150, -203)    //设置文本偏移量
        }


        var label = new BMap.Label("<div class='map-tit'>计价异常<div><div class='map-content'><div><span>时&nbsp;&nbsp;&nbsp;&nbsp;间:</span><span>12:30</span></div><div><span>订单耗时:</span><span>12时24分</span></div></div><div class='map-content'><div><span>时&nbsp;&nbsp;&nbsp;&nbsp;间:</span><span>12:30</span></div><div><span>订单金额:</span><span>188</span></div></div><div class='map-content'><div><span>车&nbsp;牌&nbsp;号:</span><span>豫D8484</span></div><div><span>订单金额:</span><span>188</span></div></div><div class='map-content'><div><span>时&nbsp;&nbsp;&nbsp;&nbsp;间:</span><span>12:30</span></div><div><span>订单金额:</span><span>188</span></div></div><div id='san'></div>", opts);  // 创建文本标注对象
        label.setStyle({
            color: "red",
            fontSize: "12px",
            height: "158px",
            width: '400px',
            lineHeight: "20px",
            fontFamily: "微软雅黑",
            border: '1px solid #5a687b',
            borderRadius: '4px'
        });


    }, 100);

    //加载公司列表 monitor_SelectCompany
    var areacode = '';//地区
    var selectCount = $("#county option:selected").text();
    if (selectCount == '所有') {
        areacode = $("#city option:selected").val();
    } else {
        areacode = $("#county option:selected").val();
    }

    if (startMonitorTimeCar != null) {
        clearInterval(startMonitorTimeCar);
    }


    $.ajax({
        timeout: 10000,
        url: "netcompany/findByareacode",
        dataType: "json",
        data: {
            areacode: areacode
        },
        success: function (companys) {
            if (companys != null && companys.length != 0) {
                $("#monitor_SelectCompany").empty();
                var html = "";
                for (var i = 0; i < companys.length; i++) {
                    html += "<option value='" + companys[i].name + "'>" + companys[i].desc + "</option>";
                }
            } else {
                html += "<option>无公司选择</option>";
            }
            $("#monitor_SelectCompany").append(html);
        },
        error: function (error, code, thow) {
            $("#monitor_SelectCompany").append("<option>无公司选择</option>");
        }
    })


    // 创建一个Socket实例
    var socket_url = $("#index_basePath").val();
    var socket = new WebSocket(socket_url);
    var trance_polyline;//轨迹线
    var trance_points = [];//轨迹点
    var sIcon = new BMap.Icon("/pic/trance/start.png", new BMap.Size(32, 32));
    var eIcon = new BMap.Icon("/pic/monitoring/car_one.png", new BMap.Size(32,70));
    var companyCarIcon = new BMap.Icon("/pic/monitoring/car.png", new BMap.Size(28,28));
    var smarker;//起点
    var emarker;//终点
    var isfirstSearch = true;
    var monitor_lockShowCheckBtn = true;//默认锁定视角
    var monitro_lockShowTranceBtn = true;//默认显示轨迹(单个车辆)
    var company_markers = [];//聚合点
    var company_markerClusterer=null;//聚合对象
    // 打开Socket
    socket.onopen = function (event) {
        socket.onmessage = function (event) {
            console.log("接收:" + event.data);
            var data = JSON.parse(event.data);
            if (data.state == "success") {
                switch (data.dataType){
                    case "gps":
                        var gps = data.object;
                        if(company_markerClusterer!=null){
                            company_markerClusterer.clearMarkers();
                        }
                        if (gps.longitude > 0 && gps.latitude > 0) {
                            var point = new BMap.Point(gps.longitude, gps.latitude);
                            trance_points.push(point);
                            //起点
                            if (isfirstSearch) {
                                smarker = new BMap.Marker(point,{icon:sIcon});
                                monitor_map.addOverlay(smarker);
                                isfirstSearch = false;
                                monitor_map.panTo(point);
                            }
                            if(emarker!=null){
                                monitor_map.removeOverlay(emarker);
                            }
                            emarker = new BMap.Marker(point,{icon:eIcon},{rotation:gps.direction});
                            monitor_map.addOverlay(emarker);

                            //锁定视角
                            if (monitor_lockShowCheckBtn) {
                                monitor_map.panTo(point, false);
                            }
                            //显示轨迹
                            monitor_map.removeOverlay(trance_polyline);
                            if (monitro_lockShowTranceBtn) {
                                trance_polyline = new BMap.Polyline(trance_points, {
                                    strokeColr: "blue",
                                    strokeWeight: 5,
                                    strokeOpacity: 1
                                });
                                monitor_map.addOverlay(trance_polyline);
                            }
                        }
                        break;
                    case "companyGps":
                        var companyGpsList = data.object;
                        company_markers.length=0;
                            if(company_markerClusterer!=null){
                                company_markerClusterer.clearMarkers();
                            }
                        for(var i=0;i<companyGpsList.length;i++){
                            var pt = new BMap.Point(companyGpsList[i].longitude,companyGpsList[i].latitude);
                            var marker = new BMap.Marker(pt,{icon:companyCarIcon,title:companyGpsList[i].vehicleno,rotation:companyGpsList[i].direction});
                                company_markers.push(marker);
                           }
                        if (isfirstSearch) {
                            isfirstSearch = false;
                            monitor_map.panTo(new BMap.Point(companyGpsList[0].longitude,companyGpsList[0].latitude));
                        }
                        company_markerClusterer = new BMapLib.MarkerClusterer(monitor_map, {markers:company_markers});
                        break;
                }
            } else if (data.state == "error") {
                layer.alert("无对应定位信息");
                //关闭定时器
                if (startMonitorTimeCar != null) {
                    clearInterval(startMonitorTimeCar);
                }
            }else if(data.state == "outTime"){
                switch (data.dataType){
                    case "gps":
                        var gps = data.object;
                        if(company_markerClusterer!=null){
                            company_markerClusterer.clearMarkers();
                        }
                        if (gps.longitude > 0 && gps.latitude > 0) {
                            var point = new BMap.Point(gps.longitude, gps.latitude);
                            trance_points.push(point);
                            //起点
                            if (isfirstSearch) {
                                smarker = new BMap.Marker(point,{icon:sIcon});
                                monitor_map.addOverlay(smarker);
                                isfirstSearch = false;
                                monitor_map.panTo(point);
                            }
                            if(emarker!=null){
                                monitor_map.removeOverlay(emarker);
                            }
                            emarker = new BMap.Marker(point,{icon:eIcon},{rotation:gps.direction});
                            monitor_map.addOverlay(emarker);
                            var label = new BMap.Label("最后定位位置",{offset:new BMap.Size(-18,-20)});
                            emarker.setLabel(label);

                            //锁定视角
                            if (monitor_lockShowCheckBtn) {
                                monitor_map.panTo(point, false);
                            }
                            //显示轨迹
                            monitor_map.removeOverlay(trance_polyline);
                            if (monitro_lockShowTranceBtn) {
                                trance_polyline = new BMap.Polyline(trance_points, {
                                    strokeColr: "blue",
                                    strokeWeight: 5,
                                    strokeOpacity: 1
                                });
                                monitor_map.addOverlay(trance_polyline);
                            }
                        }
                        break;
                    case "companyGps":
                        var companyGpsList = data.object;
                        company_markers.length=0;
                        if(company_markerClusterer!=null){
                            company_markerClusterer.clearMarkers();
                        }
                        for(var i=0;i<companyGpsList.length;i++){
                            var pt = new BMap.Point(companyGpsList[i].longitude,companyGpsList[i].latitude);
                            var marker = new BMap.Marker(pt,{icon:companyCarIcon,title:companyGpsList[i].vehicleno,rotation:companyGpsList[i].direction});
                            company_markers.push(marker);
                        }
                        if (isfirstSearch) {
                            isfirstSearch = false;
                            monitor_map.panTo(new BMap.Point(companyGpsList[0].longitude,companyGpsList[0].latitude));
                        }
                        company_markerClusterer = new BMapLib.MarkerClusterer(monitor_map, {markers:company_markers});
                        break;
                }
            }
        };
        //监听Socket的关闭
        socket.onclose = function (event) {
            console.log('Client  socket has closed', event);
        };


        //点击标注出发事件
//        var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>最后定位位置</p>");  //弹出窗口
//        emarker.addEventListener("click", function(){
//            this.openInfoWindow(infoWindow);
//        });

        // 关闭Socket....
        //socket.close()
    };
    //显示轨迹
    $("#monitor_showTranceCheckBtn").click(function () {
        if ($('#monitor_showTranceCheckBtn').is(':checked')) {
            monitro_lockShowTranceBtn = true;
        } else {
            monitro_lockShowTranceBtn = false;
        }
    });

    //锁定视角
    $("#monitor_lockShowCheckBtn").click(function () {
        if ($('#monitor_lockShowCheckBtn').is(':checked')) {
            monitor_lockShowCheckBtn = true;
        } else {
            monitor_lockShowCheckBtn = false;
        }
    });


    $("#monitor_searchCarbtn").click(function () {
        var textval= $(this).text();
        if(textval=='查询'){
            var value = $("#monitor_searchCarValue").val();
            if (value != '') {
                var areacode = '';
                var selectCount = $("#county option:selected").text();
                if (selectCount == '所有') {
                    areacode = $("#city option:selected").val();
                } else {
                    areacode = $("#county option:selected").val();
                }
                layer.load();
                longtime=0;
                $("#monitro_monitorTime").text("");
                $("#monitor_searchCarbtn").text("停止").css("backgroundColor","#ff7c62");
                $("#monitor_searchCarValue").css("backgroundColor","#CCC").attr("disabled","disabled");
                //
                $("#monitor_searchCompanyGps").text("查询").css("backgroundColor","#1A91EB");
                $("#monitor_SelectCompany").removeAttr("disabled");
                monitorCar_start(value,areacode);
            }else{
                layer.alert("请输入车牌号");
            }
        }else if(textval=='停止'){
            $("#monitor_searchCarValue").css('backgroundColor','#ffffff').removeAttr("disabled");
            $(this).text("查询").css("backgroundColor","#1A91EB");
            if (startMonitorTimeCar != null) {
                clearInterval(startMonitorTimeCar);
            }
        }
    });

    //查询监控车辆
    function monitorCar_start(value,areacode){
            $.ajax({
                timeout: 10000,
                url: "netcar/findByaAreaVehicheno",
                dataType: "json",
                data: {
                    areacode: areacode,
                    vehicheno: value
                },
                success: function (datas) {
                    layer.closeAll('loading');
                    monitor_map.removeOverlay(trance_polyline);
                    monitor_map.removeOverlay(smarker);
                    monitor_map.removeOverlay(emarker);
                    monitor_map.clearOverlays();
                    if (datas != null && datas.length != 0) {
                        //获取最后位置
                        sendSocketData = "{'type':'gps','areacode':'" + areacode + "','vehicleno':'" + datas[0].desc + "'}";
                        socket.send(sendSocketData);
                        isfirstSearch = true;
                        trance_points.length = 0;
                        if (startMonitorTimeCar != null) {
                            clearInterval(startMonitorTimeCar);
                        }
                        $("#monitro_monitorName").text(datas[0].desc);
                        //开始计时
                        startMonitorTimeCar = window.setInterval(startInterval,1000);
                    } else {
                        layer.alert("查无此车辆");
                    }
                },
                error: function (error, code, thow) {
                    layer.closeAll('loading');
                    layer.alert("查无此车辆:" + code);
                }
            })
    }


    $("#monitor_searchCompanyGps").click(function(){

        var textVal= $(this).text();
        if(textVal=="停止"){
            $("#monitor_searchCarValue").css('backgroundColor','#ffffff').removeAttr("disabled");
            $(this).text("查询").css("backgroundColor","#1A91EB");
            $("#monitor_SelectCompany").removeAttr("disabled");
            if (startMonitorTimeCar != null) {
                clearInterval(startMonitorTimeCar);
            }
        }else if(textVal=="查询"){
            var companyidc=$("#monitor_SelectCompany option:selected").val();
            if(companyidc.length!=0){
                var areacode = '';
                var selectCount = $("#county option:selected").text();
                if (selectCount == '所有') {
                    areacode = $("#city option:selected").val();
                } else {
                    areacode = $("#county option:selected").val();
                }
                $("#monitor_searchCarValue").css('backgroundColor','#ffffff').removeAttr("disabled");
                $("#monitor_searchCarbtn").text("查询").css("backgroundColor","#1A91EB");
                $(this).text("停止").css("backgroundColor","#ff7c62");
                $("#monitor_SelectCompany").attr("disabled","disabled");
                sendSocketData = "{'type':'companyGps','areacode':'" + areacode + "','companyidc':'" +companyidc+ "'}";
                isfirstSearch = true;
                socket.send(sendSocketData);
                $("#monitro_monitorName").text($("#monitor_SelectCompany option:selected").text());
                //开始计时
                monitor_map.clearOverlays();
                if (startMonitorTimeCar != null) {
                    clearInterval(startMonitorTimeCar);
                }
                startMonitorTimeCar = window.setInterval(startInterval,1000);
            }else{
                layer.alert("请选择公司");
            }
        }
    })


    var startMonitorTimeCar;//定时器
    var sendSocketData;//发送的socket数据
    //即时开始
    var longtime = 0;//开始计时总时长
    function startInterval() {
        longtime++;
        $("#monitro_monitorTime").attr("title", longtime + 1);
        $("#monitro_monitorTime").text(formatSeconds(longtime));
        //每15秒获取一次定位
        if (longtime % 15 == 0) {
            console.log("发送:" + sendSocketData);
            socket.send(sendSocketData);
        }
    }


    function startMonitorCompany(areacode,companyidcs){

    }



    //秒数转换成时分秒
    function formatSeconds(value) {
        var theTime = parseInt(value);// 秒
        var theTime1 = 0;// 分
        var theTime2 = 0;// 小时
        if (theTime > 60) {
            theTime1 = parseInt(theTime / 60);
            theTime = parseInt(theTime % 60);
            if (theTime1 > 60) {
                theTime2 = parseInt(theTime1 / 60);
                theTime1 = parseInt(theTime1 % 60);
            }
        }
        var result = "" + parseInt(theTime) + "秒";
        if (theTime1 > 0) {
            result = "" + parseInt(theTime1) + "分" + result;
        }
        if (theTime2 > 0) {
            result = "" + parseInt(theTime2) + "小时" + result;
        }
        return result;
    }

    //查看报警订阅
    $('.monitor-dingyue').click(function () {
        $.ajax({
            timeout:10000,
            url:"alarm/getAlarmSubids",
            dataType:"json",
            success:function(data){
                if(data!=null&&data.length!=0){
                    var checkInput=$("#warning-set input");
                    for(var i=0;i<checkInput.length;i++){
                       for(var j=0;j<data.length;j++){
                           var id= $(checkInput[i]).attr("name")
                            if($(checkInput[i]).attr("name")==data[j]){
                                $(checkInput[i]).prop("checked",true);
                            }
                        }
                    }
                }
            },
            error:function (error,code,throwError) {
                layer.alert("报警订阅信息查询异常:"+code);
            }
        });
        $('#warning-set').show();
    });


    //保存报警订阅
    $("#monitor-fenceSubmit").click(function(){
        var checkInput=$("#warning-set input");
        var ids="";
        for(var i=0;i<checkInput.length;i++){
            if($(checkInput[i]).is(':checked')){
                ids+=$(checkInput[i]).attr("name")+",";
                //layer.alert("-====");
            }
        }
        $.ajax({
            timeout:10000,
            url:"alarm/updateAlarmSubids",
            dataType:"json",
            data:{
                alaryTypeids:ids
            },
            success:function(data){
                if(data!=null&&data.length!=0){
                    layer.alert(data.desc);
                }
            },
            error:function (error,code,throwError) {
                layer.alert("更新订阅异常,请重试! :"+code);
            }
        });
    });



    $("#monitor-alarmTypeSelect").change(function () {
        monitor_init();
    });


    function monitor_init(){
        $.ajax({
            timeout:10000,
            dataType:"json",
            url:"alarm/getTodayAlarmByalarmType",
            data:{
                areacode:areacode,
                alarmtype:$("#monitor-alarmTypeSelect option:selected").val(),
                limit:5,
                offset:1
            },
            success:function (baseTable) {
                $("#monitor-listContext").empty();
                if(baseTable.total!=0){
                    for(var i=0;i<baseTable.rows.length;i++){
                        var row=baseTable.rows[i];
                        var alarm_list="<div class='monitoring-list'><div>"+row.position+"</div><div>&nbsp;&nbsp;车牌号:"+row.vehicleno+"&nbsp;&nbsp;"+returnTimestamp(row.alarmtime)+"</div></div>";
                        $("#monitor-listContext").append(alarm_list);
                    }
                    $("#monitor-paging").initPage(baseTable.total,1,paging);
                }else{
                    $("#monitor-paging").empty();
                }
            },
            error:function (error,code,throwth) {
                layer.alert("获取订单失败:"+code);
            }
        })
    }

    monitor_init();

    //点击分页数字按钮dd==页数,查询所有
    function paging(dd){
        $.ajax({
            timeout:10000,
            dataType:"json",
            url:"alarm/getTodayAlarmByalarmType",
            data:{
                areacode:areacode,
                alarmtype:$("#monitor-alarmTypeSelect option:selected").val(),
                limit:5,
                offset:dd
            },
            success:function (baseTable) {
                $("#monitor-listContext").empty();
                if(baseTable.total!=0){
                    for(var i=0;i<baseTable.rows.length;i++){
                        var row=baseTable.rows[i];
                        var alarm_list="<div class='monitoring-list'><div>"+row.position+"</div><div>&nbsp;&nbsp;车牌号:"+row.vehicleno+"&nbsp;&nbsp;"+returnTimestamp(row.alarmtime)+"</div></div>";
                        $("#monitor-listContext").append(alarm_list);
                    }
                }else{
                    $("#monitor-paging").empty();
                }
            },
            error:function (error,code,throwth) {
                layer.alert("获取订单失败:"+code);
            }
        })
    }

    function returnTimestamp(timestamp){
        return new Date(parseInt(timestamp)).toLocaleString();
    }


    //全选
    $("#monitor-selectAllalarm").click(function(){
        $(".warning-check input:checkbox").prop("checked",true);
    });
    //全不选
    $("#monitor-notSelectalarm").click(function(){
        $(".warning-check input:checkbox").prop("checked",false);
    });


</script>
</body>
</html>
