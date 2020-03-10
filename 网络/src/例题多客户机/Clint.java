package �����ͻ���;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Clint {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//���̻߳��̳߳�(newSingleThreadExecutor)
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        String name;
        ObjectOutputStream objectOutputStream = null;//���
        try {
            System.out.println("����������");
            name = scanner.nextLine();
            socket = new Socket("127.0.0.1",6666);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message();

            //����һ���߳���������Ϣ
            executorService.execute(new ReadThread(socket,name));

            //��һ�ε�½
            message.setFrom(name);
            message.setInfo("��Ҫ��½");
            message.setMessage(MessageType.TYPE_LOGIN);
            message.setTo(null);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();

            //��������Ϣ
            while(true) {
                Message MessageSend = new Message();
                MessageSend.setFrom(name);
                MessageSend.setMessage(MessageType.TYPE_SEND);
                System.out.println("������Ŀ������");
                MessageSend.setTo(scanner.nextLine());
                System.out.println("��������Ϣ��");
                MessageSend.setInfo(scanner.nextLine());
                objectOutputStream.writeObject(MessageSend);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                socket.close();
               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class ReadThread implements Runnable {//�½��߳�����ר�Ŷ���Ϣ
    Socket socket;
    String name;
    public ReadThread(Socket socket,String name) {
        this.socket = socket;
        this.name = name;
    }
    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            while(true) {
                try {
                    Message message = (Message) objectInputStream.readObject();
                    if(message.getFrom() != name && message.getInfo()!=null) {
                        System.out.println("["+message.getFrom()+"] : "+"["+message.getInfo()+"]" );
                    } else {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException|ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

