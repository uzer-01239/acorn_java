package test.main;

import test.mypac.Messenger;
import test.mypac.Post;

public class MainClass05 {
	
	public static void main(String[] args) {
		Messenger m1 = new Messenger();
		Post p1 = new Post(1, "제목 1", "작성자1");
		m1.sendPost(p1);
		
	}
}
