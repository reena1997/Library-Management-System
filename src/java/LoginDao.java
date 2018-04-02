import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
    System.out.print("LOGIN Dao");
Class.forName("org.h2.Driver");  
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/reena","sa","");  
      
PreparedStatement ps=con.prepareStatement("SELECT * FROM REGISTERUSER WHERE NAME=? and PASS=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  