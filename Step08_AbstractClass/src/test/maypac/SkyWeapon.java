package test.maypac;

public class SkyWeapon extends Weapon{
	
	// Weapon(추상객체)이 제공하는 기능을 활용하면서 attack() 내 상황에 맞게 사용
	
	@Override
	public void attack() {
		//부모객체가 제공하는 기능도 사용 가능
		this.prepare();
		System.out.println("공중 공격을 해요!");
		
	}
}
