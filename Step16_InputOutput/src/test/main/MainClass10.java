package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainClass10 {
	public static void main(String[] args) {
		File f=new File("memo.txt");
		try {
			//파일로부터 문자열을 읽어들일 수 있는 객체 생성
			var fr=new FileReader(f);
			//좀더 좋은 기능을 가지고 있는 BufferedReader 객체 생성
			var br=new BufferedReader(fr);
			while(true) {
				//한줄씩 읽기(1줄의 기준은 개행기호)
				String line=br.readLine();
				//더이상 읽을 line 없으면 반복 탈출
				if(line==null)break;
				//출력
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
