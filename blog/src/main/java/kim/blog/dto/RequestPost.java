package kim.blog.dto;

import kim.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestPost {
    private String title;
    private String content;
    public Post toPost(){
        return Post.builder().title(title).content(content).build();
    }
}
