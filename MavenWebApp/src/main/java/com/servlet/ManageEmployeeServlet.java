package employeesManagementApplication.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import employeesManagementApplication.beans.Employee;
import employeesManagementApplication.util.DBUtils;
import employeesManagementApplication.util.MyUtils;

@WebServlet(urlPatterns = { "/manageEmployee" })
public class ManageEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageEmployeeServlet() {
		super();
	}

	// redirect User on the appropriate view depending of what he wants to do
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect( request.getContextPath() + "/listOfEmployees");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Type = request.getParameter("submit");
		System.out.println(Type);
		
		// If user wants to delete an employee
		if (Type.equals("Delete")) {
			Connection conn = MyUtils.getStoredConnection(request);

			String email = (String) request.getParameter("sel");
			System.out.println(email);

			String errorString = null;

			try {
				DBUtils.deleteEmployee(conn, email);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}

			// If has an error, redirecte to the error page.
			if (errorString != null) {
				// Store the information in the request attribute, before forward to views.
				request.setAttribute("errorString", errorString);
				//
				RequestDispatcher dispatcher = request.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/deleteEmployeeErrorView.jsp");
				dispatcher.forward(request, response);
			}
			// If everything nice.
			// Redirect to the product listing page.
			else {
				response.sendRedirect(request.getContextPath() + "/listOfEmployees");
			}
		}

		// If user wants to add an employee
		else if (Type.equals("Add")) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createEmployeeView.jsp");
			dispatcher.forward(request, response);
		}

		// If user wants to edit an employee
		else if (Type.equals("Details")) {
			Connection conn = MyUtils.getStoredConnection(request);

			String email = (String) request.getParameter("sel");
			
			Employee employee = null;

			String errorString = null;

			try {
				employee = DBUtils.findEmployee(conn, email);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}

			// If no error.
			// The employee does not exist to edit.
			// Redirect to productList page.
			if (errorString != null && employee == null) {
				response.sendRedirect(request.getServletPath() + "/listOfEmployees");
				return;
			}

			// Store errorString in request attribute, before forward to views.
			request.setAttribute("errorString", errorString);
			request.setAttribute("employee", employee);

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editEmployeeView.jsp");
			dispatcher.forward(request, response);
		}

	}
}