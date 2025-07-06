package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		Object r1 = new MyRemocon();
		Remocon r2 = new MyRemocon();
		MyRemocon r3 = new MyRemocon();
		
		// useRemocon(r1); 
		//r1은 Object type--Remocon type 이어야 함--casting 필요
		useRemocon((Remocon)r1);
		useRemocon(r2);
		useRemocon(r3);

	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
		
	}
}
