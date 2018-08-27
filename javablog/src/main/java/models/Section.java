package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

	private int id;
	private String title;
	private List<ArticleSection> articlesSections;

	public Section(String title) {
		this.title = title;
		this.articlesSections = new ArrayList<>();
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

	@OneToMany( mappedBy = "section")
	public List<ArticleSection> getArticlesSections() {
		return articlesSections;
	}

	public void setArticlesSections(List<ArticleSection> articles) {
		this.articlesSections = articles;
	}

//	public void addArticleToSection(Article article){
//		this.articlesSections.add(article);
//	}
}
