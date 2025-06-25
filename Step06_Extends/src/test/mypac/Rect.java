package test.mypac;

public class Rect extends Shape{
	private int len;
	
	public Rect(int x, int y, int len) {
		super(x, y);
		this.len=len;
	}
	
	public void printArea() {
		double area=len * len;
		System.out.println("정사각형의 넓이는 "+area+"입니다.");
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("한 변의 길이 : "+len);
	}
}
