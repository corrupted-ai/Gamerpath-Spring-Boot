package com.path.model;

public class Message {
	
	private String messageinfo;
	private String Userid;
	public Message(String messageinfo, String userid) {
		super();
		this.messageinfo = messageinfo;
		Userid = userid;
	}
	public String getMessageinfo() {
		return messageinfo;
	}
	public void setMessageinfo(String messageinfo) {
		this.messageinfo = messageinfo;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	
}
