/**
 * Created by Mander on 2017/5/4.
 * 首页
 */



/***中心内容tab标签start****/
layui.use('element', function () {
    element = layui.element();
    element.on('tab(onelist)', function(data){
        console.log(data);
    });
});


//页面加载完毕调用事件
$(function () {
    //地区初始化
    var areaid= $("#head-area select:eq(0)").attr("id");
    if(areaid=="city"){
        var areaname= $("#city option:selected").text();
        if(areaname!='所有'){
            var areacode= $("#city option:selected").val();
            $.ajax({
                data: {areacode:areacode},
                dataType: "json",
                url: "user/findChildrenBycode",
                success: function (areas) {
                    if (areas.length != 0 & areas != null) {
                        var html = " <select id='county' class='area_select'>";
                        for (var i = 0; i < areas.length; i++) {
                            var area = areas[i];
                            html += "<option value='"+area.code+"'>"+area.name+"</option>";
                        }
                        html += "</select>";
                        $("#distinction").before(html);
                    }
                }
            });
        }else{
            $("#distinction").before("<select id='county' class='area_select'><option>所有</option></select>");
        }
    }else if(areaid=="county"){

    }

    //中心内容超出滚动
    // 初始化窗口高度
    var h = window.screen.availHeight-120-110;
    $('.layui-tab-content').css('height',h+'px');
    $('#menu-list').css('height',h+50+'px');

    // 左侧菜单事件
    $(".treebox .level1>a").click(function () {
        $(this).addClass('current')   //给当前元素添加"current"样式
            .find('i').addClass('down')   //小箭头向下样式
            .parent().next().slideDown('slow', 'easeOutQuad')  //下一个元素显示
            .parent().siblings().children('a').removeClass('current')//父元素的兄弟元素的子元素去除"current"样式
            .find('i').removeClass('down').parent().next().slideUp('slow', 'easeOutQuad');//隐藏
        return false;
    });
})



//add对应选项卡事件
function addTab(tabURL,tabTitle) {
    if(tabURL.length!=0){
        var o = 1;
        //判断是否已经打开中
        $('.layui-tab-title>li').each(function () {
            if ($(this).attr('lay-id') == tabURL) {
                element.tabChange('onelist', tabURL); //切换到这一项
                o = false;
            }
        })
        if (!o) {
            return false;
        }

        //拉取内容页面
        $.ajax({
            url:tabURL,
            dataType: 'html',
            async: false,
            success: function (str) {
                element.tabAdd('onelist', {
                    title:tabTitle,
                    content: str ,//支持传入html
                    id: tabURL
                });
                element.tabChange('onelist',tabURL);
            },
            error: function () {
                layer.alert("开发中，敬请期待！");
            }
        })
    }else{
        layer.alert("开发中，敬请期待！");
    }
}
/******中心内容tab标签end***/

/*********头部start*************/
//地区处理
$("#head-area").delegate("#city","change", function() {
    $.ajax({
        data: {areacode:$(this).val()},
        dataType: "json",
        url: "user/findChildrenBycode",
        success: function (areas) {
            var html="<option>所有</option>";
            if (areas.length != 0 & areas != null) {
                for (var i = 0; i < areas.length; i++) {
                    var area = areas[i];
                    html += "<option value='"+area.code+"'>"+area.name+"</option>";
                }
            }
            $("#county").empty();
            $("#county").append(html);
        }
    });
});



//退出登录
$('.head-user').mouseover(function(){
    $('#login-out').show();
}).mouseout(function(){$('#login-out').hide()});

/*********头部end*************/

/************首页内容图表start********************/

var index_map=new BMap.Map("indexmap");

var chart1data = [
    {name : '神舟专车',value : 170,color:'#fedd74'},
    {name : '滴滴出行',value : 300,color:'#82d8ef'},
    {name : '99出行',value :100,color:'#f76864'},
    {name : '首期约车',value : 120,color:'#80bd91'},
    {name : '一步用车',value : 150,color:'#fd9fc1'}
];


var chart1 = new iChart.Donut2D({
    render : 'canvasDiv',
    center:{
        shadow:false,
        shadow_offsetx:0,
        shadow_offsety:2,
        shadow_blur:2,
        shadow_color:'#b7b7b7',
        color:'#6f6f6f'
    },
   // data:JSON.parse($("#canvasDiv").attr("data")),
    data:chart1data,
    donutwidth:17,
    offsetx:0,
    shadow:false,
    background_color:'#ffffff',
    separate_angle:0,//分离角度
    tip:{
        enable:true,
        showType:'fixed'
    },
    sub_option : {
        label : {
            background_color:null,
            sign:false,//设置禁用label的小图标
            padding:'0 4',
            border:{
                enable:false,
                color:'#666666'
            },
            fontsize:11,
            fontweight:600,
            color : '#4572a7'
        },
        border : {
            width : 2,
            color : '#ffffff'
        }
    },
    showpercent:true,
    decimalsnum:2,
    width : 415,
    height : 230,
    radius:80
});
chart1.draw();


// 用车趋势图------------------------------
setTimeout(function () {


var callcount=[5,8,9,11,13,14,15,7,6,11];//叫车量
var ordercount=[4,6,7,10,11,12,13,5,6,9];//订单量
var canvasDiv2labels = ['10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00'];////创建x轴标签文本

var canvas2json=JSON.parse($("#canvasDiv2").attr("data"));
    if(canvas2json.length!=0){
        for(var i=0;i<canvas2json.length;i++){
           // canvasDiv2labels.push(canvas2json[i].name);
           // callcount.push(canvas2json[i].desc);
            //ordercount.push(canvas2json[i].value);
        }
    }

    // var callcount=[45,34];//叫车量
    // var ordercount=[65,44];//订单量
    // var canvasDiv2labels = ['12:00:00','13:00:00'];////创建x轴标签文本

    var canvasDiv2data = [
        {
            name : '叫车量',
            value:callcount,
            color:'#6C84BF',
            line_width:3
        },
        {
            name : '订单量',
            value:ordercount,
            color:'#E8BE2A',
            line_width:3
        }
    ];
var chart2 = new iChart.LineBasic2D({
    animation : true,//开启过渡动画
    animation_duration:600,//600ms完成动画
    render : 'canvasDiv2',
    data: canvasDiv2data,
    align:'center',
    width : 530,
    height : 550,
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
            canvasDiv2labels[i]+"</div>"+tips.join("<br/>");
    },
    legend : {
        enable : true,
        row:2,//设置在一行上显示，与column配合使用
        column : 'max',
        valign:'top',
        sign:'bar',
        background_color:null,//设置透明背景
        offsetx:-10,//设置x轴偏移，满足位置需要
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
        width:471,
        height:400,
        axis:{
            color:'#dcdcdc',
            width:1
        },
        scale:[{
            position:'left',
            start_scale:0,
            end_scale:20,
            scale_space:10,
            scale_size:2,
            scale_color:'#9f9f9f'
        },{
            position:'bottom',
            end_scale:100,
            labels:canvasDiv2labels
        }]
    }
});

//利用自定义组件构造左侧说明文本
chart2.plugin(new iChart.Custom({
    drawFn:function(){
        //计算位置
        var coo = chart2.getCoordinate(),
            x = coo.get('originx'),
            y = coo.get('originy'),
            w = coo.width,
            h = coo.height;
        //在左上侧的位置，渲染一个单位的文字
        chart2.target.textAlign('start')
            .textBaseline('bottom')
            .textFont('600 11px 微软雅黑')
            .fillText('    单位(万)',x-40,y-12,false,'#9d987a')
            .textBaseline('top')
            .fillText('时',x+w+12,y+h+10,false,'#9d987a');
    }
}));

chart2.draw();

//公司订单转化量对比----------------------------
var canvasDiv3call=[];//叫车量
var canvasDiv3order=[];//订单量
var canvasDiv3labels=[];

var canvasDiv3=JSON.parse($("#canvasDiv3").attr("data"));
if(canvasDiv3.length!=0){
    for(var i=0;i<canvasDiv3.length;i++){
        canvasDiv3call.push(canvasDiv3[i].desc);
        canvasDiv3order.push(canvasDiv3[i].value);
        canvasDiv3labels.push(canvasDiv3[i].name);
    }
}
var canvasDiv3data = [
    {
        name : '叫车量',
        value:[22,23,22,22,24],
        color:'#6C84BF'
    },
    {
        name : '订单量',
        value:[22,23,22,22,24],
        color:'#E8BE2A'
    }
];
var chart3 = new iChart.ColumnMulti2D({
    render : 'canvasDiv3',
    data: canvasDiv3data,
    labels:canvasDiv3labels,
    width : 530,
    height : 550,
    column_width : 17,
    sub_option : {
        border : {
            width : 0,
            radius : '10 10 0 0',//上圆角设置
            color : '#ffffff'
        }
    },
    background_color : '#ffffff',
    legend : {
        enable : true,
        row:2,//设置在一行上显示，与column配合使用
        column : 'max',
        valign:'top',
        sign:'bar',
        background_color:null,//设置透明背景
        offsetx:-10,//设置x轴偏移，满足位置需要
        border : true
    },
    animation : true,//开启过渡动画
    animation_duration:600,//600ms完成动画
    coordinate:{
        background_color : '#f1f1f1',
        scale:[{
            position:'left',
            start_scale:0,
            end_scale:140,
            scale_space:10
        }],
        width:471,
        height:400
    }
});
//利用自定义组件构造左侧说明文本
chart3.plugin(new iChart.Custom({
    drawFn:function(){
        //计算位置
        var coo = chart3.getCoordinate(),
            x = coo.get('originx'),
            y = coo.get('originy'),
            w = coo.width,
            h = coo.height;
        //在左上侧的位置，渲染一个单位的文字
        chart3.target.textAlign('start')
            .textBaseline('bottom')
            .textFont('600 11px 微软雅黑')
            .fillText('      单位(万)',x-40,y-12,false,'#9d987a')
            .textBaseline('top')
            .fillText('公司',x+w+2,y+h+10,false,'#9d987a');

    }
}));
chart3.draw();


// 加载热力图
var point = new BMap.Point(116.418261, 39.921984);
index_map.centerAndZoom(point, 15);

// 地图控件点击事件
$('#indexmap-blow').click(function(){
    index_map.zoomIn();
})
$('#indexmap-shrink').click(function(){
    index_map.zoomOut();
})

// 定位
$('#indexmap-getlocation').click(function(){
    index_map.centerAndZoom($('.area_select:eq(0) option:selected').text(),12);
})

//搞点假数据
var points =[
    {"lng":116.418261,"lat":39.921984,"count":50},
    {"lng":116.423332,"lat":39.916532,"count":51},
    {"lng":116.419787,"lat":39.930658,"count":15},
    {"lng":116.418261,"lat":39.921984,"count":50},
    {"lng":116.423332,"lat":39.916532,"count":51},
    {"lng":116.419787,"lat":39.930658,"count":15},
    {"lng":116.418261,"lat":39.921984,"count":50},
    {"lng":116.423332,"lat":39.916532,"count":51},
    {"lng":116.419787,"lat":39.930658,"count":15},
    {"lng":116.423332,"lat":39.916532,"count":51},
    {"lng":116.419787,"lat":39.930658,"count":15},
    {"lng":116.418261,"lat":39.921984,"count":50},
    {"lng":116.423332,"lat":39.916532,"count":51},
    {"lng":116.419787,"lat":39.930658,"count":15},
    {"lng":116.418261,"lat":39.921984,"count":50},
    {"lng":116.423332,"lat":39.916532,"count":51},
    {"lng":116.419787,"lat":39.930658,"count":15}]



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


var heatmapOverlay;//热力图
function showHeatmapOverlay(points) {
    var virtual_points=points;
    if(heatmapOverlay!=null){
        heatmapOverlay.hide();
    }
    heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":20});
    index_map.addOverlay(heatmapOverlay);
    var pt = new BMap.Point(points[0].lng,points[0].lat);
    index_map.panTo(pt);
    heatmapOverlay.setDataSet({data:points,max:100});
    heatmapOverlay.show();
}

showHeatmapOverlay(JSON.parse($("#index-orderHeat").attr("data")));


    //司机热力图
    $("#index-driverHeat").click(function(){

    });


    $("#index-psgHeat").click(function(){

    });


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

},3000)

//调用环形进度条
$('#car-online').radialIndicator({
    radius:67,
    barWidth:17,
    percentage:true,
    //initValue:$("#car-online").attr("name"),
    initValue:92,
    roundCorner:true,
    barColor:'#61CF50',
    fontSize:25,
    fontWeight:100
});

$('#driver-sign').radialIndicator({
    radius:67,
    barWidth:17,
    percentage:true,
  //  initValue:$("#driver-sign").attr("name"),
    initValue:87,
    roundCorner:true,
    barColor:'#f26e42',
    fontSize:25,
    fontWeight:100
});
$('#user-active').radialIndicator({
    radius:67,
    barWidth:17,
    percentage:true,
    //initValue:$("#user-active").attr("name"),
    initValue:55,
    roundCorner:true,
    barColor:'#e5c73b',
    fontSize:25,
    fontWeight:100
});
/************首页内容图表end********************/


layui.use('element', function(){
    element = layui.element();
});
/*************监控室====历史轨迹end**************************/


/*********************实时报警 start****************************************/
var alarmSocket;
var alarmSocket = new WebSocket($("#index_basePath").val());
alarmSocket.onopen = function (event) {
    // socket.send('gps');

    // 监听消息
    alarmSocket.onmessage = function (event) {

    }
    //监听Socket的关闭
    alarmSocket.onclose = function (event) {
        console.log('Client  socket has closed', event);
    };
};

setInterval(function () {
    $("#index-alarWindowTime").text(new Date().toLocaleString());
    // layer.open({
    //     title:"新报警提醒",
    //     skin:"index-alarmWindow",
    //     type: 1,
    //     shade: false,//不出现阴影
    //     area: ['410px', '350px'], //宽高
    //     content: $("#index_alarmWindow")
    // });
},50000);



/*********************实时报警 end****************************************/
