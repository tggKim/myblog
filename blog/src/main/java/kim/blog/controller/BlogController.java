package kim.blog.controller;

import kim.blog.dto.BlogPostResponsePost;
import kim.blog.dto.BlogResponsePost;
import kim.blog.dto.ResponsePost;
import kim.blog.entity.Post;
import kim.blog.service.PostService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final PostService postService;
    @GetMapping("/blog/posts")
    public String posts(Model model){
        List<BlogResponsePost> posts = postService.findAllPost()
                .stream()
                .map(BlogResponsePost::new)
                .toList();
        model.addAttribute("posts",posts);
        return "posts";
    }
    @GetMapping("/blog/posts/{id}")
    public String post(@PathVariable("id")Long id,Model model){
        BlogPostResponsePost post = new BlogPostResponsePost(postService.findPostById(id));
        model.addAttribute("post",post);
        return "post";
    }
    @GetMapping("/blog/post")
    public String write(@RequestParam(value="id",required = false)Long id,Model model){
        if(id==null){
            BlogPostResponsePost post = new BlogPostResponsePost();
            model.addAttribute("post",post);
        }
        else{
            BlogPostResponsePost post = new BlogPostResponsePost(postService.findPostById(id));
            model.addAttribute("post",post);
        }
        return "addOrUpdate";
    }
}
