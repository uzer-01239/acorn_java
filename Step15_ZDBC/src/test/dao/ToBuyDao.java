package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.connector.DBConnector;
import test.dto.ToBuyDto;

public class ToBuyDao {
	
	//번호를 이용하여 정보 리턴하는 메소드
	public ToBuyDto getByNum(int num) {
		
		ToBuyDto dto=null;
		
		//DB 연결
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//try~catch
		try (
			var conn=new DBConnector().getConn();
		){
			
			
			//sql
			String sql="""
					SELECT num, item, product, price, link
					FROM tobuy
					WHERE num=?
					""";
			pstmt=conn.prepareStatement(sql);
			
			//?에 값 바인딩
			pstmt.setInt(1, num);
			
			//SELECT 문 실행결과=>rs로 받아오기
			rs=pstmt.executeQuery();
			
			//반복문으로 rs에 담긴 데이터 추출
			while(rs.next()) {
				dto=new ToBuyDto();
				dto.setNum(num);
				dto.setItem(rs.getString("item"));
				dto.setProduct(rs.getString("product"));
				dto.setPrice(rs.getInt("price"));
				dto.setLink(rs.getString("link"));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally { //DB 종료
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}catch(Exception e) {}
		}
		return dto;
	}
	
	//SELECT -> List
	public List<ToBuyDto> selectAll(){
		
		List<ToBuyDto> list=new ArrayList<ToBuyDto>();
		
		
		String sql="""
				SELECT num, item, product, price, link
				FROM tobuy
				ORDER BY num ASC
				""";
		
		try (
		Connection conn=new DBConnector().getConn();
		PreparedStatement pstmt=conn.prepareStatement(sql);	
		ResultSet rs=pstmt.executeQuery();
		){
			
			
			
						
			while (rs.next()) {
				ToBuyDto dto=new ToBuyDto();
				dto.setNum(rs.getInt("num"));
				dto.setItem(rs.getString("item"));
				dto.setProduct(rs.getString("product"));
				dto.setPrice(rs.getInt("price"));
				dto.setLink(rs.getString("link"));
				
				list.add(dto);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//INSERT 메소드
	public boolean insert(ToBuyDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		//변화된 row 갯수=0 으로 초기화
		int rowCount=0;
		
		try {conn=new DBConnector().getConn();
			String sql="""
					INSERT INTO tobuy
					(num, item, product, price, link)
					VALUES (tobuy_seq.NEXTVAL, ?, ?, ?, ?)
					""";
			pstmt=conn.prepareStatement(sql);
			//?값 바인딩
			pstmt.setString(1, dto.getItem());
			pstmt.setString(2, dto.getProduct());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getLink());
			
			rowCount = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		if(rowCount > 0){
			return true;
		}else {
			return false;
		}
	}
	
	
	//UPDATE 메소드
	public boolean update(ToBuyDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		//변화된 row의 갯수--0으로 초기화
		int rowCount=0;
		
		try {
			conn=new DBConnector().getConn();
			String sql="""
					UPDATE tobuy
					SET	item=?,
					product=?,
					price=?,
					link=?
					WHERE num=?
					""";
			pstmt=conn.prepareStatement(sql);
			//?에 들어갈 값 바인딩
			
			pstmt.setString(1,dto.getItem());
			pstmt.setString(2, dto.getProduct());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getLink());
			pstmt.setInt(5, dto.getNum());
			
			//변경된 row 갯수
			rowCount=pstmt.executeUpdate();
			//executeQuery:select만.//update는 안한다
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (Exception e) {}
		}
		return rowCount>0;
	}
	
	
	
	//Delete 메소드
	public boolean deleteByNum(int num) {
		
		int rowCount=0;
		
		String sql="""
				DELETE FROM tobuy
				WHERE num=?
				""";
		
		try (
			Connection conn=new DBConnector().getConn();
			PreparedStatement pstmt=conn.prepareStatement(sql);
		){
			
			pstmt.setInt(1, num);
			rowCount=pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rowCount>0;
		
	}
	

}


