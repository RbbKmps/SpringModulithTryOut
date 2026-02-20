package com.modulith.demo.post.core.ports.driving;

import com.modulith.demo.post.core.domain.Comment;
import com.modulith.demo.post.core.domain.Post;
import jakarta.transaction.Transactional;
import java.util.List;

public interface PostAPI {
    @Transactional
    void create(PostDTO postDTO);
    List<Post> findAll();
    Post addComment(Long postId, Comment comment);
}
