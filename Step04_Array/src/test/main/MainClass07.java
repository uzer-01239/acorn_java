package test.main;

import java.util.Random;

public class MainClass07 {
	public static void main(String[] args) {
		// Random 객체 생성
		Random ran=new Random();
		int ranNum = ran.nextInt(30);
		System.out.println(ranNum);
	}
}
