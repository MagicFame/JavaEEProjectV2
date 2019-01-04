package employeesManagementApplication.util;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeesManagementApplication.beans.UserAccount;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	// Store Connection in request attribute.
	// (Information stored only exist during requests)
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	// Get the Connection object has been stored in attribute of the request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}

	// Store user info in Session.
	public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
		// On the JSP can access via ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}

	// Get the user information stored in the session.
	public static UserAccount getLoginedUser(HttpSession session) {
		UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
		return loginedUser;
	}



}
