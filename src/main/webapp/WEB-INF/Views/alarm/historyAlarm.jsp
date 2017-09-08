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
    <style>
        .hisAlarm_btnGroup {
            font: Normal 200 14px/20px Arial;
            font-family: "微软雅黑";
            border: 1px #ced0da solid;
            background-color: #ffffff;
            /*border-radius:4px;*/
            margin: 0px;
            height: 28px;
            width: 50px;
        }

        .hisAlarm_inputTime {
            background-image: url("/pic/trance/form-date.png");
            background-position: left;
            background-repeat: no-repeat;
            padding-left: 18px;
        }

        .hisAlarm_selectDatatype {
            background-color: #1389e1;
            color: white;
        }

        .alarm_btngroup {
            border: 1px #ced0da solid;
            background-color: #ffffff;
            border-radius: 4px;
        }

        .alarm_btngroup span {
            font: Normal 200 14px/20px Arial;
            font-family: "微软雅黑";
            padding: 10px;
        }

        #alarm_ulgroup {
            float: left;
            border:1px #ced0da solid;
            background-color: #ffffff;
            border-radius: 4px;
            margin-top:18px;
            font: Normal 200 14px/20px Arial;
            font-size: 18px;
            width:92px;
            height:30px;
            text-align: center;
        }
        #alarm_ulgroup div:hover{
           background-color:#C6C6C6;
            color: white;
            cursor: pointer;
        }

        /*选中状态*/
        .alarm_selectCytime{
            background-color:#2da1f8;
            color: white;
        }

    </style>
</head>
<body>
 <div id="car-warmming" style="width:100%;overflow:scroll;">
     <%--头start--%>
     <div style="padding:0 10px 0 0;">
         <div style="width:100%;height:64px;border:1px #e6eaee solid;padding-left:24px;background-color:white;border-radius:4px 4px 0px 0px">
             <div style="float: left;">
                 <label style="color:#354052;float:left;margin-top:20px;font:Normal 200 14px/20px Arial;">统计周期</label>
             </div>
             <div id="alarm_ulgroup" style="margin-left:5px;">
                 <div id="alarm_day"  time="3" style="float:left;width:30px;line-height:29px;border-right:1px #C6C6C6 solid;border-radius:4px 0 0 4px">日</div>
                 <div id="alarm_week" time="2" style="float:left;width:30px;line-height:29px;border-right:1px #C6C6C6 solid;">周</div>
                 <div id="alarm_moth"  time="1" style="float:left;width:30px;line-height:29px;border-radius:0 4px 4px 0">月</div>
             </div>
         </div>
     </div>
     <%--头end--%>
     <%--中心start--%>
     <div style="padding:0 10px 0 0;">
         <div style="height:500px;width:100%;background-color:white;border-radius:0 0 4px 4px;">
             <%--left--%>
             <div style="width:60%;float:left;padding-top:20px;padding-left:18px;padding-right:10px;">
                 <div style="color:#354052;font-size:18px;">报警热力图</div>
                 <div id="holdMap" style="height:418px;width:100%;border:1px #e6eaee solid;margin-top:18px;"></div>
             </div>
             <%--right--%>
             <div style="width:40%;float:left;padding-left:10px;padding-top:20px;border-left: 1px #e6eaee solid">
                 <div id="alarm_companyPic" style="height:240px;width:100%;color:#354052;font-size:18px;"></div>
                 <div id="alarm_typePic" style="height:240px;width:100%;color:#354052;font-size:18px;"></div>
             </div>
         </div>
     </div>
     <%--中心start--%>
     <%--地图表格start--%>
     <div style="padding:0 10px 0 0;margin-top:18px;height: 260px;">
         <div id="alarm_contextTable" style="background-color:white;widht:100%;border-radius:4px;padding:10px 10px 10px 10px;">
             <select id="alarm_selectType" class="defualt_select" style="margin-left:0px;width:110px;">
                 <option value="1">司机紧急报警</option>
                 <option value="2">集体停运</option>
                 <option value="3">聚集报警</option>
                 <option value="4">重点区域报警</option>
                 <option value="5">禁入报警</option>
                 <option value="6">跨区经营</option>
                 <option value="7">出城报警</option>
                 <option value="8">人车分离</option>
                 <option value="9">超速</option>
                 <option value="10">计价异常</option>
             </select>
             <input id="alarm_starttime" type="text" class="defaultInput hisAlarm_inputTime" placeholder="请选择开始日期">
             <input id="alarm_endtime" type="text" class="defaultInput hisAlarm_inputTime" placeholder="请选择结束日期">
             <input id="alarm_search" type="button" class="btn_blue" value="查&nbsp;询" style="margin-bottom:10px;">
             <div id="hisalarm_tableContext1" style="height:375px">
                 <table id="hisalarm_table1" title="司机紧急报警" class="bootsrapTable" style="width:100%"></table>
             </div>
             <div id="hisalarm_tableContext2" style="height:375px;width:100%;display:none">
                 <table id="hisalarm_table2" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext3" style="height:375px;width:100%;display:none">
                 <table id="hisalarm_table3" title="禁入" class="bootsrapTable"></table>
             </div>

             <div id="hisalarm_tableContext4" style="height:375px;width:100%;display:none">
                 <table id="hisalarm_table4" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext5" style="height:375px;width:100%;display:none;">
                 <table id="hisalarm_table5" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext6" style="height:375px;width:100%;display:none;">
                 <table id="hisalarm_table6" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext7" style="height:375px;width:100%;display:none;">
                 <table id="hisalarm_table7" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext8" style="height:375px;width:100%;display:none;">
                 <table id="hisalarm_table8" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext9" style="height:375px;width:100%;display:none;">
                 <table id="hisalarm_table9" title="禁入" class="bootsrapTable"></table>
             </div>
             <div id="hisalarm_tableContext10" style="height:375px;width:100%;display:none;">
                 <table id="hisalarm_table10" title="禁入" class="bootsrapTable"></table>
             </div>
         </div>
     </div>
     <%--地图表格end--%>
 </div>
</body>
<script>
$(document).ready(function () {

    var xuan = $(window).height();
    var screenWidth = $(window).width();
    //判断360浏览器
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        //=============================
        if(screenWidth > 1400){
            var he=xuan-61;
            $('#car-warmming').css('height',he);
        }else{
            var he1=xuan-38-71;
            $('#car-warmming').css('height',he1);
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
            var he2=xuan-38-107;
            $('#car-warmming').css('height',he2);
    }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
            var he3=xuan-38-95;
            $('#car-warmming').css('height',he3);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        var start = {
            format: 'YYYY-MM-DD'
            ,max: '2099-06-16'
            ,istoday: false
            ,choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            format: 'YYYY-MM-DD'
            ,max: '2099-06-16'
            ,istoday: false
            ,choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('alarm_starttime').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('alarm_endtime').onclick = function(){
            end.elem = this;
            laydate(end);
        }
        
    });

    //地区
    var  alarm_map;//地图
    setTimeout(function () {
        alarm_map = new BMap.Map("holdMap",{enableMapClick:false});
        var point = new BMap.Point(113.689231,34.767422);
        alarm_map.centerAndZoom(point, 15);
        alarm_map.enableScrollWheelZoom(true);//开启鼠标滚轮缩放
    },100)

    //周月日点击事件
    function clickCyTime(cytime){
        var areacode = '';
        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            areacode = $("#city option:selected").val();
        } else {
            areacode = $("#county option:selected").val();
        }
        //热力图
        showAlarmPointsbyCytime(areacode,cytime);
        //各个公司占比
        showAlarmCompanybyCytime(areacode,cytime);
        //各个报警占比
        showAlarmTypebyCytime(areacode,cytime);
    }

    //初始化图表;默认周
    clickCyTime(2);
    $("#alarm_week").addClass("alarm_selectCytime");//选中

    $("#alarm_ulgroup div").click(function(){
        $(this).parent().find("div").removeClass("alarm_selectCytime");
        $(this).addClass("alarm_selectCytime");
        var cytime= $(this).attr("id");
        if(cytime=="alarm_day"){
            clickCyTime(3);
        }else if(cytime=="alarm_week"){
            clickCyTime(2);
        }else if(cytime=="alarm_moth"){
            clickCyTime(1);
        }
    });


    //热力图
    function showAlarmPointsbyCytime(areacode,timeType){
        $.ajax({
            timeout:10000,
            dataType:"json",
            url:"alarm/getThermalPointAlarm",
            data:{
                areacode:areacode,
                cycleTime:timeType
            },
            success:function(data){
                if(data!=null){
                    showHoldMap(data);
                }else{
                    layer.alert("无热力图数据");
                }
            },
            error:function (error,code,throws) {
                layer.alert("无热力图数据");
            }
        })
    }

    var comdata=[{"name":"九九","value":"9.09","color":"#EBB43E"},{"name":"首汽","value":"18.18","color":"#EA5F30"},{"name":"曹操","value":"9.09","color":"#CCA968"},{"name":"神州","value":"63.64","color":"#56D1CA"}];
    //各个公司报警占比 showAlarmCompanybyCytime
    function showAlarmCompanybyCytime(areacode,timeType){
        $.ajax({
            timeout:10000,
            dataType:"json",
            url:"alarm/getProportionCompanyAlarm",
            data:{
                areacode:areacode,
                cycleTime:timeType
            },
            success:function(data){
                if(data!=null&&data.length!=0){
                    showAlarm_netcomapny(data)
                }else{
                    //layer.alert("无各个公司报警占比");

                    showAlarm_netcomapny(data);
                }
            },
            error:function (error,code,throws) {
                layer.alert("无各个公司报警占比");
            }
        })
    }

    //各个报警类型占比
    function showAlarmTypebyCytime(areacode,timeType){
        $.ajax({
            timeout:10000,
            dataType:"json",
            url:"alarm/getProportionAlarmType",
            data:{
                areacode:areacode,
                cycleTime:timeType
            },
            success:function(data){
                if(data!=null&&data.length!=0){
                    showAlarm_type(data);
                }else{
                    var data= [{"name":"聚集报警","value":"30.27","color":"#E08E35"},{"name":"集体停运","value":"18.18","color":"#DF8336"},{"name":"司机紧急报警","value":"50.55","color":"#DF8336"}]
                    showAlarm_type(data);//("查无个报警类型占比");
                }
            },
            error:function (error,code,throws) {
                //layer.alert("查无个报警类型占比");
                var data= [{"name":"聚集报警","value":"30.27","color":"#E08E35"},{"name":"集体停运","value":"18.18","color":"#DF8336"},{"name":"司机紧急报警","value":"50.55","color":"#DF8336"}]
                showAlarm_type(data);//("查无个报警类型占比");
            }
        })
    }

    //生成热力图
    function showHoldMap(points){
        //热力图
        //var points =[{"lng":116.418261,"lat":39.921984,"count":50}];

        var points1 =[
            {"lng":116.418261,"lat":39.921984,"count":50},
            {"lng":116.423332,"lat":39.916532,"count":51},
            {"lng":116.419787,"lat":39.930658,"count":15},
            {"lng":116.418455,"lat":39.920921,"count":40},
            {"lng":116.418843,"lat":39.915516,"count":100},
            {"lng":116.42546,"lat":39.918503,"count":6},
            {"lng":116.423289,"lat":39.919989,"count":18},
            {"lng":116.418162,"lat":39.915051,"count":80},
            {"lng":116.422039,"lat":39.91782,"count":11},
            {"lng":116.41387,"lat":39.917253,"count":7},
            {"lng":116.41773,"lat":39.919426,"count":42},
            {"lng":116.421107,"lat":39.916445,"count":4},
            {"lng":116.417521,"lat":39.917943,"count":27},
            {"lng":116.419812,"lat":39.920836,"count":23},
            {"lng":116.420682,"lat":39.91463,"count":60},
            {"lng":116.415424,"lat":39.924675,"count":8},
            {"lng":116.419242,"lat":39.914509,"count":15},
            {"lng":116.422766,"lat":39.921408,"count":25},
            {"lng":116.421674,"lat":39.924396,"count":21},
            {"lng":116.427268,"lat":39.92267,"count":1},
            {"lng":116.417721,"lat":39.920034,"count":51},
            {"lng":116.412456,"lat":39.92667,"count":7},
            {"lng":116.420432,"lat":39.919114,"count":11},
            {"lng":116.425013,"lat":39.921611,"count":35},
            {"lng":116.418733,"lat":39.931037,"count":22},
            {"lng":116.419336,"lat":39.931134,"count":4},
            {"lng":116.413557,"lat":39.923254,"count":5},
            {"lng":116.418367,"lat":39.92943,"count":3},
            {"lng":116.424312,"lat":39.919621,"count":100},
            {"lng":116.423874,"lat":39.919447,"count":87},
            {"lng":116.424225,"lat":39.923091,"count":32},
            {"lng":116.417801,"lat":39.921854,"count":44},
            {"lng":116.417129,"lat":39.928227,"count":21},
            {"lng":116.426426,"lat":39.922286,"count":80},
            {"lng":116.421597,"lat":39.91948,"count":32},
            {"lng":116.423895,"lat":39.920787,"count":26},
            {"lng":116.423563,"lat":39.921197,"count":17},
            {"lng":116.417982,"lat":39.922547,"count":17},
            {"lng":116.426126,"lat":39.921938,"count":25},
            {"lng":116.42326,"lat":39.915782,"count":100},
            {"lng":116.419239,"lat":39.916759,"count":39},
            {"lng":116.417185,"lat":39.929123,"count":11},
            {"lng":116.417237,"lat":39.927518,"count":9},
            {"lng":116.417784,"lat":39.915754,"count":47},
            {"lng":116.420193,"lat":39.917061,"count":52},
            {"lng":116.422735,"lat":39.915619,"count":100},
            {"lng":116.418495,"lat":39.915958,"count":46},
            {"lng":116.416292,"lat":39.931166,"count":9},
            {"lng":116.419916,"lat":39.924055,"count":8},
            {"lng":116.42189,"lat":39.921308,"count":11},
            {"lng":116.413765,"lat":39.929376,"count":3},
            {"lng":116.418232,"lat":39.920348,"count":50},
            {"lng":116.417554,"lat":39.930511,"count":15},
            {"lng":116.418568,"lat":39.918161,"count":23},
            {"lng":116.413461,"lat":39.926306,"count":3},
            {"lng":116.42232,"lat":39.92161,"count":13},
            {"lng":116.4174,"lat":39.928616,"count":6},
            {"lng":116.424679,"lat":39.915499,"count":21},
            {"lng":116.42171,"lat":39.915738,"count":29},
            {"lng":116.417836,"lat":39.916998,"count":99},
            {"lng":116.420755,"lat":39.928001,"count":10},
            {"lng":116.414077,"lat":39.930655,"count":14},
            {"lng":116.426092,"lat":39.922995,"count":16},
            {"lng":116.41535,"lat":39.931054,"count":15},
            {"lng":116.413022,"lat":39.921895,"count":13},
            {"lng":116.415551,"lat":39.913373,"count":17},
            {"lng":116.421191,"lat":39.926572,"count":1},
            {"lng":116.419612,"lat":39.917119,"count":9},
            {"lng":116.418237,"lat":39.921337,"count":54},
            {"lng":116.423776,"lat":39.921919,"count":26},
            {"lng":116.417694,"lat":39.92536,"count":17},
            {"lng":116.415377,"lat":39.914137,"count":19},
            {"lng":116.417434,"lat":39.914394,"count":43},
            {"lng":116.42588,"lat":39.922622,"count":27},
            {"lng":116.418345,"lat":39.919467,"count":8},
            {"lng":116.426883,"lat":39.917171,"count":3},
            {"lng":116.423877,"lat":39.916659,"count":34},
            {"lng":116.415712,"lat":39.915613,"count":14},
            {"lng":116.419869,"lat":39.931416,"count":12},
            {"lng":116.416956,"lat":39.925377,"count":11},
            {"lng":116.42066,"lat":39.925017,"count":38},
            {"lng":116.416244,"lat":39.920215,"count":91},
            {"lng":116.41929,"lat":39.915908,"count":54},
            {"lng":116.422116,"lat":39.919658,"count":21},
            {"lng":116.4183,"lat":39.925015,"count":15},
            {"lng":116.421969,"lat":39.913527,"count":3},
            {"lng":116.422936,"lat":39.921854,"count":24},
            {"lng":116.41905,"lat":39.929217,"count":12},
            {"lng":116.424579,"lat":39.914987,"count":57},
            {"lng":116.42076,"lat":39.915251,"count":70},
            {"lng":116.425867,"lat":39.918989,"count":8}];

        var centerPoint = new BMap.Point(points[0].lng,points[0].lat);
        alarm_map.panTo(centerPoint,true);

        if(!isSupportCanvas()){
            alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
        }
        var heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":20});
        alarm_map.addOverlay(heatmapOverlay);
        heatmapOverlay.setDataSet({data:points,max:100});
        heatmapOverlay.show();
    }


    //各个公司报警占比
    function showAlarm_netcomapny(data){
        new iChart.Bar2D({
            render : 'alarm_companyPic',
            data:data,
            title:'各公司报警类型占比',
            showpercent:true,
            decimalsnum:2,
            width :400,
            height :230,
            coordinate:{
                scale:[{
                    position:'bottom',
                    start_scale:0,
                    end_scale:110,
                    scale_space:10,
                    listeners:{
                        parseText:function(t,x,y){
                            return {text:t}
                        }
                    }
                }]
            }
        }).draw();
    }

//    showAlarm_netcomapny();
//    showAlarm_type()
    //各个报警占比
    function showAlarm_type(data){
        var chart = new iChart.Donut2D({
            render : 'alarm_typePic',
            title : {
                text : '各报警占比',
                color : '#354052'
            },
            data: data,
            sub_option : {
                label : false,
                border : false
            },
            legend:{
                enable:true,
                padding:60,
                offsetx:50,
                color:'#3e576f',//
                fontsize:12,//文本大小
                sign_size:12,//小图标大小
                line_height:16,//设置行高
                sign_space:5,//小图标与文本间距
                border:false,
                valign:'bottom',
                background_color : null//透明背景
            },
            align : 'left',
            offsetx:0,
            separate_angle:10,//分离角度
            shadow : true,
            shadow_blur : 2,
            shadow_color : '#aaaaaa',//
            shadow_offsetx : 0,
            shadow_offsety : 0,
           // background_color:'#f3f3f3',
            width :420,
            height :230,
            radius:150
        });
        chart.draw();
    }



    //下拉框
    $("#alarm_selectType").change( function() {
        var alarmtypeid = $("#alarm_selectType option:selected").val();
        $("#alarm_search").nextAll().hide();
        switch (alarmtypeid) {
            case "1":
                $("#hisalarm_tableContext1").show();
                break;
            case "2":
                $("#hisalarm_tableContext2").show();
                break;
            case "3":
                $("#hisalarm_tableContext3").show();
                break;
            case "4":
                $("#hisalarm_tableContext4").show();
                break;
            case "5":
                $("#hisalarm_tableContext5").show();
                break;
            case "6":
                $("#hisalarm_tableContext6").show();
                break;
            case "7":
                $("#hisalarm_tableContext7").show();
                break;
            case "8":
                $("#hisalarm_tableContext8").show();
                break;
            case "9":
                $("#hisalarm_tableContext4").show();
                break;
            case "10":
                $("#hisalarm_tableContext10").show();
                break;
        }
    });


    $("#alarm_search").click(function () {
        var alarmtypeid = $("#alarm_selectType option:selected").val();
        switch (alarmtypeid) {
            case "1":
                $("#hisalarm_table1").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "2":
                $("#hisalarm_table2").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "3":
                $("#hisalarm_table3").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "4":
                $("#hisalarm_table4").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "5":
                $("#hisalarm_table5").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "6":
                $("#hisalarm_table6").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "7":
                $("#hisalarm_table7").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "8":
                $("#hisalarm_table8").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "9":
                $("#hisalarm_table9").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            case "10":
                $("#hisalarm_table10").bootstrapTable("refresh", {url: "alarm/getAlarmByTypeTime"}, {query: {order: "asc"}});
                break;
            default:
        }
    });


    //1.sos
    $('#hisalarm_table1').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            //areacode, String alarmTypeid, String starttme, String endtime, String sort, String limit, String offset
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:1,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 260,
        columns: [{
            field: 'id',
            title: '编号',
            formatter: function (value, row, index) {
                return index+1;
            }},{
            field: 'vehicleNo',
            title: '车牌',
            align: "center"
        }, {
            field: 'addressName',
            title: '地区',
            align: "center"
        },{
            field: 'position',
            title: '地址',
            align: "center"
        },{
            field: 'alarmTime',
            title: '报警时间',
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            },
            align: "center"
        },{
            field: 'state',
            title: '是否处理',
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            },
            align: "center"
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        },{
            field: 'processTime',
            title: '处理时间',
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            },
            align: "center"
        },{
            field: 'userid',
            title: '处理用户id',
            align: "center"
        }]
    })


 //集体停运
    $('#hisalarm_table2').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:2,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            formatter: function (value, row, index) {
                return index+1;
            },
            align: "center"
        },{
            field: 'ougageNum',
            title: '停运数',
            align: "center"
        }, {
            field: 'vechileTotal',
            title: '车辆总数',
            align: "center"
        },{
            field: 'companyName',
            title: '公司名称',
            align: "center"
        },{
            field: 'addressName',
            title: '地区名称',
            align: "center"
        },{
            field: 'alarmTime',
            title: '报警时间',
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            },
            align: "center"
        },{
            field: 'state',
            title: '是否处理',
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            },
            align: "center"
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        },{
            field: 'processTime',
            title: '处理时间',
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            },
            align: "center"
        }]
    })

    //3	聚集报警
    $('#hisalarm_table3').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:3,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            formatter: function (value, row, index) {
                return index+1;
            },
            align: "center"
        },{
            field: 'position',
            title: '位置',
            align: "center"
        },{
            field: 'longitude',
            title: '经度',
            align: "center"
        },{
            field: 'latitude',
            title: '纬度',
            align: "center"
        },{
            field: 'vehiclenum',
            title: '聚集车辆数',
            align: "center"
        },{
            field: 'alarmtime',
            title: '报警时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        },{
            field: 'state',
            title: '是否处理',
            align: "center",
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        }]
    })

    //重点区域
    $('#hisalarm_table4').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:4,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,

        columns: [{
            field: 'id',
            title: '编号',
            formatter: function (value, row, index) {
                return index+1;
            },
            align: "center"
        },{
            field: 'areaName',
            title: '重点区域名称',
            align: "center"
        },{
            field: 'addressName',
            title: '地区名称',
            align: "center"
        }, {
            field: 'vehicleNum',
            title: '车辆数',
            align: "center"
        },{
            field: 'alarmTime',
            title: '报警时间',
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            },
            align: "center"
        },{
            field: 'state',
            title: '是否处理',
            align: "center",
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        },{
            field: 'processTime',
            title: '处理时间',
            align: "center"
        }]
    })


    //禁入报警(围栏)
    $('#hisalarm_table5').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:5,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            align: "center",
            formatter: function (value, row, index) {
                return index+1;
            }},
            {
                field: 'vehicleno',
                title: '车牌号',
                align: "center"
            },
            {
                field: 'driverName',
                title: '驾驶员姓名',
                align: "center"
            },
          {
            field: 'fenceName',
            title: '围栏名称',
            align: "center"
          },{
                field: 'addressName',
                title: '地区名称',
                align: "center"
            },{
                field: 'companyName',
                title: '公司名称',
                align: "center"
            },
            {
            field: 'alarmtime',
            title: '报警时间',
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            },
                align: "center"
        },{
            field: 'state',
            title: '是否处理',
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            },
                align: "center"
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        },{
                field: 'processtime',
                title: '处理时间',
                align: "center"
            }]
    })

    //跨区
    $('#hisalarm_table6').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:6,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            align: "center",
            formatter: function (value, row, index) {
                return index+1;
            }},
            {
                field: 'companyName',
                title: '公司名称',
                align: "center"
            },
            {
                field: 'driverName',
                title: '驾驶员名称',
                align: "center"
            },
            {
            field: 'vehicleno',
            title: '车牌',
            align: "center"
        }, {
            field: 'orderid',
            title: '订单编号',
            align: "center"
        },{
                field: 'depposition',
                title: '上车位置',
                align: "center"
            },{
                field: 'destposition',
                title: '下车位置',
                align: "center"
            },
            {
            field: 'address',
            title: '经营区划',
            align: "center"
        }, {
            field: 'realaddress',
            title: '实际经营区划',
            align: "center"
        },{
            field: 'alarmtime',
            title: '报警时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        },{
            field: 'state',
            title: '是否处理',
            align: "center",
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        }]
    })

    //出城
    $('#hisalarm_table7').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:7,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            align: "center",
            formatter: function (value, row, index) {
                return index+1;
            }},{
            field: 'vehicleno',
            title: '车牌',
            align: "center"
        },{
            field: 'driverName',
            title: '车牌',
            align: "center"
        },{
            field: 'position',
            title: '出城地点',
            align: "center"
        }, {
            field: 'companyName',
            title: '公司名称',
            align: "center"
        }, {
            field: 'vehicleposition',
            title: '车辆位置',
            align: "center"
        },{
            field: 'alarmtime',
            title: '报警时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        },{
            field: 'state',
            title: '是否处理',
            align: "center",
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        },{
            field: 'processtime',
            title: '处理时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        }]
    })


    //人车分离
    $('#hisalarm_table8').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:8,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            align: "center",
            formatter: function (value, row, index) {
                return index+1;
            }},{
            field: 'vehicleno',
            title: '车牌',
            align: "center",
        },{
            field: 'driverName',
            title: '驾驶员名称',
            align: "center"
        }, {
            field: 'companyName',
            title: '公司名称',
            align: "center"
        },{
        field: 'driverposition',
                title: '司机位置',
                align: "center"
         }, {
            field: 'vehicleposition',
            title: '车辆位置',
            align: "center"
        }, {
            field: 'orderid',
            title: '订单编号',
            align: "center"
        },{
            field: 'alarmtime',
            title: '报警时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        },{
            field: 'state',
            title: '是否处理',
            align: "center",
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果'
        },{
            field: 'processtime',
            title: '处理时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        },]
    })

    //超速
    $('#hisalarm_table9').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:9,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            formatter: function (value, row, index) {
                return index+1;
            }},{
            field: 'vehicleno',
            title: '车牌',
            align: "center"
        }, {
            field: 'address',
            title: '地址',
            align: "center"
        },{
            field: 'alarmtime',
            title: '报警时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toDateString();
            }
        },{
            field: 'state',
            title: '是否处理',
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果'
        }]
    })

    //计价
    $('#hisalarm_table10').bootstrapTable({
        classes: "table-no-bordered",
        queryParams: function (parme) {
            var areacode = '';
            var selectCount = $("#county option:selected").text();
            if (selectCount == '所有') {
                areacode = $("#city option:selected").val();
            } else {
                areacode = $("#county option:selected").val();
            }
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                alarmTypeid:10,
                starttme:$("#alarm_starttime").val(),
                endtime:$("#alarm_endtime").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "id",
        searchTimeOut:5000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize:10,//	如果设置了分页，页面数据条数
        pageList: [10, 10, 30],
        singleSelect: true,//禁止多选
        height: 370,
        columns: [{
            field: 'id',
            title: '编号',
            formatter: function (value, row, index) {
                return index+1;
            }},
            {
            field: 'vehicleno',
            title: '车牌',
            align: "center"
        },{
            field: 'driverName',
            title: '驾驶员名称',
            align: "center"
        },{
            field: 'companyName',
            title: '公司名称',
            align: "center"
        }, {
            field: 'orderid',
            title: '订单号',
            align: "center"
        }, {
            field: 'ordermileage',
            title: '订单里程',
            align: "center"
        }, {
            field: 'ordertime',
            title: '订单时间',
            align: "center"
        }, {
            field: 'ordermoney',
            title: '订单金额',
            align: "center"
        }, {
            field: 'avespeed',
            title: '平均速度',
            align: "center"
        }, {
            field: 'type',
            title: '异常类型',
            align: "center",
            formatter: function (value, row, index) {
                return value==0?"速度异常":"价格异常";
            }
        },{
            field: 'alarmtime',
            title: '报警时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        },{
            field: 'state',
            title: '是否处理',
            align: "center",
            formatter: function (value, row, index) {
                return value==1?"已处理":"未处理";
            }
        },{
            field: 'result',
            title: '处理结果',
            align: "center"
        },{
            field: 'processtime',
            title: '处理时间',
            align: "center",
            formatter:function(value, row, index){
                return new Date(value).toLocaleString();
            }
        }]
    })

})
</script>
</html>