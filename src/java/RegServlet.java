import java.io.*;  
import java.sql.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class RegServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");  
String c=request.getParameter("userCountry");  
          
try{  
Class.forName("org.h2.Driver");  
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
  
PreparedStatement ps=con.prepareStatement("insert into REGISTERUSER(NAME,PASS,EMAIL,COUNTRY) values(?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
RequestDispatcher rd=request.getRequestDispatcher("login.html");  
rd.include(request,response);      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  