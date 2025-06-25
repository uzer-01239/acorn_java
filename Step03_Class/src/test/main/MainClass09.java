package test.main;

import test.mypac.MemberInfo;

public class MainClass09 {
	public static void main(String[] args) {
		// 1. 한명의 회원정보를 MemberInfo 객체에 담아보세요.
		// (번호, 이름, 주소는 본인 마음대로 설정해서)
		MemberInfo mem2 = new MemberInfo();
		mem2.num = 2;
		mem2.name = "김진";
		mem2.addr = "서울";
		
		// 2. 위에서 생성한 객체(MemberInfo) 의 printData() 메소드를 호출해보세요
		mem2.printData();
	}
}
