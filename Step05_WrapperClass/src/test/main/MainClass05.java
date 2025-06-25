package test.main;

import java.io.InputStream;
import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 1. 콘솔창으로부터 입력 받을 수 있는 Scanner 객체를 생성해서
		 * 		그 참조값을 scan이라는 지역변수에 담기
		 * 2. scan에 담겨있는 Scanner 객체를 2번 사용해서 콘솔창으로부터 숫자 2개 입력받기
		 * 3. 입력받은 숫자(문자열)을 실제 숫자로 변경하기
		 * 4. 두 수의 합을 구해서 콘솔창에 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번쨰 숫자 입력 : ");
		String str1 = scan.nextLine();
		
		System.out.print("두번쨰 숫자 입력 : ");
		String str2 = scan.nextLine();
		
		int num1=Integer.parseInt(str1);
		double num2=Double.parseDouble(str2);
		
		// 연산 결과 얻어내기 (정수+실수=>실수)
		double result = num1+num2;
		
		// 정수 %d, 실수 %f
		String info=String.format("%d와 %f의 합은 %f입니다.", num1, num2, result);
		System.out.println(info);
		
		// System.out.println(num1 + "와" + num2 + "의 합은 " + (num1+num2) + "입니다.");		
	}
}
