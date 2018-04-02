import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditMember")  
public class EditMember extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Members</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Member b=MemberDao.getMemberById(id);  
          
        out.print("<form action='EditMember2' method='get'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+b.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+b.getname()+"'/></td></tr>");  
        out.print("<tr><td>Pass:</td><td><input type='text' name='pass' value='"+b.getpass()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+b.getemail()+"'/></td></tr>");  
        out.print("<tr><td>Country:</td><td><input type='text' name='country' value='"+b.getcountry()+"'/></td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  