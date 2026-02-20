package com.modulith.demo.post.adapters.driving;

import com.modulith.demo.post.core.usecase.PostService;
import com.modulith.demo.post.core.domain.Post;
import com.modulith.demo.post.core.ports.driving.PostDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public PostDTO post(@RequestBody PostDTO postDTO) {
        postService.create(postDTO);
        return postDTO;
    }

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }
}
