<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/5/9
  Time: 10:38  轨迹页面
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

<div id="car_moning" style="width:100%;position:absolute">
    <div id="car_monitringe" style="width: 29.5%;float: left;">
    <%--left--%>
    <div id="car_height" class="trance_left" style="width: 100%">
        <div id="car_lefttop" class="trance_lefttop" style="width: 100%;">
            <div class="trance_lefttop_Title">车辆轨迹</div>
            <div class="trance_lefttop_text" style="height:350px;">
                <div style="color: #9a9fa8"><label>车&nbsp;&nbsp;牌&nbsp;&nbsp;号:</label><input id="tance_text_vehicleno" class="tance_text"  type="text" placeholder="输入车牌号"/>
                </div>
                <div style="color: #9a9fa8"><label>有效期起:</label>
                    <%--onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="2017-05-09 10:10:10" --%>
                    <%--onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"--%>
                    <input id="tance_text_starttime" class="trance_inputTime" type="text" class="tance_text" placeholder="请选择开始时间"/></div>
                <div style="color: #9a9fa8"><label>有效期止:</label>
                    <input id="tance_text_endttime" class="trance_inputTime" type="text" class="tance_text"   placeholder="请选择结束时间"/></div>
                <div><button id="trance_searchBtn" class="btn_blue"  type="button" value="">查&nbsp;询</button></div>
            </div>
        </div>
        <div id="tance_car" class="trance_leftbottm" style="width: 100%;height: 420px;margin-top: 10px">
            <div id="trance_carInfo">
                <div style="color: #354052;width: 100%;">车辆信息</div>
                <div>车牌号:<span name="vehichleno"></span></div>
                <div>车型:<span name="model"></span></div>
                <div>车身颜色:<span name="vehiclecolor"></span></div>
            </div>
            <div id="trance_carfo" style="width:100%;">
                <div style="color:#354052;">司机信息</div>
                <div>
                <div id="trance_driverContent">
                    <div>
                        <div>姓名:<span name="drivername"></span></div>
                        <div>性别:<span name="drivergender"></span></div>
                        <div>身份证号:<span name="licenseid"></span></div>
                        <div>注册时间:<span name="contracton"></span></div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
    <%--right--%>

</div>
    <div id="trance_map" class="trance_map" style="display:block;position:relative;width: 70%;height: 100%;">
        <div id="trance_mapShow" style="width:100%;height:100%;position: relative"></div>
        <%--<div class="trance_maptool" style="">--%>
        <%--<div id="trance_mapZoomOut"><img src="./pic/index/add.png"></div>--%>
        <%--<div id="trance_mapZoomIn"><img src="./pic/index/jian.png"></div>--%>
        <%--<div id="trance_mapPosition"><img src="./pic/index/point.png" style=""></div>--%>
        <%--</div>--%>
        <div class="indexmap-set">
            <div>
                <div id="trance_mapZoomOut" class="indexmap-blow"><img src="./pic/index/add.png"></div>
                <div id="trance_mapZoomIn" class="indexmap-shrink"><img src="./pic/index/jian.png"></div>
            </div>
            <div id="trance_mapPosition" class="indexmap-getlocation"><img src="./pic/index/point.png"></div>
        </div>
    </div>
</div>
<%--底部详细--%>
<div class="trance_Order"style="display:none;">
    <%--left--%>
    <div class="trance_OrderLeft">
        <div style="" class="trance_OrderList">
            <div class="trance_OrderListDesc1"><label id="trance_startLocation"></label><label id="trance_endLocation"></label></div>
            <div class="trance_OrderListDesc2"><label id="trance_costTime"></label><label
                    style="margin-left:20px;"><span id="trance_orderCount"></span></label></div>
        </div>
        <div class="trance_OrderListshow" style="overflow:scroll">
            <%--<ul>--%>
                <%--<li>11212111111</li>--%>
                <%--<li>接单时间:2017-10-11 12:12:12</li>--%>
                <%--<li>从XXXXXXXXX<span>到</span>XXXXXXXX</li>--%>
            <%--</ul>--%>
        </div>
    </div>
    <%--right--%>
    <div id="trance_speedChart" style="float:right;width:38%;height:300px;background-color:white;">
    </div>
</div>
</body>
<script>


    var xuan = $(window).height();
    //判断360浏览器
    var screenWidth1 = $(window).width();
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        //=============================
        if(screenWidth1> 1400){
            var he=xuan-68;
            $('#car_moning').css('height',he);
            $('#car_lefttop').css('height','345px');
            $('#tance_car').css('height','465px');
        }else{
            var he1=xuan-38-71;
            $('#car_moning').css('height',he1);
            $('#car_lefttop').css('height','245px');
            $('#tance_car').css('height','293px');
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
        if(screenWidth1> 1400){
            $('#car_moning').css('height','840px');
            $('#car_lefttop').css('height','370px');
            $('#tance_car').css('height','460px');
        }else{
            $('#car_moning').css('height','500px');
            $('#car_lefttop').css('height','240px');
            $('#tance_car').css('height','260px');
            $('#car_moning').css('overflow','hidden');
        }
    }
    // 判断safari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
        var he2=xuan-144;
        $('#car_moning').css('height',he);
        $('#car_lefttop').css('height','280px');
        $('#tance_car').css('height','310px');
        console.log(he);
    }
    //==========================================================>
    //格式化时间YYYY-MM-dd HH:mm:ss
    function format(value, row, index) {
        var date = new Date(value);
        var year = date.getFullYear().toString();
        var month = (date.getMonth() + 1);
        var day = date.getDate().toString();
        var hour = date.getHours().toString();
        var minutes = date.getMinutes().toString();
        var seconds = date.getSeconds().toString();
        if (month < 10) {month = "0" + month;}
        if (day < 10) {day = "0" + day;}
        if (hour < 10) {hour = "0" + hour;}
        if (minutes < 10) {minutes = "0" + minutes;}
        if (seconds < 10) {seconds = "0" + seconds;}
        return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    }

    //设置div容器高度
    /*var car_divheight=$("#car_height").height();
    console.log(car_divheight);*/

    var tranceMap;//地图全局变量
    var trance_area = '';
    setTimeout(function(){
        tranceMap = new BMap.Map("trance_mapShow"); // 创建Map实例
        tranceMap.centerAndZoom(new BMap.Point(113.689231,34.767422), 12);  // 初始化地图,设置中心点坐标和地图级别
        tranceMap.setCurrentCity("郑州");   // 设置地图显示的城市 此项是必须设置的
        tranceMap.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

    },100)
    //点击放大地图
    $("#trance_mapZoomOut").click(function () {
        tranceMap.zoomIn();
    });
    //点击缩小地图
    $("#trance_mapZoomIn").click(function () {
        tranceMap.zoomOut();
    });
    $("#trance_mapPosition").click(function () {
        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            trance_area = $("#city option:selected").text();
        } else {
            trance_area = $("#county option:selected").text();
        }
        tranceMap.setCenter(trance_area);
    });

    layui.use('element', function(){
        element = layui.element();
    });
    // var laydate = layui.laydate;
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        var start = {
            max: laydate.now(),
            istoday: false,
            istime:true,
            format: 'YYYY-MM-DD hh:mm:ss',
            choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            max:laydate.now(),
            istoday: false,
            istime:true,
            format: 'YYYY-MM-DD hh:mm:ss',
            choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('tance_text_starttime').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('tance_text_endttime').onclick = function(){
            end.elem = this
            laydate(end);
        }

    });



    //查询button
    $("#trance_searchBtn").click(function(){
        var vehichleno = $.trim($("#tance_text_vehicleno").val());
        var stime = $("#tance_text_starttime").val();
        var etime = $("#tance_text_endttime").val();
        if (vehichleno=="") {
            layer.tips('请输入车牌号码', '#tance_text_vehicleno', {
                tips: [2, '#FF7C62']
            });
        } else if (stime=="") {
            layer.tips('请输入开始时间', '#tance_text_starttime', {
                tips: [2, '#FF7C62']
            });
        } else if (etime=="") {
            layer.tips('请输入结束时间', '#tance_text_endttime', {
                tips: [2, '#FF7C62']
            });
        } else {
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                trance_areacode = $("#city option:selected").val();
            } else {
                trance_areacode = $("#county option:selected").val();
            }
            layer.load();
            $.ajax({
                timeout:20000,
                url: "netcar/getByVehiclenoTime",
                dataType: "json",
                data: {
                    address:trance_areacode,
                    vehicleno: vehichleno,
                    starttime: stime,
                    endtime: etime
                },
                success: function (data) {
                    layer.closeAll('loading');
                    if (data != null) {
                        $("#trance_carInfo span[name='vehichleno']").text(data.vehicleno);
                        $("#trance_carInfo span[name='model']").text(data.model);
                        $("#trance_carInfo span[name='vehiclecolor']").text(data.vehiclecolor);
                       // $("#trance_driverContent").empty();
                        for(var i=0;i<data.driverList.length;i++){
                            var driver= data.driverList[i];
                            //var html="<div><div>姓名:<span>"+driver.drivername+"</span></div><div>性别:<span>"+driver.drivergender+"</span></div><div>身份证号:<span>"+driver.licenseid+"</span></div> <div>注册时间:<span>"+driver.contracton+"</span></div> </div>";
                            $("#trance_driverContent span[name='drivername']").text(driver.drivername);
                            $("#trance_driverContent span[name='drivergender']").text(driver.drivergender);
                            $("#trance_driverContent span[name='licenseid']").text(driver.licenseid);
                            $("#trance_driverContent span[name='contracton']").text(format(driver.contracton));
                            //$("#trance_driverContent").append(html);
                        }
                        //轨迹查询
                        findTrance($.trim($("#tance_text_vehicleno").val()),$("#tance_text_starttime").val(),$("#tance_text_endttime").val());
                    }else{
                        layer.tips('未找到相关信息', '#trance_searchBtn');
                    }
                },
                error: function (error,errorcode,th) {
                    layer.closeAll('loading');
                    layer.tips('查无相关信息', '#trance_searchBtn');
                }
            })
        }
    });


    //车辆轨迹查询
    var polyline;//轨迹线;
    function findTrance(vehicleno,starttime,endtime){
        $.ajax({
            timeout:20000,
            url: "netcar/getDevicegps",
            dataType: "json",
            data: {
                vehicleno:vehicleno,
                starttime:starttime,
                endtime:endtime
            },
            success: function (showGpsList) {
                tranceMap.clearOverlays();
                if (showGpsList!= null&&showGpsList.length!=0) {
                    tranceMap.removeOverlay(polyline);//移除轨迹线
                    tranceMap.removeOverlay(polyline);//移除轨迹点
                    tranceMap.removeOverlay(polyline);
                    var points=[];
                    for(var i=0;i<showGpsList.length;i++){
                        var point= new BMap.Point(showGpsList[i].lng,showGpsList[i].lat);
                        points.push(point);
                    }
                    //添加覆盖物
                    tranceMap.setViewport(points);
                    polyline = new BMap.Polyline(points,{strokeColr:"blue",strokeWeight:5,strokeOpacity:1});
                    tranceMap.addOverlay(polyline);

                    //地址解析
                    var startPoint= new BMap.Point(showGpsList[0].lng,showGpsList[0].lat);
                    var endPoint= new BMap.Point(showGpsList[showGpsList.length-1].lng,showGpsList[showGpsList.length-1].lat);

                    var sIcon = new BMap.Icon("/pic/trance/start.png", new BMap.Size(32,32));
                    var eIcon = new BMap.Icon("/pic/trance/end.png", new BMap.Size(32,32));
                    var smarker = new BMap.Marker(startPoint,{icon:sIcon});  // 创建标注
                    var emarker = new BMap.Marker(endPoint,{icon:eIcon});  // 创建标注
                    tranceMap.addOverlay(smarker);
                    tranceMap.addOverlay(emarker);
                    //地址解析
                    geocLocation(startPoint,"s");
                    geocLocation(endPoint,"e");
                    //计算耗时
                     var second= (showGpsList[showGpsList.length-1].time-showGpsList[0].time)/1000;
                      $("#trance_costTime").text(sec_to_time(second)+"秒");
                    //显示速度图
                    showSpeed(showGpsList)
                    //订单查询
                    findOrders(vehicleno,starttime,endtime)
                }else{
                    layer.msg("查无相关轨迹数据");
                }
            },
            error: function (error,errorcode,th) {
                layer.msg("查无相关轨迹数据:"+errorcode);
                tranceMap.clearOverlays();
            }
        })
    }





    //订单查询
    function findOrders(vehicleno,starttime,endtime){
        $.ajax({
            url: "order/findBycar",
            dataType: "json",
            data: {
                vehicleno:vehicleno,
                starttime:starttime,
                endtime:endtime
            },
            success: function (data) {
                $(".trance_OrderListshow").empty();
                $("#trance_orderCount").text("接驾0笔订单");
                if (data != null) {
                    $("#trance_orderCount").text("接驾"+data.length+"笔订单");
                    var html="";
                    for(var i=0;i<data.length;i++){
                        html+="<div><ul><li>"+data[i].orderid+"</li><li>, 接单时间:"+js_date_time(data[i].destributetime)+"</li><li>, "+data[i].departure+"<span> 到 </span>"+data[i].destination+"</li></ul></div>";
                    }
                    $(".trance_OrderListshow").append(html);
                }
            },
            error: function (error,errorcode,th) {
                layer.msg("查无订单信息>>"+errorcode);
                $(".trance_OrderListshow").empty();
            }
        })
    }

    //速度曲线图
    function showSpeed(showGpsList) {
        var speeds=[];
        var times=[];
        for(var i=0; i<showGpsList.length;i++){
            speeds.push(showGpsList[i].speed);
            times.push(showGpsList[i].time);
        }
        var data = [
            {
                name : '速度',
                value:speeds,
                color:'#aad0db',
                line_width:2
            }
        ];

        //var labels = ["01月","02月","03月","04月","05月","06月","07月","08月","09月","10月","11月","12月"];

        var chart = new iChart.Area2D({
            render : 'trance_speedChart',
            data: data,
            title : '速度曲线图(km/h)',
            width : 400,
            height : 300,
            tip:{
                enable : true,
                listeners:{
                    //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                    parseText:function(tip,name,value,text,i){
                        return "速度:"+value;
                    }
                }
            },
            crosshair:{
                enable:true,
                line_color:'#62bce9',
                line_width:2
            },
            sub_option:{
                label:false,
                point_size:10
            },
            background_color:'#f2f2f2',
            coordinate:{
                axis : {
                    width : [0, 0, 2, 0]
                },
                background_color:'#ffffff',
                height:'90%',
                scale:[{
                    position:'left',
                    scale_space:5,
                    scale_enable:false,//禁用小横线
                    listeners:{
                        parseText:function(t,x,y){
                            return {text:t}
                        }
                    }
                },{
                    position:'bottom',
                    start_scale:1,
                    end_scale:12,
                    parseText:function(t,x,y){
                        return {textY:y+10}
                    },
                   labels:['0']
                }]
            }
        });
        chart.draw();
    }


    //地址解析
    function geocLocation(point,startOrend){
        var geoc = new BMap.Geocoder();
        geoc.getLocation(point, function(rs){
            var addComp = rs.addressComponents;
            if(startOrend=='s'){
             $("#trance_startLocation").text(addComp.city+","+addComp.district+","+addComp.street+","+addComp.streetNumber+"→ ");
            }if(startOrend=='e'){
                $("#trance_endLocation").text(addComp.city+","+addComp.district+","+addComp.street+","+addComp.streetNumber);
            }
        });
    }
    //耗时计算
    function sec_to_time(s) {
        var t;
        if(s > -1){
            var hour = Math.floor(s/3600);
            var min = Math.floor(s/60) % 60;
            var sec = s % 60;
            if(hour < 10) {
                t = '0'+ hour + "时";
            } else {
                t = hour + "时";
            }

            if(min < 10){t += "0";}
            t += min + "分";
            if(sec < 10){t += "0";}
            t += sec.toFixed(2);
        }
        return t;
    }
    //时间戳转时间
    function js_date_time(unixtime){
        var timestr = new Date(parseInt(unixtime));
        //var datetime = timestr.toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");
        return timestr.toLocaleString();
    }


</script>
<div style="color:#1a91eb;"></div>
</html>
