package com.ssafy.hwjava10;

public class News {
	private String title;
	private String desc;
	private String link;
	
	public News(String title, String desc, String link) {
		this.title=title;
		this.desc=desc;
		this.link=link;
	}

	public News() {	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(100)
				.append("제목: ").append(title+"제목").append("     ")
				.append("내용: ").append(desc+"내용").append("     ")
				.append("링크: ").append(link+"링크").append("     ").toString();
	}
}
