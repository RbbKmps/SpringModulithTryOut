package com.modulith.demo.post.core.ports.driving;

import java.util.List;

public record PostDTO(String body, Long authorId, List<Long> tags) {}
