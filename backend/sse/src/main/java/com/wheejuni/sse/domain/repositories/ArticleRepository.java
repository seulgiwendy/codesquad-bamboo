package com.wheejuni.sse.domain.repositories;

import com.wheejuni.sse.domain.Article;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ArticleRepository extends ReactiveMongoRepository<Article, Long>{
}
