

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFaculty
 */
@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher( "/WEB-INF/addFaculty.jsp").forward( request,
	            response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		boolean chair = (request.getParameter("chairperson") == null) ? false : true;
		ArrayList<Department> departments = (ArrayList<Department>) getServletContext().getAttribute("departments");
		
		
		for (Department d: departments) {
			if (d.getName().equals(department)) {
				d.addFaculty(name, chair);
				break;
			}
		}
		response.sendRedirect("./ECSTFaculty");
//		request.getRequestDispatcher( "/ECSTFaculty").forward( request,
//	            response );
	}

}
