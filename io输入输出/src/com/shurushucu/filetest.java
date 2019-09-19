package com.shurushucu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filetest {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Administrator\\Desktop\\file.txt");
		FileWriter fileWriter = null;
		FileReader fileReader = null;
		try {
			if (!file.isFile()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file,true);
			//fileWriter.write("1870161788@qq.com");
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			fileReader = new FileReader(file);
			char[] string = new char[1024];
			int s;
			while ((s = fileReader.read(string)) != -1) {
				String string2 = new String(string, 0, s);
				System.out.print(string2);
			}
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
	}
}
