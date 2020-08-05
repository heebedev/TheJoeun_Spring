package com.springlec.mybatisAddressEx.dto;

public class AddDto {

	
	private int seq;
	private String name;
	private String telno;
	private String address;
	private String email;
	private String relation;
	
	
	
	public AddDto() {
		// TODO Auto-generated constructor stub
	}
	

	public AddDto(int seq, String name, String telno, String address, String email, String relation) {
		super();
		this.seq = seq;
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
	
	
	
}
