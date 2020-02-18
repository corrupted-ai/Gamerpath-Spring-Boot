package com.path.model;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Document(collection = "users")
public class User implements Comparable<User>{
	
	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	private String id;
	private String gamertag;
	private String name;
	private String email;
	private String password;
	private String gender;
	private int score;
	
	List<String> posts =new LinkedList<>();
	List<String> sent=new LinkedList<>();
	List<String> receive = new LinkedList<>();
	List<String> friends = new LinkedList<>();
	List<String> chats = new LinkedList<>();
	
	
	public User() {
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public List<String> getPosts() {
		return posts;
	}

	public void setPosts(String postid) {
		this.posts.add(postid);
	}



	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(String friendid) {
		this.friends.add(friendid);
	}
	public List<String> getChats() {
		return chats;
	}
	public void setChats(String chatid) {
		this.chats.add(chatid);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List<String> getSent() {
		return sent;
	}
	public void setSent(String sent) {
		this.sent.add(sent);
	}
	public List<String> getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive.add(receive);
	}
	public String getGamertag() {
		return gamertag;
	}
	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	}



	@Override
	public int compareTo(User o) {
		return o.getScore()-this.getScore();
	}



	
	
}
