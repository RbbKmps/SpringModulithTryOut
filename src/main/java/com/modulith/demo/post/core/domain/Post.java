package com.modulith.demo.post.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID postId;

    @NonNull
    private String body;

    private UUID authorId;

    @NonNull
    private List<UUID> tags;

    @ElementCollection
    private List<Comment> comments;

    public Post() {
        this.comments = new ArrayList<>();
    }

    public void setAuthorId(@NonNull UUID authorId) {
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

    public void setTags(@NonNull List<UUID> tags) {
        this.tags = tags;
    }

    public void addComment(@NonNull Comment comment) {
        this.comments.add(comment);
    }
}
