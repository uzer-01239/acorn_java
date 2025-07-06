// 이 클래스가 속해있는 패키지 명시하기 (없으면 에러)
package test.main;

// 클래스 안에서 사용하는 다른 클래스나 인터페이스 import

public class TestMain { //클래스의 범위를 나타내는 중괄호
	/*
	 * 클래스 안에 무언가를 정의할 때는 클래스 안에 속해있다는 의미에서 들여쓰기
	 * 클래스 안에 정의할 수 있는 것
	 * 1. 필드, static 필드
	 * 2. 메소드, static 메소드
	 * 3. 생성자
	 * 4. 또다른 클래스(Inner Class)
	 * -. 순서가 정해진 것은 아니지만 보통 필드=>생성자=>메소드 순서  
	 */
	
	//필드
	public String name="김구라";
	//static 필드
	public static String yourName="해골";
	
	//생성자 (메소드와 닮아 있지만 return type 이 없고 클래스명과 동일해야 한다)
	public TestMain() {
		//여기는 생성자 내부
		//어디에선가 new TestMain() 하여 객체를 생성하면 이 부분이 실행됨
		System.out.println("TestMain 생성자가 호출됨");
		//생성자 안에 지역변수 만들기 가능
	}
	
	//메소드
	public void test() {
		//여기는 메소드 내부
		//어디에선가 이 클래스(TestMain)으로 생성된 객체의 test(); 메소드를 호출하면 이 부분이 실행됨
		System.out.println("test() 메소드 호출됨");	
		//메소드 안에는 지역변수를 만들기 가능 (메소드는 불가)
	}
	
	//static 메소드
	public static void doSometing() {
		//어디에선가 클래스명에 . 찍어서 호출하는 메소드 TestMain.doSomething()으로 호출 가능
		System.out.println("doSomething()메소드 호출됨");
	}
	
	//run 했을 떄 (application 실행) 실행의 흐름이 시작되는 아주 특별한 main 메소드
	public static void main(String[] args) {
		//application 의 동작을 여기서 준비한다.
		//객체생성이나, 반복문, 메소드 호출 등등...
	}
}
