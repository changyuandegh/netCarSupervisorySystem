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
    <style>

    </style>
</head>
<body >
<div id="div_company_table" style="background-color:white;margin:0px;padding-bottom:0px;padding-top:10px;">
    <%--tool--%>
    <div style="height:35px;width:100%;">
        <select id="company_selctParm" class="defualt_select" style="float:left;line-height:30px;">
            <option value="companyname">公司名称</option>
        </select>
        <input id="company_searchValue" class="defaultInput" type="text" placeholder="请输入"/>
        <input id="company_searchBtn" class="btn_blue" type="button" value="查询"/>
    </div>
    <%--tool--%>
    <table id="company_table" class="bootsrapTable" style="width:100%">
    </table>
</div>
<script src="js/database/database.js"></script>
</body>
</html>