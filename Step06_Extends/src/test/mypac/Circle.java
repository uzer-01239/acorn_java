package test.mypac;

// Shape(도형) 클래스를 상속받아서 Circle 클래스 정의하기
// Shape 와 같은 패키지이므로 import X

public class Circle extends Shape{
	// 원의 반지름을 저장할 필드
	private int radius;
	
	public Circle(int x, int y, int radius) {
		super(x, y); // super()는 부모 클래스(Shape)의 생성자를 의미한다. 
		// new Circle(10,20) => 결국 Shape로 들어간다.
		this.radius = radius;
	}
	
	public void printArea() {
		// 원의 넓이
		double area = Math.PI*radius*radius;
		System.out.println("반지름은:"+radius+"이고 원의 넓이는 : " + area);
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("반지름은 :"+radius);
	}
}
	

