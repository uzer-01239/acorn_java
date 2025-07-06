package test.game;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DragonPanel extends JPanel {
	Image backImage, missImage;
	int unitX=0;
	int unitY=0;
	int back1Y=0, back2Y=-400;
	
	List<Missile> missList=new ArrayList<Missile>();
	//드래곤 객체 2개 배열
	Image[] unitImgs=new Image[2];
	//드래곤 이미지 인덱스
	int unitIndex;
	int count;
	
	//생성자
	public DragonFrame() {
		setPreferredSize(new Dimension(500, 800));
		
		//드래곤 이미지 2개
		unitImgs[0]=new ImageIcon(getClass().getResource("/image/unit1.png")).getImage();
		unitImgs[1]=new ImageIcon(getClass().getResource("/image/unit2.png")).getImage();
		
		//배경이미지
		backImage = new ImageIcon(getClass().getResource("/images/backbg.png")).getImage();
		//미사일이미지
		missImage = new ImageIcon(getClass().getResource("/images/mi2.png")).getImage();
	}
	

}
