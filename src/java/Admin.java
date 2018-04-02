import java.io.IOException;  
import java.io.PrintWriter;  
  import java.sql.*;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class Admin extends HttpServlet { 
    public boolean validate(String name,String pass){  
boolean status=false;  
try{  
Class.forName("org.h2.Driver");  
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
      
PreparedStatement ps=con.prepareStatement("SELECT * FROM Admin WHERE NAME=? and PASS=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");  
    String p=request.getParameter("pass");  
          
    if(validate(n,p)){  
        out.print("Welcome!");
        RequestDispatcher rd=request.getRequestDispatcher("AdminHome.html");  
        rd.include(request,response);  
    }  
    else{  
        out.print("Sorry username or password error");
        RequestDispatcher rd=request.getRequestDispatcher("Admin_login.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  