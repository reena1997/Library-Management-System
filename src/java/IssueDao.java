import java.util.*;  
import java.sql.*;  
  
public class IssueDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("org.h2.Driver");  
            con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static List<IssueBook> getAllBooks(){  
        List<IssueBook> list=new ArrayList<IssueBook>();  
          
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from ISSUE");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                IssueBook b=new IssueBook();  
                b.setmid(rs.getInt(1));  
                b.setbname(rs.getString(2));  
                b.setidate(rs.getString(3));  
                b.setduedate(rs.getString(4));  
                list.add(b);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  