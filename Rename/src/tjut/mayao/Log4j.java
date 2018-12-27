package tjut.mayao;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 说明：自定义的日志文件
 *
 * @Auther: 11432_000
 * @Date: 2018/12/24 14:29
 * @Description:
 */
public class Log4j {

    private static final File LOG_FILE;
    private static final String DEFAULT_CODE = "UTF-8";
    private static final byte[] LINE_FEED = {13,10};

    static {
        LOG_FILE = new File("C:\\Users\\11432_000.000.000\\Desktop\\游戏\\哔卡日志.txt");
        try {
            if (!LOG_FILE.getParentFile().exists()){
                LOG_FILE.getParentFile().mkdirs();
            }
            if (!LOG_FILE.exists()){
                LOG_FILE.createNewFile();
            }
        }catch (IOException e){ }
    }

    public void info(String ...messages){
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(LOG_FILE ,true));){
            byte[] timeBytes = getTime().getBytes(DEFAULT_CODE);
            for (String msg : messages){
                byte[] msgBytes = msg.getBytes(DEFAULT_CODE);
                outputStream.write(timeBytes ,0 ,timeBytes.length);
                outputStream.write(msgBytes ,0 ,msgBytes.length);
                outputStream.write(LINE_FEED);
            }
            outputStream.write(LINE_FEED);
            outputStream.flush();
        }catch (IOException e){

        }

    }

    private String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss");
        Date date = new Date();
        return sdf.format(date) + "  ";
    }

    private String getTime(int s){
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return year + "年" + month + "月" + dayOfMonth + "日 星期" + dayOfWeek + " " + hour + ":" + minute + ":" + second;
    }
}
