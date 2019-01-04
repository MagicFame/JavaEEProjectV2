package employeesManagementApplication.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import employeesManagementApplication.constantes.*;

public class MySQLConnUtils {

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		// Note: Change the connection parameters accordingly.
		String hostName = Constants.HOSTNAME;
		String dbName = Constants.DBNAME;
		String userName = Constants.USERNAME;
		String password = Constants.PASSWORD;
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		// URL Connection for MySQL:
		// Example:
		// jdbc:mysql://localhost:3306/simplehr
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}