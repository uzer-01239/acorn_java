package test.main;

import test.maypac.Zoo;
import test.maypac.Zoo.Monkey;
import test.maypac.Zoo.Tiger;

public class MainClass03 {
	public static void main(String[] args) {
		Zoo z1=new Zoo();
		
		Monkey m1 = z1.getMonkey();
		m1.say();
		
		// z1에 들어있는 참조값을 이용해서 Tiger 객체의 참조값을 얻어내고 roar()호출
		Tiger t1 = z1.getTiger();
		t1.roar();
	}
}
