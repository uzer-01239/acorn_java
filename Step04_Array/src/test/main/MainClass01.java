package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * 	in javascript
		 * 
		 * 	let nums=[10, 20, 30, 40, 50];
		 * 	
		 * 	nums[0]
		 * 	nums[1]
		 * 
		 * 	in java
		 * 	배열이 한번 만들어지면 size를 줄이거나 늘릴 수 없다.
		 * 
		 * 	int[] nums={10, 20, 30, 40, 50};
		 * 
		 * 	nums[0]
		 * 	nums[1]---참조 방법은 동일 
		 * 
		 */
		
		// "김구라" "해골" "원숭이" "주댕" "덩얼" 5개의 문자 배열
		// 참조값은 names 라는 변수에 담기
		String[] names={"김구라", "해골", "원숭이", "주댕", "덩얼"};
		
		System.out.println(names[0]); //김구라
				
		// nums 배열에 저장된 숫자를 반복문 돌면서 콘솔창에 순서대로 출력
		// for
		for (int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
