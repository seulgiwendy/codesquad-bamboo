package com.wheejuni.sse.utils;

import com.wheejuni.sse.domain.Article;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ArticleUtilsTest {

    private Article article;

    @Before
    public void setUp() {
        this.article = Article.builder()
                .article("가나다라마바사")
                .build();
    }

    @Test
    public void 이름생성_잘되는지() {
        ArticleUtils.appendWriterName(this.article);
        System.out.println(this.article.getWriter());
        assertNotNull(this.article.getWriter());
    }
}