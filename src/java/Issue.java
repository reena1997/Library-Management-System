import java.io.*;  
import java.sql.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Issue extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String id=request.getParameter("mid");  
String bn=request.getParameter("bname");  
String is=request.getParameter("issue");  
String d=request.getParameter("due");   
try{  
Class.forName("org.h2.Driver");  
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
  
PreparedStatement ps=con.prepareStatement("insert into Issue(M_ID,BNAME,ISSUE_DATE,DUE_DATE) values(?,?,?,?)");  
  
ps.setString(1,id);  
ps.setString(2,bn);  
ps.setString(3,is);  
ps.setString(4,d);  
          
int i= ps.executeUpdate();  
if(i>0)  
out.print("Book is issued...");  
   RequestDispatcher rd=request.getRequestDispatcher("AdminHome.html");  
    rd.include(request,response);  
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  