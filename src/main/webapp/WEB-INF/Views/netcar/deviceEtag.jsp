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
<div id="div_device_table" style="background-color:white;margin:0px;padding:10px 5px 0 5px;">
    <%--tool--%>
    <div style="height:35px;width:100%;">
        <select id="deviceinfo_selctParm" class="defualt_select" style="float:left;line-height:30px;margin-left:2px;">
            <option value="vehicleno">车牌号</option>
        </select>
        <input id="deviceinfo_searchValue" class="defaultInput" type="text" placeholder="请输入"/>
        <input id="car_searchBtn" class="btn_blue" type="button" title="device" value="查询"/>
    </div>
    <%--tool--%>
        <%--tab--%>
        <div style="height:35px;width:100%;margin-left:2px;">
            <label id="device_tab_device" class="device_TopTabLable">车载终端</label>
            <label id="device_tab_etag" class="device_TopTabLable" style="background-color:#f4f7fa;padding-top:5px;">电子标签</label>
            <label id="device_btn_add"  class="device_top_addDeviceBtn">+&nbsp;新增车载终端</label>
        </div>
        <%--tab--%>
        <div id="device_tableDiv">
            <table id="device_table" class="bootsrapTable" style="width: 100%;">
            </table>
        </div>
        <div id="etag_tableDiv" style="display: none">
            <table id="etag_table" class="bootsrapTable" style="border-radius:0px;">
            </table>
        </div>
</div>
<%--编辑Or新增终端--%>
<div id="device_deviceWindow" style="width:400px;height:326px;border:1px #f5f7fa solid;font-size:12px;display:none">
    <div class="edit-context" style="text-align: center">
        <table id="device-edit-table">
            <tbody>
            <tr>
                <th>车牌号:</th>
                <th><input id="edit_deviceVechilno" name="vechileno"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>终端设备号:</th>
                <th><input id="edit_deviceid" name="deviceid"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>装置品牌:</th>
                <th><input id="edit_device_brand" name="brand"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>装置型号:</th>
                <th><input id="edit_device_model" name="model"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>IMEI号:</th>
                <th><input id="edit_device_imei"name="imei"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>SIM卡号:</th>
                <th><input id="edit_device_sim"  name="sim" maxlength="11" type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>安装日期:</th>
                <th><input id="edit_device_installdate" readonly="readonly" name="installdate" onclick="laydate()"  type="text" class="defaultInput" /></th>
            </tr>
            <tr style="display: none;">
                <th>创建时间:</th>
                <th><input id="edit_device_createtime" name="createtime" readonly="readonly" type="text" class="defaultInput" /></th>
            </tr>
            </tbody>
        </table>
        <div style="width:100%;text-align:center;margin-top:5px;">
            <input type="button" class="edit_cancel_btn" style="" value="取&nbsp;消" />
            <input id="device_device_submit" type="button" class="edit_submit_btn"value="提交" /> </div>
        </div>
</div>
<%--编辑Or新增电子标签--%>
<div id="device_etagWindow" style="width:400px;height:300px;border:1px #f5f7fa solid;font-size:12px;display:none">
    <div class="edit-context">
        <table id="etag-edit-table">
            <tbody>
            <tr>
                <th>车牌号:</th>
                <th><input id="edit_etagVechilno" name="vechileno"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>标签编号:</th>
                <th><input id="edit_etagetagid" name="etagid"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>装置品牌:</th>
                <th><input id="edit_etagbrand" name="brand"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>装置型号:</th>
                <th><input id="edit_etagmodel" name="model"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>IMEI号:</th>
                <th><input id="edit_etagimei"name="imei"  type="text" class="defaultInput" /></th>
            </tr>
            <tr>
                <th>安装日期:</th>
                <th><input id="edit_etaginstalldate"   name="installdate" type="text" class="defaultInput" /></th>
            </tr>
            <tr style="display: none;">
                <th>创建时间:</th>
                <th><input id="edit_etagcreatetime" name="createtime" readonly="readonly" type="text" class="defaultInput" /></th>
            </tr>
            </tbody>
        </table>
        <div style="width:100%;text-align:center;margin-top:5px;">
            <input type="button" class="edit_cancel_btn" style="" value="取&nbsp;消" />
            <input id="device_etag_submit" type="button" class="edit_submit_btn"value="提交" /> </div>
    </div>
</div>
</div>
<script type="text/javascript">
    var table=$(window).height()-65;
    $('#div_device_table').css('height',table);


    ///=================================================================
    $("#device_tab_device").click(function () {
     $("#device_tab_etag").css({"padding-top":"5px","backgroundColor":"#f4f7fa"});
        $(this).css({"padding-top":"10px","backgroundColor":"#fff"});
        $("#etag_tableDiv").hide();
        $("#device_tableDiv").show();
        $("#device_btn_add").text("新增车载终端");
    })

    $("#device_tab_etag").click(function () {
        $("#device_tab_device").css({"padding-top":"5px","backgroundColor":"#f4f7fa"});
        $(this).css({"padding-top":"10px","backgroundColor":"#fff"});
        $("#device_tableDiv").hide();
        $("#etag_tableDiv").show();
        $("#device_btn_add").text("新增电子标签");
    })

    //终端
    $('#device_table').bootstrapTable({
        classes: "table-no-bordered",
        url: "deviceEtag/findDeviceByParm",
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
                sort: "deviceid",
                value: $.trim($("#deviceinfo_searchValue").val()),
                parameter: $("#deviceinfo_selctParm option:selected").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "deviceid",
        searchTimeOut: 10000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize: 10,//	如果设置了分页，页面数据条数
        pageList: [10, 20, 30],
//        idField: "deviceid",//指定主键
        uniqueId: "deviceid",//唯一标识符
        singleSelect: true,//禁止多选
        height:changeValue(),
        columns: [
            {field: 'vechileno', title: '车牌号', align: "center"},
            {field: 'deviceid', title: '终端设备号', align: "center"},
            {field: 'brand', title: '装置品牌', align: "center"},
            {field: 'model', title: '型号', align: "center"},
            {field: 'imei', title: 'IMEI', align: "center"},
            {field: 'sim', title: 'SIM卡号', align: "center"},
            {field: 'installdate', title: '安装日期', align: "center"},
            {field: 'createtime', title: '添加时间', align: "center"},
            {field: 'updatetime', title: '更新时间', align: "center"},
            {field: 'deviceid', title: '操作', align: "center",
                formatter:function (value,row,index) {
                    return "<img class='device_rowTool' onclick='editDevice("+value+")' src='pic/fence/edit.png'/><img class='device_rowTool' onclick='deleteDevice("+value+")' src='pic/fence/delete.png'/>"
            }}]
    });

    //电子标签
    $('#etag_table').bootstrapTable({
        classes: "table-no-bordered",
        url: "deviceEtag/findEtagByParm",
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
                sort: "deviceid",
                value: $.trim($("#deviceinfo_searchValue").val()),
                parameter: $("#deviceinfo_selctParm option:selected").val(),
                areacode: areacode
            }
            return newParme;
        },
        checkbox: true,
        striped: true,//启用各行变色
        radio: true,
        clickToSelect: true,
        selectItemName: "etagid",
        searchTimeOut: 10000,//超时时间
        paginationPreText: "<",//上一页显示图标
        paginationNextText: ">",
        sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,//	如果设置了分页，首页页码
        pageSize: 10,//	如果设置了分页，页面数据条数
        pageList: [10, 20, 30],
        idField: "etagid",//指定主键
        uniqueId: "etagid",//唯一标识符
        singleSelect: true,//禁止多选
        height:changeValue() ,
        columns: [
            {field: 'vechileno', title: '车牌号', align: "center"},
            {field: 'etagid', title: '标签编号', align: "center"},
            {field: 'brand', title: '装置品牌', align: "center"},
            {field: 'model', title: '装置型号', align: "center"},
            {field: 'imei', title: 'IMEI', align: "center"},
            {field: 'installdate', title: '安装日期', align: "center"},
            {field: 'createtime', title: '添加时间', align: "center"},
            {field: 'updatetime', title: '更新时间', align: "center"},
            {field: 'etagid', title: '操作', align: "center",
            formatter:function (value,row,index) {
                return "<img class='device_rowTool' onclick='editEtag("+value+")' src='pic/fence/edit.png'/><img class='device_rowTool' onclick='deleteEtag("+value+")' src='pic/fence/delete.png'/>"
            }}]
    });

    function changeValue(){
        //判断360浏览器
        var screenWidtha =$(window).width();
        if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
            //=============================
            if(screenWidtha > 1400){
                return 680;
            }else{
                return 400;
            }
        }
        // 判断Chrome
        else if(navigator.userAgent.indexOf("Chrome") >0)
        {
            if(screenWidtha > 1400){
                return 680;
            }else{
                return 380;
            }
        }
        // 判断afari
        else if(navigator.userAgent.indexOf("Safari") >0)
        {
            return 560;
        }

    }

    $("#car_searchBtn").click(function () {
        var padding_top= $("#device_tab_etag").css("padding-top");
        if(padding_top=='5px'){
            $("#device_table").bootstrapTable("refresh", {url: "deviceEtag/findDeviceByParm"}, {query: {order: "deviceid"}});
        }else{
            $("#etag_table").bootstrapTable("refresh", {url: "deviceEtag/findEtagByParm"}, {query: {order: "etagid"}});
        }
    });

    function editEtag(etagid) {//etag-edit-table
        var row=$('#etag_table').bootstrapTable('getRowByUniqueId', etagid);
        var inputs = $("#etag-edit-table input");
        var propertys = []
        for (var property in row) {
            propertys.push(property);
        }
        //绑定详情属性
        for (var key in row) {
            for (var i = 0; i < inputs.length; i++) {
                var input = inputs[i];
                if ($(input).attr('name') == key) {
                    $(input).val(row[key]);
                }
            }
        }
         layer.open({
            title:"编辑电子标签",
            skin:"device-EditWindow",
            type: 1,
            shade: false,//不出现阴影
            area: ['400px', '350px'], //宽高
            content: $("#device_etagWindow")
         });
        $("#device_etag_submit").attr("title","update");
        $("#edit_etagVechilno").attr("readonly","readonly");
        $("#edit_etagetagid").attr("readonly","readonly");
        $("#edit_etaginstalldate").attr("readonly","readonly");
    }

    function editDevice(deviceid){
        layer.closeAll();
        var row=$('#device_table').bootstrapTable('getRowByUniqueId', deviceid);
        //layer.alert(deviceid+"===="+row.brand+"=="+row);
        var inputs = $("#device-edit-table input");
        var propertys = []
        for (var property in row) {
            propertys.push(property);
        }
        //绑定详情属性
        for (var key in row) {
            for (var i = 0; i < inputs.length; i++) {
                var input = inputs[i];
                if ($(input).attr('name') == key) {
                    $(input).val(row[key]);
                }
            }
        }
        layer.open({
            title:"编辑车载设备",
            skin:"device-EditWindow",
            type: 1,
            shade: false,//不出现阴影
            area: ['400px', '370px'], //宽高
            content: $("#device_deviceWindow")
        });
        $("#device_device_submit").attr("title","update");
        $("#edit_deviceVechilno").attr("readonly","readonly");
        $("#edit_deviceid").attr("readonly","readonly");
        $("#edit_device_installdate").attr("readonly","readonly");
    }


    //提交
    $("#device_device_submit").click(function () {
        var todo= $(this).attr("title");
        var edit_deviceVechilno= $("#edit_deviceVechilno").val();
        var deviceid=$("#edit_deviceid").val();
        var brand=$("#edit_device_brand").val();
        var model=$("#edit_device_model").val();
        var imei=$("#edit_device_imei").val();
        var sim=$("#edit_device_sim").val();
        var installdate=$("#edit_device_installdate").val();
        if(todo=='update'){
            var createtime=$("#edit_device_createtime").val();
            $.post("deviceEtag/updateDevice",{deviceid:deviceid,brand:brand,model:model,imei:imei,sim:sim,installdate:installdate,createtime:createtime},function(data) {
                layer.alert(data.desc);
                if(data.name=='success'){
                    $("#device_table").bootstrapTable("refresh");
                }
            })
        }else if(todo=='add'){
            if(edit_deviceVechilno.length!=0&&deviceid.length!=0&&brand.length!=0&&model.length!=0&&imei.length!=0&&sim.length!=0&&installdate.length!=0){
                $.post("deviceEtag/addDevice",{vechileno:edit_deviceVechilno,deviceid:deviceid,brand:brand,model:model,imei:imei,sim:sim,installdate:installdate,createtime:createtime},function(data) {
                    layer.alert(data.desc);
                    if(data.name=='success'){
                      //  $("#device_table").bootstrapTable("refresh", {url: "deviceEtag/findDeviceByParm"}, {query: {order: "deviceid"}});
                    }
                });
             }else{ 
                layer.msg("输入不能为空");
             }
        }
    });


    //
    $("#device_etag_submit").click(function () {
        var todo= $(this).attr("title");
        var edit_deviceVechilno= $("#edit_etagVechilno").val();
        var etagid=$("#edit_etagetagid").val();
        var brand=$("#edit_etagbrand").val();
        var model=$("#edit_etagmodel").val();
        var imei=$("#edit_etagimei").val();
        var installdate=$("#edit_etaginstalldate").val();
        if(todo=='update'){
            var createtime=$("#edit_etagcreatetime").val();
            $.post("deviceEtag/updateEtag",{etagid:etagid,brand:brand,model:model,imei:imei,installdate:installdate,createtime:createtime},function(data) {
                layer.alert(data.desc);
                if(data.name=='success'){
                    $("#etag_table").bootstrapTable("refresh");
                }
            })
        }else if(todo=='add'){
            if(edit_deviceVechilno.length!=0&&etagid.length!=0&&brand.length!=0&&model.length!=0&&imei.length!=0&&installdate.length!=0){
                $.post("deviceEtag/addEtag",{vechileno:edit_deviceVechilno,etagid:etagid,brand:brand,model:model,imei:imei,installdate:installdate},function(data) {
                    layer.alert(data.desc);
                    if(data.name=='success'){
                        $("#etag_table").bootstrapTable("refresh");
                    }
                });
            }else{
                layer.msg("输入不能为空");
            }
        }
    });



    function deleteDevice(deviceid) {
        layer.confirm('确定删除？', {
            btn: ['取消','确定'] //按钮
        }, function(){
            layer.closeAll();
        }, function(){
            $.get("deviceEtag/deleteDevice?deviceid="+deviceid, function(data){
                layer.alert(data.desc);
                if(data.name=="success"){
                    $("#device_table").bootstrapTable("refresh", {url: "deviceEtag/findDeviceByParm"}, {query: {order: "deviceid"}});
                }
            });
        });
    }

    function deleteEtag(etagid) {
        layer.confirm('确定删除？', {
            btn: ['取消','确定'] //按钮
        }, function(){
            layer.closeAll();
        }, function(){
            $.get("deviceEtag/deleteEtag?etagid="+etagid, function(data){
                layer.alert(data.desc);
                if(data.name=="success"){
                    $("#etag_table").bootstrapTable("refresh", {url: "deviceEtag/findEtagByParm"},{query:{order:"deviceid"}});
                }
            });
        });
    }

    $(".edit_cancel_btn").click(function () {
        layer.closeAll();
    })

    //add
    $("#device_btn_add").click(function () {
        var padding_top= $("#device_tab_etag").css("padding-top");
        layer.closeAll();
        if(padding_top=='5px'){
            $("#device-edit-table input").val("");
            $("#device_device_submit").attr("title","add");
            $("#edit_deviceVechilno").removeAttr("readonly");
            $("#edit_deviceid").removeAttr("readonly");
            $("#edit_device_installdate").removeAttr("readonly");
            layer.open({
                title:"新增车载设备",
                skin:"device-EditWindow",
                type: 1,
                shade: false,//不出现阴影
                area: ['400px', '370px'], //宽高
                content: $("#device_deviceWindow")
            });
        }else{
            $("#etag-edit-table input").val("");
            $("#device_etag_submit").attr("title","add");
            $("#edit_etagVechilno").removeAttr("readonly");
            $("#edit_etagetagid").removeAttr("readonly");
            $("#edit_etaginstalldate").removeAttr("readonly");
            layer.open({
                title:"新增电子标签",
                skin:"device-EditWindow",
                type: 1,
                shade: false,//不出现阴影
                area: ['400px', '343px'], //宽高
                content: $("#device_etagWindow")
            });
        }
    })


    layui.use('laydate', function(){
        var laydate = layui.laydate;
        document.getElementById('edit_etaginstalldate').onfocus = function(){
            laydate({
                elem:this,
                min: '2016-06-16'
                ,max: '2099-06-16'
                ,istoday: false
            });
        }
        document.getElementById('edit_device_installdate').onfocus = function(){
            laydate({
                elem:this,
                min: '2016-06-16'
                ,max: '2099-06-16'
                ,istoday: false
            });
        }

    });
</script>
</body>