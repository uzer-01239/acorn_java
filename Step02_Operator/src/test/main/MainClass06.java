package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		// boolean type 변수나 상수는 대화식으로 설정 -> 가독성 좋다
		// can.. is... 형식
		boolean isPretty = true;
		boolean canEat = false;
		
		// 만일 이쁘다면.. 으로 읽음
		if(isPretty) {
			// 여기는 이쁘면 실행된다.
			
			
		}
		
		// 만일 이쁘지 않다면.. 으로 읽음
		if(!isPretty) {
			// 여기는 이쁘지 않을 때 실행된다.
		}
		// 만일 먹을 수 있다면... 
		if(canEat) {
			// 여기는 먹을 수 있으면 실행된다.
		}
		// 만일 먹을 수 없다면..
		if(!canEat) {
			// 여기는 먹을 수 없으면 실행된다.
		}else {// 그렇지 않다면(먹을 수 없다가 아니면)
			// 여기는 먹을 수 있으면 실행된다.
		}
		// 만일 이쁘거나 또는 먹을 수 있다면
		if(isPretty || canEat) {
			// 여기는 이뻐도 실행되고, 먹을 수 있어도 실행된다.
		}
		// 만일 이쁘고 그리고 먹을 수 있다면
		if(isPretty && canEat) {
			//이쁘기도 하고 먹을 수도 있다면 실행된다.
		}
		// 만일 이쁘고 그리고 먹을 수 없다면
		if(isPretty && !canEat) {
			// 이쁘기도 하고 먹을 수 없다면 실행된다.
		}
	}

}
