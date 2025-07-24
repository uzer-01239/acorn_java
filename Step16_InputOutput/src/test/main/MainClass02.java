package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		//1 byte 처리 스트림
		InputStream kbd=System.in;
		//2 byte 처리 스트림 (65536 가지 표현가능) - 한글 처리가능
		var isr=new InputStreamReader(kbd);
		System.out.println("입력:");
		
		try {
			//InputStreamReader 객체로 입력한 문자의 code값 읽어내기
			int code=isr.read();
			System.out.println("code:"+code);
			char ch=(char)code;
			System.out.println("char:"+ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
