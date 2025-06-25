package test.main;

import test.company.Department;
import test.company.Employee;

public class MainClass10 {
	public static void main(String[] args) {
		
		Department d1=new Department("영업부", "대전");
		/*
		 * 위의 부서에서 근무하는 사원(Employee) 객체 3개를 만들어서
		 * 그 참조값 3개를 배열에 순서대로 배열에 담아보세요
		 */
		
		Employee emp1=new Employee("사원1", 1000, d1);
		Employee emp2=new Employee("사원2", 2000, d1);
		Employee emp3=new Employee("사원3", 3000, d1);
		
		Employee[] employees = {emp1, emp2, emp3};
		
		Employee[] emps = new Employee[3];
		emps[0]=emp1;
		emps[1]=emp2;
		emps[2]=emp3;
		
		//for문 이용하여 .printInfo() 메소드 반복
		
		//1번 : i번째 방에 있는 Employee 객체의 참조값 얻어내기
		for(int i=0; i<emps.length; i++) {
			Employee tmp=emps[i];
			tmp.printInfo();
			// emps[i].printInfo(); 로도 가능
		}
		
		System.out.println("--------");
		
		//2번 : 1번의 다른 표현 Good!!
		for(Employee tmp : emps) {
			tmp.printInfo();
		}
	}
}
