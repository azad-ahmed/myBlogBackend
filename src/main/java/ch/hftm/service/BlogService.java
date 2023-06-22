package ch.hftm.service;


import ch.hftm.model.Blog;
import ch.hftm.repository.BlogRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import java.util.List;

@Dependent
public class BlogService {

    private static final Logger LOGGER = Logger.getLogger(BlogService.class.getName());

    @Inject
    BlogRepository blogRepository;

    public List<Blog> getBlogs() {
        List<Blog> blogs = blogRepository.listAll();
        LOGGER.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    @Transactional
    public void addBlog(Blog blog) {
        LOGGER.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public Blog updateBlog(long id, Blog.BlogCreateDto updateDto) {
        Blog blog = blogRepository.findById(id);
        if (blog != null) {
            LOGGER.info("Updating blog " + blog.getTitle());
            blog.setAuthor("user");
            blog.setTitle(updateDto.title());
            blog.setContent(updateDto.content());
        } else {
            LOGGER.info("No blog found with id " + id + ", creating a new one");
            blog = new Blog("user", updateDto.title(), updateDto.content());
            blogRepository.persist(blog);
        }
        return blog;
    }

    @Transactional
    public Blog partialUpdateBlog(long id, Blog.BlogCreateDto updateDto) {
        var blog = blogRepository.findById(id);
        if(blog != null) {
            if (updateDto.title() != null) {
                blog.setTitle(updateDto.title());
            }
            if (updateDto.content() != null) {
                blog.setContent(updateDto.content());
            }
        }
        return blog;
    }


    @Transactional
    public boolean deleteBlog(long id) {
        if(blogRepository.deleteById(id)) {
            LOGGER.info("Deleted blog with id " + id);
            return true;
        } else {
            LOGGER.info("No blog found with id " + id);
            return false;
        }
    }

}