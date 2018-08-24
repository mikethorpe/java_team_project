package models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    private int id;
    private String name;
    private List<Article> articles;

    public Author(){

	}

    public Author(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany( mappedBy = "author")
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
