package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 *  for 문을 이용해서
		 *  
		 *  1 + 2 + 3 + 4 ... + 99 + 100 의 총 합을
		 *  console 창에 출력하자.
		 *  
		 */
		
		int sum = 0;
		for(int i=0; i<100; i++) {
			// sum = sum +i +1 ;
			// i 는 0, 1, 2, ...99 로 변함
			// sum 에 대입되는 값은 원래 값에서 1,2,3...100 을 더한 값이 대입된다.
			sum += i+1;
			
		}
		
		System.out.println("1~100까지 총합:"+sum);
		
		sum = 0; // sum은 다시 0으로 초기화
		for(int i=1; i<=100; i++) {
			sum += i; // i 값을 sum 이라는 변수에 누적시키기
		}
	}
}
