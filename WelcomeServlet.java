package login;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("uname");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=blue text=yellow><h1>");
		pw.println("Welcome " +s1);
		pw.println("</h1></body></html>");
	}

}
