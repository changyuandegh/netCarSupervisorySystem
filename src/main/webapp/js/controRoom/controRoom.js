/**
 * Created by Mander on 2017/5/9.
 * 监控室
 */
/*************历史轨迹start**************************/
var start = {
    elem: '#tanceStarttime',
    format: 'YYYY-MM-DD hh:mm:ss',
    max: laydate.now(), //最大日期
    istime: true,
    istoday: false,
};
var end = {
    elem: '#tance_text_endttime',
    format: 'YYYY-MM-DD hh:mm:ss',
    max: laydate.now(),
    istime: true,
    istoday: false
};
laydate(start);
//laydate(end);


setTimeout(function () {

    var tranceMap;//地图全局变量
    var trance_area = '';

    tranceMap = new BMap.Map("trance_mapShow"); // 创建Map实例
    tranceMap.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
    tranceMap.setCurrentCity("北京");   // 设置地图显示的城市 此项是必须设置的
    tranceMap.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

    $("#trance_mapZoomOut").click(function () {
        tranceMap.zoomOut();
    });
    $("#trance_mapZoomIn").click(function () {
        tranceMap.zoomIn();
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
        $.ajax({
            url: "netcar/getByVehiclenoTime",
            dataType: "json",
            data: {
                address:trance_areacode,
                vehicleno: vehichleno,
                starttime: stime,
                endtime: etime
            },
            success: function (data) {
                if (data != null) {
                    $("#trance_carInfo span[name='vehichleno']").text(data.vehicleno);
                    $("#trance_carInfo span[name='model']").text(data.model);
                    $("#trance_carInfo span[name='vehiclecolor']").text(data.vehiclecolor);
                    $("#trance_driverContent").empty();
                    for(var i=0;i<data.driverList.length;i++){
                        var driver= data.driverList[i];
                        var html="<div><div>姓名:<span>"+driver.drivername+"</span></div><div>性别:<span>"+driver.drivergender+"</span></div><div>身份证号:<span>"+driver.licenseid+"</span></div> <div>注册时间:<span>"+driver.contracton+"</span></div> </div>";
                        $("#trance_driverContent").append(html);
                    }
                    findTrance($.trim($("#tance_text_vehicleno").val()),$("#tance_text_starttime").val(),$("#tance_text_endttime").val());
                }else{
                    layer.tips('未找到相关信息', '#trance_searchBtn');
                }
            },
            error: function (error,errorcode,th) {
                //layer.msg("出现异常,请稍候再试....."+errorcode);
                layer.tips('查无相关信息', '#trance_searchBtn');
            }
        })
    }
});


//车辆轨迹查询
var polyline;//轨迹线;
function findTrance(vehicleno,starttime,endtime){
    $.ajax({
        url: "netcar/getDevicegps",
        dataType: "json",
        data: {
            vehicleno:vehicleno,
            starttime:starttime,
            endtime:endtime
        },
        success: function (showGpsList) {
            if (showGpsList != null) {
                tranceMap.removeOverlay(polyline);//移除覆盖物
                var points=[];
                //showGpsList.length
                for(var i=0;i<3;i++){
                    var point= new BMap.Point(showGpsList[i].lng,showGpsList[i].lat);
                    points.push(point);
                }
                //添加覆盖物
                tranceMap.setViewport(points);
                polyline = new BMap.Polyline(points,{strokeColr:"blue",strokeWeight:2,strokeOpacity:0.5});
                tranceMap.addOverlay(polyline);
            }else{
                layer.msg("查无相关轨迹数据");
            }
        },
        error: function (error,errorcode,th) {
            layer.msg("查无相关轨迹数据");
        }
    })
}

//订单查询
function findOrders(vehicleno,starttime,endtime){
    $.ajax({
        url: "netcar/getDevicegps",
        dataType: "json",
        data: {
            vehicleno:vehicleno,
            starttime:starttime,
            endtime:endtime
        },
        success: function (data) {
            if (data != null) {

            }else{
                layer.tips('未找到相关信息', '#trance_searchBtn');
            }
        },
        error: function (error,errorcode,th) {
            //layer.msg("出现异常,请稍候再试....."+errorcode);
            layer.tips('查无相关信息', '#trance_searchBtn');
        }
    })
}

//速度曲线图
function speed(){
    var data = [
        {
            name : '北京',
            value:[-9,1,12,20,26,30,32,29,22,12,0,-6],
            color:'#1a91eb',
            line_width:2
        }
    ];
    var chart = new iChart.LineBasic2D({
        render :'trance_speedChart',
        data: data,
        title : '北京2012年平均温度情况',
        width : 400,
        height : 300,
        coordinate:{height:'80%'},
        sub_option:{
            hollow_inside:false,//设置一个点的亮色在外环的效果
            point_size:10
        },
        labels:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
    });
    chart.draw();
    //#efefef x
}
speed();

}, 100);
/*************历史轨迹end**************************/
