package com.shurushucu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ������ {

	public static void main(String[] args){
		File jFile = new File("F:\\", "word.txt");
		File jFile1 = new File("F:\\", "word - ����.txt");

		System.out.println(jFile1.exists());

		File jsFile = new File("str.txt");
		System.out.println("�ļ�����" + jFile.getName());// ��ȡ�ļ�����
		System.out.println(jFile.getParent());// ��ȡ�ļ��ĸ�·�� F:\\
		System.out.println(jsFile.getAbsolutePath());// ��ȡ����·��
		System.out.println(jFile.getAbsoluteFile());
		System.out.println(jFile.length());// ��ȡ�ļ����ݳ���
		System.out.println(jFile.isFile());// �ж��Ƿ����ļ�
		System.out.println(jFile.isDirectory());// �ж��Ƿ�Ϊ��һ��Ŀ¼
		System.out.println(jFile.isHidden());// �ж��Ƿ�Ϊ�����ļ�
		System.out.println(jFile.lastModified());// ��ȡ����޸�ʱ��
		System.out.println(jFile.canRead());//�ж��ļ��Ƿ�ɶ�
		System.out.println(jsFile.canWrite());//�ж��ļ��Ƿ��д
		
		Date date = new Date(jFile.lastModified());// ��ȡ����޸�ʱ��
		try {
			jFile1.createNewFile();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("ɾ����");
		System.out.println(jsFile.getAbsolutePath());
		int s = 0;
		while (s < 3) {
			SimpleDateFormat sitDateFormat = new SimpleDateFormat("����ʱ�䣺" + "yyyy/MM/dd  HH:mm:ss");// ���ڸ�ʽ
			// System.out.println(sitDateFormat.format(date));
			System.out.println(sitDateFormat.format(new Date()));

			try {
				Thread.sleep(1000);// ��ʱһ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s++;
		}

	}
}
