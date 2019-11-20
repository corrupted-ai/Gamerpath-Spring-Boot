package com.path.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post implements Comparable<Post>{
	
	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	private String id;
	
	private String postinfo;
	
	@DBRef
	private User user;
	
	@DBRef
	private List<Reply> replies = new LinkedList<>();

	private String datetime;

	public Post() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.datetime = myDateObj.format(myFormatObj);
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostinfo() {
		return postinfo;
	}

	public void setPostinfo(String postinfo) {
		this.postinfo = postinfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Reply reply) {
		this.replies.add(reply);
	}

	public Post(String postinfo, User user, List<Reply> replies) {
		this.postinfo = postinfo;
		this.user = user;
		this.replies = replies;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int compareTo(Post o) {
		String d1 = this.datetime;
		String d2 = o.datetime;
		int iday = Integer.parseInt(d1.substring(0, 2));
		int imonth = Integer.parseInt(d1.substring(3, 5));
		int iyear = Integer.parseInt(d1.substring(6, 10));
		int ihour = Integer.parseInt(d1.substring(11, 13));
		int imin = Integer.parseInt(d1.substring(14, 16));
		int isec = Integer.parseInt(d1.substring(17, 19));

		int fday = Integer.parseInt(d2.substring(0, 2));
		int fmonth = Integer.parseInt(d2.substring(3, 5));
		int fyear = Integer.parseInt(d2.substring(6, 10));
		int fhour = Integer.parseInt(d2.substring(11, 13));
		int fmin = Integer.parseInt(d2.substring(14, 16));
		int fsec = Integer.parseInt(d2.substring(17, 19));

		if (iyear - fyear > 0) {
			return 1;
		} else if (iyear - fyear < 0) {
			return -1;
		} else {
			if (imonth - fmonth > 0) {
				return 1;
			} else if (imonth - fmonth < 0) {
				return -1;
			} else {
				if (iday - fday > 0) {
					return 1;
				} else if (iday - fday < 0) {
					return -1;
				} else {
					if (ihour - fhour > 0) {
						return 1;
					} else if (ihour - fhour < 0) {
						return -1;
					} else {
						if (imin - fmin > 0) {
							return 1;
						} else if (imin - fmin < 0) {
							return -1;
						} else {
							if (isec - fsec > 0) {
								return 1;
							} else if (isec - fsec < 0) {
								return -1;
							} else {
								return 1;
							}

						}
					}
				}
			}
		}
	}
	
	
	
}
