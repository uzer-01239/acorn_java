package test.mypac;

public class Messenger {
	public void sendPost(Post post) {
		System.out.println(post.getAuthor()+" 님이 작성한 글을 전송했습니다.");
	}
}
