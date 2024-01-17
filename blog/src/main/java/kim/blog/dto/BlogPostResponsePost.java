package kim.blog.dto;

import kim.blog.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BlogPostResponsePost {
    private Long id;
    private String title;
    private String content;
    public BlogPostResponsePost(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
