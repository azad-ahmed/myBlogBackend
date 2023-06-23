package ch.hftm.model;


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


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog {

    public record BlogCreateDto(String title, String content) {}

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