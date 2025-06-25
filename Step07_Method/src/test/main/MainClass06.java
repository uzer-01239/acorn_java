package test.main;

import test.mypac.ZzangGu;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * ZzangGu 객체를 3개 생성해서 배열에 담고
		 * 반복문을 돌면서 배열에 담긴 ZzangGu 객체의 dance() 메소드를 모두 호출해보세요
		 */
		
		
		ZzangGu zzang1 = new ZzangGu();
		ZzangGu zzang2 = new ZzangGu();
		ZzangGu zzang3 = new ZzangGu();
		
		ZzangGu[] Zzangs = new ZzangGu[3];
		Zzangs[0] = zzang1;
		Zzangs[1] = zzang2;
		Zzangs[2] = zzang3;
		
		for(int i=0; i<Zzangs.length; i++) {
			Zzangs[i].dance();
		}
		
	}
}
