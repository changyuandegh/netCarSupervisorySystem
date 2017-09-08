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
</head>
<body>
    <div id="div_freightInfo_table"  style="background-color:white;margin:0px;padding-bottom:0px;padding-top:10px;">
    <%--tool--%>
        <div style="height:40px;width:100%;padding-left:10px;">

            <select id="fareInfo_SelectCompany" class="selectStyle" style="width:160px;height:28px;font-size:14px"></select>
            <label style="color:#5A687B">&nbsp;&nbsp;&nbsp;有效期起:</label>
            <input id="fareInfo_text_starttime" class="trance_inputTime" style="margin-left:2px;" type="text" placeholder="请选择开始时间"/>-
            <label style="color:#5A687B">&nbsp;&nbsp;&nbsp;有效期止:</label>
            <input id="fareInfo_text_endttime" class="trance_inputTime" style="margin-left:2px;" type="text"  placeholder="请选择结束时间"/>

            <input id="freight_searchBtn" class="btn_blue" type="button" value="查询"/>
        </div>
        <div style="padding-left:10px;">
            <table id="fareinfo-table" class="bootsrapTable" style="width:100% ">
            </table>
        </div>
        <div id="fareinfor_datail" style="display:none;padding:20px;">
            <div style="float: left;">
            <ul style="list-style:none;border:1px #e6eaee solid;border-radius:4px;padding:10px;">
                <li><p style="color: #2E2D3C">公司名称:&nbsp;<span name="company"></span></p>
                <li><p>行政区域:&nbsp;<span name="name"></span></p>
                <li><p>运价类型编码:&nbsp;<span name="faretype" ></span></p>
                <li><p>运价类型说明:&nbsp;<span name="faretypenote"></span></p>
                <li><p>运价有效期起:&nbsp;<span name="farevalidon"></span></p>
                <li><p>运价有效期止:&nbsp;<span name="farevalidoff"></span></p>
                <li><p>起步价:&nbsp;<span name="startfare"></span></p>
                <li><p>起步里程:&nbsp;<span name="startmile"></span>元</p>
                <li><p>计程单价:&nbsp;<span name="unitpricepermile">元/KM</span></p>
                <li><p>计时单价:&nbsp;<span name="unitpriceperminute"></span>元/分钟</p>
                <li><p>单程加价单价:&nbsp;<span name="upprice"></span></p>
                <li><p>单程加价公里:&nbsp;<span name="uppricestartmile">(KM)</span></p>
                <%--<li><p>更新时间:&nbsp;<span name="updatetime"></span></p></li>--%>
            </ul>
            </div>
            <div style="float: right;">
            <ul style="list-style:none;border:1px #e6eaee solid;border-radius:4px;padding:10px;">
                <li><p>营运早高峰时间起:&nbsp;<span name="morningpeaktimeon"></span></p>
                <li><p>营运早高峰时间止:&nbsp;<span name="morningpeaktimeoff"></span></p>
                <li><p>营运晚高峰时间起:&nbsp;<span name="eveningpeaktimeon"></span></p>
                <li><p>营运晚高峰时间止:&nbsp;<span name="eveningpeaktimeoff"></span></p>
                <li><p>其他营运高峰时间起:&nbsp;<span name="otherpeaktimeon"></span></p>
                <li><p>其他营运高峰时间止:&nbsp;<span name="otherpeaktimeoff"></span></p>
                <li><p>高峰时间单程加价单价:&nbsp;<span name="peakunitprice"></span>元</p>
                <li><p>高峰时间单程加价公里:&nbsp;<span name="peakpricestartmile"></span>KM</p>
                <li><p>低速计时加价:&nbsp;<span name="lowspeedpriceperminute"></span>元/分</p>
                <li><p>夜间费:&nbsp;<span name="nightpricepermile"></span>(元/KM)</p>
                <li><p>夜间费:&nbsp;<span name="nightpriceperminute"></span>(元/分)KM</p>
                <li><p>其他加价金额:&nbsp;<span name="otherprice"></span>(元)</p>
                <%--<li><p>状态:&nbsp;<span name="pricestate"></span></p></li>--%>
            </ul>
            </div>
        </div>
    </div>
<script type="text/javascript">
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
    //格式话时间 HH:mm
    function formater(value, row, index) {
        var date = new Date(value);
        var hour = date.getHours().toString();
        var minutes = date.getMinutes().toString();
        if (hour < 10) {hour = "0" + hour;}
        if (minutes < 10) {minutes = "0" + minutes;}
        return  hour + ":" + minutes ;
    }
    function fun(value,row,index){
        if(value == 0){
            return '有效';
        }else {
            return '无效';
        }
        //格式话时间 HH:mm
        function formater(value, row, index) {
            var date = new Date(value);
            var hour = date.getHours().toString();
            var minutes = date.getMinutes().toString();
            if (hour < 10) {hour = "0" + hour;}
            if (minutes < 10) {minutes = "0" + minutes;}
            return  hour + ":" + minutes ;
        }

    }
    //时间
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        var start = {
            max: laydate.now(),
            istoday: false,
            istime:true,
            format: 'YYYY-MM-DD'
        };
        var end = {
            max:laydate.now(),
            istoday: false,
            istime:true,
            format: 'YYYY-MM-DD'
        };
        document.getElementById('fareInfo_text_starttime').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('fareInfo_text_endttime').onclick = function(){
            end.elem = this;
            laydate(end);
        }
    });

    //运价信息表单
    $('#fareinfo-table').bootstrapTable({
        classes: "table-no-bordered",
        url: "fare/findFareInfoData",
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
                stime:$("#fareInfo_text_starttime").val(),
                etime: $("#fareInfo_text_endttime").val(),
                company:$("#fareInfo_SelectCompany option:selected").val(),
                areacode: areacode,
            }
            return newParme;
        },
        //checkbox: true,
        striped: true,//启用各行变色
        //radio: true,
        //clickToSelect: true, //是否启用点击选中行
        selectItemName: "fareid",
        searchTimeOut: 3000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize: 10,//	如果设置了分页，页面数据条数
        pageList: [10, 20, 30], //可选择每页的行数
        idField: "fareid",//指定主键
        uniqueId: "fareid",//唯一标识符
        singleSelect: true,//禁止多选
        height:changeValue(),
        columns: [{
            field: 'fareid',
            title: '序号',
            align: "center",
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'company',
            title: '公司名称',
            align: "center"
        }, {
            field: 'name',
            title: '行政区域',
            align: "center"
        }, {

            field: 'farevalidon',
            title: '有效期起',
            align: "center",
            formatter:function (value,row,index) {
                if(value.length!=0){
                    var datetime=new Date();
                    datetime.setTime(value);
                    return datetime.toLocaleString();
                }else{
                    return "";
                }
            }
        }, {

            field: 'farevalidoff',
            title: '有效期止',
            align: "center",
            formatter:function (value,row,index) {
                if(value.length!=0){
                    var datetime=new Date();
                    datetime.setTime(value);
                    return datetime.toLocaleString();
                }else{
                    return "";
                }
            }
        },
            {
            field: 'startfare',
            title: '起步价（元）',
            align: "center"
        },{
            field: 'startmile',
            title: '起步里程（km）',
            align: "center"
        }, {
            field: 'unitpricepermile',
            title: '计程单价',
            align: "center"
        },
        {
            field: 'unitpriceperminute',
                title: '计时单价',
            align: "center"
        },
        {
             field: 'nightpricepermile',
             title: '夜间费（元／公里）',
             align: "center"
        },
        {
             field: 'nightpriceperminute',
             title: '夜间费（元／分钟）',
              align: "center"
        },
        {
             field: 'pricestate',
             title: '状态',
             align: "center",
            formatter:function(value, row, index){
                if(row['pricestate'] == 0){
                    return '有效';
                }
                if(row['pricestate'] == 1){
                    return '无效';
                }
            }
        },
        {
                field: 'fareid',
                title: '操作',
                align: "center",
                formatter:function (value,row,index) {
                    var html="<a href='javascript:' style='color:#000000;'>查看</a>";
                    return  html;
                }
            }],
            onClickCell:function(field, value, row, $element) {
                if (field == 'fareid') {
                    fare_SelectOneDateDetail(value);
                }
            }
    });

    $("#freight_searchBtn").click(function () {
        $("#fareinfo-table").bootstrapTable("refresh", {url: "fare/findFareInfoData"}, {query: {order: "asc"}});
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
            return 560;
        }

    }
        //加载公司信息
        var areacode = '';//地区
        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            areacode = $("#city option:selected").val();
        } else {
            areacode = $("#county option:selected").val();
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
                    $("#fareInfo_SelectCompany").empty();
                    var html = "";
                    for (var i = 0; i < companys.length; i++) {
                        html += "<option value='" + companys[i].name + "'>" + companys[i].desc + "</option>";
                    }
                } else {
                    html += "<option>无公司选择</option>";
                }
                $("#fareInfo_SelectCompany").append(html);
            },
            error: function (error, code, thow) {
                $("#fareInfo_SelectCompany").append("<option>无公司选择</option>");
            }});

    function fare_SelectOneDateDetail(value) {
        layer.open({
            title:"运价详情",
            type: 1,
            area: ['510px', '400px'], //宽高
            content: $("#fareinfor_datail")
        })
        $.ajax({
            type : 'post',
            url : "fare/findFareInfoDatail",
            dataType:"json",
            data:{
                "fareid":value
            },
            success : function(data){
                if(data != null){
                    $("#fareinfor_datail span[name='company']").text(data.company);
                    $("#fareinfor_datail span[name='name']").text(data.name);
                    $("#fareinfor_datail span[name='faretype']").text(data.faretype);
                    $("#fareinfor_datail span[name='faretypenote']").text(data.faretypenote);
                    $("#fareinfor_datail span[name='farevalidon']").text(format(data.farevalidon));
                    $("#fareinfor_datail span[name='farevalidoff']").text(format(data.farevalidoff));
                    $("#fareinfor_datail span[name='startfare']").text(data.startfare);
                    $("#fareinfor_datail span[name='startmile']").text(data.startmile);
                    $("#fareinfor_datail span[name='unitpricepermile']").text(data.unitpricepermile);
                    $("#fareinfor_datail span[name='unitpriceperminute']").text(data.unitpriceperminute);
                    $("#fareinfor_datail span[name='upprice']").text(data.upprice);
                    $("#fareinfor_datail span[name='uppricestartmile']").text(data.uppricestartmile);
                    $("#fareinfor_datail span[name='nightpricepermile']").text(data.nightpricepermile);
                    $("#fareinfor_datail span[name='nightpriceperminute']").text(data.nightpriceperminute);
                    $("#fareinfor_datail span[name='morningpeaktimeon']").text(formater(data.morningpeaktimeon));
                    $("#fareinfor_datail span[name='morningpeaktimeoff']").text(formater(data.morningpeaktimeoff));
                    $("#fareinfor_datail span[name='eveningpeaktimeon']").text(formater(data.eveningpeaktimeon));
                    $("#fareinfor_datail span[name='eveningpeaktimeoff']").text(formater(data.eveningpeaktimeoff));
                    $("#fareinfor_datail span[name='otherpeaktimeon']").text(formater(data.otherpeaktimeon));
                    $("#fareinfor_datail span[name='otherpeaktimeoff']").text(formater(data.otherpeaktimeoff));
                    $("#fareinfor_datail span[name='peakunitprice']").text(data.peakunitprice);
                    $("#fareinfor_datail span[name='peakpricestartmile']").text(data.peakpricestartmile);
                    $("#fareinfor_datail span[name='lowspeedpriceperminute']").text(data.lowspeedpriceperminute);
                    $("#fareinfor_datail span[name='otherprice']").text(data.otherprice);
                    $("#fareinfor_datail span[name='pricestate']").text(fun(data.pricestate));
                    $("#fareinfor_datail span[name='updatetime']").text(format(data.updatetime));
                }
            }
        })
    }

</script>
</body>
</html>