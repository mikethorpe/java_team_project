package models;

import javax.persistence.*;

@Entity
@Table(name = "articles_sections")
public class ArticleSection {

	private int id;
	private Article article;
	private Section section;
	private boolean featuredInSection;


	public ArticleSection(Article article, Section section) {
		this.article = article;
		this.section = section;
		this.featuredInSection = false;
	}

	public ArticleSection() {
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

	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@ManyToOne
	@JoinColumn(name = "section_id", nullable = false)
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Column(name = "featured")
	public boolean isFeaturedInSection() {
		return featuredInSection;
	}

	public void setFeaturedInSection(boolean featuredInSection) {
		this.featuredInSection = featuredInSection;
	}
}
