package test.mypac;

//함수 형태로 쓰기 위한 어노테이션 (메소드 1개가 강제된다)
@FunctionalInterface
public interface Warmer {
	public void warm(String target); //무언가를 따듯하게 하는 가상의 메소드
	
}
