package test.main;

import java.io.File;
import java.io.FileReader;

public class MainClass09 {
	public static void main(String[] args) {
		File f=new File("memo.txt");
		try {
			//파일로부터 문자열을 읽어들일 수 있는 객체 생성
			var fr=new FileReader(f);
			//무한 루프 돌면서
			while(true) {
				//한 글자씩 읽어들인다.(문자의 code 값)
				int code=fr.read();
				//만일 더 이상 읽을 문자 없다면 read() 메소드는 -1을 리턴함.
				if(code==-1)break; //반복문 탈출
				//code를 문자열로 변환
				char ch=(char)code;
				//출력
				System.out.println(ch);
			}
			fr.read();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
