<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/7/4
  Time: 14:22
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
    <!--<link rel="stylesheet" href="">-->
    <!--<script src=""></script>-->
    <title>在线认证</title>
</head>
<body style="margin:0px;padding:0px;width:100%;height:100%;">
<div id="auth-context"
     style="background-color:white;width:100%;height:100%;overflow-y:scroll;padding-top:10px;overflow-x: hidden;">
    <div id="auth-tool" style="width:100%;height:50px;margin-left:10px;border-bottom:2px solid #C6C6C6;">
        <div style="margin-left:10px;float: left">
            <div style="font-size:18px;float: left">当前认证公司标识:&nbsp;<label id="auth-companyidc"><c:if
                    test="${!empty companyidc}">${companyidc}</c:if></label></div>
            <div style="float:left;">
            <button id="auth-search-btn" class="btn_blue" style="margin-left:20px;">查询认证结果</button>
            </div>
            <div style="float:left;margin-left:10px;height:20px;margin-top:10px;">
                <ul style="list-style:none;height:20px;line-height:20px;">
                    <li style="float: left;line-height:20px;"><label style="height:15px;width:15px;background-color:green;"></label></li>
                    <li style="float: left;line-height:20px;"><label style="height:20px;">&nbsp;通过</label></li>
                    <li style="float: left;line-height:20px;margin-left:10px;"><label style="height:15px;width:15px;background-color:#ff8a76;"></label></li>
                    <li style="float: left;line-height:20px;"><label>&nbsp;未通过</label></li>
                </ul>
            </div>
            <div style="float:left;line-height:50px;">


            </div>
        </div>
        <div style="float:right;margin-right:40px;">
            <button id="auth-alertAddCompanyidc-btn" class="btn_blue" style="">添加认证
            </button>
            <button id="auth-historyAuth-btn" class="btn_blue" style="">查看历史认证</button>
        </div>
    </div>

    <div id="auth-companyAuthState-context" class="container-fluid">
        <div class="row" style="border-bottom:1px solid #C6C6C6;height:40px;margin-top:10px;">
            <div class="col-md-12" style="padding:10px;font-size:18px;">
                基本静态信息交互接口
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align:center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">网约车平台公司基本信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">网约车平台公司营运规模信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">网约车平台公司支付信息接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">网约车平台公司服务机构接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">网约车平台公司经营许可接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">网约车平台公司运价信息接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">车辆基本信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">车辆保险信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">网约车车辆里程信息接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">驾驶员基本信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">网约车驾驶员培训信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">驾驶员移动终端信息接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">驾驶员统计信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">乘客基本信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;margin-left:20px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="border-bottom:1px solid #C6C6C6;height:40px;margin-top:10px;">
            <div class="col-md-12" style="padding:10px;font-size:18px;">
                订单信息交互接口
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">订单发起接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">订单成功接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">订单撤销接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="border-bottom:1px solid #C6C6C6;height:50px;margin-top:10px;">
            <div class="col-md-12" style="padding:10px;font-size:18px;">
                经营信息交互接口
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">车辆经营上线接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">车辆经营下线接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">经营出发接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">经营到达接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">经营支付接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;margin-left:20px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="border-bottom:1px solid #C6C6C6;height:50px;margin-top:10px;">
            <div class="col-md-12" style="padding:10px;font-size:18px;">
                定位信息交互接口
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">驾驶员定位信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">车辆定位信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="border-bottom:1px solid #C6C6C6;height:50px;margin-top:10px;">
            <div class="col-md-12" style="font-size:18px;padding:10px;">
                服务质量信息交互接口
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">乘客评价信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">乘客投诉信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;margin-left:20px;color:white;">
                <div class="auth-interfacename">驾驶员处罚信息接口</div>
                <div></div>
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">驾驶员信誉信息接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;">
            </div>
            <div class="col-md-3" style="text-align: center;">
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="border-bottom:1px solid #C6C6C6;height:50px;margin-top:10px;">
            <div class="col-md-12" style="font-size:18px;padding:10px;">
                其他接口
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;padding:10px;background-color:#ff8a76;color:white;">
                <div class="auth-interfacename">文件接口</div>
                <div></div>
            </div>
            <div class="col-md-3" style="text-align: center;">
            </div>
            <div class="col-md-3" style="text-align: center;">
            </div>
            <div class="col-md-1" style="text-align:center;padding:10px;">
                <div class="auth-interfacename"></div>
                <div></div>
            </div>
        </div>
        <div class="row" style="height:50px;margin-top:10px;">
            <div class="col-md-12" style="height:40px;padding:10px;">
            </div>
        </div>
        <%--添加公司idc--%>
        <div id="auth-addCompanyidc" style="display:none;text-align: center;padding:30px;">
            <div><input id="auth-companyidc-inputValue" name="companyidc" maxlength="255" class="defaultInput"
                        placeholder="请输入companyidc"></div>
            <div style="padding-top:25px;">
                <button id="auth-addCompanyidc-btn"
                        style="border:1px solid dodgerblue;background-color:dodgerblue;color:white;border-radius: 4px;font-size:16px;padding:5px;">
                    确定添加
                </button>
            </div>
        </div>
    </div>

    <%--表格查询--%>


</div>
</body>
<script type="text/javascript">

    $("#auth-context").css("height", $(window).height() - 145 + "px");


    $("#auth-search-btn").click(function () {
        var index = layer.load(1, {
            shade: [0.2, '#fff']
        });
        var companyidc = $("#auth-companyidc").text();
        $("#auth-companyAuthState-context .auth-interfacename").next().empty();
        $.get("/auth/getCompanyAuthInterfaceState", {companyidc: companyidc}, function (datas) {
            layer.close(index);
            var items = $("#auth-companyAuthState-context .auth-interfacename");//接口项;
            if (datas != null && datas.length != 0) {
                for (var i = 0; i < datas.length; i++) {
                    for (var j = 0; j < items.length; j++) {
                        if (datas[i].name == $(items[j]).text()) {
                          //  $(items[j]).next().append(datas[i].desc == "false" ? "<label style='color:red;'>未通过" : "<label style='color:green'>通过</label>");
                            if(datas[i].desc == "false"){
                                $(items[j]).parent().css("backgroundColor","#ff8a76");
                            }else{
                                $(items[j]).parent().css("backgroundColor","green");
                            }

                        }
                    }
                }
            } else {
                layer.alert("无相关信息");
            }
        })
    });


    //点击添加认证
    $("#auth-alertAddCompanyidc-btn").click(function () {
        layer.open({
            title: "添加新认证公司",
            type: 1,
            area: ['420px', '240px'], //宽高
            content: $("#auth-addCompanyidc")
        });
    });


    //确定添加
    $("#auth-addCompanyidc-btn").click(function () {
        var companyidc = $.trim($("#auth-companyidc-inputValue").val());
        if (companyidc.length != 0) {
            $.post("/auth/addCompanyidc", {companyidc: companyidc}, function (message) {
                layer.alert(message.desc);
            })
        } else {
            layer.alert("输入不能为空");
        }
    });

    $("#auth-historyAuth-btn").click(function () {
        layer.open({
            type: 2,
            title: '历史认证',
            shadeClose: true,
            area: ['800px', '90%'],
            content: '/auth/hisAuth'
        });
    })


</script>
</html>
