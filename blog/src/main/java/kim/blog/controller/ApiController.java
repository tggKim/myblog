package kim.blog.controller;

import kim.blog.dto.RequestPost;
import kim.blog.dto.ResponsePost;
import kim.blog.entity.Post;
import kim.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final PostService postService;
    @GetMapping("/api/posts/{id}")
    public ResponsePost find(@PathVariable("id")Long id){
        return new ResponsePost(postService.findPostById(id));
    }
    @GetMapping("/api/posts")
    public List<ResponsePost> findAll(){
        return postService.findAllPost()
                .stream()
                .map(ResponsePost::new)
                .toList();
    }
    @PostMapping("/api/posts")
    public Post save(@RequestBody RequestPost requestPost){
        return postService.savePost(requestPost);
    }
    @PutMapping("/api/posts/{id}")
    public ResponsePost update(@PathVariable("id")Long id,@RequestBody RequestPost requestPost){
        return new ResponsePost(postService.updatePost(id,requestPost));
    }
    @DeleteMapping("/api/posts/{id}")
    public void delete(@PathVariable("id")Long id){
        postService.deletePostById(id);
    }
}
