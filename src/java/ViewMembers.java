import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewBook")  
public class ViewMembers extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='AdminHome.html'>Go To Home</a>");  
        out.println("<h1>Members List</h1>");  
        List<Member> list=MemberDao.getAllMembers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th>"
                +"<th>Edit</th><th>Delete</th></tr>");  
        for(Member b:list){  
         out.print("<tr><td>"+b.getId()+"</td><td>"+b.getname()+"</td>"
                 +"<td>"+b.getemail()+"</td><td>"+b.getcountry()+"</td><td><a href='EditMember?id="+b.getId()+"'>edit</a></td>  \n" +
        "<td><a href='DeleteMember?id="+b.getId()+"'>delete</a>\n" +"</td></tr>");  
        }  
        out.print("</table>");  
        out.close();  
    }  
}  