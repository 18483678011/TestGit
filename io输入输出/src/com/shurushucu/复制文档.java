package com.shurushucu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class �����ĵ� {
	public void name2() {
		FileReader fileReader = null;// �ļ��������
		FileWriter fileWriter = null;// �ļ��������
		try {
			File nFile = new File("F:\\word.txt");
			File file = new File("F:\\word - ����.txt");
			if (!file.exists()) {// �ж��ļ��Ƿ���ڣ������ڴ����ڸ���
				file.createNewFile();// �����ļ�
				fileReader = new FileReader(nFile);
				fileWriter = new FileWriter(file);//fileWriter = new FileWriter(file��true/false);//true�����ļ�ĩβ׷�����֣�falseΪ�滻�ļ����ݣ�ϵͳĬ��ҲΪ��������ӡ�
				char[] ch = new char[20];
				int len = 0;
				while ((len = fileReader.read(ch)) != -1) {
					fileWriter.write(ch, 0, len);// ��д¼�뷽����c h����Ҫ¼������飬0�Ǵ������һ��Ԫ�ؿ�ʼ ¼�룬l e n��0��ʼ¼��l e n����Ч����
				}
				System.out.println("�����ɹ�1��");
			} else {// ����ֱ�Ӹ���
				fileReader = new FileReader(nFile);
				fileWriter = new FileWriter(file);
				char[] ch = new char[20];
				int len;
				while ((len = fileReader.read(ch)) != -1) {
					fileWriter.write(ch, 0, len);
				}
				System.out.println("�����ɹ�2��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();// �ر���fileWriter
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fileReader != null) {
					fileWriter.close();// �ر���fileWriter
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new �����ĵ�().name2();
	}
}
