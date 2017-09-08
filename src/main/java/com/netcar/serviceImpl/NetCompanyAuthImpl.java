package com.netcar.serviceImpl;

import com.netcar.dao.NetCompanyAuthDAO;
import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.service.NetCompanyAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mander on 2017/7/5.
 *
 */
@Service
public class NetCompanyAuthImpl implements NetCompanyAuthService {


    @Autowired
    private NetCompanyAuthDAO netCompanyAuthDAOImpl;

    @Override
    public AjaxMessage addCompanyAuth(String companyidc) {
        AjaxMessage ajaxMessage=new AjaxMessage("fail","操作失败");
        //添加新companyidc
        if(netCompanyAuthDAOImpl.addCompanyAuth(companyidc)){
            //其他companyidc 状态全部改为0;历史认证状态;
          int i=   netCompanyAuthDAOImpl.updateByCompanyidc(companyidc);
            if(i>0){
                ajaxMessage.setName("success");
                ajaxMessage.setDesc("操作成功");
            }
        }
        return ajaxMessage;
    }

    /**
     * 查询历史认证
     * @param companyidc
     * @param limit
     *@param offset @return
     */
    @Override
    public BaseTable findHisAuthToTableBy(String companyidc, Integer limit, Integer offset) {

        return new BaseTable(netCompanyAuthDAOImpl.findCountHisAuthToByCompanyidc(companyidc),netCompanyAuthDAOImpl.findHisAuthToByCompanyidc(companyidc,limit,offset));
    }

    @Override
    public List<Object> findAllCompanyidc() {
        return netCompanyAuthDAOImpl.findAllCompanyidc();
    }



}
