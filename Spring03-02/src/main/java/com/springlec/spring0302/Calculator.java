package com.springlec.spring0302;

public class Calculator {

	
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Addition
	
	public void addtion (int firstNum, int secondNum) {
		System.out.println("addition()");
		int resultNum = firstNum + secondNum;
		System.out.println(firstNum + " + " + secondNum + " = " + resultNum);
	}
	
	public void subtraction (int firstNum, int secondNum) {
		System.out.println("subtraction()");
		int resultNum = firstNum - secondNum;
		System.out.println(firstNum + " - " + secondNum + " = " + resultNum);
	}
	
	public void multiplication (int firstNum, int secondNum) {
		System.out.println("multiplication()");
		int resultNum = firstNum * secondNum;
		System.out.println(firstNum + " * " + secondNum + " = " + resultNum);
	}
	
	public void division (int firstNum, int secondNum) {
		System.out.println("division()");
		int resultNum = firstNum / secondNum;
		System.out.println(firstNum + " / " + secondNum + " = " + resultNum);
	}
	
	
	
	
	
	
}
