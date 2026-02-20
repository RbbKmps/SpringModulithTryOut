package com.modulith.demo.post.core.ports.driven;

import com.modulith.demo.post.core.domain.Post;
import java.util.List;
import java.util.Optional;

public interface PostPersistencePort {
    List<Post> findAll();

    Post save(Post post);

    Optional<Post> findById(Long postId);
}
