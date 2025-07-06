package test.frame01;

import javax.swing.JFrame;

/*
 * Graphic User Interface 를 만들 수 있는 클래스 설계하기
 * 1. JFrame 클래스를 상속 받는다.
 * 2. 생성자에서 필요한 초기화 작업을 한다.
 * 3. main() 메소드에서 이클래스로 객체를 생성하면 프레임(window)가 만들어진다
 */

public class MyFrame extends JFrame {
	//생성자
	public MyFrame() {
		//프레임의 제목 설정
		this.setTitle("나의 프레임"); //this.생략가능
		//프레임의 위치와 크기 설정 setBounds(x,y,width,height)
		setBounds(100, 100, 500, 500);
		//종료(x) 버튼을 눌렀을 때 프로세서(app) 전체가 종료되도록 한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면상에 실제 보이도록 한다.
		setVisible(true);
	}
}
