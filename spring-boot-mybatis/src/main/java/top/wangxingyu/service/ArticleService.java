package top.wangxingyu.service;

import top.wangxingyu.Article;

import java.util.List;

/**
 * @author 笼中雀
 */
public interface ArticleService {
    Article saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();

}
