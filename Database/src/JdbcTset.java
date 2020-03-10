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
			
			Class.forName("com.mysql.jdbc.Driver");// 数据库包加载
			String url = "jdbc:mysql://127.0.0.1:3306/hello";// 后面的hello是选择的数据库名
			String username = "root";// 数据库名字
			String password = "123456";// 数据库密码
			con = (Connection) DriverManager.getConnection(url, username, password);// 连接数据库
			stmt = (Statement) con.createStatement();
			 @SuppressWarnings("unused")
			int executeUpdate = con.createStatement().executeUpdate("delete from messge  where id=47");//删除数据 int表示
			con.createStatement().executeUpdate("delete from messge  where id=44");//删除数据
			con.createStatement().executeUpdate("insert into messge values (47,'数据' ,'87')");//改数据
			rSet = stmt.executeQuery("select * from messge");
			while (rSet.next()) {
				@SuppressWarnings("unused")
				int id = rSet.getInt("id");// 获取一行中的ID列
				int id1 = rSet.getInt(1);// 获取一行中的第一列，既是ID列；
				String name = rSet.getString("name");
				int address = rSet.getInt("address");
				if (id1 >= 3) {
					System.out.println("id=" + id1 + "\t name=" + name + "\t address= " + address);
				}

			}
			con.close();// 关闭数据库
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
