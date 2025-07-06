package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass02 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"scott", "TIGER");
			System.out.println("접속성공");
			 
		}catch (Exception e) {
			e.printStackTrace();
		}//SELECT 작업을 위해서 필요한 객체를 담을 지역변수 미리 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//실행할 SQL 문 미리 준비하기 (java10부터 추가된 문법=여러줄)
			String sql="""
					SELECT empno, ename, job, sal 
					FROM emp 
					ORDER BY empno ASC
					"""; //안에 ; 붙이면 안됨
			
			//String sql="SELECT empno, ename, job, sal FROM emp ORDER BY empno ASC";
			//sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//SELECT 문 실행하고 결과를 ResultSet 객체로 얻어내기
			rs=pstmt.executeQuery();
			//반복문 돌면서
			while(rs.next()) { //커서 내리는 역할 //
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				double sal=rs.getDouble("sal");
				//현재 Cursor 가 위치한 곳의 데이터를 테스트로 출력
				System.out.println(empno+"|"+ename+"|"+job+"|"+sal);
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}