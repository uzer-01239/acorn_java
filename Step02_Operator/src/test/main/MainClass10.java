package test.main;
/*
 *  6. 3항 연산자
 *  
 *  조건 ? 값1 : 값2
 */

public class MainClass10 {
	public static void main(String[] args) {
		boolean isWait=false;
		// isWait 이 true면 "기다려" 가 대입되고 false 면 "기다리지 마" 가 대입됨
		String result = isWait ? "기다려" : "기다리지 마";
		System.out.println(result);
		
		// 위의 3항 연산자는 아래와 같이 if~ else 문과 같은 로직이다.
		String result2=null;
		if(isWait) {
			result2 = "기다려";
			
		}else {
			result2 = "기다리지 마";
		}
		System.out.println(result2);
	}

}
