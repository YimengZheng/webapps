package followme.dream.bean;

import java.util.Date;

public class Message {
	private int messageID;
	private String content;
	private String headURL;
	private String username;
	private Date postdate;
	private int userID;
	private int baseID;
	
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int i) {
		this.messageID = i;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHeadURL() {
		return headURL;
	}
	public void setHeadURL(String headURL) {
		this.headURL = headURL;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBaseID() {
		return baseID;
	}
	public void setBaseID(int baseID) {
		this.baseID = baseID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
