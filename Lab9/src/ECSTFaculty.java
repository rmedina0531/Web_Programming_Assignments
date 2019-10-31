

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ECSTFaculty
 */
@WebServlet("/ECSTFaculty")
public class ECSTFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ECSTFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init( ServletConfig config ) throws ServletException{
    	super.init( config );
    	Department computerScience = new Department("Computer Science");
    	computerScience.addFaculty("Kang", true);
    	computerScience.addFaculty("Sun", false);
    	Department electrical = new Department("Electrical and Computer Engineering");
    	electrical.addFaculty("Argarwal", false);
    	
    	ArrayList<Department> departments = new ArrayList<>();
    	departments.add(computerScience);
    	departments.add(electrical);
    	getServletContext().setAttribute("departments", departments);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher( "/WEB-INF/facultyInformation.jsp").forward( request,
	            response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
