package test.mypac;

public interface Remocon {
	/*
	 * 필드도 가질 수 있지만 static final 만 가능하다.
	 * static : static 영역에 Remocon 인터페이스와 같이 만들어진다.
	 * final : 값이 결정된 이후에 변경 불가 (상수화)
	 * 생략 가능
	 */
	public String COMPANY="LG"; // static final 상수 --관례상 필드명 모두 대문자

	// 인터페이스는 추상 메소드만 정의할 수 있다. 
	// abstract 예약어 안 붙어도--abstract
	public abstract void up();
	public void down();
	
	
}
