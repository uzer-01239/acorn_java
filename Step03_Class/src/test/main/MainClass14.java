package test.main;

import test.mypac.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		
		new MemberDto();
		
		MemberDto dto=new MemberDto(); // 위의 MemberDto는 걍 버린 거임
		
		MemberDto dto2=new MemberDto(2, "김구라", "노량진");
		
		MemberDto dto3=new MemberDto();
		dto3.setNum(3);
		dto3.setName("해골");
		dto3.setAddr("서울");
		
	}

}
