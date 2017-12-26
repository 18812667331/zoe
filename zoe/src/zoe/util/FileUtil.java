package zoe.util;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @ClassName: FileUtil
 * @Description: (文件工具类)
 * @author zoe 515165137@qq.com
 * @date 2017年12月26日 上午9:46:57
 *
 */
public class FileUtil {
	private static final Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * @Title: toByteArray @Description: (将文件转换为ByteArrayOutputStream) @param
	 *         filename @return byte[] 返回类型 @throws
	 */
	public static ByteArrayOutputStream toByteArrayOutputStream(String filename) {
		File f = new File(filename);

		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(f));
			int bufSize = 1024;
			byte[] buffer = new byte[bufSize];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, bufSize))) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			return bos;
		} catch (IOException e) {

		} finally {
			try {
				in.close();
			} catch (IOException e) {

			}
			try {
				bos.close();
			} catch (IOException e) {

			}
		}
		return null;
	}

	/**
	 * @Title: deleteDir @Description:(删除文件夹及文件夹下的所有文件) @param dir @return boolean
	 *         返回类型 @throws
	 */
	public static boolean deleteDir(File dir) {
		if (dir.exists()) {
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					boolean success = deleteDir(new File(dir, children[i]));
					if (!success) {
						return false;
					}
				}
			}
			// 目录此时为空，可以删除
			logger.debug("===deleteDir==>>删除文件：" + dir.getPath());
			return dir.delete();
		} else {
			logger.debug(dir.getPath() + "目标文件不存在");
			return false;
		}
	}

	/**
	 * @Title: fileToString @Description: (文件转化为字符串) @param fileName @return String
	 *         返回类型 @throws
	 */
	public static String fileToString(String fileName) {
		File file = new File(fileName);
		if (file.isFile()) {
			ByteArrayOutputStream bos = toByteArrayOutputStream(fileName);
			return bos.toString();
		}
		return null;
	}

	/**
	 * @Title: copyFile @Description: (复制文件) @param oldFilePath @param newDir @param
	 *         newFileName @return @throws IOException boolean 返回类型 @throws
	 */
	public static boolean copyFile(String oldFilePath, String newDir, String newFileName) throws IOException {
		File oldFile = new File(oldFilePath);
		if (oldFile.isFile()) {
			ByteArrayOutputStream bos = toByteArrayOutputStream(oldFilePath);
			File newFile = new File(newDir);
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			;
			File file = new File(newFile, newFileName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bos.toByteArray());
			fos.close();
			return true;
		} else {
			logger.error(oldFilePath + "不是一个文件路径");
			return false;
		}
	}

	/**
	 * @Title: copyFolder @Description: (复制文件夹) @param oldPath @param
	 *         newPath @return @throws IOException boolean 返回类型 @throws
	 */
	public static boolean copyFolder(String oldPath, String newPath) throws IOException {
		File oldFile = new File(oldPath);
		File newFile = new File(newPath);
		if (oldFile.exists()) {
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			String[] file = oldFile.list();
			String path = "";
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					path = oldPath + file[i];
				} else {
					path = oldPath + File.separator + file[i];
				}
				File temp = new File(path);
				if (temp.isFile()) {
					ByteArrayOutputStream bos = toByteArrayOutputStream(path);
					FileOutputStream fos = new FileOutputStream(newPath + File.separator + file[i]);
					fos.write(bos.toByteArray());
					bos.close();
					fos.close();

				}
				/** 如果是子文件夹 **/
				if (temp.isDirectory()) {
					copyFolder(oldPath + File.separator + file[i], newPath + File.separator + file[i]);
				}
			}
		} else {
			logger.error(oldPath + "不存在");
			return false;
		}
		return false;
	}

	public static void saveContentToFile(String filePath, String fileContent, boolean isIncreased) throws IOException {
		File txtFile = new File(filePath);
		FileWriter fileWriter = new FileWriter(txtFile, isIncreased);
		fileWriter.write(fileContent);
		fileWriter.flush();
		fileWriter.close();
	}

	public static void saveContentToFile2(String filePath, String fileContent, boolean isIncreased) throws IOException {
		File txtFile = new File(filePath);
		FileWriter fileWriter = new FileWriter(txtFile, isIncreased);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		bw.write(fileContent);
		bw.flush();
		bw.close();
		fileWriter.close();
	}
}
