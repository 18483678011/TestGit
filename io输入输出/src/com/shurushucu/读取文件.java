package com.shurushucu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ��ȡ�ļ� {

	public void name() {
		File nFile = new File("F:\\word.txt");
//����1********************************************************
		try {
			FileReader iFileReader = new FileReader(nFile);
			int s = (int) nFile.length();// ��ȡ�ļ���С
			char[] st = new char[s];
			int len = iFileReader.read(st);// ��ȡ�����м�����Ч����
			System.out.println(new String(st, 0, len));
			System.out.println();
			if (iFileReader != null) {
				iFileReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//����2**********************************************************
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

		// ����3********************************************************************

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
		new ��ȡ�ļ�().name();
	}
}
