package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
	private Date lastUpdated;
	private int numberOfViews;

	public Article(String title, String textContent, Author author) {
		this.title = title;
		this.textContent = textContent;
		this.author = author;
		this.sections = new ArrayList<>();
		this.numberOfViews = 0;
		this.imageLink = "";
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

	@Type(type = "text")
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
	@ManyToMany( fetch = FetchType.EAGER)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "last_updated")
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void updateArticleDate(){
		Date currentDateTime = new Date();
		this.lastUpdated = currentDateTime;
	}

	@Transient
	public List<Integer> getSectionIds(){
		List<Integer> sectionIds = new ArrayList<>();

		for(Section section : sections){
			sectionIds.add(section.getId());
		}

		return sectionIds;
	}

	public void clearArticleSections(){
		this.sections.clear();
	}

	@Column(name = "number_of_views")
	public int getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(int numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public void addView(){
		this.numberOfViews++;
	}

	@Transient
	public String getReducedTextContent(int numberOfCharacters){
		int textContentLength = this.textContent.length();
		if (textContentLength < numberOfCharacters)
		{
			numberOfCharacters = textContentLength;
		}
		String reducedContent = this.textContent.substring(0, numberOfCharacters) + "...";
		return reducedContent;
	}

}
