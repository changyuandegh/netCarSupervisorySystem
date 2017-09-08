/**
 * Created by Mander on 2017/5/31.
 */

var fence_map;
var drawingMode;
setTimeout(function(){
    // 初始化选项卡模块,全局变量
    layui.use('element', function(){
        element = layui.element();
    });
    //创建百度地图实例，全局变量
    // 初始化围栏地图高度
    var h = window.screen.availHeight-270;
    // $('#fence-map').css('height',h+'px');
    fence_map = new BMap.Map("fence-map",{enableMapClick:false});
    fence_map.centerAndZoom(new BMap.Point(113.6888,34.767897), 13);
    fence_map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    var overlays = [];//围栏点集合

    var overlaycomplete = function(e){
        drawingManager.close();
        overlays.push(e.overlay);
        drawingMode=e.drawingMode;
    };

    var styleOptions = {
        strokeColor:"red",    //边线颜色。
        fillColor:"red",      //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight: 3,       //边线的宽度，以像素为单位。
        strokeOpacity: 0.8,    //边线透明度，取值范围0 - 1。
        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
        strokeStyle: 'solid' //边线的样式，solid或dashed。
    }

    //实例化鼠标绘制工具
    var drawingManager = new BMapLib.DrawingManager(fence_map, {
        isOpen: false, //是否开启绘制模式
        enableDrawingTool: true, //是否显示工具栏
        drawingToolOptions: {
            anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
            offset: new BMap.Size(5, 5), //偏离值
            drawingModes:[BMAP_DRAWING_CIRCLE,BMAP_DRAWING_POLYGON]
        },
        circleOptions: styleOptions, //圆的样式
        polylineOptions: styleOptions, //线的样式
        polygonOptions: styleOptions, //多边形的样式
        rectangleOptions: styleOptions //矩形的样式
    });
    // drawingManager.setDrawingMode(BMAP_DRAWING_POLYLINE);
    //添加鼠标绘制工具监听事件，用于获取绘制结果
    drawingManager.addEventListener('overlaycomplete', overlaycomplete);

    // 在切换回图工具时清空地图围栏
    $('.BMapLib_Drawing_panel>a').click(function(){
        if($(this).attr('drawingtype') != 'hander'){
            // 清空地图围栏
            clearFence();
        }
    })



    // var laydate = layui.laydate;
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        var start = {
            // format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('fence_addSDate').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('fence_addEDate').onclick = function(){
            end.elem = this
            laydate(end);
        }

        document.getElementById('fence-edit-s').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('fence-edit-e').onclick = function(){
            end.elem = this
            laydate(end);
        }

    });


    // 缩放列表
    $('#fence-shrink').click(function(){
        if($(this).attr('shrink') == '1'){
            // 需要显示
            $(this).css('transform',"rotate(0deg");
            $(this).attr('shrink','');
            if($('#fence-add').css('color') == 'rgb(0, 0, 0)'){
                $('#fence-set>div').show('fast');
                $('#fence-append-1').hide();
                $('#fence-set').animate({height: '443px'}, "fast");
            }else{
                $('#fence-set>div').show('fast');
                $('#fence-append-2').hide();
                $('#fence-set').animate({height: '243px'}, "fast");
            }
        }else{
            // 需要隐藏
            $(this).css('transform',"rotate(180deg");
            $(this).css('transform','190');
            $(this).attr('shrink','1');
            $('#fence-set>div').hide().first().show();
            $('#fence-set').animate({height: '45px'}, "fast");
        }
    })

    // 搜索点击
    $('#fence-search').click(function(){
        clearFence();
        $('#fence-shrink').attr('shrink','');
        $('.BMapLib_Drawing_panel').hide('fast');
        $('#fence-append-1').hide();
        $('#fence-append-2').show();
        $('#fence-set').css('height','443px');
        $('#fence-add>img').attr('src','./pic/fence/new_fence_dis.png')
        $('#fence-add').css('color','black');
        $(this).find('img').attr('src','./pic/fence/search_fence.png');
        $(this).css('color','#1a91eb');

        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            areacode = $("#city option:selected").val();
        } else {
            areacode = $("#county option:selected").val();
        }
        fenceSearch();
    })

    // 新增点击
    $('#fence-add').click(function(){
        fence_map.clearOverlays();
        $('#fence-shrink').attr('shrink','');
        $('.BMapLib_Drawing_panel').show('fast');
        $('#fence-append-1').show();
        $('#fence-append-2').hide()
        $('#fence-set').css('height','243px');
        $('#fence-search>img').attr('src','./pic/fence/search_fence_dis.png');
        $('#fence-search').css('color','black');
        $(this).find('img').attr('src','./pic/fence/new_fence.png');
        $(this).css('color','#1a91eb');
    })



    // 保存围栏
    $('#fence-save').click(function(){
        // 不许为空
        var area = $('#fence_type').val();
        var name = $('#fence-name').val();
        if(name == ''){$('#fence-notice').show();return false;}
        var s = $('#fence_addSDate').val();
        var e = $('#fence_addEDate').val();
        if(s == '' || e == ''){$('#fence-time-notice').show();return false;}
        if(!overlays.length){
            layer.msg("请绘制围栏");
            return false;
        }
        // 哪个形状
        var shape=1;//,默认多边形
        var xa="";
        var points="";
        ////"circle";//
        if(drawingMode=='polygon'){
            //多边形
            points = JSON.stringify(overlays[0].po);
            shape = 1;//多边形
        }else{
            //圆形
            points = JSON.stringify(overlays[0].point);
            xa = JSON.stringify(overlays[0].xa);
            shape =0;//圆型
        }
        //var str = '<div class="fence-content" type="'+type+'" points='+str+'><div class="fence-tit">'+name+'</div><div><p class="fence-area">'+area+'</p><p>'+type+'</p><p class="fence-time">'+s+'～'+e+'</p></div><img src="./pic/fence/edit.png" class="fence-do-edit"><img src="./pic/fence/delete.png" class="fence-do-delete"></div>';
        //$('#fence-all-content').prepend(str);
        $('#fence-notice').hide();
        $('#fence-time-notice').hide();
        var areacode = '';
        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            areacode = $("#city option:selected").val();
        } else {
            areacode = $("#county option:selected").val();
        }

        $.ajax({
            url:"netfence/addFence",
            timeout:10000,
            dataType:"json",
            data:{
                name:name,
                type:$("#fence_selectType option:selected").val(),
                address:areacode,
                shape:shape,
                radius:xa,
                points:points,
                startDate:$('#fence_addSDate').val(),
                endData:$('#fence_addEDate').val()
            },
            success:function (data) {
                if(data!=null&&data.length!=0){
                    layer.alert(data.desc);
                }else{
                    layer.alert("添加失败,请重试");
                }
                fence_map.clearOverlays();
                overlays.length=0;
                $('#fence-name').val('');
                $('#fence_addSDate').val('');
                $('#fence_addEDate').val('');
            },
            error:function(error,code,thorw){
                layer.alert("出现异常:"+code);
                fence_map.clearOverlays();
                $('#fence-name').val('');
                $('#fence_addSDate').val('');
                $('#fence_addEDate').val('');
            }
        })
    })

    // 点击显示围栏,单个
    $('.fence-content').click(function(){
        layer.alert("click_one");
        fence_map.clearOverlays();
        if($(this).attr('type') == '圆形'){
            // 圆形
            var arr = $(this).attr('points').split('/');
            var obj = eval('(' + arr[0] + ')');
            var point = new BMap.Point(obj.lng,obj.lat);
            // fence_map.centerAndZoom(point, 15);
            var circle = new BMap.Circle(point,arr[1],{strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5}); //创建圆
            circle.setStrokeColor('#3736FD');
            circle.setStrokeOpacity(1);
            circle.setStrokeWeight(1.2)
            circle.setFillColor('#3736FD')
            circle.setFillOpacity(0.2)
            circle.disableEditing();
            fence_map.addOverlay(circle);            //增加圆

            var myIcon = new BMap.Icon("./pic/fence/map_near.png", new BMap.Size(37,52));
            var marker2 = new BMap.Marker(point,{icon:myIcon});  // 创建标注
            fence_map.addOverlay(marker2);
        }else{
            // 多边形
            var arr = [];
            var str = $(this).attr('points');
            var points = eval(str);
            for(var i=0;i<points.length;i++){
                var lng = parseFloat(points[i].lng);
                var lat = parseFloat(points[i].lat);
                arr.push(new BMap.Point(lng,lat));
            }
            var polygon = new BMap.Polygon(arr, {strokeColor:"red", strokeWeight:2, strokeOpacity:0.7});
            fence_map.addOverlay(polygon);
            fence_map.panTo(new BMap.Point(lng,lat));
        }
    })

    // 清空地图
    $('#fence-clear').click(function(){
        clearFence();
    })

    function clearFence(){
        for(var i = 0; i < overlays.length; i++){
            fence_map.removeOverlay(overlays[i]);
        }
        overlays.length = 0;
    }

},100)


//查询围栏
$("#fence_fenceSearch").click(function(){
    fenceSearch();
});
//点击分页数字按钮dd==当前页数,查询所有
function pageAll(dd){
    var startCount=(dd*5)-5;//;//开始条数
    $.ajax({
        dataType:"json",
        url:"netfence/findfenceRows",
        data:{
            type:$("#fence_selectType option:selected").val(),
            shape:$("#fence_selectShape option:selected").val(),
            address:areacode,
            limit:5,
            name:$.trim($("#fence_searchName").val()),
            offset:startCount
        },
        success:function(data){
            $("#fence-all-content").empty();
            if(data!=null&&data.length!=0){
                var html=""
                for(var i=0;i<data.length;i++){
                    var fence= data[i];
                    var type="";
                    var shape="";
                    if(fence.type==0){
                        type="禁出"
                    }else if(fence.type==1){
                        type="禁入";
                    }else if(fence.type==2){
                        type="重点区域"
                    }
                    if(fence.shape==0){
                        shape="圆形";
                    }else if(fence.shape==1){
                        shape="多边形";
                    }
                    html+="<div class='fence-content' fenceid='"+fence.id+"' fenceName='"+fence.name+"' type='"+fence.type+"' raduis='"+fence.radius+"' address='"+fence.address+"' shape='"+fence.shape+"' startdate='"+fence.startdate+"' stopdate= '"+fence.stopdate+"' points="+fence.points+"><div class='fence-tit'>"+fence.name+"</div><div><p class='fence-area'>"+type+"</p><p>"+shape+"</p><p class='fence-time'>"+fence.startdate+"～"+fence.stopdate+"</p></div><img src='./pic/fence/edit.png' class='fence-do-edit'><img src='./pic/fence/delete.png'class='fence-do-delete'></div>";
                }
                $("#fence-all-content").append(html);
            }
        },
        error:function (error,code,th) {
            layer.alert("查无围栏数据 "+code);
            $("#fence-all-content").empty();
        }
    })
}

function fenceSearch() {
    var searchName=$.trim($("#fence_searchName").val());
    $.ajax({
        dataType:"json",
        url:"netfence/findCountfence",
        data:{
            type:$("#fence_selectType option:selected").val(),
            shape:$("#fence_selectShape option:selected").val(),
            address:areacode,
            name:searchName
        },
        timeout:5000,
        success:function(count){
            $("#fence-all-content").empty();
            if(count!=null&&count.length!=0){
                $("#page").initPage(count,1,pageAll);
            }else{
                $("#page").empty();
            }
        },
        error:function (error,code,th) {
            layer.msg("查询异常:"+code);
            $("#fence-all-content").empty();
        }
    })
}




var edit_overlay=null;//编辑的覆盖物;
var edit_id;
var  edit_name;
var edit_address;
var edit_type;
var  edit_shape;
var edit_raduis;
var edit_points;
var edit_startdate;
var edit_stopdate;
//点击编辑
$("#fence-all-content").delegate(".fence-do-edit","click",function(){

    // 开编辑
    var fence=$(this).parent();

    edit_id=$(fence).attr("fenceid");
    edit_name=$(fence).attr("fenceName");
    edit_address=$(fence).attr("address");
    edit_type=$(fence).attr("type");
    edit_shape=$(fence).attr("shape");
    edit_raduis=$(fence).attr("raduis");
    edit_points=$(fence).attr("points");
    edit_startdate=$(fence).attr("startdate");
    edit_stopdate=$(fence).attr("stopdate");
    edit_overla=null;//置空;

    $('#fence-edit-name').val($(fence).attr("fenceName"));
    $('#fence-edit-s').val($(fence).attr("startdate"));
    $('#fence-edit-e').val($(fence).attr("stopdate"));

    $("#fence_type").val($(fence).attr("type"));

    $('#fence-edit').show();
    fence_map.clearOverlays();
    if(edit_shape==0){
        var point =$.parseJSON($(fence).attr("points"));
        var raduis=$(fence).attr("raduis");
        var pt = new BMap.Point(point.lng,point.lat);
        fence_map.centerAndZoom(pt,11);
        var circle = new BMap.Circle(pt,raduis,{strokeColor:"blue",strokeWeight:2,strokeOpacity:0.5});//创建圆
        circle.setStrokeColor('#3736FD');
        circle.setStrokeOpacity(1);
        circle.setStrokeWeight(1.2)
        circle.setFillColor('#3736FD')
        circle.setFillOpacity(0.2);
        fence_map.addOverlay(circle);
        circle.enableEditing();
        edit_overlay=circle;

    }else if(edit_shape==1){
        // 多边形
        var arr = [];
        var str = $(fence).attr('points');
        var obj =$.parseJSON($(fence).attr("points"));
        var points=$.parseJSON($(fence).attr("points"));
        for(var i=0;i<points.length;i++){
            var lng = parseFloat(points[i].lng);
            var lat = parseFloat(points[i].lat);
            arr.push(new BMap.Point(lng,lat));
        }
         edit_overlay = new BMap.Polygon(arr, {strokeColor:"red", strokeWeight:2, strokeOpacity:0.7});
        fence_map.addOverlay(edit_overlay);
        edit_overlay.enableEditing();
        fence_map.panTo(new BMap.Point(lng,lat));
    }

});


//点击完成编辑
$("#fence-over").click(function(){
    var name=$("#fence-edit-name").val();
    var startdate=$("#fence-edit-s").val();
    var stopdate=$("#fence-edit-e").val();
    if(edit_shape==1){
        var points=JSON.stringify(edit_overlay.getPath());
        overEdit(edit_id,name,areacode,edit_type,edit_shape,null,points,startdate,stopdate);
    }else if(edit_shape==0){
        var centerPt=JSON.stringify(edit_overlay.getCenter());
        var radius=edit_overlay.getRadius();
        overEdit(edit_id,name,areacode,edit_type,edit_shape,radius,centerPt,startdate,stopdate);
    }
});


function overEdit(fenceid,name,address,type,shape,radius,points,startdate,stopdate){
    $.ajax({
        dataType:"json",
        url:"netfence/submitEdit",
        data:{
            fenceid:fenceid,
            name:name,
            address:address,
            type:type,
            shape: shape,
            radius:radius,
            points: points,
            startdate: startdate,
            stopdate:stopdate
        },
        success:function(data){
            layer.alert(data.desc);
            if(data.name=="success"){
                var lineData= $("#fence-all-content").find("div[fenceid='"+fenceid+"']")
                $(lineData).attr({"fenceName":name,"type":type,"shape":shape,"radius":radius,"points":points,"startdate":startdate,"stopdate":stopdate,"address":address})
            }
            $('#fence-edit').hide();
        },
        error:function (error,code,th) {
            layer.alert("编辑失败,请重试!  "+code);
            $('#fence-edit').show();
        }
    })
}



//点击删除
$("#fence-all-content").delegate(".fence-do-delete","click",function(){
    var fenceid= $(this).parent().attr("fenceid");
    $("#fence_window-sure").show();
    $("#fence-sure-bottom div:eq(0)").attr("fenceid",fenceid);
});


//关闭编辑
$('.fence-close,#fence-cancel').click(function(){
    $('#fence-edit').hide();
    fence_map.clearOverlays();
})



// 确认删除
$('#fence-sure-bottom div:eq(0)').click(function(){
    var fenceid=$(this).attr("fenceid");
    $.ajax({
        timeout:10000,
        url:"netfence/deleteByfenceid",
        dataType:"json",
        data:{
            fenceid:fenceid
        },
        success:function (data) {
            layer.alert(data.desc);
            if(data.name="success"){
                $("#fence-all-content").find("div[fenceid="+fenceid+"]").remove();
            }
            $("#fence_window-sure").hide();
        },
        error:function(error,code,throws){
            $("#fence_window-sure").hide();
            layer.alert("删除失败,请重试!  "+code);
        }
    })
})

// 取消删除
$('#fence-sure-bottom div:last').click(function(){
    $("#fence_window-sure").hide();
})

