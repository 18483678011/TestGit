package com.shurushucu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ����������������� {

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
			
			// ����1************************************
			while ((b = bReader.read(by)) != -1) {
				bWriter.write(by, 0, b);
				bWriter.flush();// ˢ�»�������ǿ�ƽ�����������д���ļ��У���ʹ������û��д��
			}
			
			// ����2****************************************************
			String iString;
			while ((iString = bReader.readLine()) != null) {// ÿ�����һ������
				bWriter.write(iString);// ���������
				bWriter.flush();
			}
			String String;
			while ((String = bReader.readLine()) != null) {// ÿ�����һ������
				bWriter.write(String + "\n");// �������
				bWriter.flush();
			}
			
			// ����3****************************************************
			while ((String = bReader.readLine()) != null) {// ÿ�����һ�����ݲ���������з�
				bWriter.write(String);// �������
				bWriter.newLine();// ���з�
				bWriter.flush();
			}
			System.out.println("���Ƴɹ���");
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
		new �����������������().testfile();
	}

}
