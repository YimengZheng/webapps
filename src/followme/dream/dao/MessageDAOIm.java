package followme.dream.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import followme.dream.bean.Message;

public class MessageDAOIm implements MessageDAO{
	
	 private Connection conn=null;
	 ResultSet rs;

	public MessageDAOIm() {
		// TODO Auto-generated constructor stub
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
	public Message findMessageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessage(int id) {
		// TODO Auto-generated method stub 
			List<Message> list=new ArrayList<Message>();
			Message message=new Message();
			try
			{		
				String sql="SELECT * from Message where userID in" +
						"SELECT followingID from Following where userID=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, id);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					message=new Message();
					message.setMessageID(rs.getInt(1));
					message.setContent(rs.getString(2));
					message.setHeadURL(rs.getString(3));
					message.setPostdate(rs.getDate(4));
					message.setUserID(rs.getInt(5));
					message.setBaseID(rs.getInt(6));		
					list.add(message);				
				}
			}
			catch(SQLException e)
			{
			    e.printStackTrace();
			}
			return list;
		}

	@Override
	public List<Message> getMessageByUser(int id)  {
		// TODO Auto-generated method stub
		List<Message> list=new ArrayList<Message>();
		Message message=new Message();
		try
		{		
			String sql="SELECT * from Message where userID=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				message=new Message();
				message.setMessageID(rs.getInt(1));
				message.setContent(rs.getString(2));
				message.setHeadURL(rs.getString(3));
				message.setPostdate(rs.getDate(4));
				message.setUserID(rs.getInt(5));
				message.setBaseID(rs.getInt(6));		
				list.add(message);				
			}
		}
		catch(SQLException e)
		{
		    e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addMessage(String content, Date date, int userid) {
		boolean b;
		// TODO Auto-generated method stub
		  try
		   {
			  String sql="SELECT username, headURL from User where userID=?";
			  PreparedStatement stmt=conn.prepareStatement(sql);
			  stmt.setInt(1, userid);
			  rs=stmt.executeQuery();
			  String username=rs.getString(1);
			  String headURL=rs.getString(2);
			   
		      sql="INSERT INTO Message VALUES(?,?,?,?,?)";
		      stmt=conn.prepareStatement(sql);
		      stmt.setString(1, content);
		      stmt.setString(2, headURL);
		      stmt.setString(3, username);
		      stmt.setDate(4, (java.sql.Date) date);
		      stmt.setInt(5, userid);    
		      stmt.executeUpdate();  
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		  return b=true;		
	}

	@Override
	public void removeMessageById(int msgid) {
		// TODO Auto-generated method stub
		 try
		   {
			  String sql="Delete * from Message where msgID=?";
			  PreparedStatement stmt=conn.prepareStatement(sql);
			  stmt.setInt(1, msgid);
			  stmt.executeQuery();
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		
	}

}
