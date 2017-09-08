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
<div id="div_company_table" style="background-color:white;margin:0px;padding-bottom:0px;padding-top:10px;">
    <%--tool--%>
    <div style="height:35px;width:100%;">
        <select id="driver_selctParm" class="defualt_select" style="float:left;line-height:30px;">
            <option value="drivername">司机姓名</option>
            <option value="driverphone">手机号</option>
            <option value="licenseid">驾驶证号</option>
        </select>
        <input id="driver_searchValue" class="defaultInput" type="text" placeholder="请输入"/>
        <input id="driver_searchBtn" class="btn_blue" type="button" value="查询"/>
        <input id="driver_showBtn" class="btn_blue" type="button" value="显示" style="display:none;"/>
    </div>
    <%--tool--%>
    <table id="driver_table" class="bootsrapTable" style="width: 100%">
    </table>
</div>
<!-- 信息弹窗 -->
<div class="information-window" id="information">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this">基本信息</li>
            <li>驾驶员培训信息</li>
            <li>驾驶员移动终端信息</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="window-base">
                    <div><img src="./pic/driverphoto.jpg">
                        <h4 style="text-align:center">王进喜</h4>
                    </div>
                    <div>
                        <p>性别：男</p>
                        <p>国籍：中国</p>
                        <p>民族：汉族</p>
                        <p>出生日期：1993/22/03</p>
                        <p>婚姻状况：未婚</p>
                        <p>学历：研究生</p>
                        <p>户口登记机关名称：站南区派出所</p>
                        <p>户口或常住地址：郑州市二七区二七万达2号221</p>
                        <p>通信地址：郑州市二七区二七万达2号221</p>
                        <p>注册地行政区域代码：48474834949494534</p>
                        <p>手机号：135555555555</p>
                        <p>服务类型：网络预约出租车</p>
                        <p>驾驶员合同（或协议）签署公司：神州专车</p>
                        <p>合同（或协议）有效期起：2017/04/14</p>
                        <p>合同（或协议）有效期止：2019/04/14</p>
                        <p>紧急情况联系人：牟翠花</p>
                        <p>紧急情况联系人电话：138888888888</p>
                        <p>紧急情况联系人通信地址：郑州市二七区紫金山百货大楼2号3349郑州市二七区紫金山百货大楼2号3349郑州市二七区紫金山百货大楼2号3349郑州市二七区紫金山百货大楼2号3349郑州市二七区紫金山百货大楼2号3349郑州市二七区紫金山百货大楼2号3349郑州市二七区紫金山百货大楼2号3349</p>
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="window-base">
                    <div><img src="./pic/driverphoto.jpg">
                        <h4 style="text-align:center">王进喜</h4>
                    </div>
                    <div>
                        <p>驾驶证号：345989435834</p>
                        <p>驾驶证类型：C1</p>
                        <p>驾驶证领取日期：3017/3/23</p>
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="window-base">
                    <div><img src="./pic/driverphoto.jpg">
                        <h4 style="text-align:center">王进喜</h4>
                    </div>
                    <div>
                        <p>终端设备号：CXf94949434990</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="window-close"><img src="./pic/tab_close.png"></div>
</div>

<!-- 修改弹窗 -->
<div class="information-window" id="edit">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this">新增车载终端</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <h4 style="font-size: 14px;color:#8493A8;">终端信息</h4>
                <p class="edit-factory">终端厂商：<input type="text" placeholder="请输入终端厂商"></p>
                <p class="edit-factory">厂商编号：<input type="text" placeholder="请输入终端厂商"></p>
                <p class="edit-factory">设备型号：<input type="text" placeholder="请输入终端厂商"></p>
                <p class="edit-factory">SIM卡号：<input type="text" placeholder="请输入终端厂商"></p>
                <p class="edit-factory">安装时间：<input type="text" placeholder="请输入终端厂商"></p>
            </div>
        </div>
    </div>
    <div class="window-close"><img src="./pic/tab_close.png"></div>
</div>
<script type="text/javascript">
    //捕获页
//    layer.open({
//        type: 1,
//        shade: false,
//        title: false,
//        content: $('#edit')
//    });
    //窗口关闭事件
    $('.window-close').click(function(){
        $(this).parent().hide();
        $('#mark').hide();
    })
</script>
<script src="js/database/database.js"></script>
</body>
</html>