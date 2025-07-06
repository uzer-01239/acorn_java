package test.main;

import test.maypac.Weapon;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 여기서(main method) 아래에 정의된 useWeapon() 메소드를 호출하려면?
		 */
		useWeapon(new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("뿌셔!!");
			}
		});
		
		useNum(3);
		useString("점심");
		
	}
	
	public static void useWeapon(Weapon w) {
		w.attack();
	}
	
	public static void useNum(int num) {
		System.out.println(num+"번 공격!");
	}
	
	public static void useString(String name) {
		System.out.println(name+"을 공격!");
	}

}
