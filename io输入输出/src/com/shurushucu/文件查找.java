package com.shurushucu;

import java.io.File;

public class �ļ����� {
	public static void main(String[] args) {
		new �ļ�����().name();
		new �ļ�����().name1();
	}
	public void name() {// ���ҵ�ǰĿ¼�µ��ļ������ļ���
		File nFile = new File("F:\\");
		File[] fileString = nFile.listFiles();//��ȡ��ǰ�ļ����µ������ļ��Լ��ļ�����ɵ��ļ�����
		for (File string : fileString) {
			String nString = string.getName();
			if (nString.endsWith("xt")) {// �����ַ�������ָ���ַ�����
				System.out.println(string.getAbsolutePath() + " �ļ���С��" + string.length() + "B");//���վ���·�����
			}
			if (nString.startsWith("J")) {// �����ַ�������ָ���ַ���ʼ
				if (string.isFile()) {// �ж��Ƿ�Ϊ�ļ�
					System.out.println(string.getAbsolutePath() + " �ļ���С��" + string.length() + "B");
				} else {
					System.out.println(string.getAbsolutePath() + " �ļ��д�С��" + string.length() + "B");
				}
			}
		}

	}

    //************************************************************************************************************
	public void name1() {// ���Բ���Ŀ¼���ļ�
		File suFile = new File("F:\\��Ƭ");
		diguihans(suFile);
	}

	private static void diguihans(File suFile) {// �ݹ��˼��
		File[] S = suFile.listFiles();
		for (File file : S) {
			if (file.isDirectory()) {
				diguihans(file);
			} else {
				String string = file.getName();// ��ȡ�ļ���
				if (string.startsWith("��") && string.endsWith(".rar")) {// ��ʼΪz ����Ϊ.rar��
					System.out.println(file.getAbsolutePath() + " �ļ���С��" + file.length() / (1024 * 1024) + "MB");// ���Ŀ���ļ��ľ��Ե�ַ
				}
			}
		}
	}
}
