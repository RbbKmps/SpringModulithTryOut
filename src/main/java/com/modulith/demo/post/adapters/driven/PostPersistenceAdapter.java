package com.modulith.demo.post.adapters.driven;

import com.modulith.demo.post.core.domain.Post;
import com.modulith.demo.post.core.ports.driven.PostPersistencePort;
import java.util.List;
import java.util.Optional;
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
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return postRepository.findById(postId);
    }
}
