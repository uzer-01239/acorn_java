

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.main.DBConnector;

/*
 * Data Access Object 객체를 생성할 클래스 정의하기
 * -DB에 insert, update, delete, select 작업을 하는 코드를 작성한다.
 */
public class MemberDao{
	
	//회원번호를 이용해서 회원 1명의 정보를 리턴하는 메소드
	public MemberDto getByNum(int num) {
		//MemberDto 객체늬 참조값을 담을 지역변수를 미리 만든다.
		MemberDto dto=null; //new는 객체 내부-while 문 안에서 하는 게 좋다.
		//필요한 지역변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql문
			String sql = """
					SELECT name, addr
					FROM member
					WHERE num=?
					""";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			pstmt.setInt(1, num);

			//select 문 실행하고 결과를 ResultSet으로 받아온다.
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 담긴 데이터 추출해서 어떤 객체에 담는다,.
			while (rs.next()) {
				dto=new MemberDto();
				dto.setNum(num); //번호는 매개변수 번호
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	
	//회원 전체 목록을 select해서 List에 담아서 리턴하는 메소드
	public List<MemberDto> selectAll(){
		//회원정보를 누적시킬 ArrayList 객체 미리 준비하기
		List<MemberDto> list=new ArrayList<MemberDto>();
		
		
		//필요한 지역변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnector().getConn();
			//실행할 sql문
			String sql = """
					SELECT num, name, addr
					FROM member
					ORDER BY num ASC
					""";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩-? 없음

			//select 문 실행하고 결과를 ResultSet으로 받아온다.
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 담긴 데이터 추출해서 어떤 객체에 담는다,.
			while (rs.next()) {
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				//회원 한명의 정보가 담긴 새로운 MemberDto 객체의 참조값을 List에 누적시키기
				list.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	
	
	//회원 한명의 정보를 DB에서 수정하고 성공여부를 리턴하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//변화된 row의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount = 0;
	
		try {
			conn = new DBConnector().getConn();
			String sql = """
					UPDATE member
					SET name=?, addr=?
					WHERE num=?
					""";
			pstmt = conn.prepareStatement(sql);
			//?에 들어갈 값 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//sql 문 실행하고 변경된(추가, 삭제,,,) row 갯수 리턴
			rowCount = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	
		//변화된 rowCount 값을 조사해서 작업의 성공여부를 알아낸다.
		if (rowCount > 0) {
			return true; //작업성공--true 리턴
		} else {
			return false;//작업실패--false 리턴
		}
	}
	
	//회원 한명의 정보를 DB에서 삭제하고 성공여부를 리턴하는 메소드
	public boolean deleteByNum(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//변화된 row의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount = 0;

		try {
			conn = new DBConnector().getConn();
			String sql = """
					DELETE FROM member
					WHERE num=?
					""";
			pstmt = conn.prepareStatement(sql);
			//?에 들어갈 값 바인딩
			pstmt.setInt(1, num);
			//sql 문 실행하고 변경된(추가, 삭제,,,) row 갯수 리턴
			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}

		//변화된 rowCount 값을 조사해서 작업의 성공여부를 알아낸다.
		if (rowCount > 0) {
			return true; //작업성공--true 리턴
		} else {
			return false;//작업실패--false 리턴
		}
	}
	
	
	//회원 한명의 정보를 DB에 저장하고 성공여부를 리턴하는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//변화된 row의 갯수를 담을 변수 선언하고 0으로 초기화
		int rowCount = 0;

		try {
			conn = new DBConnector().getConn();
			String sql = """
					INSERT INTO member
					(num, name, addr)
					VALUES(member_seq.NEXTVAL, ?, ?)
					""";
			pstmt = conn.prepareStatement(sql);
			//?에 들어갈 값 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql 문 실행하고 변경된(추가, 삭제,,,) row 갯수 리턴
			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}

		//변화된 rowCount 값을 조사해서 작업의 성공여부를 알아낸다.
		if (rowCount > 0) {
			return true; //작업성공--true 리턴
		} else {
			return false;//작업실패--false 리턴
		}
		
	}

}
