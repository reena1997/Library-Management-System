import java.util.*;  
import java.sql.*;  
  
public class MemberDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("org.h2.Driver");  
            con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
     public static int update(Member b){  
        int status=0;  
        try{  
            Connection con=MemberDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update REGISTERUSER set NAME=?,PASS=?,EMAIL=?,COUNTRY=? where ID=?");   
            ps.setString(1,b.getname());  
            ps.setString(2,b.getpass());  
            ps.setString(3,b.getemail());  
            ps.setString(4,b.getcountry());  
            ps.setInt(5,b.getId()); 
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
     public static Member getMemberById(int id){  
        Member b=new Member();  
          
        try{  
            Connection con=MemberDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from REGISTERUSER where ID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                b.setId(rs.getInt(1));  
                b.setname(rs.getString(2));  
                b.setpass(rs.getString(3));  
                b.setemail(rs.getString(4));  
                b.setcountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return b;  
    } 
     public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=MemberDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from REGISTERUSER where ID=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static List<Member> getAllMembers(){  
        List<Member> list=new ArrayList<Member>();  
          
        try{  
            Connection con=MemberDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from REGISTERUSER");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Member b=new Member();  
                b.setId(rs.getInt(1));  
                b.setname(rs.getString(2));  
                b.setpass(rs.getString(3));  
                b.setemail(rs.getString(4));  
                b.setcountry(rs.getString(5));
                list.add(b);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  