package com.modulith.demo.post.core.ports.driving;

import java.util.List;
import java.util.UUID;

public record PostDTO(String body, UUID authorId, List<UUID> tags) {}
