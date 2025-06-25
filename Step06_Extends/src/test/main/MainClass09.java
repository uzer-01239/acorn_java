package test.main;

import test.company.Department;
import test.company.Employee;
import test.company.Manager;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 사원이름: KING
		 * 급여 : 5000
		 * 부서 : 기획부
		 * 부서 위치 : 서울
		 */
		
		Manager m1=new Manager("KING", 5000, new Department("기획부", "서울"));
		m1.setPosition("이사");
		
		m1.printInfo();
		
				
		Employee m2=new Manager("KING", 5000, new Department("기획부", "서울"));
		// m2.setPosition("이사"); --> 불가! Employee 객체니까 -- Manager 메소드 못 씀
		m2.printInfo();
		
		Manager m3=(Manager)m2;
		m3.setPosition("이사");
		m3.printInfo();
		
	}
}
