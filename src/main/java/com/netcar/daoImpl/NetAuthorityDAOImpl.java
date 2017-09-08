package com.netcar.daoImpl;

import com.netcar.dao.NetAuthorityDAO;
import com.netcar.entity.NetAuthority;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 */
@Repository
public class NetAuthorityDAOImpl implements NetAuthorityDAO {


    private Logger logger=Logger.getLogger(NetAuthorityDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }


    public List<NetAuthority> findAll() {
        return getSession().createQuery("from NetAuthority").list();
    }


    /**
     * 查询获取左侧主菜单
     * @param userid
     * @return
     */
    @Override
    public List<NetAuthority> findMenuByUserid(int userid) {
        List<NetAuthority> netAuthorities = new ArrayList<NetAuthority>();
        try {
            Query query = getSession().createSQLQuery("select au.id,au.title,au.level,au.type,au.groupid,au.url,au.icon,au.desciption from net_authority au inner join net_roleAuth  ra on ra.authorityid=au.id inner join net_userRole ur on \n" +
                    "ur.roleid=ra.roleid where ur.userid=:userid AND au.level<3");
            query.setInteger("userid", userid);
            List ls = query.list();
            if(ls!=null&&ls.size()!=0){
               netAuthorities=bindData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return netAuthorities;
    }


    /**
     * 数据绑定
     * @param list
     * @return
     */
    private List<NetAuthority> bindData(List list) {
        List<NetAuthority> authorities = new ArrayList<NetAuthority>();
        for (int i = 0; i < list.size(); i++) {
            NetAuthority netAuthority = new NetAuthority();
            Object[] object = (Object[]) list.get(i);
            netAuthority.setId(Integer.parseInt(object[0].toString()));
            netAuthority.setTitle(object[1].toString());
            netAuthority.setLevel(Integer.parseInt(object[2].toString()));
            netAuthority.setType(object[3] != null ? object[3].toString() : "");
            netAuthority.setGroupid(Integer.parseInt(object[4].toString()));
            netAuthority.setUrl(object[5] != null ? object[5].toString() : "");
            netAuthority.setIcon(object[6] != null ? object[6].toString() : "");
            netAuthority.setDesciption(object[7] != null ? object[7].toString() : "");
            authorities.add(netAuthority);
        }
        return authorities;
    }

}
