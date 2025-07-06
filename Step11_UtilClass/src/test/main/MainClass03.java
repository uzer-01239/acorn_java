package test.main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {

		//Quiz
		Scanner scan = new Scanner(System.in);
				
		//위에서 생성한 Scanner 객체로 반복문 돌면서 문자열 5번 입력 받아서
		//입력 받을 떄마다 ArrayList<String>객체에 add()하고
		//다 입력 받으면 다시 한번 반복문 돌면서 ArrayList<String> 객체에 저장된 문자열 5개를 
		//순서대로 콘솔창에 출력하라.
				
		ArrayList<String> msgs = new ArrayList<String>();

		for(int i=0; i<5; i++) {
			String input = scan.nextLine();
			msgs.add(input);
		}
		
		for(String tmp:msgs) {
			System.out.println(tmp);
		}
	}
}
