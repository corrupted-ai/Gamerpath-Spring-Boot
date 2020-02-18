package com.path.repo;

import java.util.List;

import com.path.model.Post;
import com.path.model.Reply;

public interface PostDAO {
	public Post createpost(Post p);
	public Post find(String id);
	public List<Reply> getreplies(String id);
	public Post addreply(String id, Reply r);
	public List<Post> getallposts();
	public List<Post> getpopularposts();
	public List<Post> getnewposts();
	public List<Post> getpostsbyids(List<String> ids);
}
