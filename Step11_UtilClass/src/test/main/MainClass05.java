package test.main;

import java.util.ArrayList;

import test.mypac.MemberDto;

public class MainClass05 {
	public static void main(String[] args) {
		//MemberDto 객체를 저장할 수 있는 ArrayList 객체 생성
		//참조값을 List 인터페이스 type으로 받아서 사용하는 경우가 많다.
		ArrayList<MemberDto> list=new ArrayList<>();
		//1번 회원의 정보
		MemberDto dto1=new MemberDto();
		dto1.setNum(1);
		dto1.setName("김구라");
		dto1.setAddr("노량진");
		
		//2,3번 회원의 정보
		MemberDto dto2=new MemberDto(2, "해골", "서울");
		MemberDto dto3=new MemberDto(3, "원숭이", "저기어딘가");
		
		//생성한 회원의 정보를 ArrayList 객체에 누적시키기
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		for(MemberDto tmp:list) {
			String info = String.format("번호: %d, 이름: %s, 주소: %s", tmp.getNum(), tmp.getName(), tmp.getAddr());
			System.out.println(info);
		}
		
		System.out.println("forEach()를 이용하면 --->");
		//람다식
		list.forEach(tmp->{
			String info = String.format("번호: %d, 이름: %s, 주소: %s", tmp.getNum(), tmp.getName(), tmp.getAddr());
			System.out.println(info);
		});

	}
}