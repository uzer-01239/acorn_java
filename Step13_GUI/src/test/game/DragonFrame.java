package test.game;

import javax.swing.JFrame;

public class DragonFrame extends JFrame {
	//생성자
	public DragonFrame() {
		setTitle("Dragon Flight");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DraonPanel gPanel=new DragonPanel();
		add(gPanel);
		pack();
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new DragonFrame();
	}
	

}
