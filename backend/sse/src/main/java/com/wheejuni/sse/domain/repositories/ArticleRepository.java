package com.wheejuni.sse.domain.repositories;

import com.wheejuni.sse.domain.Article;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ArticleRepository extends ReactiveMongoRepository<Article, Long>{

    public Mono<Article> findById(String id);
}
