
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sdsaa {
	private File file;
	private BufferedReader reader;
	private InputStream is;
	private InputStreamReader isReader;

	public sdsaa() { 
	}

	public sdsaa(String filePath) {
		file = new File(filePath);
		initReader();
	}  

	private void initReader() {
		if (file != null && file.isFile() && file.canRead()) {
               //�ļ����ڿɶ�ȡ�����ǡ��ļ���������Ŀ¼
			try {
				is = new FileInputStream(file);// �����ļ�������
				isReader = new InputStreamReader(is);// �����������Reader
				reader = new BufferedReader(isReader);// ���ڰ��ж�ȡ�ļ�
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Integer> parse() {
		List<Integer> lstNumber = null;// ���ս������������
		String txtLine = null;// ��ʱ���������水�ж�ȡ�����ַ���
		String splitRegexp = "([0-9]+)\\s?";// ƥ�����ֵ�������ʽ
		Pattern pattern = Pattern.compile(splitRegexp);// ��������
		Matcher matcher = null;// �����Matcher����
        //��ʼ��ȡ�ļ�
		if (reader != null) {
			lstNumber = new ArrayList<Integer>();// ��ʼ��List
			try {
				while ((txtLine = reader.readLine()) != null) {// ���ж�ȡ�ļ�
					matcher = pattern.matcher(txtLine);// ��ȡmatcherʵ����׼�����в���
					while (matcher.find()) {// ���ҷ���������ƥ���飬���������List
						lstNumber.add(Integer.valueOf(matcher.group(1)));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {// �ر���
				try {
					reader.close();
					isReader.close();
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lstNumber;// ���ؽ��
	}

	public static void main(String[] args) {
		sdsaa fileParser = new sdsaa("D:\\test.txt");
		System.out.println(fileParser.parse());
	}
}