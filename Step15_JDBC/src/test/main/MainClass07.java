package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;

public class MainClass07 {
	public static boolean insert(MemberDto dto) {
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		//변화된 row의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount=0;
		
		try {
			conn=new DBConnector().getConn();
			String sql="""
					INSERT INTO member
					(num, name, addr)
					VALUES(member_seq.NEXTVAL, ?, ?)
					""";
			pstmt=conn.prepareStatement(sql);
			//?에 들어갈 값 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql 문 실행하고 변경된(추가, 삭제,,,) row 갯수 리턴
			rowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {}
			
		}
		
		//변화된 rowCount 값을 조사해서 작업의 성공여부를 알아낸다.
		if(rowCount>0) {
			return true; //작업성공--true 리턴
		}else {
			return false;//작업실패--false 리턴
		}
	}
	
	public static void main(String[] args) {
		//DB에 추가할 회원의 정보라고 가정하자(member table)
		String name="누구게";
		String addr="어디게";
		//회원의 이름과 주소를 MemberDto 객체에 담느다
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//메소드 호출하면서 전달
		boolean isSuccess=insert(dto);
		if(isSuccess) {
			System.out.println("성공!");
		}else {
			System.out.println("실패여");
		}
	}
}
