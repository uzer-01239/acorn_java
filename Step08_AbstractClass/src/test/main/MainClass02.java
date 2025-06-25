package test.main;

import test.maypac.NavalWeapon;
import test.maypac.MyWeapon;
import test.maypac.SkyWeapon;
import test.maypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		Weapon w1=new SkyWeapon();
		w1.attack();
		
		Weapon w2=new MyWeapon();
		w2.attack();
		
		// 해상 공격을 하는 Weapon type 객체를 만들어서
		// .attack() 호출했을 때 해상공격이 되도록
		
		Weapon w3=new NavalWeapon();
		w3.attack();
		
		
	}
}
