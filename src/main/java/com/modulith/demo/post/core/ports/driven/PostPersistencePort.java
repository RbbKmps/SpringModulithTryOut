package com.modulith.demo.post.core.ports.driven;

import com.modulith.demo.post.core.domain.Post;
import java.util.List;

public interface PostPersistencePort {
    List<Post> findAll();

    void save(Post post);
}
