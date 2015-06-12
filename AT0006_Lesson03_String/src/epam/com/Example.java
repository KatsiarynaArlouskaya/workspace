package epam.com;

import java.io.UnsupportedEncodingException;

public class Example {

	public static void main(String[] args) {
		/*byte[] data3 = {(byte) 0xE3, (byte) 0xEE};
		String str5 = new String(data3, "CP1251");
		System.out.println(str5);
		String str6 = new String(data3, "CP866"); 
		System.out.println(str6);*/

	/*	String str = "Мама мыла раму1!";
		byte[] strCP = str.getBytes();
		int charCode;
		for (byte b : strCP) {
			charCode = b;
			System.out.print(charCode + " ");
		}*/
		
	/*	String str1 = "\u004C";
		String str2 = "\u0433";
		String str3 = "\u10DA";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		byte[] b1 = str1.getBytes();
		byte[] b2 = str2.getBytes();
		byte[] b3 = str3.getBytes();
		
		System.out.println(str1 + " - length=" + str1.length() + "; number of bytes=" + b1.length);
		System.out.println(str2 + " - length=" + str2.length() + "; number of bytes=" + b2.length);
		System.out.println(str3 + " - length=" + str3.length() + "; number of bytes=" + b3.length);
		
		for (byte b :b3){
			System.out.print(Integer.toBinaryString(b).toString().substring(24)+" ");
		}*/
		
		String str = "\uD835\uDD0A";
		
		System.out.println(str);
		System.out.println(" - length: "+str.length());
		System.out.println(" - codePointCount: "+str.codePointCount(0, str.length()));
	}

}
