package zoe.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: JSONUtil
 * @Description: (JSON和java对象相互转换)
 * @author zoe 515165137@qq.com
 * @date 2017年12月19日 下午12:39:44
 *
 */
public class JsonUtil {
	public static <T> T stringToBean(String str, Class<T> clazz) {
		JSONObject parseObject = JSON.parseObject(str);
		T javaObject = JSON.toJavaObject(parseObject, clazz);
		return javaObject;
	}

	public static <T> T beanToString(String str, Class<T> clazz) {
		JSONObject parseObject = JSON.parseObject(str);
		T javaObject = JSON.toJavaObject(parseObject, clazz);
		return javaObject;
	}
}
