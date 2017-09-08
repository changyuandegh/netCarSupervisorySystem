import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.Menu;
import com.netcar.entity.NetAuthority;
import com.netcar.entity.NetCompanybaseinfo;
import com.netcar.entity.NetUser;
import com.netcar.service.NetAuthorityService;
import com.netcar.service.NetCompanybaseinfoService;
import com.netcar.service.NetUserService;
import com.netcar.tools.MD5Util;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mander on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-hibernate.xml","classpath:spring-dispatcher-servlet.xml"})
public class NetUserTest {



    @Autowired
    private NetUserService netUserServiceImpl;

    @Autowired
    private NetCompanybaseinfoService netCompanybaseinfoServiceImpl;


    @Autowired
    private NetAuthorityService netAuthorityServiceImpl;

    /**
     * 获取用户主菜单功能
     */
    @Test
    public void getNetauth(){
        int userid=1;
        List<NetAuthority> netAuthorityList= netAuthorityServiceImpl.findMenuByUserid(userid);
        List<Menu> menuList=new ArrayList<>();
        //获取一级菜单
        for (int i = 0; i < netAuthorityList.size(); i++) {
            if(netAuthorityList.get(i).getLevel()==1){
                Menu menu=new Menu();
                menu.setNetAuthority(netAuthorityList.get(i));
                menuList.add(menu);
            }
        }
        //获取一级菜单下的子菜单
        for (int i = 0; i < menuList.size(); i++) {
            NetAuthority mainNet= menuList.get(i).getNetAuthority();
            List<NetAuthority> secondAuth=new ArrayList<>();
            for (int j = 0; j < netAuthorityList.size(); j++) {
                NetAuthority netAuthority= netAuthorityList.get(j);
                if (mainNet.getGroupid()==netAuthority.getGroupid()&&netAuthority.getLevel()==2){
                    secondAuth.add(netAuthority);
                }
            }
            menuList.get(i).setNetAuthorities(secondAuth);
        }

        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(menuList.get(i).getNetAuthority().getTitle());
            for (int j = 0; j < menuList.get(i).getNetAuthorities().size(); j++) {
                System.out.println(menuList.get(i).getNetAuthorities().get(j).getTitle());
            }
        }
    }

    @Test
    public void testfindUser(){
       NetUser netUser= netUserServiceImpl.findByNamePass("system", MD5Util.MD5("admin"));
        System.out.println(netUser);
        UUID uuid=UUID.randomUUID();

        System.out.println(uuid.toString());
    }


    @Test
    public void testNetCompany(){
        BaseTable baseTable = netCompanybaseinfoServiceImpl.findAll(10,0, 410000, "companyid");
        System.out.println("total size:"+baseTable.getTotal());
        List<NetCompanybaseinfo> list = baseTable.getRows();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getCompanyname());
        }
        System.out.println("====");

        BaseTable baseTable1 = netCompanybaseinfoServiceImpl.findByParm("companyname", "滴", 10, 0, 410000, "companyid");
        List<NetCompanybaseinfo> list1 = baseTable1.getRows();
        System.out.println("total size:"+baseTable1.getTotal());
        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i).getCompanyname());
        }
        System.out.println("====");
    }

    /**
     * 是否压缩
     */
    @Test
    public void testGZIP() {
        org.apache.commons.httpclient.HttpClient httpClient=new org.apache.commons.httpclient.HttpClient();
        GetMethod get = new GetMethod("http://localhost:8081/user/dologin");
        try{
            get.addRequestHeader("accept-encoding", "gzip,deflate");
            get.addRequestHeader("user-agent", "Mozilla/5.0 (compatible; MSIE 6.0; Windows NT 5.0; Alexa Toolbar; Maxthon 2.0)");
            int er = httpClient.executeMethod(get);
            if(er==200){
                System.out.println(get.getResponseContentLength());
                String html = get.getResponseBodyAsString();
                System.out.println(html);
                System.out.println(html.getBytes().length);
            }
        }catch (Exception  e){
            e.printStackTrace();
        }
        finally{
            get.releaseConnection();

        }
    }


    public static String timeStamp2Date(String seconds,String format) {
       if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
                return "";
       }
       if(format == null || format.isEmpty()){
             format = "yyyy-MM-dd HH:mm:ss";
         }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
         return sdf.format(new Date(Long.valueOf(seconds+"000")));
     }

    @Test
    public void testFTP(){
        //2017-05-12 11:45:29
        //1494318394000
//1494318394000
        String time= timeStamp2Date("1494318394","yyyy-MM-dd HH:mm:ss");
        System.out.println("time=="+time);

        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //long lt = new Long(1494318394000);
        Date date = new Date(1494318394);
        res = simpleDateFormat.format(date);
        System.out.println(res);
    }


    @Test
    public void testcom(){
        List<AjaxMessage> list= netCompanybaseinfoServiceImpl.findidNameByareacode("410000");
        System.out.println(list.get(0).toString());
    }




}
