package ��ͻ��˷�����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server=null;
	private Socket socket=null;
	static int count=0; 
	public Server() {
		try {
			System.out.println("�������߳�������...");
			server=new ServerSocket(9797);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				socket=server.accept();
				//ServerThread serverThread=new ServerThread(socket);
				//serverThread.start();
				count++;
				System.out.println("��ǰ�����߳�����"+count);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
	}

}

	/*class ServerThread extends Thread{
		Socket socket=null;
		public ServerThread(Socket socket) {
			this.socket=socket;
		}

		public void run() {
			InputStream in=null;
			InputStreamReader isrInputStreamReader=null;
			BufferedReader bufferedReader=null;
			OutputStream out=null;
			PrintWriter printWriter=null;
			try {
				in=socket.getInputStream();
				isrInputStreamReader=new InputStreamReader(in);
				bufferedReader=new BufferedReader(isrInputStreamReader);
				String string=null;
				while ((string=bufferedReader.readLine())!=null) {
					System.out.println("�ͻ��� :"+string);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}*/
