package MyUtils;

import JavaIO.RandomAccessFile.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/17 14:50
 * @Description:
 */
public class DateUtils {

    public static String getTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
}
