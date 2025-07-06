package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.ToBuyDao;
import test.dto.ToBuyDto;

public class ToBuyFrame extends JFrame {
	

	
	//field
	JTable table;
	DefaultTableModel model;
	ToBuyDao dao=new ToBuyDao();
	
	
	public ToBuyFrame() {
		
		setTitle("To Buy List");
		setBounds(100,100,800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		//레이아웃
		setLayout(new BorderLayout());
		
		//JButton 1개
		JButton insertBtn=new JButton("저장");
		JButton deleteBtn=new JButton("삭제");
		JButton updateBtn=new JButton("수정");
		
		//패널에 UI 배치
		JPanel panel=new JPanel();
		panel.add(insertBtn);
		panel.add(deleteBtn);
		panel.add(updateBtn);
		
		//패널 배경색
		panel.setBackground(Color.lightGray);
		//패널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.SOUTH);
				
		//회원목록을 출력할 테이블
		table=new JTable();
		//테이블의 칼럼명을 배열로 미리 준비한다.
		String[] colNames= {"번호", "분류", "상품", "가격", "링크"};
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
		
		JScrollPane scroll=new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		
		Object[] row1= {0, "sample"};
		model.addRow(row1);
		
		printToBuy();
		
		//저장버튼 
		insertBtn.addActionListener((e)->{
			
			
			
			
		});
		
		
	   
	}
	
	
	public void printToBuy() {
		model.setRowCount(0);
		List<ToBuyDto> list = dao.selectAll();
		for(ToBuyDto tmp:list) {
			Object[] row = {tmp.getNum(), tmp.getItem(), tmp.getProduct(), tmp.getPrice(), tmp.getLink()};
			model.addRow(row);
		}
		
		// 마지막 줄: 입력용 빈 행
	    Object[] emptyRow = {"", "", "", "", ""};
	    model.addRow(emptyRow);
	    


	}
	
	public static void main(String[] args) {
		ToBuyFrame f=new ToBuyFrame();
		
	}

	
}
