

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


public class ALogout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException { 
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
    
        RequestDispatcher rd=request.getRequestDispatcher("Admin_login.html");  
        rd.include(request,response); 
        out.close();  
    }


}
