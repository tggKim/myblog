package kim.blog.dto;

import kim.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponsePost {
    private String title;
    private String content;
    public ResponsePost(Post post){
        this.title=post.getTitle();
        this.content=post.getContent();
    }
}
