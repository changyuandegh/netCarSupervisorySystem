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
    document.getElementById('tance_text_starttime').onclick = function(){
        start.elem = this;
        laydate(start);
    }
    document.getElementById('tance_text_endttime').onclick = function(){
        end.elem = this
        laydate(end);
    }
});

$('#order_List').bootstrapTable({
    classes: "table-no-bordered",
    url: "order/findorderDatail",
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
            stime:$("#tance_text_starttime").val(),
            etime: $("#tance_text_endttime").val(),
            Company:$("#monitor_SelectCompany option:selected").val(),
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
    idField: "driverid",//指定主键
    uniqueId: "driverid",//唯一标识符
    singleSelect: true,//禁止多选
    height: changeValue(),
    columns: [{
        field: 'driverid',
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
        field: ' ',
        title: '订单状态',
        align: "center"
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
        field: 'drivername',
        title: '司机姓名',
        align: "center"
    }, {
        field: 'driverphone',
        title: '司机手机号',
        align: "center"
    }, {
        field: 'compangname',
        title: '公司名称',
        align: "center"
    }, {
        field: 'departure',
        title: '上车地址',
        align: "center"
    }, {
        field: 'destination',
        title: '下车地址',
        align: "center"
    },{
        title: '操作',
        align: "center",
        formatter:function (row) {
            return  '<a href="javascript:" onclick="selectOneDateDetail()"  style="color:#000000;">查看</a>';
        }
    }
    ]
});

$("#order_searchBtn").click(function () {
    $("#order_List").bootstrapTable("refresh", {url: "order/findorderDatail"}, {query: {order: "asc"}});
});
function changeValue(){
    //判断360浏览器
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        //=============================
        var screenWidth = $(window).width();
        if(screenWidth > 1400){
            return 790;
        }else{
            return 480;
        }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
        return 790;
    }
    // 判断afari
    else if(navigator.userAgent.indexOf("Safari") >0)
    {
        console.log(11111111);
        return 400;
    }
}





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
                $("#monitor_SelectCompany").empty();
                var html = "";
                for (var i = 0; i < companys.length; i++) {
                    html += "<option value='" + companys[i].name + "'>" + companys[i].desc + "</option>";
                }
            } else {
                html += "<option>无公司选择</option>";
            }
            $("#monitor_SelectCompany").append(html);
        },
        error: function (error, code, thow) {
            $("#monitor_SelectCompany").append("<option>无公司选择</option>");
        }
    })