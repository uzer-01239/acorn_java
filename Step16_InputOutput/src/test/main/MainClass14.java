package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass14 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			//파일로부터 byte 알갱이를 읽어들일 객체 생성
			fis=new FileInputStream("c:/playground/South Korea.png");
			//byte 알갱이를 파일에 출력할 객체 생성
			fos=new FileOutputStream("c:/playground/copied3.png");
			//byte 알갱이 1024개를 한번에 읽어들일 수 있는 배열 객체 생성 (1 kilo byte)
			byte[] buffer=new byte[1024];
			//반복문 돌면서
			while(true) {
				//byte[] 객체를 전달해서 배열에 읽어들이도록 하고 몇 byte를 읽어들였는지를 리턴받는다
				int readedCount=fis.read(buffer);
				//만일 더이상 읽을 byte 가 없다면 반복문 탈출
				if(readedCount == -1)break;
				//배열 안에 읽어들인 데이터를 읽은 갯수만큼 출력하기
				fos.write(buffer, 0, readedCount);
				fos.flush();
			}
			System.out.println("파일을 copy 했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null)fos.close();
				if(fis!=null)fis.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
