import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcTset {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rSet = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");// ���ݿ������
			String url = "jdbc:mysql://127.0.0.1:3306/hello";// �����hello��ѡ������ݿ���
			String username = "root";// ���ݿ�����
			String password = "123456";// ���ݿ�����
			con = (Connection) DriverManager.getConnection(url, username, password);// �������ݿ�
			stmt = (Statement) con.createStatement();
			 @SuppressWarnings("unused")
			int executeUpdate = con.createStatement().executeUpdate("delete from messge  where id=47");//ɾ������ int��ʾ
			con.createStatement().executeUpdate("delete from messge  where id=44");//ɾ������
			con.createStatement().executeUpdate("insert into messge values (47,'����' ,'87')");//������
			rSet = stmt.executeQuery("select * from messge");
			while (rSet.next()) {
				@SuppressWarnings("unused")
				int id = rSet.getInt("id");// ��ȡһ���е�ID��
				int id1 = rSet.getInt(1);// ��ȡһ���еĵ�һ�У�����ID�У�
				String name = rSet.getString("name");
				int address = rSet.getInt("address");
				if (id1 >= 3) {
					System.out.println("id=" + id1 + "\t name=" + name + "\t address= " + address);
				}

			}
			con.close();// �ر����ݿ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rSet != null) {
				try {
					rSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
