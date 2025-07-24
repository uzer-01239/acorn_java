package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import test.dao.ToBuyDao;
import test.dto.ToBuyDto;

public class ToBuyFrame extends JFrame {
	

	
	//field
	JTable table;
	DefaultTableModel model;
	ToBuyDao dao=new ToBuyDao();
	JLabel label;
	
	public ToBuyFrame() {
		
		setTitle("To Buy List");
		setBounds(100,100,800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		//레이아웃
		setLayout(new BorderLayout());
		
		//title
		JLabel titlelabel=new JLabel("📋 TO BUY LIST", SwingConstants.CENTER);
		titlelabel.setFont(new Font("SansSerif", Font.BOLD,22));
		
		add(titlelabel, BorderLayout.NORTH);
		
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
		String[] colNames= {"번호", "아이템", "상품", "가격", "링크"};
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
		
		
		//data 불러오기
		printToBuy();
		
		
	    
		//저장버튼 
		insertBtn.addActionListener((e)->{
			
			int lastRow = model.getRowCount()-1;
			
			try {
				//편집 종료
				if(table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}
				
				
				//저장 버튼 누르면 dto 생성
				String item = model.getValueAt(lastRow, 1).toString();
				String product = model.getValueAt(lastRow, 2).toString();
				String priceStr = model.getValueAt(lastRow, 3).toString();
				String link = model.getValueAt(lastRow, 4).toString();
				
				
				if(item.isEmpty()) {
					JOptionPane.showMessageDialog(this, "아이템을 작성해주세요");
					return;
				}
					
				int price=0;
				if (!priceStr.isEmpty()) {
					try {
						price=Integer.parseInt(priceStr);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(this, "price is number..");
						return;
					}
				}
				
				ToBuyDto dto = new ToBuyDto();
				dto.setItem(item);
				dto.setProduct(product);
				dto.setPrice(price);
				dto.setLink(link);
				
				boolean isSuccess=dao.insert(dto);
				if(isSuccess) {
					JOptionPane.showMessageDialog(this, "saved!");
					printToBuy();
					
				}else {
					JOptionPane.showMessageDialog(this, "failed!");
				}
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "price is number..");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "error : "+ ex.getMessage());
				ex.printStackTrace();
			}

		});
		
		
		//삭제버튼 Delete
		deleteBtn.addActionListener((e)->{
			int selectedRow=table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "select a Row!");
				return;
			}
			int num=(int)model.getValueAt(selectedRow, 1);
			dao.deleteByNum(num);
			printToBuy();
		});
		
		
		
	   setVisible(true);
	}
	
	
	public void printToBuy() {
		model.setRowCount(0); // 데이터 초기화
		List<ToBuyDto> list = dao.selectAll(); // 데이터 다 list에 가져옴
		//list 배열 돌면서 각 데이터를 object[]배열로 한 줄을 만듦
		for(ToBuyDto tmp:list) {
			Object[] row = {tmp.getNum(), tmp.getItem(), tmp.getProduct(), tmp.getPrice(), tmp.getLink()};
			model.addRow(row);
			
		}
		
		
	    //마지막 빈 행 추가
		model.addRow(new Object[]{"", "", "", "", ""});

	}
	
	//메인메소드
	public static void main(String[] args) {
		ToBuyFrame f=new ToBuyFrame();
		
	}

	
}
