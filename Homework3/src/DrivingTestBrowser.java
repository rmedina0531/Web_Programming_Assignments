

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final int DESCRIPTION= 0;
	static final int ANSWERA = 1;
	static final int ANSWERB = 2;
	static final int ANSWERC = 3;
	static final int CORRECTANSWER = 4;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init( ServletConfig config ) throws ServletException{
    	//In init(), read DrivingTest.txt and store the 
    	//questions in a List<Question> in the application scope.
    	
    	
    	String filename = "/WEB-INF/DrivingTest.txt";
    	super.init( config );
    	ServletContext context = getServletContext();
    	//find the complete path of the file
    	//test to find what foilder to add the file
    	String path = context.getRealPath(filename);
    	File file = new File(path);
    	//read the file and add the data
    	BufferedReader br;
    	
    	
    	
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
	    	
			ArrayList<Question> questions = new ArrayList<>();
			ArrayList<String> question = new ArrayList<>();
			while ((st = br.readLine()) != null) {
				if (st.length() == 0 && question.size() != 0){
					questions.add(new Question(question.get(DESCRIPTION), question.get(ANSWERA),
							question.get(ANSWERB), question.get(ANSWERC), question.get(CORRECTANSWER)));
	    			question = new ArrayList<>();
	    			continue;
	    		}
//				System.out.println(st.length());
				question.add(st);
	    	}
//	    	System.out.println(questions.size());
			//set the questions as a context attribute
			context.setAttribute("questions", questions);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);

		}

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//In doGet(), process the request, select the question to be displayed, 
		//and pass the question (and additional data if necessary) to a view (i.e. JSP).
		String s = request.getParameter("index");
		if (s == null) {
			s = "0";
		}
		int index = Integer.parseInt(s);
//		System.out.println(index);
		getServletContext().setAttribute("index",index);
		ArrayList<Question> qlist = (ArrayList<Question>) getServletContext().getAttribute("questions");
		
//		String size = "" + qlist.size(); 
//		getServletContext().setAttribute("size", size);
		
		Question q = qlist.get(index);
		
		int nextIndex = index + 1;
		int prevIndex = index - 1;
		if (nextIndex >= qlist.size()){
			nextIndex--;
		}
		if (prevIndex < 0) {
			prevIndex = 0;
		}
		String nextLink = "./DrivingTestBrowser?index=" + nextIndex;
		String prevLink = "./DrivingTestBrowser?index=" + prevIndex;
		
		//load the appropriate question
		int questionNumber = index + 1;
		getServletContext().setAttribute("questionNumber", questionNumber);
		getServletContext().setAttribute("nextLink", nextLink);
		getServletContext().setAttribute("prevLink", prevLink);
		request.getRequestDispatcher( "/WEB-INF/question.jsp").forward( request,
	            response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
