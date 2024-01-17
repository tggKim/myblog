package kim.blog.dto;

import kim.blog.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BlogResponsePost {
    private Long id;
    private String title;
    private LocalDateTime createdTime;
    public BlogResponsePost(Post post){
        this.id=post.getId();
        this.title=post.getTitle();
        this.createdTime=post.getCreatedTime();
    }
}
