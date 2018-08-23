import models.Author;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {

    private Author author;

    @Test
    public void hasName(){
        author = new Author("Mike");
        assertEquals("Mike", author.getName());
    }

    @Test
    public void testSetName() {
        String name = "Mike";
        Author instance = new Author(name);
        instance.setName(name);
        assertEquals(instance.getName(), name);
    }
    
}
