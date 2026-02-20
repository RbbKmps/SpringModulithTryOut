package com.modulith.demo.post.core.ports.driving;

import jakarta.transaction.Transactional;

public interface PostAPI {
    @Transactional
    void create(PostDTO postDTO);
}
