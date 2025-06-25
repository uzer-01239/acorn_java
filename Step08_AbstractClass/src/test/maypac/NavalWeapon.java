package test.maypac;

public class NavalWeapon extends Weapon{
	@Override
	public void attack() {
		prepare();
		System.out.println("해상 공격까지!!");	
	}

}
