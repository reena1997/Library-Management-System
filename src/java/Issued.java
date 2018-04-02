import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/Issued")  
public class Issued extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='UserHome.html'>Back</a>");  
        out.println("<h1>Issued Book List</h1>");  
        List<IssueBook> list=IssueDao.getAllBooks();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Member Id</th><th>Book_Name</th><th>Issue Date</th><th>Due Date</th></tr>");  
        for(IssueBook b:list){  
         out.print("<tr><td>"+b.getmid()+"</td><td>"+b.getbname()+"</td><td>"+b.getidate()+"</td>"
                 +"<td>"+b.getduedate()+"</td></tr>");  
        }  
        out.print("</table>");  
        out.close();  
    }  
}  