package followme.dream.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import followme.dream.bean.User;

public class UserDAOIm implements UserDAO{	
	
	 private Connection conn=null;
	 ResultSet rs;
	 
	 public UserDAOIm()
	 {	 
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/followme", "root", "");
			 System.out.println("connect successfully!");
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }
	 

	@Override
	public boolean addUser(String username,String email, String password){
		boolean b;
		// TODO Auto-generated method stub
		  try
		   {
		    String sql="INSERT INTO User(username,email,password) VALUES(?,?,?)";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setString(1, username);
		    stmt.setString(2, email);
		    stmt.setString(3, password);
		    
		    stmt.executeUpdate();    
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		  return b=true;
	}
	
	@Override
	public boolean findUserByNameAndPass(String name, String password){
		// TODO Auto-generated method stub
		boolean bl = false;
		
		try
		   {
		    String sql="SELECT * from User where username=? and password=?";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setString(1, name);
		    stmt.setString(2, password);

		    rs=stmt.executeQuery();
		    if(rs.next())
		    {
		    	bl=true;
		    	System.out.println("find the user!");
		    }
		    else
		    {
		    	System.out.println("user doesn't exists!");
		    }
		   }
		 catch(SQLException e)
		   {
		    e.printStackTrace();
		   }	
  	return bl;		   		   
	}

	@Override
	public User findUserByName(String name){
		// TODO Auto-generated method stub
		
		User user=null;
		try
		   {
		    String sql="SELECT * from User where username=?";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setString(1, name);

		    rs=stmt.executeQuery();
		    if(rs.next())
		    {
		    	user=new User();
		    	user.setUserID(rs.getInt(1));
		    	user.setUsername(rs.getString(2));
		    	user.setPassword(rs.getString(3));
		    	user.setGender(rs.getString(4));
		    	user.setBirthday(rs.getDate(5));
		    	user.setEmail(rs.getString(6));
		    	user.setHeadURL(rs.getString(7));
		    	user.setCity(rs.getString(8));
		    	user.setCountry(rs.getString(9));		  
		    }

		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }	
    	return user;
	}

	@Override
	public void updateUser(User user) {
		String sql="UPDATE User SET username=?,gender=?," +
		  "head=?,EMP_PHONE=? WHERE EMP_ID=?";
		//not finished
		
	}

	@Override
	public void removeStudentByName(String name) {
		// TODO Auto-generated method stub
		try
		   {
		    String sql="DELETE FROM User WHERE username=?";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setString(1, name);
		    stmt.executeUpdate();
		    
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list =new ArrayList<User>();
		User user=new User();
		try
		   {
		    String sql="SELECT * from User";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	user=new User();
		    	user.setUserID(rs.getInt(1));
		    	user.setUsername(rs.getString(2));
		    	user.setPassword(rs.getString(3));
		    	user.setGender(rs.getString(4));
		    	user.setBirthday(rs.getDate(5));
		    	user.setEmail(rs.getString(6));
		    	user.setHeadURL(rs.getString(7));
		    	user.setCity(rs.getString(8));
		    	user.setCountry(rs.getString(9));
		    	list.add(user);
		  
		    }
		    
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		return list;
		    
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		List<User> list =new ArrayList<User>();
		User user=new User();
		try
		   {
		    String sql=query;
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	user=new User();
		    	user.setUserID(rs.getInt(1));
		    	user.setUsername(rs.getString(2));
		    	user.setPassword(rs.getString(3));
		    	user.setGender(rs.getString(4));
		    	user.setBirthday(rs.getDate(5));
		    	user.setEmail(rs.getString(6));
		    	user.setHeadURL(rs.getString(7));
		    	user.setCity(rs.getString(8));
		    	user.setCountry(rs.getString(9));
		    	list.add(user);
		  
		    }
		    
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		return list;
	}
	
}
