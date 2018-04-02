import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Books</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Book b=BookDao.getBookById(id);  
          
        out.print("<form action='EditServlet2' method='get'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+b.getId()+"'/></td></tr>");  
        out.print("<tr><td>Book Name:</td><td><input type='text' name='bname' value='"+b.getbname()+"'/></td></tr>");  
        out.print("<tr><td>Book Code:</td><td><input type='text' name='bcode' value='"+b.getbcode()+"'/></td></tr>");  
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='"+b.getauthor()+"'/></td></tr>");  
        out.print("<tr><td>Date Of Arrival:</td><td><input type='text' name='datearrival' value='"+b.getdatearrival()+"'/></td></tr>");  
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+b.getprice()+"'/></td></tr>");  
        out.print("<tr><td>Rack No:</td><td><input type='text' name='rno' value='"+b.getrno()+"'/></td></tr>");  
        out.print("<tr><td>Subject Code:</td><td><input type='text' name='scode' value='"+b.getscode()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  