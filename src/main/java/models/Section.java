package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

	private int id;
	private String title;
	private List<Article> articles;

	public Section(String title) {
		this.title = title;
		this.articles = new ArrayList<>();
	}

	public Section() {
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

	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToMany
	@JoinTable(
		name="articles_sections",
		joinColumns = { @JoinColumn(name = "section_id", updatable = false)},
		inverseJoinColumns = {@JoinColumn(name = "article_id", updatable = false)}
	)
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void addArticleToSection(Article article){
		this.articles.add(article);
	}
}
