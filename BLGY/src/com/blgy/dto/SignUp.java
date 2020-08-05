package com.blgy.dto;

public class SignUp {
	String email;
	String name;
	String nickname;
	String birthdate;
	String telno;
	String address;
	String addressdt;
	String xaxis;
	String yaxis;
	String pw;
	
	public SignUp(String email, String name, String nickname, String birthdate, String telno, String address,
			String addressdt, String xaxis, String yaxis, String pw) {
		super();
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.birthdate = birthdate;
		this.telno = telno;
		this.address = address;
		this.addressdt = addressdt;
		this.xaxis = xaxis;
		this.yaxis = yaxis;
		this.pw = pw;
	}

	public SignUp(String email) {
		super();
		this.email = email;
	}

	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressdt() {
		return addressdt;
	}
	public void setAddressdt(String addressdt) {
		this.addressdt = addressdt;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
