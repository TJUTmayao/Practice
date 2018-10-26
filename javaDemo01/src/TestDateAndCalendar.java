import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/15 15:50
 * @Description:
 */
public class TestDateAndCalendar {

    public static void main(String[] arg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.MINUTE ,30);
        System.out.println(calendar.getTime());
        /* 判断calender是否在指定时间之后 */
        boolean after = calendar.after(14243);
        System.out.println(after);
        int[] nums=new int[10];
    }
}
