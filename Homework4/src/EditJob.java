

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditJob
 */
@WebServlet("/EditJob")
public class EditJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int edit = Integer.parseInt(request.getParameter("jobID"));
		
		ArrayList<Job> jobsList = (ArrayList<Job>) getServletContext().getAttribute("jobList");
		for (Job j: jobsList) {
			if (j.getJobID() == edit) {
				getServletContext().setAttribute("editJob", j);
				break;
			}
		}
		request.getRequestDispatcher( "/WEB-INF/EditJob.jsp").forward( request,
	            response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Job job = (Job) getServletContext().getAttribute("editJob");
		
		
//		String qual = request.getParameter("q");
//		System.out.println(qual);
		ArrayList<String> q = new ArrayList();
		String[] qualifications = request.getParameterValues("qualifications");
		for (String s: qualifications) {
			q.add(s);
		}
		
		
//		if (request.getParameter("Java") != null) {
//			q.add(request.getParameter("Java"));
//		}
//		if (request.getParameter("Python") != null) {
//			q.add(request.getParameter("Python"));
//		}
//		if (request.getParameter("MySQL") != null) {
//			q.add(request.getParameter("MySQL"));
//		}
//		if (request.getParameter("Azure") != null) {
//			q.add(request.getParameter("Azure"));
//		}
//		if (request.getParameter("Oracle") != null) {
//			q.add(request.getParameter("Oracle"));
//		}
//		if (request.getParameter("AWS") != null) {
//			q.add(request.getParameter("AWS"));
//		}
		
//		q.add(qual);
		
		
		
		String title = request.getParameter("title");
		String category =request.getParameter("category");
		String location = request.getParameter("location");
		
		ArrayList<Job> jobs = (ArrayList<Job>) getServletContext().getAttribute("jobList");
		
		for(Job j: jobs) {
			if (j.getJobID() == job.getJobID()) {
				j.setJobTitle(title);
				j.setCategory(category);
				j.setLocation(location);
				j.setQualifications(q);
				break;
			}
		}
		
		
		response.sendRedirect("./JobListings");
	}

}
