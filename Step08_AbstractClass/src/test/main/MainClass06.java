package test.main;

import test.maypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * Cyber 공간을 공격하고싶다
		 * 클래스 파일을 따로 만들기 싫다 => Local Inner Class 로 만들기
		 * 근데 생각해보면,, MyWeapon, SkyWeapon, NavlaWeapon, SpaceWeapon 등의 type은 필요 없어
		 * 따라서 클래스 이름 짓기도 귀찮음. => 익명의 Local Inner Class 만들기
		 */
		
		Weapon w1 = new Weapon() {
			@Override
			public void attack() {
			prepare();
			System.out.println("사이버 공격!!! 해킹!!!");
			}
		};
		w1.attack(); //사이버 공격
		
		/*
		 * 가상(Virtual) 공간을 공격할거야
		 * 익명의 Local Inner Class를 이용해서 Weapon type 객체를 생성해서 공격할 예정인데
		 * 1번만 공격할거야 => 위의 w1 처럼 변수를 만들지 않고 1회용으로 객체 만들어서 사용예정
		 */
		
		new Weapon() {
			@Override
			public void attack() {
				System.out.println("virtual!! 가상공격");
			}
		}.attack();
	}
}
