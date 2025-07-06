package test.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
	//필요한 필드 정의
	Image backImage;
	Image missImage;
	
	//드래곤의 좌표
	int unitX=0;
	int unitY=0;
	
	//배경1의 y좌표
	int back1Y=0, back2Y=-400;
	
	//Missile 객체를 누적시킬 ArrayList 객체
	List<Missile> missList = new ArrayList<Missile>();
	
	//
	Image[] unitImgs=new Image[2];
	//드래곤 이미지 인댁스
	int unitIndex;
	
	//메소드 호출 횟수를 누적
	int count;
	
	//생성자
	public GamePanel() {
		//무언가 준비 작업..
		
		//Panel의 크기 설정 width:500, height:800
		setPreferredSize(new Dimension(300,400));
		
		unitImgs[0] = new ImageIcon(getClass().getResource("/images/unit1.png")).getImage();
		unitImgs[1] = new ImageIcon(getClass().getResource("/images/unit2.png")).getImage();
		
		//배경 이미지
		URL url2=getClass().getResource("/images/backbg.png");
		backImage=new ImageIcon(url2).getImage();
		
		
		missImage=new ImageIcon(getClass().getResource("/images/mi2.png")).getImage();
		
		MouseMotionAdapter adapter=new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//마우스의 좌표
				int x=e.getX();
				int y=e.getY();
				//마우스의 좌표를 unit의 좌표에 반영하기
				unitX=x;
				unitY=y;
				
				//테스트로 출력해보기
				System.out.println(x+" "+y);
			}
		};
		//마우스 움직임을 처리하기 위한 code
		addMouseMotionListener(adapter);
		
		//Panel 이 포커스를 받을 수 있도록 (key event 처리를 위해)
		setFocusable(true);
		//바로 포커스 주기
		requestFocusInWindow();
		
		//키보드 입력처리
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//만일 space바를 누르면
				if(e.getKeyCode() ==32) {
					//Missile 객체를 생성해서 현재 unit의 좌표를 담은다음 List에 누적시키기
					Missile m=new Missile(unitX, unitY);
					missList.add(m);
					
				}
				
			}
		});
		
		//Panel 이 10/1000 초마다 다시 그려지게 하기 위한 타이머 설정
		Timer timer=new Timer(10, (e)->{
			//System.out.println("호출되고 있다아");
			//Panel 객체의 repaint() 메소드를 호출(결과적으로 painComponent() 메소드가 다시 호출됨)
			repaint();
		});
		
		timer.start();
	}
	
	//panel에 무언가를 그릴 때 호출되는 메소드
	//Panel이 초기화될 때 한번 호출되고 그 다음에는 repaint()라는 메소드가 호출 될 때마다 다시 호출된다.
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//메소드 호출 카운트 증가
		count++;
		//배경이미지
		g.drawImage(backImage, 0, back1Y, 300, 400, this);
		g.drawImage(backImage, 0, back2Y, 300, 400, this);
		
		//반복문 돌면서 미사일 이미지 모두 그리기
		for(int i=0; i<missList.size(); i++) {
			//i 번째 미사일 객체
			Missile tmp=missList.get(i);
			g.drawImage(missImage, tmp.getX(),tmp.getY(),this);
		}
		
		
		//메소드의 매개변수에 전달되는 Graphics 객체를 Panel 에 그림을 그릴 수 있는 도구다
		g.drawImage(unitImgs[unitIndex], unitX-25, unitY-25, 50, 50, this);
		
		//드래곤 unmitInsdex 1증가
		if(count%10 == 0) {
			unitIndex++;
			if(unitIndex++ == 2){
				
				// 인덱스를 다시 0으로
				unitIndex=0;
			}
		}
		
		//미사일 갯수 표시	
		g.setColor(Color.yellow);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Missile : "+missList.size(), 10, 20);
		

		
		//모든 미사일의 y좌표를 감소시켜 미사일이 위로 발사되도록
		for(Missile tmp : missList) {
			//현재 y좌표에서 10 증가 시킨 값을 얻어내서
			int resultY = tmp.getY()-10;
			//해당 객체에 다시 넣기
			tmp.setY(resultY);
			//만일 위쪽으로 화면을 벗어난 미사일 객체라면
			if(tmp.getY() <= -10) {
				//제거하도록 표시해둔다.
				tmp.setRemove(true);
			}
			
		}
		
		//반복문 돌면서 List에서 제거할 Missile 객체는 제거한다.
		for(int i=0; i<missList.size(); i++) {
			//i 번째 Missile 객체
			Missile tmp=missList.get(i);
			//만일 i번째 미사일객체가 제거할 객체라면
			if (tmp.isRemove() ) {
				//List에서 i번째 item을 제거한다.
				missList.remove(i);
			}
		}
		
		back1Y += 1;
		back2Y += 1;
		
		//만일 배경1이 아래쪽으로 벗어난다면
		if(back1Y >= 400) {
			//-800의 좌표로 다시 보낸다.
			back1Y=-400;
		}
		//만일 배경2가 아래쪽으로 벗어난다면
		if(back2Y >= 400) {
			back2Y=-400;
		}
	}
}
