/**
 * 
 */
package followme.dream.dao;

/**
 * @author Dream
 *
 */
import java.util.*;

import followme.dream.bean.Message;

public interface MessageDAO {
	
	Message findMessageById(int id);
	boolean addMessage(String content, Date date, int userid);
	void removeMessageById(int id);
	List<Message> getAllMessage(int id);
	List<Message> getMessageByUser(int id);

}
