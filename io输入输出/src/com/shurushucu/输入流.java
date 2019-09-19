package com.shurushucu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 输入流 {

	public static void main(String[] args){
		File jFile = new File("F:\\", "word.txt");
		File jFile1 = new File("F:\\", "word - 副本.txt");

		System.out.println(jFile1.exists());

		File jsFile = new File("str.txt");
		System.out.println("文件名：" + jFile.getName());// 获取文件名称
		System.out.println(jFile.getParent());// 获取文件的父路径 F:\\
		System.out.println(jsFile.getAbsolutePath());// 获取绝对路径
		System.out.println(jFile.getAbsoluteFile());
		System.out.println(jFile.length());// 获取文件内容长度
		System.out.println(jFile.isFile());// 判断是否是文件
		System.out.println(jFile.isDirectory());// 判断是否为其一个目录
		System.out.println(jFile.isHidden());// 判断是否为隐藏文件
		System.out.println(jFile.lastModified());// 获取最后修改时间
		System.out.println(jFile.canRead());//判断文件是否可读
		System.out.println(jsFile.canWrite());//判断文件是否可写
		
		Date date = new Date(jFile.lastModified());// 获取最后修改时间
		try {
			jFile1.createNewFile();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("删除：");
		System.out.println(jsFile.getAbsolutePath());
		int s = 0;
		while (s < 3) {
			SimpleDateFormat sitDateFormat = new SimpleDateFormat("北京时间：" + "yyyy/MM/dd  HH:mm:ss");// 日期格式
			// System.out.println(sitDateFormat.format(date));
			System.out.println(sitDateFormat.format(new Date()));

			try {
				Thread.sleep(1000);// 延时一秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s++;
		}

	}
}
