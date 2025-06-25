package test.mypac;

public class MemberDto {
	// 필드 정의하기 ( 접근 지정자가 private 로 되어있으면 외부에서 접근불가)
	// 동일 객체 내부에서만 접근 가능
	private int num;
	private String name;
	private String addr;
	
	// 클래스명과 동일하고 return type이 명시되어 있지 않은 이것은 생성자(Constructor)이다.
	// 객체를 new 하는 시점에 한번 호출된다.
	// 객체를 new 하는 시점에 무언가 초기화 작업을 할 게 있으면 여기서 한다.
	public MemberDto() {
		System.out.println("MemberDto 클래스의 생성자가 호출됨!");
	}
	
	// 생성자는 필요에 따라서 다른 모양으로 여러 개 정의할 수 있다.
	public MemberDto(int num){
		System.out.println("MemberDto 클래스의 생성자가 번호로 호출됨!");
	}
	
	public MemberDto(int num, String name, String addr) {
		System.out.println("MemberDto 클래스의 생성자가 정보로 호출됨!");
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	

	}

