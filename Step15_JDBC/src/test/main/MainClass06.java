package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MainClass06 {
	public static void main(String[] args) {
		//DB에 추가할 회원의 정보라고 가정하자(member table)
		String name="누구게";
		String addr="어디게";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=new DBConnector().getConn();
			String sql="""
					INSERT INTO member
					(num, name, addr)
					VALUES(member_seq.NEXTVAL, ?, ?)
					""";
			pstmt=conn.prepareStatement(sql);
			//?에 들어갈 값 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			//sql 문 실행하고 변경된(추가, 삭제,,,) row 갯수 리턴
			int rowCount = pstmt.executeUpdate();
			if(rowCount>0) {
				System.out.println("작업성공");
			}else {
				System.out.println("작업실패..");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
