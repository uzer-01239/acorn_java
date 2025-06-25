package test.main;

import test.maypac.MyWeapon;
import test.maypac.SkyWeapon;
import test.maypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		//추상 클래스도 data type 의 역할을 할 수 있다.
		Weapon w1 = null;
		
		//그렇다면 Weapon type 의 참조값은 어떻게 얻어내?
		//Weapon w2 = new Weapon(); //추상클래스 단독 객체 생성은 불가 
		
		//Weapon 추상클래스를 상속받은 MyWeapon 클래스로 객체를 생성해서 Weapon 참조값 얻어내기
		Weapon w2 = new MyWeapon(); 
		w2.prepare();
		w2.attack();
		
		Weapon w3 = new SkyWeapon(); 
		w3.attack();
		
	}

}
