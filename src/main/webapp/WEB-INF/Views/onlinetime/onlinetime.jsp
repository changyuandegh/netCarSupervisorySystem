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
    <div id="div_onlinetime_table" style="background-color:white;margin:0px;padding-bottom:0px;padding-top:10px;padding-left:10px;">
    <%--tool--%>
        <div style="height:40px;width:100%;">
            <select id="onlinetime_SelectCompany" class="selectStyle" style="width:160px;height:28px;font-size:14px"></select>
            车牌号:<input id="onlinetime_searchValue" class="defaultInput" type="text"  placeholder="请输入"/>
            <label style="color:#5A687B">&nbsp;&nbsp;&nbsp;有效期起:</label>
            <input id="onlinetime-starttime" class="trance_inputTime" style="margin-left:2px;"type="text" class="tance_text" placeholder="请选择开始时间"/>-
            <label style="color:#5A687B">&nbsp;&nbsp;&nbsp;有效期止:</label>
            <input id="onlinetime-endttime" class="trance_inputTime" style="margin-left:2px;" type="text" class="tance_text"   placeholder="请选择结束时间"/>
            <input id="onlinetime_searchBtn" class="btn_blue" type="button" value="查询"/>
        </div>
        <div>
            <table id="driveronlinetime-table" class="bootsrapTable" style="width: 100%">
            </table>
        </div>
    </div>
<script type="text/javascript">

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

        document.getElementById('onlinetime-starttime').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('onlinetime-endttime').onclick = function(){
            end.elem = this
            laydate(end);
        }
    });


    //在线时长表单
    $('#driveronlinetime-table').bootstrapTable({
        classes: "table-no-bordered",
        url: "onlinetime/selectOnlineTime",
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

                search: $.trim($("#onlinetime_searchValue").val()),
                stime:$("#onlinetime-starttime").val(),
                etime: $("#onlinetime-endttime").val(),
                company:$("#onlinetime_SelectCompany option:selected").val(),
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
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize: 10,//	如果设置了分页，页面数据条数
        pageList: [10, 20, 30], //可选择每页的行数
        idField: "onlinid",//指定主键
        uniqueId: "onlinid",//唯一标识符
        singleSelect: true,//禁止多选
        height:changeValue(),
        columns: [{
            field: 'onlinid',
            title: '序号',
            align: "center",
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'equipment',
            title: '设备',
            align: "center"
        }, {
            field: 'license',
            title: '车牌号码',
            align: "center"
        }, {
            field: 'drivername',
            title: '司机姓名',
            align: "center",
        }, {
            field: 'company',
            title: '所属公司',
            align: "center"
        },{
            field: 'earlytime',
            title: '最早在线时长',
            align: "center"
        }, {
            field: 'endtime',
            title: '最晚在线时长',
            align: "center"
        }]
    });

    $("#onlinetime_searchBtn").click(function () {
        $("#driveronlinetime-table").bootstrapTable("refresh",{url:"onlinetime/selectOnlineTime"},{query:{order:"asc"}});
    });

    //加载公司 信息
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
                $("#onlinetime_SelectCompany").empty();
                var html = "";
                for (var i = 0; i < companys.length; i++) {
                    html += "<option value='" + companys[i].name + "'>" + companys[i].desc + "</option>";
                }
            } else {
                html += "<option>无公司选择</option>";
            }
                $("#onlinetime_SelectCompany").append(html);
            },
            error: function (error, code, thow) {
                $("#onlinetime_SelectCompany").append("<option>无公司选择</option>");
        }
    })
    function changeValue(){
        //判断360浏览器
        var screenWidth = $(window).width();
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

</script>
</body>