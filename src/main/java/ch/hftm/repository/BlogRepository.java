package ch.hftm.repository;


import ch.hftm.model.Blog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BlogRepository implements PanacheRepository<Blog> {

    // Persistieren (Speichern) eines Blog-Objekts in der Datenbank
    public void createBlog(Blog blog) {
        persist(blog);
    }

    // Löschen eines Blog-Objekts aus der Datenbank
    public void removeBlog(Blog blog) {
        delete(blog);
    }

    // Abrufen aller Blog-Objekte aus der Datenbank
    public List<Blog> getAllBlogs() {
        return listAll();
    }

    // Finden eines bestimmten Blog-Objekts durch seine ID
    public Blog getBlogById(Long id) {
        return findById(id);
    }

}