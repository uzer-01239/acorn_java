package test.fruit;

public class Apple {
	private String variety;
	
	public Apple() {
		this.variety=null;
	}
	
	public Apple(String variety) {
		this.variety=variety;
	}
	
	@Override
	public String toString() {
		return (variety != null) ? "Apple{"+variety+"}" : "Apple";
	}

}

