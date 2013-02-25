package followme.dream.bean;
import java.sql.*;

public class JDBCCon{
	public static void main(String[] args) throws SQLException{
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
	    }catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/followme", "root", "");
	}
}
