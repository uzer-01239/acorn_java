package test.main;

import java.io.File;
import java.io.IOException;
// java.util 패키지에 있는 Random 클래스를 import
// import 안하면 Random 쓸 수 없음
import java.util.Random;
import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) throws IOException {
		// 기본 데이터 type 의 값이 담길 수 있는 빈 공간은 만들 수 없다.
		// int num = null; (X)
		int num; // javaScript는 let num; 만 해도 undefined 나오지만 java는 x
		
		// 문자열을 다룰 때는 String Type 을 사용하면 된다.
		String name="kim";
		
		String str = null; // str=10; str=true; str='a'; 안됨
	
		// 랜덤한 숫자를 얻어내고 싶다면?
		// 랜덤한 숫자를 생성해주는 기능을 가진 객체가 필요하다.
		Random ran = null; // ran=10; ran="kim"; 다 안됨
		ran = new Random(); // Random 객체 생성 표현식 (()는 생성자/method 아님)	
		boolean result1=ran.nextBoolean();
		
		System.out.println(result1);
		
		int result2=ran.nextInt();
		System.out.println(result2); 
		
		// 콘솔창에 문자열 출력하려면? 
		// 콘솔창에 문자열을 출력해주는 기능을 가진 객체가 필요하다.
		
		// 파일 시스템에 memo.txt 파일을 만들고 싶다면?
		// 파일을 만들 수 있는 기능을 가진 객체가 필요하다.
		File f = new File("C:/playground/memo.txt");
		f.createNewFile();
		
		// 콘솔창에 입력한 숫자나 문자열을 읽어들이고 싶다면?
		// 콘솔창에 입력한 내용을 이용해서 
		// int 나 String 을 만들어내는 기능을 가진 객체가 필요하다.
		Scanner scan = new Scanner(System.in);
		String line=scan.nextLine();
		
		System.out.println("main 메소드가 종료됩니다.");
		
	}

}
