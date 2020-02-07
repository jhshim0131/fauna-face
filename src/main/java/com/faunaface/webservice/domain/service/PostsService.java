package com.faunaface.webservice.domain.service;

import com.faunaface.webservice.domain.posts.Posts;
import com.faunaface.webservice.domain.posts.PostsRepository;
import com.faunaface.webservice.web.dto.PostsResponseDto;
import com.faunaface.webservice.web.dto.PostsSaveRequestDto;
import com.faunaface.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The User is " +
                "not existed id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The User is " +
                        "not existed id="+id));

        return new PostsResponseDto(entity);
    }


}
