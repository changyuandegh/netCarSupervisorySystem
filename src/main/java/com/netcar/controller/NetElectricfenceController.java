package com.netcar.controller;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetElectricfence;
import com.netcar.entity.NetUser;
import com.netcar.service.NetElectricfenceService;
import com.netcar.tools.ContextData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Mander on 2017/5/15.
 * 围栏控制器
 */
@Controller
@RequestMapping(value = "/netfence")
public class NetElectricfenceController {


    @Autowired
    private NetElectricfenceService netElectricfenceServiceImpl;


    /**
     * 进入电子围栏
     *
     * @return
     */
    @RequestMapping(value = "/fence")
    private String fencePage() {
        return "controRoom/fence";
    }


    @RequestMapping(value = "/findfence")
    @ResponseBody
    private BaseTable findfencePage(String address, String type, String shape, String name, Integer limit, Integer offset) {
        BaseTable table = new BaseTable();
        if (!StringUtils.isEmpty(address) && !StringUtils.isEmpty(type) && !StringUtils.isEmpty(shape)) {
            table = netElectricfenceServiceImpl.findByParms(address, type, shape, name, limit, offset);
        }
        return table;
    }


    @RequestMapping(value = "/findfenceRows")
    @ResponseBody
    private List<?> findfenceRows(String address, String type, String shape, String name, Integer limit, Integer offset) {
        if (!StringUtils.isEmpty(address) && !StringUtils.isEmpty(type) && !StringUtils.isEmpty(shape)) {
            return netElectricfenceServiceImpl.findRowsByParms(address, type, shape, name, limit, offset);
        }
        return null;
    }


    /**
     * 查询获得总数
     * @param address
     * @param type
     * @param shape
     * @param name
     * @return
     */
    @RequestMapping(value = "/findCountfence")
    @ResponseBody
    private int findCountfence(String address, String type, String shape, String name) {
        BaseTable table = new BaseTable();
        if (!StringUtils.isEmpty(address) && !StringUtils.isEmpty(type) && !StringUtils.isEmpty(shape)) {
            return netElectricfenceServiceImpl.findCountByParms(address, type, shape, name);
        }
        return 0;
    }


    /**
     * 添加围栏
     *
     * @return
     */
    @RequestMapping(value = "/addFence")
    @ResponseBody
    private AjaxMessage addFence(String name, String type, String address, String shape, String radius, String points, String startDate, String endData, HttpServletRequest request, HttpServletResponse reponse) {
        AjaxMessage ajaxMessage = new AjaxMessage();
        try {
            if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(type) && !StringUtils.isEmpty(address) && !StringUtils.isEmpty(shape) && !StringUtils.isEmpty(points) && !StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endData)) {
                NetElectricfence fence = new NetElectricfence();
                fence.setName(name);
                fence.setAddress(Integer.parseInt(address));
                int fenceshape = Integer.parseInt(shape);
                fence.setType(Integer.parseInt(type));
                fence.setPoints(points);
                fence.setEncrypt(3);
                fence.setShape(fenceshape);
                if (fenceshape == 0) {
                    fence.setRadius(Double.parseDouble(radius));
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

                fence.setStartdate(new Date(dateFormat.parse(startDate).getTime()));
                fence.setStopdate(new Date(dateFormat.parse(endData).getTime()));

                Object object = request.getSession().getAttribute(ContextData.loginuser);

                fence.setCreatorid(((NetUser) object).getId());
                fence.setUpdatetime(new Timestamp(System.currentTimeMillis()));
                fence.setUpdatetime(new Timestamp(System.currentTimeMillis()));
                fence.setState(0);
                boolean result = netElectricfenceServiceImpl.add(fence);
                if (result) {
                    ajaxMessage.setDesc("添加围栏成功");
                    ajaxMessage.setName("success");
                } else {
                    ajaxMessage.setDesc("添加围栏失败");
                    ajaxMessage.setName("error");
                }
            } else {
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("有空输入项");
            }
        } catch (Exception e) {
            ajaxMessage.setDesc("出现异常,添加围栏失败");
            ajaxMessage.setName("error");
        }
        return ajaxMessage;
    }


    @RequestMapping(value = "/submitEdit")
    @ResponseBody
    private AjaxMessage fenceEdit(String fenceid, String name, String address, String type, String shape, String radius, String points, String startdate, String stopdate) {
        AjaxMessage ajaxMessage = new AjaxMessage();
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(type) && !StringUtils.isEmpty(address) && !StringUtils.isEmpty(shape) && !StringUtils.isEmpty(points) && !StringUtils.isEmpty(startdate) && !StringUtils.isEmpty(stopdate)) {

            NetElectricfence fence = new NetElectricfence();
            fence.setId(Integer.parseInt(fenceid));
            fence.setName(name);
            fence.setAddress(Integer.parseInt(address));
            int fenceshape = Integer.parseInt(shape);
            fence.setShape(fenceshape);
            fence.setRadius(StringUtils.isEmpty(radius) ? null : Double.parseDouble(radius));
            fence.setType(Integer.parseInt(type));
            fence.setPoints(points);
            fence.setEncrypt(3);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                fence.setStartdate(new java.sql.Date(format.parse(startdate).getTime()));
                fence.setStopdate(new java.sql.Date(format.parse(stopdate).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            fence.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            boolean reg = netElectricfenceServiceImpl.update(fence);
            if (reg) {
                ajaxMessage.setName("success");
                ajaxMessage.setDesc("编辑成功");
            } else {
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("编辑失败");
            }
        }
        return ajaxMessage;
    }


    @RequestMapping(value = "/deleteByfenceid")
    @ResponseBody
    private AjaxMessage deleteFence(String fenceid, HttpServletRequest request, HttpServletResponse response) {
        AjaxMessage ajaxMessage = new AjaxMessage();
        if (!StringUtils.isEmpty(fenceid)) {
            boolean reg = netElectricfenceServiceImpl.deleteByfenceid(Integer.parseInt(fenceid));
            if (reg) {
                ajaxMessage.setDesc("删除成功");
                ajaxMessage.setName("success");
            } else {
                ajaxMessage.setDesc("删除失败");
                ajaxMessage.setName("error");
            }
        } else {
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("围栏不能为空");
        }
        return ajaxMessage;
    }


}
