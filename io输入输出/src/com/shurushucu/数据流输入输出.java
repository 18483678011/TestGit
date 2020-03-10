package com.shurushucu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ������������� {
	public void Test() {
		File dFile = new File("F:\\�й��_�κ쿵_SE�μ�.zip");
		File shangFile = new File("F:\\SE�μ�.zip");
		BufferedInputStream bi = null;
		BufferedOutputStream bO = null;
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			long soll = System.currentTimeMillis();
			inputStream = new FileInputStream(dFile);
			outputStream = new FileOutputStream(shangFile);
			bi = new BufferedInputStream(inputStream);
			bO = new BufferedOutputStream(outputStream);
			byte[] byt = new byte[1024];
			int d;
			while ((d = bi.read(byt)) != -1) {
				bO.write(byt, 0, d);
			}
			bO.flush();// ˢ�»�������ǿ�ƽ�����������д���ļ��У���ʹ������û��д��
			long dd = System.currentTimeMillis();
			System.out.println("��Ҫ��ʱ�䣺" + (dd - soll));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bi != null) {
				try {
					bi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bO != null) {
				try {
					bO.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new �������������().Test();
	}
}
