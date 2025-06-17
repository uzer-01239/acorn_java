package test.main;

/*
 * 2. 증감 연산자 테스트
 */
public class MainClass02 {
	public static void main(String[] args) {
		int num=0;
		num++;
		num++;
		num++; // num 이 최종 3이 된당.
		
		int num2=0;
		num2--;
		num2--;
		num2--; //num2가 최종 -3 이 된당.
		
		int num3=0;
		int result1 = num3++; // result1 에 0이 대입되고 num3가 1 증가한다.
		
		int num4=0;
		int result2 = ++num4; // num4 가 1 증가하고 result2 에 1 이 대입된당.
		num4++; // num4 가 최종 2가 된다.
		
		
		
	}

}
