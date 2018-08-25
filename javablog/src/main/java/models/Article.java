package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

	private int id;
	private String title;
	private String imageLink;
	private String textContent;
	private Author author;
	private List<Section> sections;

	public Article(String title, String textContent, Author author) {
		this.title = title;
		this.textContent = textContent;
		this.author = author;
		this.sections = new ArrayList<>();
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
	@JoinColumn( name = "author_id", nullable = false)
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToMany
	@JoinTable(
			name = "articles_sections",
			joinColumns =  { @JoinColumn(name = "article_id", updatable = false)},
			inverseJoinColumns = { @JoinColumn(name = "section_id", updatable = false) }
	)
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void addSectionToArticle(Section section){
		this.sections.add(section);
	}
}
