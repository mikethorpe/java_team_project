import models.Article;
import models.Author;
import models.Section;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SectionTest {

	private Section section;
	private Article article;
	private Author author;

	@Before
	public void before(){
		author = new Author("Molly");
		article = new Article("Mike and Molly write code", "Content", author);
		section = new Section("Technology");
	}

	@Test
	public void canGetAndSetId(){
		section.setId(21);
		assertEquals(21, section.getId());
	}

	@Test
	public void canGetTitle(){
		assertEquals("Technology", section.getTitle());
	}

	@Test
	public void canSetTitle(){
		section.setTitle("Environment");
		assertEquals("Environment", section.getTitle());
	}

	@Test
	public void canGetAndSetArticles(){
		List<Article> articles = new ArrayList<>();
		articles.add(article);
		section.setArticles(articles);
		assertEquals("Mike and Molly write code", section.getArticles().get(0).getTitle());
	}

	@Test
	public void canAddArticleToSection(){
		section.addArticleToSection(article);
		assertEquals(1, section.getArticles().size());
	}
}
