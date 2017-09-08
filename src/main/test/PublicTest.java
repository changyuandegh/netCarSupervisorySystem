import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CY on 2017/9/8.
 */
public class PublicTest {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyMMddHHmmss");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
