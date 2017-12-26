package test;

import java.io.IOException;

import zoe.util.FileUtil;

/**
 * @ClassName: FileUtilTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zoe 515165137@qq.com
 * @date 2017年12月26日 上午9:42:31
 *
 */
public class FileUtilTest {
	public static void main(String[] args) throws IOException {
		// FileUtil.copyFolder("D://test", "E://test");
		long currentTimeMillis3 = System.nanoTime();
		int length =10000;
		for (int i = 0; i < length; i++) {
			FileUtil.saveContentToFile2("d://2.txt", i + "\n", true);
		}
		long currentTimeMillis4 = System.nanoTime();
		long l2 = currentTimeMillis4 - currentTimeMillis3;
		System.out.println(l2);
		long currentTimeMillis1 = System.nanoTime();
		for (int i = 0; i < length; i++) {
			FileUtil.saveContentToFile("d://1.txt", i + "\n", true);
		}
		long currentTimeMillis2 = System.nanoTime();
		long l1 = currentTimeMillis2 - currentTimeMillis1;
		System.out.println(l1);

	}
}
