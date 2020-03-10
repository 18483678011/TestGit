import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class prepare {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hello", "root","123456");
			String sql = "select * from messge where name = ? or address=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			connection.createStatement().executeUpdate("update  messge set name='无敌' ,address=23  where id = 8");//改数据
			connection.createStatement().executeUpdate("delete from messge where id=78");//改数据
			connection.createStatement().executeUpdate("insert into messge values (78,'ssd' ,'87')");//改数据
			pStatement.setString(1, "%");// 第一个通配符设置
			pStatement.setInt(2, 23);// 第二个通配符设置
			ResultSet executeQuery = pStatement.executeQuery();
			System.out.println("id\t name\taddress");
			while (executeQuery.next()) {
				System.out.println(executeQuery.getString(1) + " \t" + executeQuery.getString(2) + "\t"
						+ executeQuery.getString(3));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
