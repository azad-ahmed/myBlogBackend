package ch.hftm.service;

import ch.hftm.model.Blog;
import ch.hftm.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;


public class BlogServiceTest {

    @Test
    public void testGetBlogs() {
        // Mock the BlogRepository
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);


        // Create an instance of BlogService
        BlogService blogService = new BlogService();
        blogService.blogRepository = blogRepository;

        // Call getBlogs and check the result
        List<Blog> blogs = blogService.getBlogs();
        assertEquals(1, blogs.size());
        assertEquals("author", blogs.get(0).getAuthor());
        assertEquals("title", blogs.get(0).getTitle());
        assertEquals("content", blogs.get(0).getContent());
    }

    @org.junit.Test
    public void testAddBlog() {
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        BlogService blogService = new BlogService();
        blogService.blogRepository = blogRepository;

        Blog blog = new Blog("author", "title", "content");
        blogService.addBlog(blog);

        // Verify that the blog has been persisted
        Mockito.verify(blogRepository, Mockito.times(1)).persist(blog);
    }

    @org.junit.Test
    public void testUpdateBlog() {
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        BlogService blogService = new BlogService();
        blogService.blogRepository = blogRepository;

        Blog blog = new Blog("author", "title", "content");
        blog.setId(1L);
        Mockito.when(blogRepository.findById(1L)).thenReturn(blog);

        Blog.BlogCreateDto updateDto = new Blog.BlogCreateDto("newTitle", "newContent");
        blogService.updateBlog(1L, updateDto);

        // Verify that the blog has been updated
        assertEquals("newTitle", blog.getTitle());
        assertEquals("newContent", blog.getContent());
    }

    @org.junit.Test
    public void testDeleteBlog() {
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        BlogService blogService = new BlogService();
        blogService.blogRepository = blogRepository;

        Blog blog = new Blog("author", "title", "content");
        blog.setId(1L);
        Mockito.when(blogRepository.findById(1L)).thenReturn(blog);

        blogService.deleteBlog(1L);

        // Verify that the blog has been deleted
        Mockito.verify(blogRepository, Mockito.times(1)).deleteById(1L);
    }
}