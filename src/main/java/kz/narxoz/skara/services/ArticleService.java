package kz.narxoz.skara.services;

import kz.narxoz.skara.entity.Article;

import java.util.List;

public interface ArticleService {
  List<Article> getAllArticle();

  Article getArticles(Long id);
}
