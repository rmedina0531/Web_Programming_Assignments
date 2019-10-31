

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddJob
 */
@WebServlet("/AddJob")
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher( "/WEB-INF/AddJob.jsp").forward( request,
	            response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		String qual = request.getParameter("q");
//		System.out.println(qual);
		ArrayList<String> q = new ArrayList();
		
		String[] qualifications = request.getParameterValues("qualifications");
		for(String s: qualifications) {
			q.add(s);
		}
				
				
//		if (request.getParameter("java") != null) {
//			q.add(request.getParameter("java"));
//		}
//		if (request.getParameter("python") != null) {
//			q.add(request.getParameter("python"));
//		}
//		if (request.getParameter("sql") != null) {
//			q.add(request.getParameter("sql"));
//		}
//		if (request.getParameter("azure") != null) {
//			q.add(request.getParameter("azure"));
//		}
//		if (request.getParameter("oracle") != null) {
//			q.add(request.getParameter("oracle"));
//		}
//		if (request.getParameter("aws") != null) {
//			q.add(request.getParameter("aws"));
//		}
		
//		q.add(qual);
		Job job = new Job(request.getParameter("title"), request.getParameter("category"),
				request.getParameter("location"), q);
		
		
		ArrayList<Job> joblist = (ArrayList<Job>) getServletContext().getAttribute("jobList");
		joblist.add(job);
		
		response.sendRedirect("./JobListings");
	}

}
