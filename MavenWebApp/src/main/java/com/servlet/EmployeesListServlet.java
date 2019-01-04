package employeesManagementApplication.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeesManagementApplication.beans.Employee;
import employeesManagementApplication.util.DBUtils;
import employeesManagementApplication.util.MyUtils;
 
@WebServlet(urlPatterns = { "/listOfEmployees" })
public class EmployeesListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EmployeesListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	if(MyUtils.getLoginedUser(session) == null) {
    		response.sendRedirect( request.getContextPath() + "/login");
    	}
    	else {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Employee> list = null;
        try {
            list = DBUtils.queryEmployee(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if(list.size() == 0) {
        	request.setAttribute("error", "The club has no member");
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("employeesList", list);
         
        // Forward to /WEB-INF/views/employeesListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/employeesListView.jsp");
        dispatcher.forward(request, response);
    	}
    }
 

 
}