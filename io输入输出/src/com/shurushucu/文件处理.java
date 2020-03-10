package com.shurushucu;

import java.io.File;
import java.io.IOException;

public class 文件处理 {

	public static void main(String[] args) {
		File file = new File("F:\\", "111.txt");
		File file4=new File("F:\\新建文件夹","11123.txt");
		try {
			file4.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			file.createNewFile();//创建文件
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.delete();//删除文件
		boolean renameTo = file4.renameTo(file);//改变文件位置以及名字//要保证后面的不存在，前面的存在才可以实现
		System.out.println(renameTo);
		System.out.println(file.isFile());//判断文件是否存在
		File file2=new File("F:\\");
		File[] sFile=file2.listFiles();//获取file2目录下的所有文件以及文件夹
		for (File file3:sFile) {
			System.out.println(file3);		
		}
	}

}
