package test.frame03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	//생성자
	public MyFrame() {
		setTitle("스레드 테스트");
		setBounds(100,100,300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton startBtn=new JButton("작업시작");
		/*
		 * type 추론이 가능하다면 지역변수의 type 선언 대신에 var 로 선언할 수 있다.
		 * java10에서 추가됨. 아직 실무에서는 1.8 버전을 쓰는 곳이 많음
		 * 지역변수에만 사용가능, 필드는 안됨
		 * 인터페이스 type 추론 불가
		 * null로 초기화 불가
		 */
		var startBtn2=new JButton("작업시작2"); 
		
		add(startBtn);
		add(startBtn2);
		
		startBtn.addActionListener((e)->{
			new Thread(()->{
				//여기는 메인스레드가 실행해준다. (버튼을 누르면)
				System.out.println("10초 걸리는 작업 시작");
				try {
					//결과적으로 메인스레드는 10초간 sleep 상태가 된다.(작업중이라고 가정)
					Thread.sleep(1000*10);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("작업종료");
			}).start();
			
		});
		
		startBtn2.addActionListener((e)->{
			//Thread 객체를 생성하면서 Runnable type 을 전달하고 해당 객체의 start() 메소드를 호출하면
			//새로운 작업단위가 시작된다.
				new Thread(()->{
				//여기는 Runnable type 객체의 run() 메소드 내부이다.(새로운 스레드가 시작되는 메소드)
				System.out.println("5초 걸리는 작업 시작");
				try {
					//결과적으로 메인스레드는 10초간 sleep 상태가 된다.(작업중이라고 가정)
					Thread.sleep(1000*5);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("작업종료");
			}).start();
		});
		
		setVisible(true);
	}
	
	
	//메인 메소드
	 public static void main(String[] args) {
		 //메인 스레드에서 MyFrame 객체를 생성하고 스레드는 사용자의 입력을 처리하기 위해 어디선가 대기중..
		new MyFrame();
	}

}
