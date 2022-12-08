package kz.narxoz.skara.services;

import java.util.List;
import kz.narxoz.skara.entity.Article;


public interface ArticleService {
  List<Article> getAllArticle();

  Article getArticles(Long id);

  List<Article> ratingArticles();

  Article saveArticle(Article article);

  List<Article> randArticles(int limit);
}
