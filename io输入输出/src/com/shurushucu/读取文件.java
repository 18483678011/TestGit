package com.shurushucu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class 读取文件 {

	public void name() {
		File nFile = new File("F:\\word.txt");
//方法1********************************************************
		try {
			FileReader iFileReader = new FileReader(nFile);
			int s = (int) nFile.length();// 获取文件大小
			char[] st = new char[s];
			int len = iFileReader.read(st);// 获取包含有几个有效数据
			System.out.println(new String(st, 0, len));
			System.out.println();
			if (iFileReader != null) {
				iFileReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//方法2**********************************************************
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(nFile);
			char[] d = new char[10];
			int c;
			while ((c = fileReader.read(d)) != -1) {
				for (int i = 0; i < c; i++) {
					System.out.print(d[i]);
				}
			}
			System.out.println();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 方法3********************************************************************

		FileReader fileReader2 = null;
		try {

			fileReader2 = new FileReader(nFile);
			int s;
			char[] strings = new char[100];
			while ((s=fileReader2.read(strings)) != -1) {
				String string = new String(strings, 0, s);
				System.out.println(string);
			}
			System.out.println();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (fileReader2 != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new 读取文件().name();
	}
}
