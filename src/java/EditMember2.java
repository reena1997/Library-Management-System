import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditMember2")  
public class EditMember2 extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String pass=request.getParameter("pass");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
        Member e=new Member();  
        e.setId(id);  
        e.setname(name);  
        e.setpass(pass);  
        e.setemail(email);  
        e.setcountry(country);  
        int status=MemberDao.update(e);  
        if(status>0){  
            RequestDispatcher rd=request.getRequestDispatcher("ViewMembers");  
        rd.forward(request,response);   
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  