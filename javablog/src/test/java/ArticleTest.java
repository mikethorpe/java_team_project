import models.Article;
import models.Author;
import models.Section;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ArticleTest {

	Article article;
	Author author;
	Section section;

	@Before
	public void before(){
		section = new Section("Technology");
		author = new Author("Molly");
		article = new Article("Mike and Molly code together", "Some content", author);
	}

	@Test
	public void canGetAndSetId(){
		article.setId(12);
		assertEquals(12, article.getId());
	}

	@Test
	public void canGetTitle(){
		assertEquals("Mike and Molly code together", article.getTitle());
	}

	@Test
	public void canSetTitle(){
		article.setTitle("Code together");
		assertEquals("Code together", article.getTitle());
	}

	@Test
	public void canGetAndSetImageLink(){
		article.setImageLink("www.images.com/image.jpg");
		assertEquals("www.images.com/image.jpg", article.getImageLink());
	}

	@Test
	public void canGetTextContent(){
		assertEquals("Some content", article.getTextContent());
	}


	@Test
	public void canSetTextContent(){
		article.setTextContent("Different content");
		assertEquals("Different content", article.getTextContent());
	}

	@Test
	public void canGetAuthor(){
		String authorName = article.getAuthor().getName();
		assertEquals("Molly", authorName);
	}

	@Test
	public void canSetAuthor(){
		Author mike = new Author("Mike");
		article.setAuthor(mike);
		String authorName = article.getAuthor().getName();
		assertEquals("Mike", authorName);
	}

	@Test
	public void canGetAndSetSections(){
		List<Section> sections = new ArrayList<>();
		sections.add(section);
		article.setSections(sections);
		assertEquals("Technology", sections.get(0).getTitle());
	}

	@Test
	public void canAddSectionToArticle(){
		article.addSectionToArticle(section);
		assertEquals(1, article.getSections().size());
	}


}
