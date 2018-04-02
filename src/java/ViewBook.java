import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewBook")  
public class ViewBook extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='AdminHome.html'>Go To Home</a>");  
        out.println("<h1>Book List</h1>");  
        List<Book> list=BookDao.getAllBooks();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Book_Name</th><th>Book_Code</th><th>Author</th><th>Date_Of_Arrival</th>"
                + "<th>Price</th><th>Rack_no</th><th>Subject_code</th><th>Edit</th><th>Delete</th></tr>");  
        for(Book b:list){  
         out.print("<tr><td>"+b.getId()+"</td><td>"+b.getbname()+"</td><td>"+b.getbcode()+"</td>"
                 +"<td>"+b.getauthor()+"</td><td>"+b.getdatearrival()+"</td><td>"+b.getprice()+"</td><td>"
         +b.getrno()+"</td><td>"+b.getscode()+"</td><td><a href='EditServlet?id="+b.getId()+"'>edit</a></td>  \n" +
        "<td><a href='DeleteServlet?id="+b.getId()+"'>delete</a>\n" +"</td></tr>");  
        }  
        out.print("</table>");  
        out.close();  
    }  
}  