package test.frame01;
/*
 * 새로운 스레드 만들기
 * 1.Thread 클래스를 상속받은 클래스를 정의한다.
 * 2.run() 메소드를 오버라이드한다.
 * 3.run() 메소드 안에서 새로운 스레드에서 해야할 작업을 코딩한다.
 * 4.만든 클래스로 객체를 생성하고 해당 객체의 start() 메소드를 호출하면 새로운 스레드가 시작된다.
 */

public class WorkThread extends Thread{
	@Override
	public void run() {
		//여기는 메인스레드가 실행해준다. (버튼을 누르면)
		System.out.println("10초 걸리는 작업 시작");
		try {
			//결과적으로 메인스레드는 10초간 sleep 상태가 된다.(작업중이라고 가정)
			Thread.sleep(1000*10);
		}catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("작업종료");
	}
}
