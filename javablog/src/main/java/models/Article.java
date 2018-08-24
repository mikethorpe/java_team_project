package models;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

	private int id;
	private String title;
	private String imageLink;
	private String textContent;
	private Author author;

	public Article(String title, String textContent, Author author) {
		this.title = title;
		this.textContent = textContent;
		this.author = author;
	}

	public Article() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "image_link")
	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	@Column(name = "text_content")
	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	@ManyToOne
	@JoinColumn( name = "author_id")
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
