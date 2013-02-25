package followme.dream.dao;

import java.util.List;

import followme.dream.bean.*;


public interface FollowingDAO {
	
	List<User> findFollowing(int userid);
	void deleteFollowing(int userid, int followingid);
	void addFollowing(int userid, int followingid);
}
