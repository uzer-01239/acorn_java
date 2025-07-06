package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		try {
			/*
			 * Thread.sleep() 메소드 내부에서는 RuntimeException을 상속받지않은
			 * InterruptedException이 발생한다. RuntimeException을 상속받지 않은 예외는
			 * 예외처리를 의무적으로 해야한다. 처리하는 방법
			 * 1. throw
			 * 2. try~catch로 묶어주기
			 */
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료됩니다.");
	}
}
