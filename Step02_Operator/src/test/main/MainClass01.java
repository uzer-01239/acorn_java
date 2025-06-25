/**
 * 
 */
package test.main;

/*
 * 1. 산술연산자 테스트
 * 
 *  +, -, *, /, %
 *  
 */

public class MainClass01 {
	public static void main(String[] args) {
		int num1=5;
		int num2=2;
		// + 연산
		int sum = 10+1;
		int sum2 = num1 + num2;
		int sum3 = 10 +num2;
		// 정수끼리 연산하면 결과는 정수만 나온다.
		int result1 = 5/3;
		int result2 = num1/num2;
		// 연산의 결과로 실수 값을 얻어내고 싶으면 적어도 하나는 실수여야 한다.
		// double result3 = 5 / 3.0;
		double result3 = 5 / (double)3;
		
		int result4 = 10 % 3;
		
		byte a = 10;
		// a는 byte type 인데 int type b 에 대입하는 건 문제가 없을까
		int b = a;
		// b 는 int type 인데 b 에 저장된 값을 byte type C에 대입하는 건?
		// byte=8, int=32 이므로 문제가 있을 수도 있고, 대입값 크기가 작으면 문제 없을 수도
		// casting 해야 오류 x : (byte)을 인식시켜줌
		byte c = (byte)b;
		int d = 1000;
		byte e = (byte)d;

		
	}

}
