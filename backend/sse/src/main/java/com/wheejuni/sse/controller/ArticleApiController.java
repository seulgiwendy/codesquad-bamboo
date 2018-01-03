package com.wheejuni.sse.controller;

import com.wheejuni.sse.domain.nonpersistent.ArticleDto;
import com.wheejuni.sse.domain.nonpersistent.ArticlePostResult;
import com.wheejuni.sse.domain.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticleApiController {

    @Autowired
    ArticleRepository articleRepository;

    @PostMapping("/new")
    public ArticlePostResult saveNewArticle(@RequestBody ArticleDto articleDto) {
        //TODO save new article post
        return null;
    }

}
