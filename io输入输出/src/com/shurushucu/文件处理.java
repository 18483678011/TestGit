package com.shurushucu;

import java.io.File;
import java.io.IOException;

public class �ļ����� {

	public static void main(String[] args) {
		File file = new File("F:\\", "111.txt");
		File file4=new File("F:\\�½��ļ���","11123.txt");
		try {
			file4.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			file.createNewFile();//�����ļ�
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.delete();//ɾ���ļ�
		boolean renameTo = file4.renameTo(file);//�ı��ļ�λ���Լ�����//Ҫ��֤����Ĳ����ڣ�ǰ��Ĵ��ڲſ���ʵ��
		System.out.println(renameTo);
		System.out.println(file.isFile());//�ж��ļ��Ƿ����
		File file2=new File("F:\\");
		File[] sFile=file2.listFiles();//��ȡfile2Ŀ¼�µ������ļ��Լ��ļ���
		for (File file3:sFile) {
			System.out.println(file3);		
		}
	}

}
