package test.main;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 *  1~100 사이의 숫자 중에서 짝수의 총합을 구해서 출력하자.
		 */
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1~100 사이 숫자 중에서 짝수의 총합:" + sum);
		sum = 0;
		// i 를 2,4,6...100 으로 변하게 for 문 구성
		for (int i=2; i<=100; i+=2) {
			sum += i;
			
		}
	}

}
