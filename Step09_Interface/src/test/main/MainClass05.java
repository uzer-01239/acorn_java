package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		
		// 여긴 나중에 구현될 예정
		/*
		 * 여기는 팀원이 코딩한다고 가정
		 * 팀원이 직접 Drill type 객체를 생성해서
		 * 어디에 구멍을 뚫을지 맘대로 결정한다.
		 */
		
		Drill d1 = new Drill() {
			
			@Override
			public void hole() {
				System.out.println("구멍을 뚫어버려");
				
			}
		};
		useDrill(d1);
		
		
		Drill d2 = () -> {
			System.out.println("구멍을 또 뚫어");
		};		
		useDrill(d2);
		
		useDrill(()->{
			System.out.println("구멍을 또다시 뚫어");
		});
		
	}
	
	// 이건 미리 만들어진 상태
	/*
	 * useDrill() 기능을 만드는 프로그래머(팀장, 라이브러리나 프레임워크 개발자) 입장에서 생각해보자
	 * `Drill 인터페이스`는 본인이 미리 만들어 놓은 상태
	 * 메소드 안에서 Drill 객체를 이용해서 어떤 복잡한 동작을 미리 만들어 놓을 수 있따.
	 */
	public static void useDrill(Drill d) {
		d.hole();
	}

}
