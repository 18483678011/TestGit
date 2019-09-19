package com.shurushucu;

import java.io.File;

public class 文件查找 {
	public static void main(String[] args) {
		new 文件查找().name();
		new 文件查找().name1();
	}
	public void name() {// 查找当前目录下的文件或者文件夹
		File nFile = new File("F:\\");
		File[] fileString = nFile.listFiles();//获取当前文件夹下的所有文件以及文件夹组成的文件数组
		for (File string : fileString) {
			String nString = string.getName();
			if (nString.endsWith("xt")) {// 查找字符串按照指定字符结束
				System.out.println(string.getAbsolutePath() + " 文件大小：" + string.length() + "B");//按照绝对路径输出
			}
			if (nString.startsWith("J")) {// 查找字符串按照指定字符开始
				if (string.isFile()) {// 判断是否为文件
					System.out.println(string.getAbsolutePath() + " 文件大小：" + string.length() + "B");
				} else {
					System.out.println(string.getAbsolutePath() + " 文件夹大小：" + string.length() + "B");
				}
			}
		}

	}

    //************************************************************************************************************
	public void name1() {// 可以查子目录的文件
		File suFile = new File("F:\\照片");
		diguihans(suFile);
	}

	private static void diguihans(File suFile) {// 递归的思想
		File[] S = suFile.listFiles();
		for (File file : S) {
			if (file.isDirectory()) {
				diguihans(file);
			} else {
				String string = file.getName();// 获取文件名
				if (string.startsWith("机") && string.endsWith(".rar")) {// 开始为z 结束为.rar；
					System.out.println(file.getAbsolutePath() + " 文件大小：" + file.length() / (1024 * 1024) + "MB");// 输出目标文件的绝对地址
				}
			}
		}
	}
}
