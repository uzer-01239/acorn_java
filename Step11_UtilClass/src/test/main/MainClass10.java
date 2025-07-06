package test.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass10 {
	public static void main(String[] args) {
		//Set 클래스의 of()라는 static 메소드를 이용해서 read only Set 객체를 만들 수도 있다.
		Set<String> set1 = Set.of("A", "B", "C", "D");
		Set<String> set2 = Set.of("E", "F", "G", "H");
		
		//중복된 데이터가 들어있는 List
		List<String> names = List.of("kim", "kim", "lee", "choi");
		
		//List 는 Collection type이기도 하다((Collection 이 부모 type)
		Collection<String> collec = names; //다형성 확인
		
		//HashSet 객체의 생성자에 List를 전달해서 HashSet 객체 생성(중복이 제거된다)
		Set<String> namesSet = new HashSet<>(names);
		
		//ArrayList 객체의 생성자에 Set를 전달해서 ArrayList 객체 생성(인덱스로 관리할 수 있다)
		List<String> names2 = new ArrayList<String>(namesSet);
		
	}

}
