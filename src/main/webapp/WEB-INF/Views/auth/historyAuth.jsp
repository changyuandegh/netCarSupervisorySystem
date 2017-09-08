<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/7/5
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
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
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no,width=device-width"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="vendor/bootstrap_table/bootstrap.min.css">
    <link rel="stylesheet" href="vendor/bootstrap_table/bootstrap-table.min.css">
    <script src="js/jquery-2.1.4.js"></script>
    <script src="vendor/bootstrap_table/bootstrap-table.min.js"></script>
    <script src="vendor/bootstrap_table/bootstrap-table-zh-CN.min.js"></script>
    <style>
        .bootsrapTable {
            font-size: 12px;
            border-radius: 2px;
            font-family: Palatino;
        }

        .bootsrapTable thead th {
            background-color: #D5E5FD;
            color: #354052;
            border-left: none;
        }

        .bootsrapTable tbody tr {
            line-height: 40px;
        }
    </style>
    <title>历史认证</title>
</head>
<body>
<div style="width:100%;">
    <div id="hisAuth-tool" style="height:50px;width:100%;padding:20px;">
        <select id="hisAuth-companyidcs-select" style="height:24px;line-height: 24px;">
            <c:if test="${!empty companyidcs}">
                <c:forEach items="${companyidcs}" var="companyidc">
                    <option value="${companyidc}">${companyidc}</option>
                </c:forEach>
            </c:if>
        </select>
        <button id="hisAuth-search-btn"
                style="background-color:deepskyblue;color:white;padding:5px;font-size:14px;border-radius:4px;border:none;margin-left:10px;">
            查&nbsp;&nbsp;询
        </button>
    </div>
    <div style="margin-top:10px;">
        <table id="hisAuth-table" class="bootsrapTable" style="width: 100%"></table>
    </div>
</div>
</body>
<script type="text/javascript">
    $('#hisAuth-table').bootstrapTable({
        classes: "table-no-bordered",
        url: "/auth/findHisAuthToTableByCompanyidc",
        queryParams: function (parme) {
            var companyidc = $("#hisAuth-companyidcs-select option:selected").val();
            var newParme = {
                limit: parme.limit,//页面大小
                offset: parme.offset,//页码
                companyidc: companyidc
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
        idField: "driverid",//指定主键
        uniqueId: "driverid",//唯一标识符
        singleSelect: true,//禁止多选
        height: 450,
        columns: [{
            //c.id, c.companyidc,c.checked,i.interfacename
            field: 'id', title: '编号', align: "center", formatter: function (value, row, index) {
                return index + 1;
            }
        }, {field: 'interfacename', title: '接口名称', align: "center"},
            {
                field: 'checked', title: '状态', align: "center", formatter: function (value, row, index) {
                if (value == 0) {
                    return "未通过"
                } else {
                    return "通过";
                }
            }
            }, {field: 'companyidc', title: '公司标识', align: "center"}
        ]
    });

    $("#hisAuth-search-btn").click(function () {
        $("#hisAuth-table").bootstrapTable("refresh", {url: "/auth/findHisAuthToTableByCompanyidc"}, {query: {order: "asc"}});
    });
</script>
</html>
