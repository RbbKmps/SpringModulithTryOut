package com.modulith.demo.post.core.ports.driving;

import com.modulith.demo.post.core.domain.Comment;
import com.modulith.demo.post.core.domain.Post;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface PostAPI {
    @Transactional
    void create(PostDTO postDTO);
    List<Post> findAll();
    Post addComment(UUID postId, Comment comment);
}
