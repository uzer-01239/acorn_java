package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("이름입력:");
		String name=scan.nextLine();
		
		System.out.println("주소입력:");
		String addr=scan.nextLine();
		
		//MemberDao 객체를 이용해서 DB에 저장하려면?
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//MemberDao 객체의 insert() 메소드를 활용해서 DB에 저장한다.
		MemberDao dao=new MemberDao();
		//dao.insert(dto);
		
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			System.out.println(name+"님의 정보를 DB에 저장했습니다.");
		}else {
			System.out.println("저장 실패");
		}
	
	}
}
