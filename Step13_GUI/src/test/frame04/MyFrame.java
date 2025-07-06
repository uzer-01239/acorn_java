package test.frame04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
	//필드
	private JButton countBtn;
	private int count=0;
	
	//생성자
	public MyFrame() {
		setTitle("나의 프레임");
		setBounds(100,100,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//레이아웃 매니저 객체 생성
		FlowLayout layout=new FlowLayout(FlowLayout.CENTER);
		//프레임의 레이아웃 매니저 설정
		setLayout(layout);
		//생성한 버튼의 참조값을 필드에 저장하면 객체 안에서 어디든 사용 가능
		countBtn=new JButton("0");
		add(countBtn);
		//버튼의 setText() 메소드를 이용하면 버튼에 출력된 문자열을 변경할 수 있다.
		//countBtn.setText("1");
		
		countBtn.addActionListener(this);

		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼의 text를 변경하려면 생성자에서 new JButton() 했던 참조값을 여기서 사용할 수 있어야 한다.
		count++;

		countBtn.setText(Integer.toString(count));
		
	}
}
