<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<div class="index-top">
    <div class="index-top-left">
        <p id="today-count"></p>
        <div>
            <div class="index-top-bar1">
                <img src="./pic/hp_today_orders.png">&nbsp;订单数
            </div>
            <div class="index-top-bar2">39394949</div>
        </div>
        <div>
            <div class="index-top-bar1">
                <img src="./pic/hp_today_orders.png">&nbsp;营运里程
            </div>
            <div class="index-top-bar2">39394949</div>
        </div>
        <div>
            <div class="index-top-bar1">
                <img src="./pic/hp_today_orders.png">&nbsp;营运金额
            </div>
            <div class="index-top-bar2">39394949</div>
        </div>
    </div>
    <div class="index-top-right">
        <div>
            <div class="index-top-bar3"><img src="./pic/index/hp_carryPasRate.png"></div>
            <div class="index-top-bar4">
                <p>重载率</p>
                <p>12%</p>
            </div>
        </div>
        <div class="index-top-count">
            <div>
                <span>今日司机数:</span>20<img src="./pic/index/up.png">
            </div>
            <div>
                <span>今日乘客数:</span>-29<img src="./pic/index/down.png">
            </div>
        </div>
        <div class="index-top-count">
            <div style="font-size:12px"><img style="width:20px" src="./pic/index/hp_warning.png">未读报警</div>
            <div>10</div>
        </div>
    </div>
</div>

<div id="index-nth2">
    <div>
        <center class="index-nth2-left">
            <p>车辆在线率</p>
            <div class="GaugeMeter" data-animate_gauge_colors="1" data-animate_text_colors="1" id="GaugeMeter_91" data-percent="90" data-append="%" data-size="190" data-color="#D3EC5F" data-back="#F0F0F0" data-width="13"   data-style="Arch"  data-label_color="#FFFFFF"></div>
        </center>
        <center class="index-nth2-left">
            <p>司机签到率</p>
            <div class="GaugeMeter" data-animate_gauge_colors="2" data-animate_text_colors="1" id="GaugeMeter_91" data-percent="45" data-append="%" data-size="190" data-color="#F26E42" data-back="#F0F0F0" data-width="13"   data-style="Arch"  data-label_color="#FFFFFF"></div>
        </center>
        <center class="index-nth2-left">
            <p>用户活跃率</p>
            <div class="GaugeMeter" data-animate_gauge_colors="2" data-animate_text_colors="1" id="GaugeMeter_91" data-percent="80" data-append="%" data-size="190" data-color="#E5C73B" data-back="#F0F0F0" data-width="13"   data-style="Arch"  data-label_color="#FFFFFF"></div>
        </center>
    </div>

    <div>
        <div id="canvasDiv"></div>
    </div>
</div>

<div class="index-nth3">
    <center>
        <p>叫车量和订单量(昨日时间分布图)</p>
        <div id="canvasDiv2"></div>
    </center>
    <center>
        <p>叫车和订单量(各公司)</p>
        <div id="canvasDiv3"></div>
    </center>
</div>

<!-- 热力图 -->
<div class="index-nth4">
    <p>用车热力图</p>
    <div id="indexmap"></div>
</div>
<script type="text/javascript">
    $(".GaugeMeter").gaugeMeter();
    //获取客户端时间
    var myDate = new Date();
    var nowdate = myDate.toLocaleDateString().replace(/\//g, "-");
    var nowtime = myDate.toLocaleTimeString().split(':');
    $('#today-count').html('今日数据统计<span>&nbsp;(截止到'+nowdate+nowtime[0]+':'+nowtime[1]+')</span>');

    //icharjs----------------------------
    var data = [
        {name : '神舟专车',value : 30,color:'#fedd74'},
        {name : '滴滴出行',value : 25,color:'#82d8ef'},
        {name : '99出行',value : 15,color:'#f76864'},
        {name : '首期约车',value : 20,color:'#80bd91'},
        {name : '一步用车',value : 10,color:'#fd9fc1'}
    ];

    var chart = new iChart.Donut2D({
        render : 'canvasDiv',
        center:{
            text:'订单量\n分析',
            shadow:true,
            shadow_offsetx:0,
            shadow_offsety:2,
            shadow_blur:2,
            shadow_color:'#b7b7b7',
            color:'#6f6f6f'
        },
        data: data,
        donutwidth:34,
        offsetx:-60,
        shadow:true,
        background_color:'#ffffff',
        separate_angle:10,//分离角度
        tip:{
            enable:true,
            showType:'fixed'
        },
        legend : {
            enable : true,
            shadow:true,
            background_color:null,
            border:false,
            legend_space:1,//图例间距
            line_height:15,//设置行高
            sign_space:5,//小图标与文本间距
            sign_size:10,//小图标大小
            color:'#6f6f6f',
            fontsize:11//文本大小
        },
        sub_option:{
            label:false,
            color_factor : 0.3
        },
        showpercent:true,
        decimalsnum:4,
        width : 340,
        height : 240,
        radius:130
    });

    chart.draw();

    // 用车趋势图------------------------------
    var pv=[],ip=[],t;
    //创建随机数据
    for(var i=0;i<25;i++){
        t = Math.floor(Math.random()*(30+((i%12)*5)))+10;
        pv.push(t);
        t = Math.floor(t*0.5);
        t = t-Math.floor((Math.random()*t)/2);
        ip.push(t);
    }

    var data = [
        {
            name : '叫车量',
            value:pv,
            color:'#aad0db',
            line_width:3
        },
        {
            name : '订单量',
            value:ip,
            color:'#f68f70',
            line_width:3
        }
    ];

    //创建x轴标签文本

    var labels = ["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"];

    var chart = new iChart.LineBasic2D({
        render : 'canvasDiv2',
        data: data,
        align:'center',
        width : 530,
        height : 380,
        background_color:'#FEFEFE',
        tip:{
            enable:true,
            shadow:true,
            move_duration:400,
            border:{
                enable:true,
                radius : 5,
                width:1,
                color:'#3f8695'
            },
            listeners:{
                //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                parseText:function(tip,name,value,text,i){
                    return name+":"+value+"万";
                }
            }
        },
        tipMocker:function(tips,i){
            return "<div style='font-weight:600'>"+
                    labels[i]+":00点"+
                    "</div>"+tips.join("<br/>");
        },
        legend : {
            enable : true,
            row:2,//设置在一行上显示，与column配合使用
            column : 'max',
            valign:'top',
            sign:'bar',
            background_color:null,//设置透明背景
            offsetx:-40,//设置x轴偏移，满足位置需要
            border : true
        },
        crosshair:{
            enable:true,
            line_color:'#62bce9'//十字线的颜色
        },
        sub_option : {
            label:false,
            point_size:12
        },
        coordinate:{
            width:414,
            height:270,
            axis:{
                color:'#dcdcdc',
                width:1
            },
            scale:[{
                position:'left',
                start_scale:0,
                end_scale:100,
                scale_space:10,
                scale_size:2,
                scale_color:'#9f9f9f'
            },{
                position:'bottom',
                end_scale:100,
                labels:labels
            }]
        }
    });

    //利用自定义组件构造左侧说明文本
    chart.plugin(new iChart.Custom({
        drawFn:function(){
            //计算位置
            var coo = chart.getCoordinate(),
                    x = coo.get('originx'),
                    y = coo.get('originy'),
                    w = coo.width,
                    h = coo.height;
            //在左上侧的位置，渲染一个单位的文字
            chart.target.textAlign('start')
                    .textBaseline('bottom')
                    .textFont('600 11px 微软雅黑')
                    .fillText('单位(万)',x-40,y-12,false,'#9d987a')
                    .textBaseline('top')
                    .fillText('时',x+w+12,y+h+10,false,'#9d987a');

        }
    }));
    //开始画图
    chart.draw();

    //公司订单转化量对比----------------------------
    var data = [
        {
            name : '叫车量',
            value:[60,80,105,125,108,120],
            color:'#1385a5'
        },
        {
            name : '订单量',
            value:[45,52,54,74,90,84],
            color:'#c56966'
        }
    ];
    var chart = new iChart.ColumnMulti2D({
        render : 'canvasDiv3',
        data: data,
        labels:["滴滴出行","神州专车","首期集团","99出行","一步用车"],
        width : 500,
        height : 390,
        background_color : '#ffffff',
        legend : {
            enable : true,
            row:2,//设置在一行上显示，与column配合使用
            column : 'max',
            valign:'top',
            sign:'bar',
            background_color:null,//设置透明背景
            offsetx:-30,//设置x轴偏移，满足位置需要
            border : true
        },
        coordinate:{
            background_color : '#f1f1f1',
            scale:[{
                position:'left',
                start_scale:0,
                end_scale:140,
                scale_space:20
            }],
            width:410,
            height:270
        }
    });
    //利用自定义组件构造左侧说明文本
    chart.plugin(new iChart.Custom({
        drawFn:function(){
            //计算位置
            var coo = chart.getCoordinate(),
                    x = coo.get('originx'),
                    y = coo.get('originy'),
                    w = coo.width,
                    h = coo.height;
            //在左上侧的位置，渲染一个单位的文字
            chart.target.textAlign('start')
                    .textBaseline('bottom')
                    .textFont('600 11px 微软雅黑')
                    .fillText('单位(万)',x-40,y-12,false,'#9d987a')
                    .textBaseline('top')
                    .fillText('公司',x+w+12,y+h+10,false,'#9d987a');

        }
    }));
    chart.draw();


    // 加载热力图
    map = new BMap.Map("indexmap");
    var point = new BMap.Point(116.418261, 39.921984);
    map.centerAndZoom(point, 15);
    // 地图缩略图
    var overView = new BMap.OverviewMapControl();
    var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
    map.addControl(overView);
    map.addControl(overViewOpen);

    // 地图控件
    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
    var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
    var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL});
    map.addControl(top_left_control);
    map.addControl(top_left_navigation);
    map.addControl(top_right_navigation);

    //搞点假数据
    var points =[
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

    if(!isSupportCanvas()){
        alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
    }
    //详细的参数,可以查看heatmap.js的文档 https://github.com/pa7/heatmap.js/blob/master/README.md
    //参数说明如下:
    /* visible 热力图是否显示,默认为true
     * opacity 热力的透明度,1-100
     * radius 势力图的每个点的半径大小   
     * gradient  {JSON} 热力图的渐变区间 . gradient如下所示
     *  {
     .2:'rgb(0, 255, 255)',
     .5:'rgb(0, 110, 255)',
     .8:'rgb(100, 0, 255)'
     }
     其中 key 表示插值的位置, 0~1.
     value 为颜色值.
     */
    // heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":20});
    // map.addOverlay(heatmapOverlay);
    // heatmapOverlay.setDataSet({data:points,max:100});

    // heatmapOverlay.show();

    function setGradient(){
        /*格式如下所示:
         {
         0:'rgb(102, 255, 0)',
         .5:'rgb(255, 170, 0)',
         1:'rgb(255, 0, 0)'
         }*/
        var gradient = {};
        var colors = document.querySelectorAll("input[type='color']");
        colors = [].slice.call(colors,0);
        colors.forEach(function(ele){
            gradient[ele.getAttribute("data-key")] = ele.value;
        });
        heatmapOverlay.setOptions({"gradient":gradient});
    }
    //判断浏览区是否支持canvas
    function isSupportCanvas(){
        var elem = document.createElement('canvas');
        return !!(elem.getContext && elem.getContext('2d'));
    }

</script>
</html>