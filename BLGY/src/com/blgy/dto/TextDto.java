package com.blgy.dto;

public class TextDto {
	
	
	
	int userseq;
	int textseq;
	public int getTextseq() {
		return textseq;
	}




	public void setTextseq(int textseq) {
		this.textseq = textseq;
	}
	String nickname;
	String nickname_send;
	String nickname_receive;
	String xaxis;
	String yaxis;
	String email;
	String date;
	String message;
	int myseq;
	
	
	public TextDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public TextDto(int userseq, String nickname) {
		super();
		this.userseq = userseq;
		this.nickname = nickname;
	}





	public TextDto(String nickname_send, String nickname_receive, String message, String date) {
		super();
		this.nickname_send = nickname_send;
		this.nickname_receive = nickname_receive;
		this.date = date;
		this.message = message;
	}




	public TextDto(int textseq, String nickname_send, String nickname_receive, String message, String date) {
		super();
		this.textseq = textseq;
		this.nickname_send = nickname_send;
		this.nickname_receive = nickname_receive;
		this.date = date;
		this.message = message;
	}




	public String getNickname_send() {
		return nickname_send;
	}




	public void setNickname_send(String nickname_send) {
		this.nickname_send = nickname_send;
	}




	public String getNickname_receive() {
		return nickname_receive;
	}




	public void setNickname_receive(String nickname_receive) {
		this.nickname_receive = nickname_receive;
	}




	public int getUserseq() {
		return userseq;
	}
	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getXaxis() {
		return xaxis;
	}
	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}
	public String getYaxis() {
		return yaxis;
	}
	public void setYaxis(String yaxis) {
		this.yaxis = yaxis;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMyseq() {
		return myseq;
	}
	public void setMyseq(int myseq) {
		this.myseq = myseq;
	}
	
	
	
	
}
