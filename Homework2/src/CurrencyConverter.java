

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrencyConverter
 */
@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyConverter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
    	super.init( config );
    	ServletContext context = getServletContext();
    	//find the complete path of the file
    	//test to find what foilder to add the file
    	String path = context.getRealPath("/WEB-INF/rates.txt");
    	File file = new File(path);
    	//read the file and add the data
    	BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			ArrayList<String> currency = new ArrayList<>();
			ArrayList<BigDecimal> rate = new ArrayList<>();
	    	while ((st = br.readLine()) != null) {
	    		String[] words = st.split(" ");
	    		currency.add(words[0]);
	    		rate.add(new BigDecimal(words[1]));
	    	}
	    	
	    	//set currency and rate to the attributes as arrays
	    	context.setAttribute("currency", currency);
	    	context.setAttribute("rate", rate);
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
		
		//get the converstion rates stored in in the attributes
		ArrayList<String> currency = (ArrayList<String>) getServletContext().getAttribute("currency");
		//ArrayList<BigDecimal> rate = (ArrayList<BigDecimal>) getServletContext().getAttribute("rate");
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Currency Converter</title></head>");
		out.println("<body>");
		out.println("<h2>");
		out.println("<form method=\"post\">");
		
		//amount input
		out.println("<input type=\"text\" name=\"amount\">");
		
		//unput currency selector
		out.println("<select name=\"inputCurrency\">");
		for (String type: currency) {
			out.println("<option value=\"" + type + "\">" + type +"</option>");
		}
		out.println("</select>=?");
		//output currency selector
		out.println("<select name=\"outputCurrency\">");
		for (String type: currency) {
			out.println("<option value=\"" + type + "\">" + type +"</option>");
		}
		out.println("</select>");
		//calculate Button
		out.println("<input type=\"submit\">");
		out.println("</form>");
		out.println("</h2>");
		out.println("</body>");
		out.println("");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		ArrayList<String> currency = (ArrayList<String>) getServletContext().getAttribute("currency");
		ArrayList<BigDecimal> rate = (ArrayList<BigDecimal>) getServletContext().getAttribute("rate");
		
		String input = request.getParameter("inputCurrency");
		String output = request.getParameter("outputCurrency");
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		
		BigDecimal answer = convert(input, output, amount, currency, rate);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Currency Converter</title></head>");
		out.println("<body>");
		out.println("<h2>");
		out.println(amount + " " + input + " = " + answer +" "+ output);
		out.println("</h2>");
		
		
//		out.println("<form method=\"get\">");
//		out.println("<input type=\"submit\">");
//		out.println("</form>");
		out.println("<a href=\"./CurrencyConverter\">Back</a>");
		
		out.println("</body>");
		out.println("");
		out.println("</html>");
	}
	
	private BigDecimal convert(String input, String output, BigDecimal amount, 
								ArrayList<String> currency, ArrayList<BigDecimal> rate) {
		int indexIn = currency.indexOf(input);
		int indexOut = currency.indexOf(output);
		
		BigDecimal result;
				
		if (input.equals("USD")) {
			result = amount.multiply(rate.get(indexOut));
		}else if (output.contentEquals("USD")){
			result = amount.divide(rate.get(indexIn), 3, RoundingMode.HALF_UP);
		}else {
			result = amount.divide(rate.get(indexIn), 3, RoundingMode.HALF_UP);
			result = result.multiply(rate.get(indexOut));
			return result;
		}
		return result.setScale(3, RoundingMode.CEILING);
	}
}
