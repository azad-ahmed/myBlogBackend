package ch.hftm.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String author;
    private String content;


    public CommentDTO() {
        this.id = id;
        this.author = author;
        this.content = content;
    }
}
