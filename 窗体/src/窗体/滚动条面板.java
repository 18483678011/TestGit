package 窗体;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class 滚动条面板 extends JFrame{
    public 滚动条面板() {
    	setTitle ("滚动条文本框");
    	setBounds(400, 400, 500, 450);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//JPanel jpan9=new JPanel();
    	Container jpan=getContentPane();
    	JTextArea jte=new JTextArea(20,10);//代表字符个数
        JScrollPane js=new JScrollPane(jte); //带滚动条的面板容器  
    	jte.setSize(200,200);
    	jpan.add(js);
    	setVisible(true);
    }
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new 滚动条面板();

	}

}
