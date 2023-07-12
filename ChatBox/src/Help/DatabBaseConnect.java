package Help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabBaseConnect {
	public static Connection openConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/ta_tch_chatbox";
		String username = "root";
		String password = "Hiep12062004@";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
