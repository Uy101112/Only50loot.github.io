import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class regisDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
	{
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava55?useSSL=false","root","uday");
			Statement st=con.createStatement();
			st.executeUpdate("insert into login values('"+s1+"','"+s2+"')");
			response.sendRedirect("login.html");
			con.close();
		}
		catch(Exception e1)
		{
			out.println(e1);
			
		}
		
		
		out.println("<h1>DATA INSERTED</h1>");
		out.println("</html>");
		out.println("</body>");
		out.close();
	}
}
