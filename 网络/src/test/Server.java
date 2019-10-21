package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket Ssocket;
	//PrintWriter reader;
	BufferedReader reader;
	Socket accept;
	int port =10001;
	public void getServer() {
		try {
			System.out.println("等待连接");
			Ssocket=new ServerSocket(port);
			while (true) {
				accept = Ssocket.accept();
				System.out.println("连接成功");
				reader=new BufferedReader(new InputStreamReader(accept.getInputStream()));
				getstream();
				//String string=reader.readLine();
				//System.out.println(string);				
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getstream() {
		try {
			while (true) {
				if (accept.isConnected()) {
					System.out.println(reader.readLine());
				}
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (accept != null) {
				accept.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.getServer();
	}
}
