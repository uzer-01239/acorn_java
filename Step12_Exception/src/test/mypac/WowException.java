package test.mypac;
/*
 * 필요한 경우 예외 클래스를 직접 정의해서 원하는 시점에 해당 예외를 발생시켜야 하는 경우도 있다.
 * 이 클래스로 생성한 예외를 발생시키고 싶으면
 * throw new  WowException(예외메시지); 하면 된다.
 */
public class WowException extends RuntimeException{ //1.RuntimeException을 상속받는다.
	
	//생성자에 전달되는 예외 메시지를 부모 생성자에 전달한다.
	public WowException(String msg) {
		super(msg);
	}
	
}
