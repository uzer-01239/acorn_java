package test.main;

import test.mypac.Post;

public class MainClass08 {
	public static void main(String[] args) {
		// 1. Post 객체를 생성해서 p1 참조값ㅇ르 p1 이라는 변수에 담아보세요.
		Post p1 = new Post();
		// 2. 글 번호 1000을 위에서 생성한 객체에 담아보세요.
		p1.id = 1000;
		// 3. 글 내용 "안녕하세요!" 를 위에서 생성한 객체에 담아보세요.
		p1.content = "안녕하세요!";
		// 4. 작성자 "원숭이"를 위에서 생성한 객체에 담아보세요.
		p1.author = "원숭이";
		// 5. debug 모드로 확인해보세요.
	}

}
