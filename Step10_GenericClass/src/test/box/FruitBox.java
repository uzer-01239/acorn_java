package test.box;

// Generic 클래스 T를 전달받을 수 있는 클래스 설계하기
public class FruitBox<T> {
	// T 를 필드의 type으로 활용
	private T item;
	
	// T 를 매개변수 type으로 활용
	public void pack(T item) {
		this.item=item;
		System.out.println(this.item+" packed");
	}
	
	
	// T 를 메소드 리턴 type 으로 활용
	public T unpack(T item) {
		return item;
	}
}

//FruitBox<Apple> box1= new FruitBox
