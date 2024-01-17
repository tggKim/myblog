package kim.blog.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    @Builder
    public Post(String title,String content){
        this.title=title;
        this.content=content;
    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
}
