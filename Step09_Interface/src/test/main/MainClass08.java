package test.main;

import test.mypac.Person;
import test.mypac.Singer;

public class MainClass08 {
	public static void main(String[] args) {
		//person 객체를 생성해서 Person type으로 받으면
		Person p1=new Person();
		p1.work();
		p1.sing();
		p1.develop();
		
		Singer p2 = new Person();
		p2.sing(); //밖에 못함. 일도 못함.
		
	}
}
