package login;

import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
	Connection con;
   
    public LoginServlet() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "Anil");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() 
	{
		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			try {
				String s1=request.getParameter("uname");
				String s2=request.getParameter("pword");
				
				PreparedStatement pstmt=con.prepareStatement
						("select * from uinfo where uname=? and pword=?");
				
				pstmt.setString(1, s1);
				pstmt.setString(2, s2);
				ResultSet rs=pstmt.executeQuery();
				PrintWriter pw=response.getWriter();
				pw.println("<html><body bgcolor=green text=yellow><center><h1>");
				if(rs.next())
				{
					pw.println("Welcome... "+s1);
				}else
				{
					pw.println("Invalid username/password");
				}
				pw.println("</h1></center></body></html>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}