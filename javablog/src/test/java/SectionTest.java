import models.Section;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SectionTest {

	Section section;
	@Before
	public void before(){
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
}
