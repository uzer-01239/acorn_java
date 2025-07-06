package test.main;

import test.mypac.Warmer;

public class MainClass06 {
	public static void main(String[] args) {
		Warmer w1 = new Warmer() {
			
			@Override
			public void warm(String target) {
				System.out.println(target+"을(를) 따듯하게 해요");
			}
		};
		
		useWarmer(w1);
		
		Warmer w2 = (target)->{
			System.out.println(target+"을(를) 땃뜻하게 해요");
		};
		useWarmer(w2);
		
		useWarmer((target)->{
			System.out.println(target+"을(를) 뜨겁게 해요");
		});
		
	}
	
	public static void useWarmer(Warmer w) {
		w.warm("손");
	}
}
