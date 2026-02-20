package com.modulith.demo.post.core.domain;

import com.modulith.demo.global.ValueObject;
import lombok.Getter;

@Getter
public class Comment implements ValueObject {
    public String userName;
    public String body;

    public Comment(String userName, String body) {
        this.userName = userName;
        this.body = body;
    }
}
