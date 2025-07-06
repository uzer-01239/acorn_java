package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

/*
 * HashSet 은 Set 인터페이스를 구현한 클래스이다.
 * - 순서가 없다.
 * - key 값도 없다.
 * - 중복을 허용하지 않는다.
 * - 어떤 data 를 묶음(집합)으로 관리하고자 할 때 사용한다.
 */
public class MainClass09 {
	public static void main(String[] args) {
		//정수를 저장할 수 있는 HashSet 객체를 생성해서 참조값을 Set 인터페이스 type 지역변수에 담기
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(3);
		set1.add(5);
		set1.add(6);
		set1.add(7);
		set1.add(8);
		set1.add(9);
		
		//String
		Set<String> set2=new HashSet<String>();
		set2.add("kim");
		set2.add("kim");
		set2.add("lee");
		set2.add("park");
		set2.add("choi");
		set2.add("ko");
		set2.add("oh");
		
		//set 객체에 저장된 모든 아이템을 순서를 보장하진 않지만 모두 참조해서 사용해보기
		set1.forEach((item)->{
			//set1은 Set<Integer> 이기 때문에 item은 Integer type이 된다.
			Integer tmp=item;
			System.out.println(item);
		});
		System.out.println("----------");
		
		set2.forEach((item)->{
			//set2는 Set<String> 이기 때문에 item은 String type이 된다.
			//String tmp=item;
			//System.out.println(tmp);
			System.out.println(item);
		});
		
		set2.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
		
			}
		});
		
		System.out.println("-----");
		
		//Iterator 를 사용하는 구조도 연습하기
		Iterator<String> it = set2.iterator();
		//무한루프를 구성하거나 정확한 반복횟수를 알 수 없을 떄 while(){} 문을 많이 사용한다.
		while(it.hasNext()) { //다음 item 이 있는지 확인해서
			//다음 item을 얻어낸다. (item 의 type은 Iterator의 Generic type이다)
			String item=it.next();
			//얻어낸 item을 사용하고 또 다음 item이 있는지 위에서 확인이 된다.
			System.out.println(item);
		}
		
	}
}
