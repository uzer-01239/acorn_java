package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main method 가 시작되었습니다.");
		//1 byte 처리 스트림
		InputStream kbd=System.in;
		//2 byte 처리 스트림--한글 가능
		var isr=new InputStreamReader(kbd);
		//BufferReader의 생성자로 InputStreamReader 객체를 전달해서 객체생성
		var br=new BufferedReader(isr);
		System.out.println("입력:");
		try {
			//문자열 한줄 읽어들이기
			String line=br.readLine();
			System.out.println("line:"+line);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
