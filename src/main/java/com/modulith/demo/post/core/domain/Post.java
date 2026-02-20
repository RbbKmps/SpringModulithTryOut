package com.modulith.demo.post.core.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  postId;
    @NonNull private String body;
    private Long authorId;
    @NonNull private List<Long> tags;
    @ElementCollection
    private List<Comment> comments;

    public Post() {
        this.comments = new ArrayList<>();
    }

    public void setAuthorId(@NonNull Long authorId) {
        if (this.authorId != null) {
            throw new IllegalArgumentException("This post already has an author");
        }
        this.authorId = authorId;
    }

    public void setBody(@NonNull String body) {
        if (body.strip().length() > 100) {
            throw new IllegalArgumentException("This post has too many characters");
        }
        this.body = body;
    }

    public void setTags(@NonNull List<Long> tags) {
        this.tags = tags;
    }

    public void addComment(@NonNull Comment comment) {
        this.comments.add(comment);
    }
}
