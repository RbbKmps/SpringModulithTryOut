package com.modulith.demo.post.core.usecase;

import com.modulith.demo.post.core.domain.Post;
import com.modulith.demo.post.core.ports.driving.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post postDTOToPost(PostDTO postDTO);
}
