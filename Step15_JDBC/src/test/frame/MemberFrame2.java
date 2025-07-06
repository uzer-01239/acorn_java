package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import test.dao.MemberDao;
import test.dto.MemberDto;
import test.main.DBConnector;

public class MemberFrame2 extends JFrame{
	
	//필요한 필드 정의
	JTextField inputName, inputAddr;
	//표 형식으로 정보를 출력할 UI
	JTable table;
	//JTable 에 출력할 data를 공급해 줄 모델 객체
	DefaultTableModel model;
	//MemberDao를 자주 사용할 예정--필드 (필드는 var 불가)
	MemberDao dao= new MemberDao();
	
	
	//생성자
	public MemberFrame2() {
		//레이아웃
		setLayout(new BorderLayout());
		
		//JLable 2개
		JLabel label1=new JLabel("이름");
		JLabel label2=new JLabel("주소");
		
		//JTextField 1개
		inputName=new JTextField(10);
		inputAddr=new JTextField(10);
		
		//JButton 1개
		JButton insertBtn=new JButton("저장");
		JButton deleteBtn=new JButton("삭제");
		JButton updateBtn=new JButton("수정");
		
		//저장 버튼
		insertBtn.addActionListener((e)-> {
			
			// 저장 버튼을 누르면 dto 생성
			var name = inputName.getText();
			var addr = inputAddr.getText();
			
			MemberDto dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);

			//팝업
			boolean isSuccess=dao.insert(dto);
			if(isSuccess) {
				//this 는 나의 참조값(나=>MemberFrame 객체 =>Component type이기도 함)
				JOptionPane.showMessageDialog(this, "저장 성공!");
			}else {JOptionPane.showMessageDialog(this, "저장 실패ㅜ");}
			
			printMember();
		});		
		
		//삭제 버튼 눌렀을 때 실행할 함수
		deleteBtn.addActionListener((e)->{
			//선택된 row의 index값을 읽어온다
			int selectedRow=table.getSelectedRow();
			//만약 선택된 row가 없다면
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택해주세요");
				return; //함수 종료(리턴)
			}
			//삭제할 회원의 Primary Key 값 가져와서-- DB에서 삭제
			int num=(int)model.getValueAt(selectedRow, 1); //object type 을 (int)로 casting
			dao.deleteByNum(num);
			//기존 출력내용을 모두 삭제하고 DB에서 회원정보 다시 불러오기 --메소드로 만듦
			printMember();
			
		});
		
		//수정버튼
		updateBtn.addActionListener((e)->{
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showConfirmDialog(this, "수정할 row를 선택해주세요");
				return;
			}
			int num=(int)model.getValueAt(selectedRow, 1);
			MemberDto dto=dao.getByNum(num);
			var inputName=new JTextField(10);
			var inputAddr=new JTextField(10);
			JPanel editPanel=new JPanel();
			editPanel.add(new JLabel("이름:"));
			editPanel.add(inputName);
			editPanel.add(new JLabel("주소:"));
			editPanel.add(inputAddr);
			
			//MemberDto에 있는 정보를 JTextField에 출력
			inputName.setText(dto.getName());
			inputAddr.setText(dto.getAddr());
			
			
			
			//JPanel 을 전달하면서 ConfirmDialog를 띄운다
			int result = JOptionPane.showConfirmDialog(
				this, 
				editPanel, 
				num+" 번 회원 수정",
				JOptionPane.OK_CANCEL_OPTION
				);
			//리턴되는 숫자값을 테스트로 콘솔창에 출력하기--0:확인/2:취수/-1:X
			//System.out.println(result); 
			//만약 확인버튼을 누르면
			if(result == JOptionPane.OK_OPTION) {
				
				String name=inputName.getText();
				String addr=inputAddr.getText();
				
				MemberDto newDto=new MemberDto();
				newDto.setNum(num);
				newDto.setName(name);
				newDto.setAddr(addr);
				boolean isSuccess=dao.update(newDto);
				if(isSuccess) {
					JOptionPane.showMessageDialog(this, "수정성공");
					printMember();
				}else {
					JOptionPane.showMessageDialog(this, "실패다야");
					
				}
				
			}
			

			
		});
		
		//패널에 UI 배치
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(insertBtn);
		panel.add(deleteBtn);
		panel.add(updateBtn);
		
		//패널 배경색
		panel.setBackground(Color.lightGray);
		//패널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.NORTH);
		
		//회원목록을 출력할 테이블
		table=new JTable();
		//테이블의 칼럼명을 배열로 미리 준비한다.
		String[] colNames= {"번호", "회원번호", "이름", "주소"};
		//테이블에 연결할 모델 객체
		model=new DefaultTableModel();
		//모델에 칼럼명을 전달한다.
		model.setColumnIdentifiers(colNames);
		
		//모델을 테이블에 연결
		table.setModel(model);
		//테이블의 글자 크기와 행의 높이 조절
		table.getTableHeader().setFont(new Font("Sans-serif", Font.BOLD, 18));
		table.setFont(new Font("Sans-serif", Font.PLAIN, 16)); //데이터 글자크기 14
		table.setRowHeight(20); //행 높이
		
		
		//row 가 많은 경우 스크롤이 가능하도록 테이블에 scroll 기능 부여
		JScrollPane scroll=new JScrollPane(table);
		//테이블을 품고 있는 JScrollPane을 프레임의 가운데 배치하기
		add(scroll,BorderLayout.CENTER);
		
		//샘플 data를 table에 출력
		Object[] row1 = {0, "sample name", "sample addr"};
		model.addRow(row1);
		printMember();
				
		
	}
	
	public void printMember() {
		model.setRowCount(0);
		//MemberDao 객체를 이용해서 회원목록 얻어온 후 회원목록을 table에 반복문 돌면서 출력
		List<MemberDto> list = dao.selectAll();
		int index=1;
		for(MemberDto tmp:list) {
		//MemberDto 객체 하나당 하나의 Object[]를 만들어서
		Object[] row = {index++, tmp.getNum(), tmp.getName(), tmp.getAddr()};
		//모델에 추가
		model.addRow(row);
		}
	}
	
	
	//main method
	public static void main(String[] args) {
		MemberFrame2 f=new MemberFrame2();
		f.setTitle("회원 정보");
		f.setBounds(100,100,800,500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		

	}
}
