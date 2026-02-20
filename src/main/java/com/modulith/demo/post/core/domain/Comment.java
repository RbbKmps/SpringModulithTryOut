package com.modulith.demo.post.core.domain;

import com.modulith.demo.global.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Comment implements ValueObject {
    public String userName;
    public String body;

    public Comment(String userName, String body) {
        this.userName = userName;
        this.body = body;
    }

    public Comment() {}
}
