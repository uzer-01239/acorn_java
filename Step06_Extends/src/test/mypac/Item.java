package test.mypac;

public class Item {
	private String name;
	private int price;
	private String madeBy;
	
	
	// 상품의 이름을 필드에 저장하는 setter 메소드
	public void setName(String name) {
		this.name=name; // 매개변수로 들어온 name 이 필드 안의 this.name으로 들어옴
	}
	
	public String getName() {
		return name;
	}

}
