package test.mypac;

public class Person implements Singer, Programmer {
	//어떤 type으로 받냐에 따라 사용할 수 있음--Person type 은 다 사용가능
	
	public void work() {
		System.out.println("일을 하고 있습니다.");
	}

	@Override
	public void sing() {
		System.out.println("노래하는 사람입니다.");
		
	}

	@Override
	public void develop() {
		System.out.println("개발자입니다.");
		
	}

}
