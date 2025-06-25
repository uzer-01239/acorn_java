package test.main;

import test.company.Department;
import test.company.Employee;

public class MainClass08 {
	public static void main(String[] args) {
				
		Department dept1=new Department("교육부","역삼동");
		Employee emp1=new Employee("김구라", 1000, dept1);
		
		emp1.printInfo();
		
		/*
		 * 위에서 생성한 부서와 동일한 부서에서 근무하는 사원(Employee)객체를 하나 더 생성하기
		 * 이름 : 원숭이
		 * 급여 : 2000
		 */
		
		System.out.println("");
		Employee emp2=new Employee("원숭이", 2000, dept1);
		
		emp2.printInfo();
		
		/*
		 * 이름 : 주뎅
		 * 급여 : 3000
		 * 부서 : SALES
		 * 부서 위치 : LA
		 * 1줄 코딩
		 */
		System.out.println("");
		Employee emp3=new Employee("주뎅", 3000, new Department("SALES","LA"));
		emp3.printInfo();
	}
}
