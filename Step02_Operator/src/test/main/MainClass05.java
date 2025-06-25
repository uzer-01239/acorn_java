package test.main;
/*
 *  4. 논리 연산자 테스트
 *  
 *  &&, ||, !
 *  
 *	and, or, not
 *
 *	`그리고`, `또는`, `~가 아니면` 으로 읽음
 * 
 */
public class MainClass05 {
	public static void main(String[] args) {
		/* or 연산
		 * `또는` 이라고 읽음
		 * 
		 * 어느 하나만 true => true
		 * 모두 다 false => false 
		 */
		
		boolean result1 = false || false; // false
		boolean result2 = true || false; // true
		boolean result3 = false || true; // true
		boolean result4 = true || true; // true
		
		/* and 연산
		 * `그리고` 라고 읽음
		 * 
		 * 모두 true 일 때만 true
		 * 어느 하나만 false 여도 결과 = false
		 * 
		 */
		
		boolean result5 = false && false; // false
		boolean result6 = false && true; // false
		boolean result7 = true && false; // false
		boolean result8 = true && true; // true
		
		/*
		 * not  연산
		 * ~가 아니면 이라고 읽음
		 * 
		 * boolean 값을 반전시킴
		 */
		
		boolean result9 = !true; // false
		boolean result10 = !false; // true
		
	}
}
