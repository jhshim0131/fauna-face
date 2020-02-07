package com.faunaface.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostsRepository extends JpaRepository <Posts, Long> {
}
