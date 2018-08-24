import models.Article;
import models.Author;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorTest {

    private Author author;
    private Article article;
	private List<Article> articles;


    @Before
    public void before(){
        author = new Author("Mike");
		article = new Article("Article Title", "Content", author);
		articles = new ArrayList<>();
		articles.add(article);
	}

    @Test
    public void hasName(){
        assertEquals("Mike", author.getName());
    }

    @Test
    public void testSetName() {
        String name = "Mike";
        Author instance = new Author(name);
        instance.setName(name);
        assertEquals(instance.getName(), name);
    }

    @Test
    public void canGetAndSetArticles(){
		author.setArticles(articles);
		Article article = author.getArticles().get(0);
		assertEquals(article.getTitle(), "Article Title");
	}

}
