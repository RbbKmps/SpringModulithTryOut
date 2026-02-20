package com.modulith.demo.notification.core.usecase;

import com.modulith.demo.post.core.ports.driving.CommentAdded;
import com.modulith.demo.post.core.ports.driving.PostCreated;
import com.modulith.demo.user.core.ports.driving.UserAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {
    private final UserAPI userAPI;

    public  NotificationService(UserAPI userAPI) {
        this.userAPI = userAPI;
    }

    @ApplicationModuleListener
    public void onPostCreated(PostCreated event) {
        var post = event.postDTO();

        String author = userAPI.getUsernameById(post.authorId());

        log.info("POST CREATED EVENT:");
        log.info("A POST WAS CREATED: {}", post.body());

        post.tags().forEach(userId -> {
            String username = userAPI.getUsernameById(userId);
            log.info("USER {} HAS BEEN TAGGED BY {}", username, author);
        });
    }

    @ApplicationModuleListener
    public void onCommentAdded(CommentAdded event) {
        log.info("POST RECEIVED COMMENT EVENT:");
        log.info("YOUR POST WITH ID {} HAS RECEIVED A COMMENT FROM {}", event.postId(), event.username());
    }
}
