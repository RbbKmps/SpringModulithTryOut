package com.modulith.demo.post.core.ports.driving;

import org.jmolecules.event.types.DomainEvent;

public record PostCreated(PostDTO postDTO) implements DomainEvent {}