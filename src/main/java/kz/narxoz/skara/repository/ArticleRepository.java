package kz.narxoz.skara.repository;

import io.lettuce.core.dynamic.annotation.Param;
import kz.narxoz.skara.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {

  @Query(value = "Select * from article ORDER BY random() limit :limit", nativeQuery = true)
  List<Article> randArticles(@Param("limit") int limit);

}
