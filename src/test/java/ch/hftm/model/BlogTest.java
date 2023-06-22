package ch.hftm.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlogTest {

    @Test
    public void testCreateBlog() {
        Blog blog = new Blog("author", "title", "content");
        assertEquals("author", blog.getAuthor());
        assertEquals("title", blog.getTitle());
        assertEquals("content", blog.getContent());
    }
}