package ch.hftm.model;


import ch.hftm.dto.BlogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog {

    public record BlogCreateDto(String title, String content) {}


    public BlogDTO toDTO() {
        BlogDTO dto = new BlogDTO();
        dto.setId(this.getId());
        dto.setTitle(this.getTitle());
        dto.setContent(this.getContent());
        dto.setAuthor(this.getAuthor());
        dto.setLikes(this.getLikes());
        dto.setComments(this.getComments().stream().map(Comment::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public static Blog fromDTO(BlogDTO dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setContent(dto.getContent());
        blog.setAuthor(dto.getAuthor());
        // Handle comments conversion if needed
        return blog;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Author must not be blank")
    private String author;

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Content must not be blank")
    private String content;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "BlogLikes", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "likes")
    private List<String> likes = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Blog(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}