package ch.hftm.model;


import ch.hftm.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_fk")
    private Blog blog;
    @NotBlank(message = "Author must not be blank")
    private String author;
    @NotBlank(message = "Content must not be blank")
    private String content;

    public Comment(Blog blog, String author, String content) {
        this.blog = blog;
        this.author = author;
        this.content = content;
    }

    public CommentDTO toDTO() {
        CommentDTO dto = new CommentDTO();
        dto.setId(this.getId());
        dto.setAuthor(this.getAuthor());
        dto.setContent(this.getContent());
        return dto;
    }

    public static Comment fromDTO(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setAuthor(dto.getAuthor());
        comment.setContent(dto.getContent());
        return comment;
    }

}