package test.frame03;

import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Graphic User Interface 를 만들 수 있는 클래스 설계하기
 * 1. JFrame 클래스를 상속 받는다.
 * 2. 생성자에서 필요한 초기화 작업을 한다.
 * 3. main() 메소드에서 이클래스로 객체를 생성하면 프레임(window)가 만들어진다
 */

public class MyFrame extends JFrame implements ActionListener {
	//ActionListener 인터페이스를 구현했기 때문에 강제로 override 된 메소드 
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("이게 버튼4야");
		
	}
	
	//생성자
	public MyFrame() {
		//프레임의 제목 설정
		this.setTitle("나의 프레임"); //this.생략가능
		//프레임의 위치와 크기 설정 setBounds(x,y,width,height)
		setBounds(100, 100, 500, 500);
		//종료(x) 버튼을 눌렀을 때 프로세서(app) 전체가 종료되도록 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//레이아웃 매니저 객체 생성
		FlowLayout layout=new FlowLayout(FlowLayout.CENTER);
		//프레임의 레이아웃 매니저 설정
		setLayout(layout);
		//JButton 객체 생성
		JButton btn1=new JButton("버튼1");
		JButton btn2=new JButton("버튼2");
		JButton btn3=new JButton("버튼3");
		JButton btn4=new JButton("버튼4");
		//프레임의 add() 메소드 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치된다.
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		//ActionListener 는 메소드 1개짜리 인터페이스다.
		//UI 에 어떤 동작이 일어났을 때 호출될 예정인 메소드를 가지고 있는 ActionListener 객체
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 눌렸다");
			}
		};
		//첫번째 버튼에 액션 리스너 등록하기
		btn1.addActionListener(listener);
		
		//메소드 1개--함수 모양으로 ActionListener 객체 만들 수 있따.	
		
		ActionListener listener2=(e)->{
			System.out.println("버튼2도 눌림");
		};
		btn2.addActionListener(listener2);
			
		btn3.addActionListener(e->System.out.println("버튼3도 눌림"));
		
		//this 는 MyFrame 객체의 참조값을 가리킨다.
		btn4.addActionListener(this);		

		//화면상에 실제 보이도록 한다.
		setVisible(true);
	}
	
	//main 메소드 만들기
	public static void main(String[] args) {
		new MyFrame();
		
	}
}
