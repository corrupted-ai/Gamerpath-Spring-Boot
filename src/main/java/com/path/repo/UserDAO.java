package com.path.repo;

import java.util.List;

import com.path.model.Post;
import com.path.model.User;

public interface UserDAO {
	public User create(User u);
	public User find(String id);
	public List<User> findgamer(String gamertag);
	public List<User> topten();
	public List<Post> userposts(String id);
	public User addposttouser(String id, String pid);
	public List<User> getusersbyids(List<String> ids);
	public boolean validateemail(String email);
	public boolean validateuser(String email,String password);
}
