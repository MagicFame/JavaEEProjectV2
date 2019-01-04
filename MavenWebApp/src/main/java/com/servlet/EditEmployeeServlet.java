package employeesManagementApplication.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import employeesManagementApplication.beans.Employee;
import employeesManagementApplication.util.DBUtils;
import employeesManagementApplication.util.MyUtils;
 
@WebServlet(urlPatterns = { "/editEmployee" })
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditEmployeeServlet() {
        super();
    }
 
    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.sendRedirect( request.getContextPath() + "/listOfEmployees");
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        
        String DBemail = (String) request.getParameter("DBemail");
        String name = (String) request.getParameter("name");
		String firstName = (String) request.getParameter("firstName");
		String homePhone = (String) request.getParameter("homePhone");
		String mobilePhone = (String) request.getParameter("mobilePhone");
		String workPhone = (String) request.getParameter("workPhone");
		String address = (String) request.getParameter("address");
		String city = (String) request.getParameter("city");
		String email = (String) request.getParameter("email");
		int postalCode = 0;
		try {
			postalCode = Integer.parseInt(request.getParameter("postalCode"));
		} catch (Exception e) {
		}
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
 
        String errorString = null;
 
        try {
            DBUtils.updateEmployee(conn, employee, DBemail);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("employee", employee);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editEmployeeView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the employee listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/listOfEmployees");
        }
    }
 
}
