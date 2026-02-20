package com.modulith.demo.post.adapters.driving;

import com.modulith.demo.post.core.domain.Comment;
import com.modulith.demo.post.core.ports.driving.PostAPI;
import com.modulith.demo.post.core.domain.Post;
import com.modulith.demo.post.core.ports.driving.PostDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostAPI postAPI;

    public PostController(PostAPI postAPI) {
        this.postAPI = postAPI;
    }

    @PostMapping()
    public PostDTO post(@RequestBody PostDTO postDTO) {
        postAPI.create(postDTO);
        return postDTO;
    }

    @GetMapping
    public List<Post> findAll() {
        return postAPI.findAll();
    }

    @PutMapping("/{postId}/comment")
    public Post addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return postAPI.addComment(postId, comment);
    }
}
