package com.modulith.demo.post.core.usecase;

import com.modulith.demo.post.core.domain.Comment;
import com.modulith.demo.post.core.ports.driving.CommentAdded;
import com.modulith.demo.post.core.ports.driving.PostAPI;
import com.modulith.demo.post.core.ports.driving.PostCreated;
import com.modulith.demo.post.core.domain.Post;
import com.modulith.demo.post.core.ports.driving.PostDTO;
import com.modulith.demo.post.core.ports.driven.PostPersistencePort;
import com.modulith.demo.user.core.ports.driving.UserAPI;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostAPI {
    private final PostPersistencePort postPersistencePort;
    private final UserAPI userAPI;
    private final ApplicationEventPublisher events;

    public PostService(PostPersistencePort postPersistencePort, UserAPI userAPI, ApplicationEventPublisher events) {
        this.postPersistencePort = postPersistencePort;
        this.userAPI = userAPI;
        this.events = events;
    }

    @Transactional
    @Override
    public void create(PostDTO postDTO) {
        postDTO.tags().forEach(tag -> {
            if (!userAPI.getUserExists(tag)) {
                throw new IllegalArgumentException("User with id " + tag + " does not exist");
            }
        });

        if (!userAPI.getUserExists(postDTO.authorId())) {
            throw new IllegalArgumentException("User with id " + postDTO.authorId() + " does not exist");
        }

        Post post = new Post();
        post.setBody(postDTO.body());
        post.setAuthorId(postDTO.authorId());
        post.setTags(postDTO.tags());
        postPersistencePort.save(post);

        events.publishEvent(new PostCreated(postDTO));
    }

    @Transactional
    @Override
    public Post addComment(Long postId, Comment comment) {
        Optional<Post> post = postPersistencePort.findById(postId);
        if (post.isEmpty()) {
            throw new IllegalArgumentException("Post with id " + postId + " does not exist");
        }

        if (!userAPI.getUsernameExists(comment.userName)) {
            throw new IllegalArgumentException("User " + comment.userName + " does not exist");
        }

        post.get().addComment(comment);

        events.publishEvent(new CommentAdded(postId, comment.userName));

        return postPersistencePort.save(post.get());
    }

    public List<Post> findAll() {
        return postPersistencePort.findAll();
    }
}
