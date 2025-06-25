package test.main;

import test.maypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 우주를 공격하고 싶다
		 * Weapon 추상 클래스를 상속받은 클래스 파일로 만들어야 하는 귀찮음..
		 * Local Inner Class 로 만들면 좀 편할듯
		 * 
		 */
		
		class SpaceWeapon extends Weapon{
			@Override
			public void attack() {
				System.out.println("우주를 공격!");				
			}
		}
		//위에서 생성한 클래스로 객체 생성
		Weapon w1=new SpaceWeapon();
		//메소드 호출
		w1.attack();
		
		new SpaceWeapon().attack();
	}
}
