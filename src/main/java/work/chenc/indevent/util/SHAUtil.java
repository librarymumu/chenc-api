package work.chenc.indevent.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 采用SHAA加密
 */
public class SHAUtil {

	/***
	 * SHA加密 生成40位SHA码
	 *
	 * @param 待加密字符串
	 * @return 返回40位SHA码
	 */
	public static String shaEncode(String password) {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
			byte[] byteArray = password.getBytes("UTF-8");
			byte[] md5Bytes = sha.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
	}

	public static String shaEncode(String username, String password) {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
			byte[] byteArray = (username + password).getBytes("UTF-8");
			byte[] md5Bytes = sha.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 利用java原生的摘要实现SHA256加密
	 *
	 * @param str 加密后的报文
	 * @return
	 */
	public static String getSHA256StrJava(String str) {
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	/**
	 * 将byte转为16进制
	 *
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		String username = "木木";
		String password = "123456";
		System.out.println(SHAUtil.shaEncode(username, password));
	}
}
