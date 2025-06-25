package test.main;

import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		//String type 이 저장되어있는 배열
		String[] data = {"🍒", "🍎", "🍌", "🍈", "7"};
		
		//위 배열에 저장된 5개의 문자열 중에서 랜덤하게 1개만 콘솔창 출력되도록 하기
		
		Random ran = new Random();
		int ranNum1 = ran.nextInt(data.length);
		int ranNum2 = ran.nextInt(data.length);
		int ranNum3 = ran.nextInt(data.length);
		
		int[] ranNums = {ranNum1, ranNum2, ranNum3};
		
		for(int i=0; i<ranNums.length; i++) {
			System.out.println(data[ranNums[i]]);
		}

		if (ranNum1==ranNum2 && ranNum2==ranNum3) {
			System.out.println("Congratuation!!");
		}else {
			System.out.println("woooo~");
		}

		
		
	}

}
