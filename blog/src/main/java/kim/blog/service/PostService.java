package kim.blog.service;

import kim.blog.dto.RequestPost;
import kim.blog.entity.Post;
import kim.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post savePost(RequestPost requestPost){
        return postRepository.save(requestPost.toPost());
    }
    public Post findPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("없다"));
    }
    public List<Post> findAllPost(){
        return postRepository.findAll();
    }
    public void deletePostById(Long id){
        postRepository.deleteById(id);
    }
    @Transactional
    public Post updatePost(Long id,RequestPost requestPost){
        Post post = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("없다"));
        post.update(requestPost.getTitle(),requestPost.getContent());
        return post;
    }
}
