package kz.narxoz.skara.repository;

import kz.narxoz.skara.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
