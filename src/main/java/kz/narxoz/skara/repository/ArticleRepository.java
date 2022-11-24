package kz.narxoz.skara.repository;

import kz.narxoz.skara.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
