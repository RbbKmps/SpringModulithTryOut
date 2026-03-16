package com.modulith.demo.post.core.ports.driving;

import java.util.UUID;
import org.jmolecules.event.types.DomainEvent;

public record CommentAdded(UUID postId, String username) implements DomainEvent {
}
