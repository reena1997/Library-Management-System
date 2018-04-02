import java.util.*;  
import java.sql.*;  
  
public class BookDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("org.h2.Driver");  
            con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
     public static int update(Book b){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update ADD_BOOKS set BOOK_NAME=?,BOOK_CODE=?,AUTHOR=?,DATE_OF_ARRIVAL=?,PRICE=?,RACK_NO=?,SUBJECT_CODE=? where ID=?");   
            ps.setString(1,b.getbname());  
            ps.setString(2,b.getbcode());  
            ps.setString(3,b.getauthor());  
            ps.setString(4,b.getdatearrival());  
            ps.setString(5,b.getprice());  
            ps.setString(6,b.getrno());  
            ps.setString(7,b.getscode());
            ps.setInt(8,b.getId()); 
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
     public static Book getBookById(int id){  
        Book b=new Book();  
          
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from ADD_BOOKS where ID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                b.setId(rs.getInt(1));  
                b.setbname(rs.getString(2));  
                b.setbcode(rs.getString(3));  
                b.setauthor(rs.getString(4));  
                b.setdatearrival(rs.getString(5));  
                b.setprice(rs.getString(6));  
                b.setrno(rs.getString(7)); 
                b.setscode(rs.getString(8));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return b;  
    } 
     public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from ADD_BOOKS where ID=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static List<Book> getAllBooks(){  
        List<Book> list=new ArrayList<Book>();  
          
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from ADD_BOOKS");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Book b=new Book();  
                b.setId(rs.getInt(1));  
                b.setbname(rs.getString(2));  
                b.setbcode(rs.getString(3));  
                b.setauthor(rs.getString(4));  
                b.setdatearrival(rs.getString(5));
                b.setprice(rs.getString(6));  
                b.setrno(rs.getString(7)); 
                b.setscode (rs.getString(8));
                list.add(b);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  