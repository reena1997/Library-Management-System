import java.io.*;  
import java.sql.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class AddBookServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("bookName");  
String c=request.getParameter("bookCode");  
String a=request.getParameter("author");  
String ar=request.getParameter("arrival");  
String p=request.getParameter("price");  
String r=request.getParameter("rackNo");  
String sc=request.getParameter("subjectCode"); 
try{  
Class.forName("org.h2.Driver");  
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
  
PreparedStatement ps=con.prepareStatement("insert into ADD_BOOKS(BOOK_NAME,BOOK_CODE,AUTHOR,DATE_OF_ARRIVAL,PRICE,RACK_NO,SUBJECT_CODE) values(?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,c);  
ps.setString(3,a);  
ps.setString(4,ar);  
ps.setString(5,p); 
ps.setString(6,r);
ps.setString(7,sc);  
          
int i= ps.executeUpdate();  
if(i>0)
{
out.print("Your book is successfully added..."); 
RequestDispatcher rd=request.getRequestDispatcher("AdminHome.html");  
rd.include(request,response);  
}
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  