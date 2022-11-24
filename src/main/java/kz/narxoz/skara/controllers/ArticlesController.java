package kz.narxoz.skara.controllers;

import kz.narxoz.skara.entity.Article;
import kz.narxoz.skara.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

public class ArticlesController {

  @Autowired
  ArticleService articleService;

  @GetMapping("/articles")
  public List<Article> getArticles() {
    return articleService.getAllArticle();
  }

}
