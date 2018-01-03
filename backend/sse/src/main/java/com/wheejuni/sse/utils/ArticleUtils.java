package com.wheejuni.sse.utils;

import com.wheejuni.sse.domain.Article;
import com.wheejuni.sse.domain.repositories.ArticleRepository;
import org.jooq.lambda.Seq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ArticleUtils {

    private static final int ARTICLE_ID_LENGTH = 10;

    public enum Prefixes {

        ANONYMOUS("익명의"),
        LEGENDARY("전설의"),
        PRETTY("어여쁜");

        private String prefix;

        Prefixes(String prefix) {
            this.prefix = prefix;
        }

        public static String getRandomPrefixes() {
            return Arrays.stream(Prefixes.values()).collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                Collections.shuffle(collected);
                return collected.stream();
            }))
                    .limit(1)
                    .findFirst().get().prefix;
        }
    }

    public enum WriterNames {

        POBI("포비"),
        ELLY("엘리"),
        ALIENS("알린"),
        JAKE("제이크"),
        TRAM("트램"),
        MIN("민"),
        HOON("훈"),
        BEOWULF("베오울프"),
        RYAN("라이언");

        private String name;

        WriterNames(String name) {
            this.name = name;
        }

        public static String getRandomNames() {
            return Arrays.stream(WriterNames.values()).collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                Collections.shuffle(collected);
                return collected.stream();
            }))
                    .limit(1)
                    .findFirst().get().name;
        }
    }

    public Article appendWriterName(Article article) {
        return Arrays.asList(article).stream().map(a -> {
            a.setWriter(generateWriterName());
            return a;
        }).findFirst().get();
    }

    public Article appendGeneratedId(Article article) {
        return Arrays.asList(article).stream().map(a -> {
            a.setId(generateRandomString());
            return a;
        }).findFirst().get();
    }

    private String generateWriterName() {
        StringBuilder writerName = new StringBuilder();
        writerName.append(Prefixes.getRandomPrefixes());
        writerName.append(" ");
        writerName.append(WriterNames.getRandomNames());

        return writerName.toString();
    }

    private static String generateRandomString() {
        List<String> alphabet = Seq.rangeClosed('a', 'z').map(Object::toString).toList();
        Collections.shuffle(alphabet);
        StringBuffer generatedId = new StringBuffer();

        while(generatedId.length() < ARTICLE_ID_LENGTH) {
            generatedId.append(alphabet.stream().findFirst().get());
            Collections.shuffle(alphabet);
        }

        return generatedId.toString();
    }
}
