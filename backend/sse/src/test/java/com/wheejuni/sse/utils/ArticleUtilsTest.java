package com.wheejuni.sse.utils;

import com.wheejuni.sse.domain.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleUtilsTest {

    private Article article;

    @Autowired
    private ArticleUtils articleUtils;

    @Before
    public void setUp() {
        this.article = Article.builder()
                .article("가나다라마바사")
                .build();
    }

    @Test
    public void 이름생성_잘되는지() {
        articleUtils.appendWriterName(this.article);
        System.out.println(this.article.getWriter());
        assertNotNull(this.article.getWriter());
    }

    @Test
    public void ID생성_잘되는지() {
        articleUtils.appendGeneratedId(this.article);
        System.out.println(this.article.getId());
        assertNotNull(this.article.getId());
    }
}