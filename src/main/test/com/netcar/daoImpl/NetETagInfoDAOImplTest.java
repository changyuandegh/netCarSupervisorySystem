package com.netcar.daoImpl;

import com.netcar.dao.NetETagInfoDAO;
import com.netcar.entity.NetEtag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Work on 2017/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetETagInfoDAOImplTest {

    @Autowired
    NetETagInfoDAO netETagInfoDAOImpl;

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findAllCount() throws Exception {
    }

    @Test
    public void findByCarInfo() throws Exception {
    }

    @Test
    public void findByCarInfoCount() throws Exception {
    }

    @Test
    public void add() throws Exception {
        NetEtag etag = new NetEtag();
        etag.setEtagid("1111111124");
        etag.setBrand("厂商1");
        etag.setModel("X1");
        etag.setImei("111111000001");
        etag.setCreatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        etag.setUpdatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        netETagInfoDAOImpl.add(etag,"豫AT0011");
    }

    @Test
    public void edit() throws Exception {
        NetEtag etag = new NetEtag();
        etag.setEtagid("1111111124");
        etag.setBrand("厂商1");
        etag.setModel("X1");
        etag.setImei("111111000003");
        etag.setCreatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        etag.setUpdatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        netETagInfoDAOImpl.edit(etag);
    }

    @Test
    public void delete() throws Exception {
        netETagInfoDAOImpl.delete("1111111124");
    }

}