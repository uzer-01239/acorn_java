package test.mypac;

public class Post {
	// 글번호를 저장할 필드
	public int id;
	// 글 내용을 저장할 필드
	public String content;
	// 글 작정자를 저장할 필드
	public String author;
	
	// 객체의 필드에 있는 정보를 이쁘게 출력하기
	public void printData() {
		String data = String.format("번호:%d 내용:%s 작성자:%s ", this.id, this.content, this.author);
		System.out.println(data);
	}
}
