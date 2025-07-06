package test.dto;

import java.net.URL;

public class ToBuyDto {
	private int num;
	private String item;
	private String product;
	private int price;
	private URL link;
	
	
	//생성자
	public ToBuyDto(){}

	
	//getters & setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public URL getLink() {
		return link;
	}

	public void setLink(URL link) {
		this.link = link;
	}

	
}
