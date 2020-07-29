package com.springlec.spring0201;

public class MainClass {

	public static void main(String[] args) {
		
		// 가감승제 계산
		// 1. class로 계산
		// 2. 데이터는 메인class 선정하고 가감승제 class 계산
		
		Calculation calculation = new Calculation();
		
		calculation.setFirstNum(5);
		calculation.setSecondNum(8);
		
		calculation.addition();
		calculation.subtraction();
		calculation.multiplication();
		calculation.division();
		

	}

}
