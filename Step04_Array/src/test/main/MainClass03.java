package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		// String type 을 담을 수 있는 방 3개짜리 빈 배열
		String[] names= {null, null, null};
		names[0]="kim";
		names[1]="lee";
		names[2]="park";
		// names[3]="xxx"; //예외 발생
		
		// String type 을 담을 수 있는 null 로 초기화된 방 100개짜리 배열객체 생성
		String[] names2=new String[100];
		for(int i=0; i<names2.length; i++) {
			names2[i]= "kim"+i;
		}
		
		
	}
}
