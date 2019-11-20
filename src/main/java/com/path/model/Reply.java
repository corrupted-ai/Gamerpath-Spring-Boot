package com.path.model;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "replies")
public class Reply {
	
	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	private String id;
	
	@DBRef
	private User user;
	
	private String replyinfo;

	public Reply() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReplyinfo() {
		return replyinfo;
	}

	public void setReplyinfo(String replyinfo) {
		this.replyinfo = replyinfo;
	}

	public Reply(User user, String replyinfo) {
		super();
		this.user = user;
		this.replyinfo = replyinfo;
	}
}
