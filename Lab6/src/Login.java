

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Login</title></head>");
		out.println("<body>");
		
		out.println("<form method=\"post\">");
		//username
		out.println("User Name:");
		out.println("<input type=\"text\" name=\"userName\"><br>");
		
		//password
		out.println("Password:");
		out.println("<input type=\"text\" name=\"password\">");
		
		//button
		out.println("<input type=\"submit\">");
		
		out.println("</form>");
		out.println("</body>");
		out.println("");
		out.println("</html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		HttpSession session = request.getSession();
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		String validUser = "cysun";
		String validPass = "abcd";
		
		if (username.equals(validUser) && password.equals(validPass)){
			session.setAttribute("userName", validUser);
			response.sendRedirect("./Lab6/Members");
		}else {
			response.sendRedirect("./Lab6/Login");
		}
		
	}

}
