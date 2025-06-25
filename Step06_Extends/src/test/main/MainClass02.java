package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

/*
 * [ 다형성 ]
 * java에서 객체는 여러 개의 type 을 가질 수 있따.
 * 지역변수나 필드 앞에 선언하는 data type은 (참조 데이터 type)
 * 그 안에 들어있는 참조값의 사용설명서라고 생각하면 됨
 * 그래서 그 지역변수나 필드에 . 점을 찍으면 사용설명성에 명시된 기능만 사용할 수 있음
 * java 의 모든 객체는 다형성을 가질 수 있다.
 * 다형성은 `여러 type`이라는 의미.
 */

public class MainClass02 {
	public static void main(String[] args) {
		// HandPhone 객체를 생성해서 나온 참조값을 HandPhone type 지역변수 p1에 담기
		HandPhone p1=new HandPhone();
		// HandPhone 객체를 생성해서 나온 참조값을 Phone type 지역변수 p1에 담기
		Phone p2=new HandPhone();
		// HandPhone 객체를 생성해서 나온 참조값을 Object type 지역변수 p1에 담기
		Object p3=new HandPhone();
	}
}
