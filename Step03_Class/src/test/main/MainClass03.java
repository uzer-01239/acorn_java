package test.main;

import test.auto.Car;

public class MainClass03 {
	public static void main(String[] args) {
		Car c1 = new Car();
		// 필드에 참조되는 값을 지역변수에 담아보기
		String name = c1.name; // null
		int price = c1.price; // 0
		c1.name="소나타";
		c1.price=3000;
		// 담은 후에 참조되는 값을 지역변수에 담아보기
		String name2=c1.name; // "소나타"
		int price2=c1.price; // 3000
	}
}
