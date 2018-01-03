package com.wheejuni.sse.controller;

import com.wheejuni.sse.domain.Article;
import com.wheejuni.sse.domain.nonpersistent.ArticleDto;
import com.wheejuni.sse.domain.nonpersistent.ArticlePostResult;
import com.wheejuni.sse.domain.repositories.ArticleRepository;
import com.wheejuni.sse.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ArticleApiController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleUtils articleUtils;

    @GetMapping("/allarticles")
    public Flux<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "/allarticles/event", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Article> streamAllArticles() {
        return articleRepository.findAll();
    }


    @PostMapping("/new")
    public Mono<Article> saveNewArticle(@RequestBody ArticleDto articleDto) {
        Article article = Article.builder().article(articleDto.getContent()).build();
        articleUtils.appendWriterName(article);
        articleUtils.appendGeneratedId(article);

        return articleRepository.save(article);
    }



}
