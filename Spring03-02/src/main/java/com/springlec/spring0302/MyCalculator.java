package com.springlec.spring0302;

public class MyCalculator {
	
	
	//중계자
	
	
	Calculator  calculator;
	
	private int firstNum;
	private int secondNum;
	
	public MyCalculator() {
		
	}
	
	//더하기를 할 줄 아는 애한테 일을 시킨다. 
	public void add() {
		calculator.addtion(firstNum, secondNum);
	}
	
	public void sub() {
		calculator.subtraction(firstNum, secondNum);
	}
	
	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}
	
	public void div() {
		calculator.division(firstNum, secondNum);
	}

	
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

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
