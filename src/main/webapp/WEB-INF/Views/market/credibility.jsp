<%--
  Created by IntelliJ IDEA.
  User: Mander
  Date: 2017/6/12
  Time: 10:43
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
    <style>

    </style>
    <title>Title</title>
</head>
<body>
<div id="cre_height" class="credibility" style="background-color:white;padding:0px;width:100%;border-radius:4px;overflow: scroll;">
    <%--公司信誉start--%>
     <div id="cer_heightcompany" style="width:100%;">
        <div style="width:100%;height:50px;padding-left:20px;border-bottom:1px #e6eaee solid;">
            <label style="line-height:50px;font-size:14px;color: #5a687b;font-weight:400;">请选择公司</label>
            <select id="credibility-select-companys" class="selectStyle" style="margin-right:5px;height:27px;">
                <option>滴滴出行</option>
            </select>
        </div>
         <div class="credibility-context" style="overflow: hidden">
             <div title="乘客评价" style="float:left;width:33.3%;height:240px;text-align:center;">
                 <div style="height:20px;color:#354052;font-size:18px;margin-top:20px;margin-bottom:10px;">平台乘客评价</div>
                 <%--<div style="text-align:center;width:100%;height:20px;margin-left:100px;">--%>
                     <%--<ul style="list-style: none;margin-bottom:5px;">--%>
                         <%--<li style="float:left;height:20px;"><div id="credibility-company-start"></div></li>--%>
                         <%--<li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">4分</li>--%>
                         <%--<li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;"></li>--%>
                     <%--</ul>--%>
                 <%--</div>--%>
                 <div style="text-align:center;width:100%;height:20px;margin-left: 33.7%;margin-top: 44px;">
                     <ul style="list-style: none;margin-bottom:5px;">
                         <li style="float:left;height:20px;"><div id="credibility-company-start1"></div></li>
                         <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">5分</li>
                         <li id="credibility-company-startValue5" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;">96%</li>
                     </ul>
                 </div>
                 <div style="text-align:center;width:100%;height:20px;margin-left: 33.7%;">
                     <ul style="list-style: none;margin-bottom:5px;">
                         <li style="float:left;height:20px;"><div id="credibility-company-start2"></div></li>
                         <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">4分</li>
                         <li id="credibility-company-startValue4" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;">96%</li>
                     </ul>
                 </div>
                 <div style="text-align:center;width:100%;height:20px;margin-left: 33.7%;">
                     <ul style="list-style: none;margin-bottom:5px;">
                         <li style="float:left;height:20px;"><div id="credibility-company-start3"></div></li>
                         <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">3分</li>
                         <li id="credibility-company-startValue3" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;">96%</li>
                     </ul>
                 </div>
                 <div style="text-align:center;width:100%;height:20px;margin-left: 33.7%;">
                     <ul style="list-style: none;margin-bottom:5px;">
                         <li style="float:left;height:20px;"><div id="credibility-company-start4"></div></li>
                         <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">2分</li>
                         <li id="credibility-company-startValue2" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;">96%</li>
                     </ul>
                 </div>
                 <div style="text-align:center;width:100%;height:20px;margin-left:33.7%;">
                     <ul style="list-style: none;margin-bottom:5px;">
                         <li style="float:left;height:20px;"><div id="credibility-company-start5"></div></li>
                         <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">1分</li>
                         <li id="credibility-company-startValue1" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;">96%</li>
                     </ul>
                 </div>
             </div>
             <div title="平台投诉处理率" style="text-align: center;float:left;width:33.3%;height:240px;border-left:1px #e6eaee solid;border-right:1px solid #e6eaee;">
                 <div style="height:20px;color:#354052;font-size:18px;margin-top:20px;margin-bottom:10px;">平台投诉处理率</div>
                 <div id="credibility-complaints" style="margin-top: 20px"></div>
             </div>
             <div title="平台订单爽约率" style="text-align: center;float:left;width:33.3%;height:240px;">
                 <div style="height:20px;color:#354052;font-size:18px;margin-top:20px;margin-bottom:10px;">平台订单爽约率</div>
                 <div id="credibility-order" style="margin-top: 20px"></div>
             </div>
         </div>
     </div>
    <%--公司信誉end--%>
        <div style="width:100%;height:10px;background-color:#f0f3f5;border:none;"></div>
    <%--单个司机信誉start--%>
            <div style="height:40px;width:100%;padding-left:10px;">
                <label style="color: #354052;font-size: 17px;font-weight:400;margin-left:10px;margin-top: 28px">单个司机信誉查询</label>
                <br>
                <input id="credibility-driverSearchText" class="defaultInput" type="text" style="width:170px;" placeholder="请输入司机身份证号"/>
                <input id="credibility-driverSearchBtn" class="btn_blue" type="button" style="margin-left:10px;" value="查&nbsp;询" />

            </div>
            <%--contain--%>
            <div id="redibility-dataShow" style="padding:10px;width:100%;padding-left:20px;">
                <div style="height:20px;color:#354052;font-size:16px;float: left;width: 100%;margin-top:45px">基本信息</div>
                <div style="float:left;width:120px;height:180px;border:1px #e6eaee solid;margin-top:18px" title="司机头像"></div>
                <div style="width:100px;height:150px;float:left;width:330px;margin-left:20px;" title="司机基本信息">

                    <div style="border:1px #e6eaee solid;padding:10px;margin-top:18px;color:#5a687b">
                        <ul id="redibility-driverbaseInfo" style="list-style:none;">
                            <li style="line-height:30px;">姓名:<span id="redibility-drivername" style="float:right;"></span></li>
                            <li style="line-height:30px;">机动车驾驶证号:<span id="redibility-lisenceid" style="float:right;"></span></li>
                            <li style="line-height:30px;">服务质量考核日期:<span id="redibility-testdate" style="float:right;"></span></li>
                            <li style="line-height:30px;">服务质量考核机构:<span id="redibility-testdepartment" style="float:right;"></span></li>
                        </ul>
                    </div>
                </div>
                <div style="float:left;width:300px;margin-left:20px;margin-top: -21px" title="司机评价信息">
                    <div style="height:20px;color:#354052;font-size:16px;">评价状况</div>
                    <div style="border:1px #e6eaee solid;padding:10px;margin-top:20px;color:#5a687b">
                        <%--<div style="text-align:center;width:100%;height:20px;margin-left:10px;">--%>
                            <%--<ul style="list-style: none;margin-bottom:5px;">--%>
                                <%--<li style="float:left;height:20px;"><div id="credibility-driver-start"></div></li>--%>
                                <%--<li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">5分</li>--%>
                                <%--<li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;">96%</li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                        <div style="text-align:center;width:100%;height:20px;margin-left:10px;">
                            <ul style="list-style: none;margin-bottom:5px;">
                                <li style="float:left;height:20px;"><div id="credibility-driver-start1"></div></li>
                                <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">5分</li>
                                <li id="credibility-driver-startValue5" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;"></li>
                            </ul>
                        </div>
                        <div style="text-align:center;width:100%;height:20px;margin-left:10px;">
                            <ul style="list-style: none;margin-bottom:5px;">
                                <li style="float:left;height:20px;"><div id="credibility-driver-start2"></div></li>
                                <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">4分</li>
                                <li id="credibility-driver-startValue4" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;"></li>
                            </ul>
                        </div>
                        <div style="text-align:center;width:100%;height:20px;margin-left:10px;">
                            <ul style="list-style: none;margin-bottom:5px;">
                                <li style="float:left;height:20px;"><div id="credibility-driver-start3"></div></li>
                                <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">3分</li>
                                <li id="credibility-driver-startValue3" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;"></li>
                            </ul>
                        </div>
                        <div style="text-align:center;width:100%;height:20px;margin-left:10px;">
                            <ul style="list-style: none;margin-bottom:5px;">
                                <li style="float:left;height:20px;"><div id="credibility-driver-start4"></div></li>
                                <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">2分</li>
                                <li id="credibility-driver-startValue2" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;"></li>
                            </ul>
                        </div>
                        <div style="text-align:center;width:100%;height:20px;margin-left:10px;">
                            <ul style="list-style: none;margin-bottom:5px;">
                                <li style="float:left;height:20px;"><div id="credibility-driver-start5"></div></li>
                                <li style="float:left;height:20px;line-height:20px;margin-left:10px;color:#7f8fa4;font-size:12px;">1分</li>
                                <li id="credibility-driver-startValue1" style="float:left;height:20px;line-height:20px;margin-left:10px;color:#ff7d27;font-size:12px;"></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <%--无记录显示--%>
            <div id="redibility-noDataShow" style="width:100%;height:300px;text-align:center;display:block;padding-top:30px;text-align:center;display:none;">
                <div><img src="pic/market/empty_driCre.png"/></div>
                <div>无记录显示</div>
            </div>
            <%--无记录显示--%>
        </div>
    <%--单个司机信誉end--%>

<script>
    var xuan = $(window).height();

    var screenWidth = $(window).width();
    //判断360浏览器
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        if(screenWidth > 1400){
            var he=xuan-61;
            $('#cre_height').css('height',he);
        }else{
            var he1=xuan-38-50;
            $('#cre_height').css('height',he1);
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {

        if(screenWidth > 1400){
            var hea=xuan-150;
            $('#cre_height').css('height',hea);
        }else{
            var he2=xuan-38-70-20;
            $('#cre_height').css('height',he2);
        }

    }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
        var he3=xuan-38-95;
        $('#cre_height').css('height',he3);
    }

    //============================================================
    //公司列表
    function  initCompanyList() {
        var areacode = '';
        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            areacode = $("#city option:selected").val();
        } else {
            areacode = $("#county option:selected").val();
        }
        $.get('netcompany/findByareacode',{areacode:areacode},function(data){
            $("#credibility-select-companys").empty();
            if(data!=null&&data.length!=0){
                var html=""
                for(var i=0;i<data.length;i++){
                    html+="<option value='"+data[i].name+"'>"+data[i].desc+"</option>";
                }
                $("#credibility-select-companys").html(html);
                var companyidc=$("#credibility-select-companys option:selected").val();
                passengerForCompany(companyidc);
                passengerComplaintForCompany(companyidc);
                orderBreakRate(companyidc);
            }
        });
    }

    initCompanyList();

    //统计公司乘客评价
    function passengerForCompany(companyidc){
        $.get('order/getServiceScopegroupByCompanyidc',{companyidc:companyidc},function(data){
            if(data.length!=0){
                var start1,start2,start3,start3,start4,start5,startTotal=0;
                for(var i=0;i<data.length;i++){
                    startTotal+=data[i].serviceScopeCount;
                 if(data[i].serviceScopeLevle=="1"){
                     start1=data[i].serviceScopeCount;
                 }
                if(data[i].serviceScopeLevle==2){
                    start2=data[i].serviceScopeCount;
                }
                if(data[i].serviceScopeLevle==3){
                    start3=data[i].serviceScopeCount;
                }
                if(data[i].serviceScopeLevle==4){
                    start4=data[i].serviceScopeCount;
                }
                if(data[i].serviceScopeLevle==5){
                    start5=data[i].serviceScopeCount;
                 }
                }
                $("#credibility-company-startValue1").text((Math.round(start1/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-company-startValue2").text((Math.round(start2/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-company-startValue3").text((Math.round(start3/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-company-startValue4").text((Math.round(start4/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-company-startValue5").text((Math.round(start5/ startTotal * 10000)/100.00 + "%"));
            }else{
                $("#credibility-company-startValue1").text("");
                $("#credibility-company-startValue2").text("");
                $("#credibility-company-startValue3").text("");
                $("#credibility-company-startValue4").text("");
                $("#credibility-company-startValue5").text("");
            }
        });
    }


    //统计公司投诉处理率
    function passengerComplaintForCompany(companyidc){
        $.get('order/getComplaintForCompany',{companyidc:companyidc},function(data){
            if(data!=null){
                installCompalaints(data);
            }else{
                //installCompalaints(0);
                $('#credibility-complaints').html("<div>无数据</div>");
            }
        });
    }

    //订单爽约率
    function orderBreakRate(companyidc){
        $.get('order/getComplaintForCompany',{companyidc:companyidc},function(data){
            if(data!=null){
                orderCancelRete(data);
            }else{
                //orderCancelRete(0);
                $("#credibility-order").html("<div>无数据</div>");
            }
        });
    }

    $("#credibility-select-companys").change(function(){
        var companyidc=$("#credibility-select-companys option:selected").val();
        passengerForCompany(companyidc);
        passengerComplaintForCompany(companyidc);
        orderBreakRate(companyidc);
    });




    //单个司机查询
    $("#credibility-driverSearchBtn").click(function(){
        var value= $.trim($("#credibility-driverSearchText").val());
        if(value.length!=0){
            searchDriverCredibility(value);
        }else{
            layer.tips('请输入司机身份证号码', '#credibility-driverSearchText', {
                tips: [3, 'red'],
                time: 3000
            });
        }
    });

    //基本信息
    function searchDriverCredibility(licenseid){

        $.get('netdriver/findBydriverByParm',{licenseid:'licenseid',licenseidVaue:licenseid},function(netdriver){
            if(netdriver.length!=0){
                $("#redibility-drivername").text(netdriver.drivername);
                $("#redibility-lisenceid").text(netdriver.licenseid);
                rateSearch(licenseid)
                $("#redibility-dataShow").show();
                $("#redibility-noDataShow").hide();
            }else{
                $("#redibility-dataShow").hide();
                $("#redibility-noDataShow").show();
            }
        })
        //考核机构和日期
        $.get('netdriver/findLastTestDateRateDriverByLicenseid',{licenseid:licenseid},function(rateddriver){
            if(rateddriver.length!=0){
                $("#redibility-testdate").text(rateddriver.testdate);
                $("#redibility-testdepartment").text(netdriver.testdepartment);
            }else{
                $("#redibility-testdate").text("");
                $("#redibility-testdepartment").text("");
            }
        })

    }

    //单个司机统计信息;
    function rateSearch(licenseid){
        $.get('netdriver/findRateDriverByLicenseid',{licenseid:licenseid},function (data) {
            if(data!=null&&data.length!=0){
                if(data.length!=0){
                var start1,start2,start3,start3,start4,start5,startTotal=0;
                for(var i=0;i<data.length;i++){
                    startTotal+=data[i].serviceScopeCount;
                    if(data[i].serviceScopeLevle=="1"){
                        start1=data[i].serviceScopeCount;
                    }
                    if(data[i].serviceScopeLevle==2){
                        start2=data[i].serviceScopeCount;
                    }
                    if(data[i].serviceScopeLevle==3){
                        start3=data[i].serviceScopeCount;
                    }
                    if(data[i].serviceScopeLevle==4){
                        start4=data[i].serviceScopeCount;
                    }
                    if(data[i].serviceScopeLevle==5){
                        start5=data[i].serviceScopeCount;
                    }
                }
                $("#credibility-driver-startValue1").text((Math.round(start1/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-driver-startValue2").text((Math.round(start2/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-driver-startValue3").text((Math.round(start3/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-driver-startValue4").text((Math.round(start4/ startTotal * 10000)/100.00 + "%"));
                $("#credibility-driver-startValue5").text((Math.round(start5/ startTotal * 10000)/100.00 + "%"));
            }else{
                $("#credibility-driver-startValue1").text("");
                $("#credibility-driver-startValue2").text("");
                $("#credibility-driver-startValue3").text("");
                $("#credibility-driver-startValue4").text("");
                $("#credibility-driver-startValue5").text("");
            }
            }else{

            }
        })
    }


//    function passengerForCompany(companyidc){
//        $.get('order/getServiceScopegroupByCompanyidc',{companyidc:companyidc},function(data){
//            if(data.length!=0){
//                var start1,start2,start3,start3,start4,start5,startTotal=0;
//                for(var i=0;i<data.length;i++){
//                    startTotal+=data[i].serviceScopeCount;
//                    if(data[i].serviceScopeLevle=="1"){
//                        start1=data[i].serviceScopeCount;
//                    }
//                    if(data[i].serviceScopeLevle==2){
//                        start2=data[i].serviceScopeCount;
//                    }
//                    if(data[i].serviceScopeLevle==3){
//                        start3=data[i].serviceScopeCount;
//                    }
//                    if(data[i].serviceScopeLevle==4){
//                        start4=data[i].serviceScopeCount;
//                    }
//                    if(data[i].serviceScopeLevle==5){
//                        start5=data[i].serviceScopeCount;
//                    }
//                }
//                $("#credibility-company-startValue1").text((Math.round(start1/ startTotal * 10000)/100.00 + "%"));
//                $("#credibility-company-startValue2").text((Math.round(start2/ startTotal * 10000)/100.00 + "%"));
//                $("#credibility-company-startValue3").text((Math.round(start3/ startTotal * 10000)/100.00 + "%"));
//                $("#credibility-company-startValue4").text((Math.round(start4/ startTotal * 10000)/100.00 + "%"));
//                $("#credibility-company-startValue5").text((Math.round(start5/ startTotal * 10000)/100.00 + "%"));
//            }else{
//                $("#credibility-company-startValue1").text("");
//                $("#credibility-company-startValue2").text("");
//                $("#credibility-company-startValue3").text("");
//                $("#credibility-company-startValue4").text("");
//                $("#credibility-company-startValue5").text("");
//            }
//        });
//    }





    $('#credibility-company-start').raty({ readOnly: true, score: 5 });
    $('#credibility-company-start1').raty({ readOnly: true, score: 5 });
    $('#credibility-company-start2').raty({ readOnly: true, score: 4 });
    $('#credibility-company-start3').raty({ readOnly: true, score: 3 });
    $('#credibility-company-start4').raty({ readOnly: true, score: 2 });
    $('#credibility-company-start5').raty({ readOnly: true, score: 1 });

    $('#credibility-driver-start').raty({ readOnly: true, score: 5 });
    $('#credibility-driver-start1').raty({ readOnly: true, score: 5 });
    $('#credibility-driver-start2').raty({ readOnly: true, score: 4 });
    $('#credibility-driver-start3').raty({ readOnly: true, score: 3 });
    $('#credibility-driver-start4').raty({ readOnly: true, score: 2 });
    $('#credibility-driver-start5').raty({ readOnly: true, score: 1 });

    //投诉处理率
    function installCompalaints(value){
        $('#credibility-complaints').empty();
            $('#credibility-complaints').radialIndicator({
                radius:67,
                barWidth:17,
                percentage:true,
                initValue:value,
                roundCorner:true,
                barColor:'#ead536',
                fontSize:25,
                fontWeight:100,
                height:20
         });
    }

    function orderCancelRete(value){
        $('#credibility-order').empty();
        $('#credibility-order').radialIndicator({
            radius:67,
            barWidth:17,
            percentage:true,
            initValue:value,
            roundCorner:true,
            barColor:'#ff943e',
            fontSize:25,
            fontWeight:100
        });
    }


</script>
</body>
</html>
