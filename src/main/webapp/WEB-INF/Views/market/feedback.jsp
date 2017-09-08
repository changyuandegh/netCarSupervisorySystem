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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no,width=device-width"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <!--<link rel="stylesheet" href="">-->
    <!--<script src=""></script>-->
    <title>订单管理</title>
</head>
<body>
<div id="feedback-context" style="background-color:white;margin:0px;padding:0px;width:100%;">
<!-- 订单详情弹窗 -->
<div class="information-window" id="information">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this">接单司机</li>
            <li>订单明细</li>
            <li>支付明细</li>
            <li>订单售后</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="window-base">
                    <div><img src="./pic/driverphoto.jpg">
                    </div>
                    <div>
                        <p>接单司机：黎明</p>
                        <p>平均接单量：33.4次／每日</p>
                        <p>投诉量：33次</p>
                        <p>驾驶车辆：豫A49494</p>
                        <p>爽约率：24%</p>
                        <p>信誉度：55.6%</p>
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="window-base">
                    <div style="padding:10px;width:90%;margin-left:5%">
                        <p>驾驶证号：345989435834</p>
                        <p>驾驶证类型：C1</p>
                        <p>驾驶证领取日期：2017/3/23</p>
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="window-base">
                    <div style="padding:10px;width:90%;margin-left:5%">
                        <p>支付金额：345989435834</p>
                        <p>支付方式：支票</p>
                        <p>支付日期：2017/3/23</p>
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="window-base">
                    <div style="padding:10px;width:90%;margin-left:5%">
                        <p>乘客评价：很好，司机热情好客！</p>
                        <p>投诉建议：暂无</p>
                        <p>评价日期：2017/3/23</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="window-close"><img src="./pic/tab_close.png"></div>
</div>

<!-- 运价弹窗 -->
<div class="price-window" style="display:none;">
    <div>滴滴出行的运价详情
        <div class="window-close" style="line-height:20px">X</div>
    </div>
    <div>
        <div><img src="./pic/market/didi.jpeg"></div>
        <div>
            <p>单程加价单价：1元</p>
            <p>单程加价公里：公里</p>
            <p>营运早高峰时间起：8:00</p>
            <p>营运早高峰时间止：22:00</p>
            <p>营运晚高峰时间起：22:00</p>
            <p>营运晚高峰时间止：22:00</p>
            <p>营运时长费用：2元</p>
            <p>平均营运价格：9元／公里</p>
            <p>夜间加收服务费：2元</p>
            <p>平均加收服务费：2元／公里</p>
        </div>
    </div>
</div>

<!-- 市场把控 -->
<div id="appraise-top">
    <select class="selectStyle" style="margin-right:5px;height:27px;">
        <option>订单号</option>
    </select>
    <input id="feedback-search" type="text" maxlength="50" placeholder="请输入订单号" style="width:318px;height: 28px;border-radius: 4px;background-color: #ffffff;border: solid 1px #dfe3e9;padding-left:4px;line-height:28px;">
    <div id="feedback-searchBtn" class="search-buttom" style="margin-left:10px;display:inline-block;float:none">查询</div>
</div>
<div class="appraise-middel">
    <div>订单号：<span id="feedback-orderid"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单时间：<span id="feedback-ordertime"></span></div>
    &nbsp;&nbsp;&nbsp;接单车牌：<span id="feedback-vechelno"></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司机驾驶证：<span id="feedback-licenseid"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乘客电话：<span id="feedback-passagetPhone"></span>
</div>
<div id="appraise-content">
    <div>
        <div class="tell-some">
            <img src="./pic/market/credibility_evalution.png">
            <div class="appraise-list">
                <div style="color:#354052;font-size:18px">订单评价</div>
                <div style="font-size:14px">评价内容:<span id="feedback-detail" style="color:#ff7d27;font-size:14px"></span></div>
                <div id="feedback-servicescore" style=""></div>
            </div>
        </div>
        <div class="tell-some">
            <img src="./pic/market/credibility_evalution1.png">
            <div class="appraise-list">
                <div style="color:#354052;font-size:18px">投诉建议</div>
                <div style="font-size:14px">投诉内容:<span id="feedback-complaintDetail" style="color:#ff7d27;font-size:14px"></span></div>
                <%--<div>--%>
                    <%--<p>建议内容：<span></span></p>--%>
                <%--</div>--%>
            </div>
        </div>
        <div class="tell-some">
            <img src="./pic/market/credibility_penalties.png">
            <div class="appraise-list">
                <div style="color:#354052;font-size:18px">违规处罚</div>
                <div style="font-size:14px" style="color:#ff7d27;font-size:14px">处理结果:<span id="feedback-result" style="color:#ff7d27;font-size:14px"></span></div>
            </div>
        </div>
    </div>
    <div>
        <%--<h3 style="color:#354052">投诉建议</h3>--%>
        <%--<p style="color:#ff7d27">“司机在车上饮酒”</p>--%>
        <%--<img src="./pic/driverphoto.jpg">--%>
        <%--<p>处理状态：未处理</p>--%>
        <%--<p>处理结果：对司机进行罚款和扣分</p>--%>
    </div>
</div>

<script type="text/javascript">

    $("#feedback-serverScope").raty({readOnly:true,score:3});
 //   $("#feedback-serverScope").css("width",'200px');

    $("#feedback-searchBtn").click(function(){
        var searchvalue=$.trim($("#feedback-search").val());
        if(searchvalue.length!=0){
            $.get('order/getFeedBackByorderid',{orderid:searchvalue},function(feedback){
                if(feedback.length!=0){
                    showDesc(feedback);
                }else{
                    layer.msg("查无相关数据");
                    resetShowDesc();
                }
            })
        }else{
            layer.tips('请输入订单号', '#feedback-search', {
                tips: [3, 'red'],
                time: 3000
            });
        }
    });

    function showDesc(feedback) {
//        private String orderid;
//        private String ordertime;
//        private String vechelno;
//        private String passagetPhone;
//        private String licenseid;
//
//        private String servicescore;//评价等级
//        private String detail;//评价内容
//
//        //投诉建议
//        private String complaintDetail;//投诉内容
//        private String result;//处理结果

        $("#feedback-orderid").text(feedback.orderid);
        $("#feedback-ordertime").text(feedback.ordertime);
        $("#feedback-vechelno").text(feedback.vechelno);
        $("#feedback-passagetPhone").text(feedback.passagetPhone);
        $("#feedback-licenseid").text(feedback.licenseid);
        $("#feedback-servicescore").raty({readOnly:true,score:feedback.servicescore});
        $("#feedback-servicescore").css("width","150px");
        $("#feedback-detail").text(feedback.detail);
        $("#feedback-complaintDetail").text(feedback.complaintDetail);
        $("#feedback-result").text(feedback.result);
    }

    //重置
    function resetShowDesc() {
        $("#feedback-orderid").text("");
        $("#feedback-ordertime").text("");
        $("#feedback-vechelno").text("");
        $("#feedback-passagetPhone").text("");
        $("#feedback-licenseid").text("");
        $("#feedback-servicescore").text("");
        $("#feedback-detail").text("");
        $("#feedback-complaintDetail").text("");
        $("#feedback-result").text("");
    }


    // 窗口关闭事件
    $('.window-close').click(function(){
        $(this).parents('.price-window').hide();
        $('#mark').hide();
    })

</script>
</div>
</body>
</html>
<script>
    var screen_width = $(window).width();
    //判断360浏览器
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        //=============================
        if(screen_width > 1400){
            $('.tell-some').css('height','33.3333%');
        }else{
            $('.tell-some').css('height','27.3333%');
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
        $('.tell-some').css('height','33.3333%');
    }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
        $('.tell-some').css('height','33.3333%');
    }
</script>
