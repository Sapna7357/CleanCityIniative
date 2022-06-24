package clean.city.initiative;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerForm")

public class registerForm extends HttpServlet{
	
	databaseObject dbobj = new databaseObject();
	private static final long serialVersionUID = 1L;
	// TODO Auto-generated constructor stub
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String full_name = request.getParameter("fname");
		String user_name = request.getParameter("uname");
		String email= request.getParameter("email");
		String user_password = request.getParameter("password");
		String user_confirmPassword = request.getParameter("confirm_password");
		System.out.println("hlo");
		System.out.println(full_name );
		if (full_name.isEmpty()  || user_name.isEmpty() || email.isEmpty() || user_password.isEmpty() || user_confirmPassword.isEmpty() ) {
			request.setAttribute("regError", "All fields mandatory");
			 request.getRequestDispatcher("registerForm.jsp").include(request, response);
			
		}
		 else {
				try {
					dbobj.registerUser(full_name,user_name,email,user_password );
					RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
					req.forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}

	}
}
