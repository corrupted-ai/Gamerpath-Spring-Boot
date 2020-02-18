package com.path.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.path.model.Post;
import com.path.model.Reply;
import com.path.model.User;
import com.path.repo.PostDAO;
import com.path.repo.ReplyDAO;
import com.path.repo.UserDAO;

@CrossOrigin
@RestController
public class Pathcontrroller {
	@Autowired
	private PostDAO postdao;
	
	@Autowired
	private ReplyDAO replydao;
	
	@Autowired
	private UserDAO userdao;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json")
	public List<Post> getallposts(){
		return postdao.getnewposts();
	}
	@RequestMapping(value = "/posts/popular", method = RequestMethod.GET, produces = "application/json")
	public List<Post> getpopularposts(){
		return postdao.getpopularposts();
	}
	
	@RequestMapping(value = "/post/{id}/replys", method = RequestMethod.GET, produces = "application/json")
	public List<Reply> getreplys(@PathVariable("id") String id){
		return postdao.getreplies(id);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET, produces = "application/json")
	public Post getpost(@PathVariable("id") String id){
		return postdao.find(id);
	}
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getuser(@PathVariable("id") String id){
		return userdao.find(id);
	}
	@RequestMapping(value = "/users/search/{gamertag}", method = RequestMethod.GET, produces = "application/json")
	public List<User> findgamers(@PathVariable("gamertag") String gamertag){
		return userdao.findgamer(gamertag);
	}
	@RequestMapping(value = "/users/top", method = RequestMethod.GET, produces = "application/json")
	public List<User> findtop(){
		return userdao.topten();
	}
	@RequestMapping(value = "/user/{id}/posts", method = RequestMethod.GET, produces = "application/json")
	public List<Post> userposts(@PathVariable("id") String id){
		return userdao.userposts(id);
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public boolean validuser(@RequestBody List<String> details){
		return userdao.validateuser(details.get(0), details.get(1));
	}
	
	
	
	
	
	@PostMapping(value = "/user/new")
	public boolean newuser(@RequestBody User u) {
		if(userdao.validateemail(u.getEmail())) {
			userdao.create(u);
			return true;
		}
		return false;
	}
	
	@PostMapping(value = "/post/new")
	public Post newpost(@RequestBody Post p) {
		return postdao.createpost(p);
	}
	@PostMapping(value = "/post/{id}/reply/new")
	public Post addreply(@PathVariable("id") String id,  @RequestBody Reply r) {
		replydao.create(r);
		return postdao.addreply(id, r);
	}
	@PostMapping(value = "/user/{id}/post/new")
	public User addpost(@PathVariable("id") String id,  @RequestBody Post p) {
		postdao.createpost(p);
		return userdao.addposttouser(id, p.getId());
	}
	
}
