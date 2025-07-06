package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// String type을 매개변수에 전달하면서 메소드 호출
		
		// 메소드 호출하면서 String type 데이터를 직접 만들어서 전달
		sendMessage("hello");
		sendMessage("bye");
		
		// 이미 만들어진 변수에 있는 내용ㅇ르 변수명으로 전달
		String str="kimgura";
		MainClass02.sendMessage(str);
	}
	
	// 메시지를 전송하는 기능을 가진 가상의 메소드
	public static void sendMessage(String msg) {
		System.out.println(msg+"를 전송했습니다.");
	}
}
