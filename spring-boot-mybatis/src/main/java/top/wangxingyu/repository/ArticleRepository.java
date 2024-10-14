package top.wangxingyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wangxingyu.Article;

/**
 * @author 笼中雀
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByAuthor(String author);
}
