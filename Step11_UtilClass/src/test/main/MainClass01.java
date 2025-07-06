package test.main;

import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		//java에서 배열은 용도가 한정되어있음. item을 담을 수 있는 공간을 늘이거나 줄일 수 없음.
		
		//문자열(String) type 을 담을 수 있는 방 5개 짜리 배열 객체 생성
		String[] names = new String[5];
		names[0] = "김구라";
		names[1] = "해골";
		names[2] = "원숭이";
		
		//아이템을 갯수 상관없이 필요에 따라 마음대로 추가하거나 제거할 수 있는 배열목록(ArrayList) 객체 생성하기
		ArrayList<String> friends = new ArrayList<>();
		//이름 3개 담기
		friends.add(0, "김구라");
		friends.add("해골");
		friends.add("원숭이");
		
		//0번방 아이템을 불러와서 item 변수에 담기
		String item = friends.get(0);
		
		System.out.println(item);
		
		//1번방 아이템을 삭제
		friends.remove(1);
		//저장된 아이템의 갯수(size)를 size라는 지역변수에 담기
		int size = friends.size();
		//0번방에 "에이콘" 끼워넣기
		friends.add(0, "에이콘");
		friends.set(0, "에이콘아카데미");
		System.out.println(friends.get(0));
		//저장된 모든 아이템 전체 삭제
		friends.remove(1);
		friends.clear();
		System.out.println(friends.size());
		//.add .get 많이 씀
	}
}
