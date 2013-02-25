package followme.dream.dao;

import java.util.List;

import followme.dream.bean.User;

public interface FollowerDAO {
	List<User> findFollower(int userid);
}
