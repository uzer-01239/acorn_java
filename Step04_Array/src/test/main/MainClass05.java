package test.main;

import test.mypac.MemberInfo;

public class MainClass05 {
	public static void main(String[] args) {
		MemberInfo m1=new MemberInfo();
		m1.num=1;
		m1.name="김구라";
		m1.addr="노량진";
		
		MemberInfo m2=new MemberInfo();
		m2.num=2;
		m2.name="해골";
		m2.addr="행신동";
		
		MemberInfo m3=new MemberInfo();
		m3.num=3;
		m3.name="원숭이";
		m3.addr="동물원";
		
		// 위에서 생성한 MemberInfo 객체의 참조값 3개를 배열에 순서대로 담아보기
		MemberInfo[] members= {m1, m2, m3}; //배열 안 m1,,의 type:MemberInfo
		MemberInfo b = members[0];
		int c=members[0].num;
		String d=members[1].name;
		String e=members[2].addr;
		members[0].printData(); // 메소드 호출
		
				
	}

}
