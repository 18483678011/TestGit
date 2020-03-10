package com.shurushucu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 输入输出流 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * String dString=scanner.next().toUpperCase();//将读取到的数据统一转化为大写
		 * System.out.println(dString); String
		 * dString1=scanner.next().toLowerCase();//将读取到的数据统一转化为小写
		 * System.out.println(dString1);
		 */
		// 方法1****************************************************************
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("输入字符：");
			String dStrin = scanner.next().toUpperCase();// 将读取到的数据统一转化为大写
			if ("E".equalsIgnoreCase(dStrin) || "exit".equalsIgnoreCase(dStrin)) {
				// 为了执行忽略大小写的比较，可以调用equalsIgnoreCase( )方法。当比较两个字符串时，它会认为A-Z和a-z是一样的。
				System.out.println("程序结束");
				break;
			}
			System.out.println(dStrin);
		}
		// 方法2**************************************************************************
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);// 字节流字符流
		BufferedReader reader = new BufferedReader(inputStreamReader);// 字符缓冲流
		try {
			while (true) {
				System.out.println("输入数据：");
				String string;
				string = reader.readLine();
				if ("e".equalsIgnoreCase(string) || "exit".equalsIgnoreCase(string)) {
					System.out.println("程序结束");
					break;
				}
				System.out.println(string.toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
