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
import com.path.model.Reply;

@Repository
public class PostDAOImpl implements PostDAO{
	
	@Autowired
	private MongoTemplate mongo;
	
	
	@Override
	public Post createpost(Post p) {
		return mongo.insert(p);
	}

	@Override
	public Post find(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Post.class).get(0);
	}

	@Override
	public List<Reply> getreplies(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Post.class).get(0).getReplies();
	}

	@Override
	public Post addreply(String id, Reply r) {
		Post p = find(id);
		p.setReplies(r);	
		return mongo.save(p);
	}

	@Override
	public List<Post> getallposts() {
		return mongo.findAll(Post.class);
	}

	@Override
	public List<Post> getpopularposts() {
		List<Post> p= mongo.findAll(Post.class);
		Collections.sort(p, new Comparator<Post>() {

			@Override
			public int compare(Post o1, Post o2) {
				return o2.getScore()-o1.getScore();
			}
		});
		return p;
	}

	@Override
	public List<Post> getnewposts() {
		List<Post> p= mongo.findAll(Post.class);
		Collections.reverse(p);
		return p;
	}

	@Override
	public List<Post> getpostsbyids(List<String> ids) {
		List<Post> p = new LinkedList<Post>();
		for(String id:ids) {
			p.add(find(id));
		}
		return p;
	}
	
}
