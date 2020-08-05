package com.blgy.dto;

public class LogInDto {
int validation;
String email;
String pwd;
public int getValidation() {
	return validation;
}
public void setValidation(int validation) {
	this.validation = validation;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public LogInDto(int validation, String email, String pwd) {
	super();
	this.validation = validation;
	this.email = email;
	this.pwd = pwd;
}
public LogInDto(int validation, String email) {
	super();
	this.validation = validation;
	this.email = email;
}

public LogInDto() {
	super();
}
}
