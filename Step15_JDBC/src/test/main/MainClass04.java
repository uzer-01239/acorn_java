package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Java DataBase Connectivity (JDBC)
 * 
 * - java 에서 DB에 연결해서 INSERT, UPDATE, DELETE, SELECT 등의 작업을 할 수 있다.
 * - 우리는 ORACLE DataBase 에 연결해서 이런 작업을 할 예정이다.
 * - ORACLE 연결 driver 클래스가 있어야 연결 가능
 */

public class MainClass04 {
	public static void main(String[] args) {
		//DB에 접속해서 작업을 하려면 Connection 객체가 필요하다.
		Connection conn=null;
		
		//SELECT 작업을 위해서 필요한 객체를 담을 지역변수 미리 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//우리가 설계한 DBConnector 클래스를 이용하여 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			
			
			//실행할 SQL 문 미리 준비하기 (java10부터 추가된 문법=여러줄)
			String sql="""
					SELECT empno, ename, deptno, dname
					FROM emp 
					INNER JOIN dept
					USING(deptno)
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
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String info = String.format("사원번호:%d 사원이름:%s 부서번호:%d 부서이름:%s", empno, ename, deptno, dname);
				System.out.println(info);
				//현재 Cursor 가 위치한 곳의 데이터를 테스트로 출력
				System.out.println(empno+"|"+ename+"|"+deptno+"|"+dname);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
