package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainClass12 {
	public static void main(String[] args) {
		//1. 로또 번호를 담을 HashSet 객체를 생성해서 참조값을 Set type set1이라는 지역변수에 담기
		Set<Integer> set1 = new HashSet<>();
		
		//2. Random 객체를 생성해서 참조값을 ran 이라는 지역변수에 담기
		Random ran = new Random();
		
		
		/*
		 * 3. while 문을 이용해서 랜덤한 로또 번호를 set1에 반복적으로 담기
		 * 		while문은 무한루프로 만들고 while문 탈출조건은 set1.size()가 6되면 탈출
		 * 		ran.nextInt(45)+1 은 1~45 의 랜덤한 정수 얻어낼 수 있다
		 * 		로또 번호 6개
		 */
		while (true) {
			int rannum = ran.nextInt(45)+1; //상한선45-->0~44
			set1.add(rannum);
			if(set1.size()==6) { // 6번 도는데--똑같은 수가 나올 수도 있지--한번더
				break;
			}
		}
		
		//4. set1에 담긴 번호를 모두 하나씩 콘솔창에 출력
		set1.forEach((item)->{
			System.out.print(item+" ");
		});
		
		System.out.println("");
		
		//5. AI에 물어봐서 set1에 담긴 내용을 List에 담은 다음 오름차순으로 정렬하기
		List<Integer> nums = new ArrayList<Integer>(set1);
		Collections.sort(nums);
		
		System.out.println(nums);
		//6. 오름차순 정렬된 번호를 하나씩 순서대로 콘솔창 출력
		nums.forEach(item->System.out.println(item));
		
		
	}
}

