/**
 * Created by Mander on 2017/4/28.
 * 资料库
 */

/***************司机start***************************/
$('#driver_table').bootstrapTable({
    classes: "table-no-bordered",
    url: "netdriver/findByParm",
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
        order: "driverid",
        search: $.trim($("#driver_searchValue").val()),
        parameter: $("#driver_selctParm option:selected").val(),
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
     height:changeValue(),
    columns: [{
        field: 'driverid', title: '编号', align: "center", formatter: function (value, row, index) {
            return index + 1;
        }
    }, {field: 'drivername', title: '姓名', align: "center"}, {
        field: 'drivergender',
        title: '性别',
        align: "center",
        formatter: function (value, row, index) {
            if (value == 1) {
                return "男"
            } else if (value == 0) {
                return "女"
            }
        }
    }, {field: 'driverphone', title: '手机号', align: "center"}, {
        field: 'licenseid',
        title: '驾驶员驾驶证号',
        align: "center"
    }, {field: 'driveraddress', title: '户口地址', align: "center"}, {
        field: 'drirvercontactaddress',
        title: '通信地址',
        align: "center"
    }, {field: 'ordercount', title: '完成订单次数', align: "center"}, {
        field: 'trafficviolationcount',
        title: '交通违章次数',
        align: "center"
    }, {field: 'complainedcount', title: '被投诉次数', align: "center"}, {
        field: 'creditpoints',
        title: '司机信誉分',
        align: "center"
    }]
});
$("#driver_searchBtn").click(function () {
    $("#driver_table").bootstrapTable("refresh", {url: "netdriver/findByParm"}, {query: {order: "asc"}});
});

$("#driver_showBtn").click(function(){
    layer.open({
        type: 1,
        shade: false,
        title: false, //不显示标题
        content: $('#information'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
    });
})

function changeValue(){
    //判断360浏览器
    var screenWidtha =$(window).width();
    if((window.navigator.mimeTypes[40]||!window.navigator.mimeTypes.length)){
        //=============================
        if(screenWidtha > 1400){
                return 775;
             }else{
                 return 495;
            }
    }
    // 判断Chrome
    else if(navigator.userAgent.indexOf("Chrome") >0)
    {
        if(screenWidtha > 1400){
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
/***************司机end***************************/


/***************车辆start***************************/
$('#car_table').bootstrapTable({
    classes: "table-no-bordered",
    url: "netcar/findByParm",
    queryParams: function (parme) {
        var areacode = '';
        var selectCount = $("#county option:selected").text();
        if (selectCount == '所有') {
            areacode = $("#city option:selected").val();
        } else {
            areacode = $("#county option:selected").val();
        }
        var newParme = {
            limit: parme.limit, //页面大小
            offset: parme.offset, //页码
            order: parme.order,
            search: $.trim($("#car_searchValue").val()),
            parameter: $("#car_selctParm option:selected").val(),
            areacode: areacode
        }
        return newParme;
    },
    checkbox: true,
    striped: true,//启用各行变色
    radio: true,
    clickToSelect: true,
    selectItemName: "id",
    searchTimeOut: 3000,//超时时间
    paginationPreText: "<",//上一页显示图标
    paginationNextText: ">",
    sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
    pagination: true,//设置为 true 会在表格底部显示分页条
    pageNumber: 1,//	如果设置了分页，首页页码
    pageSize: 10,//	如果设置了分页，页面数据条数
    pageList: [10, 20, 30],
    idField: "companyid",//指定主键
    uniqueId: "companyid",//唯一标识符
    singleSelect: true,//禁止多选
    height:changeValue(),
    columns: [{
        field: 'carid',
        title: '编号',
        align: "center",
        formatter: function (value, row, index) {
            return index + 1;
        }
    }, {
        field: 'vehicleno',
        title: '车牌号',
        align: "center"
    }, {
        field: 'platecolor',
        title: '车牌颜色',
        align: "center"
    }, {
        field: 'seats',
        title: '核定载客位',
        align: "center"
    }, {
        field: 'brand',
        title: '车辆厂牌',
        align: "center"
    }, {
        field: 'model',
        title: '车辆型号',
        align: "center"
    }, {
        field: 'vehicletype',
        title: '车辆类型',
        align: "center"
    }, {
        field: 'ownername',
        title: '车辆所有人',
        align: "center"
    }, {
        field: 'vehiclecolor',
        title: '车身颜色',
        align: "center"
    }, {
        field: 'certificate',
        title: '运输证字号',
        align: "center"
    }]
});

$("#car_searchBtn").click(function () {
    $("#car_table").bootstrapTable("refresh", {url: "netcar/findByParm"}, {query: {order: "asc"}});
});

/***************车辆end***************************/
/***************平台公司 start***************************/
$('#company_table').bootstrapTable({
    classes: "table-no-bordered",
    url: "netcompany/findByParm",
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
            order: "companyid",
            search: $.trim($("#company_searchValue").val()),
            parameter: $("#company_selctParm option:selected").val(),
            areacode: areacode
        }
        return newParme;
    },
    checkbox: true,
    striped: true,//启用各行变色
    radio: true,
    clickToSelect: true,
    selectItemName: "id",
    searchTimeOut: 3000,//超时时间
    paginationPreText: "<",//上一页显示图标
    paginationNextText: ">",
    sidePagination: "server",//设置在哪里进行分页,可选值为 'client' 或者 'server'
    pagination: true,//设置为 true 会在表格底部显示分页条
    pageNumber: 1,//	如果设置了分页，首页页码
    pageSize: 10,//	如果设置了分页，页面数据条数
    pageList: [10, 20, 30],
    idField: "companyid",//指定主键
    uniqueId: "companyid",//唯一标识符
    singleSelect: true,//禁止多选
    height:changeValue(),
    columns: [{
        field: 'companyid',
        title: '编号',
        align: "center",
        formatter: function (value, row, index) {
            return index + 1;
        }
    }, {
        field: 'companyname',
        title: '公司名称',
        align: "center"
    }, {
        field: 'identifier',
        title: '统一社会信用代码',
        align: "center"
    }, {
        field: 'address',
        title: '行政区划代码',
        align: "center"
    }, {
        field: 'businessscope',
        title: '经营范围',
        align: "center"
    }, {
        field: 'contactaddress',
        title: '通信地址',
        align: "center"
    }, {
        field: 'economictype',
        title: '经营户经济类型',
        align: "center"
    }, {
        field: 'regcapital',
        title: '注册资本',
        align: "center"
    }, {
        field: 'organization',
        title: '发证机构名称',
        align: "center"
    }]
});
$("#company_searchBtn").click(function () {
    $("#company_table").bootstrapTable("refresh", {url: "netcompany/findByParm"}, {query: {order: "asc"}});
});





///=============================================

/***************平台公司end***************************/

