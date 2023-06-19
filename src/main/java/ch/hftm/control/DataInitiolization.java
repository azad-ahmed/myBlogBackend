package ch.hftm.control;

import ch.hftm.entity.Blog;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.logging.Logger;

public class DataInitiolization {

    @Inject
    BlogRepository blogRepository;

    @Inject
    Logger logger;

    @Transactional
    public void init(@Observes StartupEvent event) {
        if(blogRepository.count() < 1) {
            logger.info("Initializing Data!");
            var blog = Blog.builder()
                    .title("Hello World")
                    .content("This is my first Blog Post")
                    .build();

            blogRepository.persist(blog);
        }
    }
}
