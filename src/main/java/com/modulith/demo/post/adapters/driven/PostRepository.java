package com.modulith.demo.post.adapters.driven;

import com.modulith.demo.post.core.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
