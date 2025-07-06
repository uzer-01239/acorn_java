package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * HashMap<key type, value type>
		 * 
		 * key type은 일반적으로 String type을 가장 많이 사용한다.
		 * value type은 담고싶은 데이터 type 을 고려해서 지정하면 된다.
		 * value type을 Object로 지정하면 어떤 data type이던지 다 담을 수 있다.
		 * 순서가 없는 데이터를 다룰 떄 사용하면 된다
		 * dto 클래스 대신에 사용하기도 한다
		 * javascript에서의 {key:value, ...}와 비슷한 개념
		 */
		
		//HashMap 클래스는 Map 인터페이스를 구현했다(주로 이렇게)
		//type 상관 없이 담을 수 있따는 얘기.
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		//동일한 key값으로 다시 담으면 수정됨
		map.put("name", "선생님");
		map.clear();

		
		//데이터를 참조할 떄는 .get(key)메소드 이용
		int num = (int)map.get("num");
		String name = (String)map.get("name");
		boolean isMan = (boolean)map.get("isMan");
		
		//Map 인터페이스의 of()라는 static 메소드로 read only Map 객체도 만들어낼 수 있따.
		Map<String, Object> map2=Map.of(
				"num",2,
				"name","해골",
				"isMan",false
		);
		
	}
}
