package employeesManagementApplication.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeesManagementApplication.beans.UserAccount;
import employeesManagementApplication.beans.Employee;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.userName, a.password from userAccounts a " //
				+ " where a.userName = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.userName, a.password from userAccounts a "//
				+ " where a.userName = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("password");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static List<Employee> queryEmployee(Connection conn) throws SQLException {
		String sql = "Select a.name, a.firstName, a.homePhone, a.mobilePhone, a.workPhone, a.address, a.postalCode,	a.city, a.email from employees a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			String name = rs.getString("name");
			String firstName = rs.getString("firstName");
			String homePhone = rs.getString("homePhone");
			String mobilePhone = rs.getString("mobilePhone");
			String workPhone = rs.getString("workPhone");
			String address = rs.getString("address");
			int postalCode = rs.getInt("postalCode");
			String city = rs.getString("city");
			String email = rs.getString("email");
			Employee employee = new Employee();
			employee.setName(name);
			employee.setFirstName(firstName);
			employee.setHomePhone(homePhone);
			employee.setMobilePhone(mobilePhone);
			employee.setWorkPhone(workPhone);
			employee.setAddress(address);
			employee.setPostalCode(postalCode);
			employee.setCity(city);
			employee.setEmail(email);
			list.add(employee);
		}
		return list;
	}

	public static Employee findEmployee(Connection conn, String email) throws SQLException {
		String sql = "Select a.name, a.firstName, a.homePhone, a.mobilePhone, a.workPhone, a.address, a.postalCode,	a.city, a.email from employees a where a.email=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			String firstName = rs.getString("firstName");
			String homePhone = rs.getString("homePhone");
			String mobilePhone = rs.getString("mobilePhone");
			String workPhone = rs.getString("workPhone");
			String address = rs.getString("address");
			int postalCode = rs.getInt("postalCode");
			String city = rs.getString("city");
			String email_ = rs.getString("email");
			Employee employee = new Employee();
			employee.setName(name);
			employee.setFirstName(firstName);
			employee.setHomePhone(homePhone);
			employee.setMobilePhone(mobilePhone);
			employee.setWorkPhone(workPhone);
			employee.setAddress(address);
			employee.setPostalCode(postalCode);
			employee.setCity(city);
			employee.setEmail(email_);
			return employee;
		}
		return null;
	}

	public static void updateEmployee(Connection conn, Employee employee, String DBemail) throws SQLException {
		String sql = "Update employees set name=?, firstName=?, homePhone=?, mobilePhone=?, workPhone=?, address=?, postalCode=?, city=?, email=? where email=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, employee.getName());
		pstm.setString(2, employee.getFirstName());
		pstm.setString(3, employee.getHomePhone());
		pstm.setString(4, employee.getMobilePhone());
		pstm.setString(5, employee.getWorkPhone());
		pstm.setString(6, employee.getAddress());
		pstm.setInt(7, employee.getPostalCode());
		pstm.setString(8, employee.getCity());
		pstm.setString(9, employee.getEmail());
		pstm.setString(10, DBemail);
		pstm.executeUpdate();
	}

	public static void insertEmployee(Connection conn, Employee employee) throws SQLException {
		String sql = "Insert into employees(name, firstName, homePhone, mobilePhone, workPhone, address, postalCode, city, email) values (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, employee.getName());
		pstm.setString(2, employee.getFirstName());
		pstm.setString(3, employee.getHomePhone());
		pstm.setString(4, employee.getMobilePhone());
		pstm.setString(5, employee.getWorkPhone());
		pstm.setString(6, employee.getAddress());
		pstm.setInt(7, employee.getPostalCode());
		pstm.setString(8, employee.getCity());
		pstm.setString(9, employee.getEmail());

		pstm.executeUpdate();
	}

	public static void deleteEmployee(Connection conn, String email) throws SQLException {
		String sql = "Delete From employees where email= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, email);

		pstm.executeUpdate();
	}

}