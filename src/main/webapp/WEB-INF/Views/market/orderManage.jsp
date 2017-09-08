<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/5/31
  Time: 11:41
  To change this template use File | Settings | File Templates.
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
    <%--<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no,width=device-width"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">--%>
    <!--<link rel="stylesheet" href="">-->
    <title>订单管理</title>
</head>
<body>
<div style="background-color:white;padding:0px;width:100%;height:100%;border-radius:4px;">
    <!-- 市场把控 -->
    <div id="div_company_table" style="background-color:white;margin:0px;padding-bottom:0px;padding-top:10px;">
        <%--tool--%>
        <select id="order_selctParm" class="defualt_select" style="float:left;line-height:20px;width:100px;">
            <option value="netorderid">订&nbsp;&nbsp;单&nbsp;&nbsp;号</option>
            <option value="vehicleno">车&nbsp;&nbsp;牌&nbsp;&nbsp;号</option>
            <option value="driverphone">司机手机号</option>
            <option value="passengerphone">乘客手机号</option>
            <%--<option value="passengerphone">公司名称</option>--%>
        </select>
        <input id="order_searchValue" class="defaultInput" type="text" placeholder="请输入" />
        <label style="color:#5A687B">&nbsp;有效期起:</label>
        <input id="order-starttime" class="trance_inputTime tance_text" style="margin-left:0px;" type="text" placeholder="请选择开始时间"/>
        <label style="color:#5A687B">&nbsp;有效期止:</label>
        <input id="order-endtime" class="trance_inputTime tance_text" style="margin-left:0px;" type="text" placeholder="请选择结束时间"/>
        <input id="order_searchBtn" class="btn_blue" type="button" value="查询"/>
        <%--tool--%>
    </div>
    <div style="margin-top:10px;padding-left:10px;">
        <table id="order_List" class="bootsrapTable" style="width: 100%">
        </table>
    </div>
    <div id="order-window" style="color:#354052;display:none;">
        <div id="order-window-head" class="order-layer-head" data-orderid="" style="height:40px;background-color:#f5f8fa;">
            <div class="order-layer-head-context">
              <a id="order-showOrder" title="order" class="order-showdesc-selected" href="javascript:">订单信息</a>
            </div>
            <div class="order-layer-head-context">
                <a id="order-showDriver" title="driver" index="1" href="javascript:">接单司机</a>
            </div>
            <div class="order-layer-head-context">
                <a id="order-showPay" title="pay" index="2" href="javascript:">支付信息</a>
            </div>
            <div class="order-layer-head-context">
                <a id="order-showRate" title="rate" index="3" href="javascript:">订单售后</a>
            </div>
            <div style="line-height:40px;height:40px;float:right;padding-right:20px;">
                <a href="javascript:" title="关闭" onclick="layer.closeAll()" style="color:#5a687b;text-decoration:none;">X</a>
            </div>
        </div>
        <div id="order-orderDesc">
            <ul id="order-orderDesc-ul" style="list-style:none;border:1px #e6eaee solid;border-radius:4px;padding:10px;">
                <li>订单号:<span name="orderid"></span></li>
                <li>订单类型:<span name="ordertype"></span></li>
                <li>订单状态:<span name="state"></span></li>
                <li>车辆类型:<span name="cartype"></span></li>
                <li>叫车时间:<span name="createtime"></span></li>
                <li>预约上车时间:<span name="departtime"></span></li>
                <%--<li>订单耗时:<span name=" "></span></li>--%>
                <%--<li>上车时间:<span name="departtime"></span></li>--%>
                <%--<li>下车时间:<span name=" "></span></li>--%>
                <%--<li>订单里程:<span name="depmileage"></span></li>--%>
                <%--<li>上车地点:<span name="actualgoonbus"></span></li>--%>
                <%--<li>下车地点:<span name=""></span></li>--%>
            </ul>
        </div>
        <div id="order-orderDriver" style="display: none;">
            <div style="float:left;width:150px;height:180px;border:1px #e6eaee solid;">

            </div>
            <%--#fafbfc e6eaee--%>
            <div style="border-radius:4px;margin-left:10px;float:left;border:1px #e6eaee solid;width:360px;">
            <ul style="list-style:none;padding-left:10px;">
                <li>司机姓名:<span name="drivername"></span></li>
                <li>手机号码:<span name="driverphone"></span></li>
                <%--<li>所属公司:<span name=""></span></li>--%>
                <%--<li>车牌号:<span name=""></span></li>--%>
                <li>投诉次数:<span name="complainedcount"></span></li>
                <%--<li>车辆类型:<span name=""></span></li>--%>
                <li>信誉度:<span name="creditpoints"></span></li>
            </ul>
            </div>
        </div>
        <div id="order-orderPay"  style="display: none;">
            <ul style="list-style:none;border:1px #e6eaee solid;border-radius:4px;padding:10px;">
                    <li>电子支付:<span name="lineprice"></span></li>
                    <li>现金支付:<span name="cashprice"></span></li>
                    <li>应支付金额:<span name="price"></span></li>
                    <li>优惠金额:<span name="benfitprice"></span></li>
                    <li>实际支付金额:<span name="factprice"></span></li>
                    <li>支付时间:<span name="paytime"></span></li>
            </ul>
        </div>
        <div id="order-orderRate"  style="display: none;">
            <ul style="list-style:none;border:1px #e6eaee solid;border-radius:4px;padding:10px;">
                <li>订单评分:<span name="servicescore"></span></li>
                <li>订单评价:<span name="detail"></span></li>
                <li>投诉建议:<span name="complaintDetail"></span></li>
                <%--<li>乘客建议:<span name=""></span></li>--%>
            </ul>
        </div>
    </div>
</div>
</body>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        var start = {
            max: laydate.now(),
            istoday: false,
            istime:true,
            format: 'YYYY-MM-DD',
            choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            max:laydate.now(),
            istoday: false,
            istime:true,
            format: 'YYYY-MM-DD',
            choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        document.getElementById('order-starttime').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('order-endtime').onclick = function(){
            end.elem = this
            laydate(end);
        }
    });

    $('#order_List').bootstrapTable({
        classes: "table-no-bordered",
        url: "order/findOrdersByparm",
        queryParams:function (parme) {
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
                order: parme.order,
                search: $.trim($("#order_searchValue").val()),
                parameter: $("#order_selctParm option:selected").val(),
                stime:$("#order-starttime").val(),
                etime: $("#order-endtime").val(),
                areacode: areacode,
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true, //是否启用点击选中行
        selectItemName: "id",
        searchTimeOut: 3000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        sortable: true, //是否启用排序
        sortOrder: "asc", //排序方式
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize: 10,//	如果设置了分页，页面数据条数
        pageList: [10, 20, 30], //可选择每页的行数
        singleSelect: true,//禁止多选
        height:changeValue(),
        columns: [{
            field: 'orderid',
            title: '序号',
            align: "center",
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'netorderid',
            title: '订单号',
            align: "center"
        }, {
            field: 'state',
            title: '订单状态',
            align: "center",
            formatter:function (value,row,index) {
                var state="";
                if(value==0||value==1||value==2||value==12||value==10){
                    state="进行中";
                }
                if(value==3||value==4||value==5||value==11){
                    state="已完成";
                }if(value==6||value==7||value==8){
                    state="已取消";
                }else if(value==9){
                    state="超时"
                }
                return state;
            }
        }, {
            field: 'ordertype',
            title: '订单类型',
            align: "center",
            formatter:function(value, row, index){
                if (row['ordertype'] == '1') {
                    return '即时';
                }
                if (row['ordertype'] == '2') {
                    return '预约';
                }
                if (row['ordertype'] == '3') {
                    return '派发';
                }
            }
        }, {
            field: 'depamount',
            title: '订单金额',
            align: "center"
        },{
            field: 'depmileage',
            title: '里程',
            align: "center"
        }, {
            field: 'vehicleno',
            title: '车牌号',
            align: "center"
        }, {
            field: 'licenseid',
            title: '司机驾驶证',
            align: "center"
        }, {
            field: 'driverphone',
            title: '司机手机号',
            align: "center"
        },{
            field: 'departure',
            title: '上车地址',
            align: "center"
        }, {
            field: 'destination',
            title: '下车地址',
            align: "center"
        },{
            field: 'orderidAction',
            title: '操作',
            align: "center",
            formatter:function (value, row, index) {
                return  "<a href='javascript:' class='order-showlineDesc'  style='color:#000000;'>查看</a>";
            }
        }],
        onClickCell:function(field, value, row, $element){
            if(field=='orderidAction'){
                order_selectOneDateDetail(row);
            }
        }
    });

    function changeValue(){

        var screenWidth = $(window).width();
        //判断360浏览器
        if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
            //=============================

            if(screenWidth > 1400){
                return 770;
            }else{
                return 480;
            }
        }
        // 判断Chrome
        else if(navigator.userAgent.indexOf("Chrome") >0)
        {
            if(screenWidth > 1400){
                return 790;
            }else{
                return 480;
            }
        }
        // 判断afari
        else if(navigator.userAgent.indexOf("Safari") >0)
        {
            return 550;
        }

    }

    $("#order_searchBtn").click(function () {
        $("#order_List").bootstrapTable("refresh", {url: "order/findOrdersByparm"}, {query: {order: "asc"}});
    });

    //订单详细
    $("#order-showOrder").click(function(){
        $("#order-orderPay,#order-orderDriver,#order-orderPay,#order-orderRate").hide();
        $("#order-orderDesc").show();
        $("#order-window").parent().parent().css("height",'300px');
        $("#order-showOrder").addClass("order-showdesc-selected");
        $("#order-showRate,#order-showPay,#order-showDriver").removeClass("order-showdesc-selected");
    });
    //司机信息
    $("#order-showDriver").click(function(){
        $("#order-orderPay,#order-orderDesc,#order-orderPay,#order-orderRate").hide();
        $("#order-orderDriver").show();
        $("#order-window").parent().parent().css("height",'300px');
        $("#order-showDriver").addClass("order-showdesc-selected");
        $("#order-showRate,#order-showPay,#order-showOrder").removeClass("order-showdesc-selected");
        var licenseid=$("#order-showDriver").attr("data-licenseid");
        $.get('netdriver/findDriverBylicenseid',{licenseid:licenseid},function(data){
            if(data!=null&&data.length!=0){
                $("#order-orderDriver ul span[name='drivername']").text(data.drivername);
                $("#order-orderDriver ul span[name='driverphone']").text(data.driverphone);
                $("#order-orderDriver ul span[name='complainedcount']").text(data.complainedcount);
                $("#order-orderDriver ul span[name='creditpoints']").text(data.creditpoints);
            }else{
                $("#order-orderDriver ul span").text("无");
            }
        });
    });

    //支付信息
    $("#order-showPay").click(function(){
        $("#order-orderDriver,#order-orderDesc,#order-orderPay,#order-orderRate").hide();
        $("#order-orderPay").show();
        $("#order-window").parent().parent().css("height",'280px');
        $("#order-showPay").addClass("order-showdesc-selected");
        $("#order-showRate,#order-showDriver,#order-showOrder").removeClass("order-showdesc-selected");
        //
        var orderid= $("#order-window").attr("data-orderid");
        $.get('order/getOrderPayByorderid',{orderid:orderid},function(data){
            if(data!=null&&data.length!=0){
                $("#order-orderPay ul span[name='lineprice']").text(data.lineprice);
                $("#order-orderPay ul span[name='cashprice']").text(data.cashprice);
                $("#order-orderPay ul span[name='price']").text(data.price);
                $("#order-orderPay ul span[name='benfitprice']").text(data.benfitprice);
                $("#order-orderPay ul span[name='factprice']").text(data.factprice);
                var time=new Date();
                time.setTime(data.paytime);
                $("#order-orderPay ul span[name='paytime']").text(time.toLocaleString());
            }else{
                $("#order-orderPay ul span").text("无");
            }
        });
    });



    //售后信息
    $("#order-showRate").click(function(){
        $("#order-orderDriver,#order-orderDesc,#order-orderPay,#order-orderPay").hide();
        $("#order-orderRate").show();
        $("#order-window").parent().parent().css("height",'220px');
        $("#order-showPay,#order-showDriver,#order-showOrder").removeClass("order-showdesc-selected");
        $("#order-showRate").addClass("order-showdesc-selected");
        var orderid= $("#order-window").attr("data-orderid");
        $.get('order/getOrderAfterSales',{orderid:orderid},function(data){
            if(data!=null&&data.length!=0){
                $("#order-orderRate ul span[name='servicescore']").text(data.servicescore);
                $("#order-orderRate ul span[name='detail']").text(data.detail);
                $("#order-orderRate ul span[name='complaintDetail']").text(data.complaintDetail);
            }else{
                $("#order-orderRate ul span").text("无");
            }
        });
    });


    //调用弹出窗
    function order_selectOneDateDetail(row){
        //默认订单详细
        $("#order-orderPay,#order-orderDriver,#order-orderPay,#order-orderRate").hide();
        $("#order-orderDesc").show();
        $("#order-window").parent().parent().css("height",'300px');
        $("#order-showOrder").addClass("order-showdesc-selected");
        $("#order-showRate,#order-showPay,#order-showDriver").removeClass("order-showdesc-selected");
        $("#order-window").attr("data-orderid",row.orderid);

        //绑定司机驾驶证号;
        $("#order-showDriver").attr("data-licenseid",row.licenseid);
        layer.open({
            title:"",
            type: 1,
            closeBtn:0,
            shade: false,//不出现阴影
            area: ['600px', '350px'], //宽高
            content: $("#order-window")
        });
        $.get('order/getOrderByorderid',{orderid:row.orderid},function(data){
            if(data.length!=0){
                $("#order-orderDesc-ul span[name='orderid']").text(data.orderid);
                var ordertype=data.ordertype;
                if (ordertype== '1') {
                    ordertype='即时';
                }
                if (ordertype== '2') {
                    ordertype='预约';
                }
                if (ordertype== '3') {
                    ordertype='派发';
                }
                $("#order-orderDesc-ul span[name='ordertype']").text(ordertype);
                var value= data.state;
                var state="";
                if(value==0||value==1||value==2||value==12||value==10){
                    state="进行中";
                }
                if(value==3||value==4||value==5||value==11){
                    state="已完成";
                }if(value==6||value==7||value==8){
                    state="已取消";
                }else if(value==9){
                    state="超时"
                }
                $("#order-orderDesc-ul span[name='state']").text(state);
                $("#order-orderDesc-ul span[name='cartype']").text(data.cartype==1?"豪华":"经济");
                var ctime=new Date();
                ctime.setTime(data.createtime);
                $("#order-orderDesc-ul span[name='createtime']").text(ctime.toLocaleTimeString());
                ctime.setTime(data.departtime);
                $("#order-orderDesc-ul span[name='departtime']").text(ctime.toLocaleTimeString());
            }else{
                $("#order-orderDesc-ul span[name='ordertype']").text("无");
                $("#order-orderDesc-ul span[name='state']").text("无");
                $("#order-orderDesc-ul span[name='cartype']").text("无");
                $("#order-orderDesc-ul span[name='createtime']").text("无");
                $("#order-orderDesc-ul span[name='departtime']").text("无");
            }
        })
    }
</script>
</html>
