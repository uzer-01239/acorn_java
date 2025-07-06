package test.mypac;

//Generic Class는 2개 이상일 수 있다.
public class Pair<K, V> {
	//필드
	private K key;
	private V value;
	
	//생성자
	public Pair(K key, V value) {
		this.key=key;
		this.value=value;		
	}

	//메소드
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
