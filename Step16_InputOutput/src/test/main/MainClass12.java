package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass12 {
	public static void main(String[] args) {
		try {
			//파일로부터 byte 알갱이를 읽어들일 객체 생성
			var fis=new FileInputStream("c:/playground/South Korea.png");
			//byte 알갱이를 파일에 출력할 객체 생성
			var fos=new FileOutputStream("c:/playground/copied.png");
			//반복문 돌면서
			while(true) {
				//1 byte 씩 읽어들여서
				int readedByte=fis.read();
				//만일 더이상 읽을 게 없다면 반복문 탈출
				if(readedByte==-1)break;
				//읽은 byte를 출력
				fos.write(readedByte);
				fos.flush();
			}
			System.out.println("파일을 copy 했습니다.");
			//마무리 작업
			fos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
