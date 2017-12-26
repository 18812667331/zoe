package zoe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: (Date和String类型转换)
 * @author zoe 515165137@qq.com
 * @date 2017年12月19日 下午12:37:18
 *
 */
public class DateUtil {
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date stringToDate(String pattern, String string) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(string);
	}
}
