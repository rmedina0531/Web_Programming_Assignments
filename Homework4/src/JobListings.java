

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JobListings
 */
@WebServlet("/JobListings")
public class JobListings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobListings() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ServletConfig config ) throws ServletException{
    	super.init( config );
    	ArrayList<Job> jobList = new ArrayList<>();
    	
    	ArrayList<String> temp = new ArrayList<>();
    	temp.add("Java");
    	temp.add("MySQL");
    	jobList.add(new Job("Junior Developer", "Software Development", "Los Angeles, CA", temp));
    	
    	jobList.add(new Job("Senior Developer", "Software Development", "Los Angeles, CA", temp));
    	
    	temp = new ArrayList<>();
    	temp.add("AWS");
    	jobList.add(new Job("System Administrator", "System Administrator", "Portland, OR", temp));
    	getServletContext().setAttribute("jobList", jobList);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher( "/WEB-INF/JobListings.jsp").forward( request,
		            response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
	}

}
