package test.mypac;

public class MemberInfo {
	// 회원의 번호를 저장할 필드
	public int num;
	// 회원의 이름 필드
	public String name;
	// 회원의 주소 
	public String addr;
	
	// 필드에 저장된 정보를 콘솔창에 출력
	public void printData() {
		System.out.println(this.num+"번 회원정보");
		String data = "번호 : "+this.num+"/ 이름 : "+this.name+"/ 주소 : "+this.addr;
		System.out.println(data);
	

	}
}
