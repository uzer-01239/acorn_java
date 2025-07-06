package test.main;

import test.mypac.Operator;

public class MainClass07 {
	public static void main(String[] args) {
		
		//더하기 연산으로 결과값을 리턴해주는 Operater type 객체
		Operator plus = (double num1, double num2)->{
			return num1+num2;
		};
		
		//람다 표현식 (매개변수의 type 생략가능)
		Operator minus = (num1, num2)->{
			return num1-num2;
		};
		
		//메소드의 {} 생략하고 return 예약어 없이 리턴할 값만 --> 우측에 작성해도 됨
		Operator multiply = (a,b) -> a*b;
				
		System.out.println(plus.execute(3, 3.4));
		System.out.println(minus.execute(3, 5));
		System.out.println(multiply.execute(9,13));
		
	}
}
