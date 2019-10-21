package 例题多客户机;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Clint {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//单线程化线程池(newSingleThreadExecutor)
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        String name;
        ObjectOutputStream objectOutputStream = null;//输出
        try {
            System.out.println("请输入名称");
            name = scanner.nextLine();
            socket = new Socket("127.0.0.1",6666);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message();

            //启动一个线程用来读消息
            executorService.execute(new ReadThread(socket,name));

            //第一次登陆
            message.setFrom(name);
            message.setInfo("我要登陆");
            message.setMessage(MessageType.TYPE_LOGIN);
            message.setTo(null);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();

            //后续发消息
            while(true) {
                Message MessageSend = new Message();
                MessageSend.setFrom(name);
                MessageSend.setMessage(MessageType.TYPE_SEND);
                System.out.println("请输入目标名称");
                MessageSend.setTo(scanner.nextLine());
                System.out.println("请输入消息：");
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
class ReadThread implements Runnable {//新建线程用来专门读信息
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

