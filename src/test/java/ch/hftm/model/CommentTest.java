package ch.hftm.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommentTest {

    @Test
    public void testCreateComment() {
        Blog blog = new Blog("author", "title", "content");
        Comment comment = new Comment(blog, "commentAuthor", "commentContent");

        assertEquals(blog, comment.getBlog());
        assertEquals("commentAuthor", comment.getAuthor());
        assertEquals("commentContent", comment.getContent());
    }

    // Weitere Testmethoden für Kommentar-Funktionalitäten

}