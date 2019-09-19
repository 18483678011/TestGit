package com.shurushucu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 缓冲数据输入输出流 {

	public void testfile() {
		File sFile = new File("123.txt");
		File sFiles = new File("456.txt");
		try {
			sFiles.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileReader bFileReader = null;
		FileWriter bFileWriter = null;
		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		try {
			bFileReader = new FileReader(sFile);
			bFileWriter = new FileWriter(sFiles);
			bReader = new BufferedReader(bFileReader);
			bWriter = new BufferedWriter(bFileWriter);
			char[] by = new char[1024];
			int b;
			
			// 方法1************************************
			while ((b = bReader.read(by)) != -1) {
				bWriter.write(by, 0, b);
				bWriter.flush();// 刷新缓冲区，强制将缓冲区数据写入文件中，即使缓冲区没有写满
			}
			
			// 方法2****************************************************
			String iString;
			while ((iString = bReader.readLine()) != null) {// 每次输出一行数据
				bWriter.write(iString);// 不换行输出
				bWriter.flush();
			}
			String String;
			while ((String = bReader.readLine()) != null) {// 每次输出一行数据
				bWriter.write(String + "\n");// 换行输出
				bWriter.flush();
			}
			
			// 方法3****************************************************
			while ((String = bReader.readLine()) != null) {// 每次输出一行数据不能输出换行符
				bWriter.write(String);// 换行输出
				bWriter.newLine();// 换行符
				bWriter.flush();
			}
			System.out.println("复制成功！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bFileReader != null) {
				try {
					bFileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bFileWriter != null) {
				try {
					bFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new 缓冲数据输入输出流().testfile();
	}

}
