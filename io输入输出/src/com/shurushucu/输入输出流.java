package com.shurushucu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ��������� {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * String dString=scanner.next().toUpperCase();//����ȡ��������ͳһת��Ϊ��д
		 * System.out.println(dString); String
		 * dString1=scanner.next().toLowerCase();//����ȡ��������ͳһת��ΪСд
		 * System.out.println(dString1);
		 */
		// ����1****************************************************************
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("�����ַ���");
			String dStrin = scanner.next().toUpperCase();// ����ȡ��������ͳһת��Ϊ��д
			if ("E".equalsIgnoreCase(dStrin) || "exit".equalsIgnoreCase(dStrin)) {
				// Ϊ��ִ�к��Դ�Сд�ıȽϣ����Ե���equalsIgnoreCase( )���������Ƚ������ַ���ʱ��������ΪA-Z��a-z��һ���ġ�
				System.out.println("�������");
				break;
			}
			System.out.println(dStrin);
		}
		// ����2**************************************************************************
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);// �ֽ����ַ���
		BufferedReader reader = new BufferedReader(inputStreamReader);// �ַ�������
		try {
			while (true) {
				System.out.println("�������ݣ�");
				String string;
				string = reader.readLine();
				if ("e".equalsIgnoreCase(string) || "exit".equalsIgnoreCase(string)) {
					System.out.println("�������");
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
