package test.main;

import test.mypac.HandPhone;

public class MainClass01 {
	public static void main(String[] args) {
		HandPhone p1=new HandPhone();
		// 부모 클래스에 정의된 메소드를 사용할 수 있다.
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		
	}
}
