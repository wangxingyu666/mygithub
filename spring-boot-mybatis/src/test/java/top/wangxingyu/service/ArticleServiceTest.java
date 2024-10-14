package top.wangxingyu.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wangxingyu.Article;

@SpringBootTest
@Slf4j
class ArticleServiceTest {
    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot 从入门到精通")
                .build();
        Article saveArticle = articleService.saveArticle(article);
        log.info(String.valueOf(saveArticle));
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(2L);
    }

    @Test
    void updateArticle() {
        Article article=articleService.getArticle(2L);
        article.setTitle("SpringBoot111");
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article=articleService.getArticle(2L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
    }
}