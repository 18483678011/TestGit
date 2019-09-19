
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
               //文件存在可读取并且是“文件”而不是目录
			try {
				is = new FileInputStream(file);// 创建文件输入流
				isReader = new InputStreamReader(is);// 创建输出流的Reader
				reader = new BufferedReader(isReader);// 用于按行读取文件
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Integer> parse() {
		List<Integer> lstNumber = null;// 最终结果保存在这里
		String txtLine = null;// 临时变量，保存按行读取到的字符串
		String splitRegexp = "([0-9]+)\\s?";// 匹配数字的正则表达式
		Pattern pattern = Pattern.compile(splitRegexp);// 编译正则
		Matcher matcher = null;// 正则的Matcher对象
        //开始读取文件
		if (reader != null) {
			lstNumber = new ArrayList<Integer>();// 初始化List
			try {
				while ((txtLine = reader.readLine()) != null) {// 按行读取文件
					matcher = pattern.matcher(txtLine);// 获取matcher实例，准备进行查找
					while (matcher.find()) {// 查找符合条件的匹配组，将结果放入List
						lstNumber.add(Integer.valueOf(matcher.group(1)));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {// 关闭流
				try {
					reader.close();
					isReader.close();
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lstNumber;// 返回结果
	}

	public static void main(String[] args) {
		sdsaa fileParser = new sdsaa("D:\\test.txt");
		System.out.println(fileParser.parse());
	}
}