package test.main;

public class MainClass01 {
	// static 영역에 만들어지는  main() 메소드
	public static void main(String[] args) {
		
		System.out.println("main method가 시작됨");
		// class명에 . 찍어서 static 메소드 호출하기
				MainClass01.test();
		System.out.println("main method가 종료됨");
		// 동일한 class 안에 있는 static 메소드를 호출할 때는 `클래스.` 생략가능
		test();
	}
	public static void test() {
		System.out.println("test() method가 호출됨");
	}
}
