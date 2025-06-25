package test.main;

import test.mypac.Post;

public class MainClass04 {
	public static void main(String[] args) {
		
		// sendPost() 메소드를 호출해보세요
		// sendPost(null); // 방법 1
		sendPost(new Post()); // 방법 2
		sendPost(new Post(1, "제목1", "작성자1")); // 방법 3
		Post p1 = new Post(2, "제목2", "작성자2"); // 방법 4
		sendPost(p1);
		
		Post p3 = new Post(); // 방법 5
		p3.setId(3);
		p3.setTitle("제목3");
		p3.setAuthor("작성자3");
	}
	
	
	public static void sendPost(Post post) {
		System.out.println(post.getTitle());
		System.out.println("글을 전송했습니다.");
	}

}
