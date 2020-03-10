package com.shurushucu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 复制文档 {
	public void name2() {
		FileReader fileReader = null;// 文件输入程序
		FileWriter fileWriter = null;// 文件输出程序
		try {
			File nFile = new File("F:\\word.txt");
			File file = new File("F:\\word - 副本.txt");
			if (!file.exists()) {// 判断文件是否存在，不存在创建在复制
				file.createNewFile();// 创建文件
				fileReader = new FileReader(nFile);
				fileWriter = new FileWriter(file);//fileWriter = new FileWriter(file，true/false);//true即在文件末尾追加文字，false为替换文件内容，系统默认也为不可以添加。
				char[] ch = new char[20];
				int len = 0;
				while ((len = fileReader.read(ch)) != -1) {
					fileWriter.write(ch, 0, len);// 重写录入方法，c h是需要录入的数组，0是从数组第一个元素开始 录入，l e n从0开始录入l e n个有效数据
				}
				System.out.println("操作成功1！");
			} else {// 存在直接复制
				fileReader = new FileReader(nFile);
				fileWriter = new FileWriter(file);
				char[] ch = new char[20];
				int len;
				while ((len = fileReader.read(ch)) != -1) {
					fileWriter.write(ch, 0, len);
				}
				System.out.println("操作成功2！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();// 关闭流fileWriter
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fileReader != null) {
					fileWriter.close();// 关闭流fileWriter
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new 复制文档().name2();
	}
}
