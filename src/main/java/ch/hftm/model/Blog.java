package ch.hftm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog extends PanacheEntityBase {

    public record BlogCreateDto(String title, String content) {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
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