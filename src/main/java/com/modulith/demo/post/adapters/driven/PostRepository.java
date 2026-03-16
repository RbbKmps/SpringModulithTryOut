package com.modulith.demo.post.adapters.driven;

import com.modulith.demo.post.core.domain.Post;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
