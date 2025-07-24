package test.main;

import java.io.IOException;
import java.io.InputStream;

/*
 * 입력, 출력 (Input, Output)
 * 
 * - 입력 : 어떤 대상으로부터 데이터를 메모리로 읽어들이는 것 
 * - 프로그래밍 언어의 관점에서 메모리라는 것은 변수 or 필드 or 객체로 생각하면 된다.
 * - 데이터는 2진수로 이루어져있지만 2진수 8개의 묶음인 1byte 단위로 생각하면 된다.
 * - 1byte 는 총 256 가지 값을 표현 가능
 * - 1byte 를 10진수로 환산하면 0~255 숫자 중 하나
 * - 입력과 출력을 통해서 이동하는 데이터는 byte 하나하나가 이동한다고 생각하면 된다
 */

public class MainClass01 {
	public static void main(String[] args) {
		
		//키보드와 연결된 InputStream type 의 참조값을 kbd라는 지역변수에 담기
		//InputStream 객체는 1byte 단위 처리 스트림
		//영문자 대소문자, 숫자, 특수문자만 처리 가능
		//한글 처리 불가
		InputStream kbd=System.in;
		try {
			//입력한 문자의 code 값 읽어오기
			int code=kbd.read();
			System.out.println("code:"+code);
			//code 값에 대응하는 문자 얻어내기
			char ch=(char)code;
			System.out.println("ch:"+ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
