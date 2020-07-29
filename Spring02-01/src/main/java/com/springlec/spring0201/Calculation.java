package com.springlec.spring0201;

public class Calculation {
	
	
	// Field
	
	private int firstNum;
	private int secondNum;
	
	
	
	// Constructor
	
	public Calculation() {
	
		
		
	}
	
	
	// Method
	// Addition
	public void addition() {
		System.out.println("addition()");
		int resultNum = firstNum + secondNum;
		
		System.out.println(firstNum + " + " + secondNum + " = " + resultNum);
		
	}
	// Subtraction
	public void subtraction() {
		System.out.println("subtraction()");
		int resultNum = firstNum - secondNum;
		
		System.out.println(firstNum + " - " + secondNum + " = " + resultNum);
		
	}
	//Multiplication
	public void multiplication() {
		System.out.println("multiplication()");
		int resultNum = firstNum * secondNum;
		
		System.out.println(firstNum + " * " + secondNum + " = " + resultNum);
		
	}
	//Division
	public void division() {
		System.out.println("division()");
		int resultNum = firstNum / secondNum;
		
		System.out.println(firstNum + " / " + secondNum + " = " + resultNum);
		
	}


	//Setter & Getter
	public int getFirstNum() {
		return firstNum;
	}


	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}


	public int getSecondNum() {
		return secondNum;
	}


	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	
	


}
