package test.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class MemoFrame extends JFrame{
	
	//필드 정의
	JTextArea ta=new JTextArea();
	//현재 열린 파일
	File openedFile;

	//생성자
	public MemoFrame(String title) {
		super(title);
		//메뉴바
		JMenuBar mb=new JMenuBar();
		//메뉴
		JMenu menu=new JMenu("File");
		//메뉴 아이템
		JMenuItem newItem=new JMenuItem("New");
		JMenuItem openItem=new JMenuItem("Open");
		JMenuItem saveItem=new JMenuItem("Save");
		JMenuItem saveAsItem=new JMenuItem("Save As");
		
		//처음에 저장기능은 disable 된 상태로 만든다.
		saveItem.setEnabled(false);
		saveAsItem.setEnabled(false);
		
		
		//메뉴에 메뉴 아이템을 순서대로 추가
		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(saveAsItem);
		//메뉴를 메뉴바에 추가
		mb.add(menu);
		//프레임의 메소드를 이용해서 메뉴바 추가하기
		setJMenuBar(mb);
		//레이아웃 설정
		setLayout(new BorderLayout());
		//스크롤 패널
		JScrollPane scp=new JScrollPane(ta);
		//프레임의 가운데에 JScrollPane을 배치하기
		add(scp, BorderLayout.CENTER);
		//JTextArea 의 글자크기 조절
		Font font=new Font("SansSerif", Font.PLAIN, 30);
		ta.setFont(font);
		ta.setVisible(false); //처음에는 JTextArea 안보임
		
		//new 를 눌렀을 때
		newItem.addActionListener((e)->{
			ta.setVisible(true);
			//프레임의 제목
			setTitle("제목 없음");
			saveAsItem.setEnabled(true);
		});
		
		//saveAs
		saveAsItem.addActionListener((e)->{
			//파일 선택을 하게 해주는 객체
			var fc=new JFileChooser();
			//파일 저장하게 해주는 다이얼로그
			int result=fc.showSaveDialog(this);
			//만일 제대로 파일 만들 준비가 됐다면
			if(result == JFileChooser.APPROVE_OPTION) {
				//해당 file 객체를 얻어오기
				openedFile=fc.getSelectedFile();
				setTitle(openedFile.getName());
				//실제로 해당 파일 만들기
				try {
					openedFile.createNewFile();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				saveToFile();
				saveItem.setEnabled(true);
			}
		});
		
		//open
		openItem.addActionListener((e)->{
			
			var fc=new JFileChooser();
			int result=fc.showOpenDialog(this);
			
			if(result== JFileChooser.APPROVE_OPTION) {
				openedFile=fc.getSelectedFile();
				setTitle(openedFile.getName());
				try (var fis=new FileInputStream(openedFile)){
					//파일 내용 읽어서 문자열로 변환
					byte[] data = fis.readAllBytes();
					String memo=new String(data);
					
					ta.setText(memo);
					ta.setVisible(true);
					saveItem.setEnabled(true);
					saveAsItem.setEnabled(true);
					
				} catch (Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(this, "파일을 열 수 없음");
				}
			}
			
		
		});
		
		//save
		saveItem.addActionListener((e)->{
			if(openedFile != null) {
				saveToFile();
			} else {
				JOptionPane.showMessageDialog(this, "Save As!");
			}
		});
		
	}
	//현재까지 JTextArea 에 입력한 내용을 읽어와서 openedFile 에 저장하는 메소드
	public void saveToFile() {
		//JTextArea 에 입력한 문자열을 읽어와서
		String memo=ta.getText();
		//FileWriter 객체를 이용해서 openedFile 객체에 문자열이 저장되도록 한다.
		try (var fw=new FileWriter(openedFile);){
			fw.append(memo);
			fw.flush();
			JOptionPane.showMessageDialog(this, "저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	public static void main(String[] args) {
		MemoFrame f=new MemoFrame("메모장");
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
