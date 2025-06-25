package test.maypac;

// 추상클래스를 상속받으면 자식클래스는 부모의 추상 메소드를 반드시 Override해야 한다.
public class MyWeapon extends Weapon{
	@Override
	public void attack() {
	
	 System.out.println("1층 attack!");
	}
}
