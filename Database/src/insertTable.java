import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class insertTable {

	public static void main(String[] args) {
		Connection connection = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hello", "root",
					"123456");
			String sql = "update  messge set id=3 where id=88";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			PreparedStatement prepareStatement1 = connection.prepareStatement("delete from  messge where id=9");
			prepareStatement1.executeUpdate();
			prepareStatement.executeUpdate();
			String sql1 = "select * from messge";
			PreparedStatement pr = connection.prepareStatement(sql1);
			ResultSet executeQuery = pr.executeQuery(sql1);
			while (executeQuery.next()) {
				System.out.println(executeQuery.getString(1)+"\t "+executeQuery.getString(2)+"\t "+executeQuery.getString(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
