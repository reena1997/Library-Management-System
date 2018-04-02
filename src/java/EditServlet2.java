import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String bname=request.getParameter("bname");  
        String bcode=request.getParameter("bcode");  
        String author=request.getParameter("author");  
        String datearrival=request.getParameter("datearrival");  
        String price=request.getParameter("price");  
        String rno=request.getParameter("rno");  
        String scode=request.getParameter("scode");  
        Book e=new Book();  
        e.setId(id);  
        e.setbname(bname);  
        e.setbcode(bcode);  
        e.setauthor(author);  
        e.setdatearrival(datearrival);  
        e.setprice(price);  
        e.setrno(rno);  
        e.setscode(scode);  
          
        int status=BookDao.update(e);  
        if(status>0){  
            RequestDispatcher rd=request.getRequestDispatcher("ViewBook");  
        rd.forward(request,response);   
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  