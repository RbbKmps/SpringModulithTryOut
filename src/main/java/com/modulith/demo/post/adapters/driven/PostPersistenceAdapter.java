package com.modulith.demo.post.adapters.driven;

import com.modulith.demo.post.core.domain.Post;
import com.modulith.demo.post.core.ports.driven.PostPersistencePort;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PostPersistenceAdapter implements PostPersistencePort {
    private final PostRepository postRepository;

    public PostPersistenceAdapter(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
