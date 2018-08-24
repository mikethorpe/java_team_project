import models.Article;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArticleTest {

	Article article;
	@Before
	public void before(){
		article = new Article("Mike and Molly code together", "Some content");
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


}
