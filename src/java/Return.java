import java.io.*;  
import java.sql.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Return extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String id=request.getParameter("mid");  
String bc=request.getParameter("bcode");  
String is=request.getParameter("issue");  
String ex=request.getParameter("expiry");   
try{  
Class.forName("org.h2.Driver");  
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
  
PreparedStatement ps=con.prepareStatement("delete from ISSUE where M_ID=?");  
  
ps.setString(1,id);  
          
int i= ps.executeUpdate();  
if(i>0)  
out.print("Book is returned...");  
   RequestDispatcher rd=request.getRequestDispatcher("index.html");  
    rd.include(request,response);  
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  