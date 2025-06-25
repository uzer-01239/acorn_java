package test.main;

import test.mypac.Circle;
import test.mypac.Rect;
import test.mypac.Shape;

public class MainClass07 {
	public static void main(String[] args) {
		//shape 객체 생성
		//Shape s1=new Shape(); //default 생성자가 없어서 객체 생성불가_error
		
		Shape s1=new Shape(100, 200);
		s1.printInfo();
		
		System.out.println("");
		
		Circle c1=new Circle(200, 300, 10);
		c1.printArea();
		c1.printInfo();
		
		System.out.println("");
		
		Rect r1=new Rect(100, 200, 50);
		r1.printArea();
		r1.printInfo();
	}
}

