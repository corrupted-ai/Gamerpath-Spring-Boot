package com.path.repo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.path.model.Post;
import com.path.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private MongoTemplate mongo;
	
	@Autowired
	private PostDAO postdao;
	
	@Override
	public User create(User u) {
		return mongo.insert(u);
	}

	@Override
	public User find(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), User.class).get(0);
	}

	@Override
	public List<User> findgamer(String gamertag) {
		return mongo.find(new Query(Criteria.where("gamertag").is(gamertag)), User.class);
	}

	@Override
	public List<User> topten() {
		List<User> top = mongo.findAll(User.class);
		Collections.sort(top);
		List<User> topten = new LinkedList<>();
		for(int i=0;i<10;i++) {topten.add(top.get(i));}
		return topten;
	}

	@Override
	public List<Post> userposts(String id) {
		User u = find(id);
		return postdao.getpostsbyids(u.getPosts());
	}

	@Override
	public User addposttouser(String id, String pid) {
		User u = find(id);
		u.setPosts(pid);
		return mongo.save(u);
	}

	@Override
	public List<User> getusersbyids(List<String> ids) {
		List<User> u =new LinkedList<>();
		for(String id:ids) {
			u.add(find(id));
		}
		return u;
	}

	@Override
	public boolean validateemail(String email) {
		List<User> all = mongo.findAll(User.class);
		for(User u:all) {
			if (u.getEmail().equalsIgnoreCase(email)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean validateuser(String email, String password) {
		List<User> all = mongo.findAll(User.class);
		for(User u:all) {
			if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	

}
