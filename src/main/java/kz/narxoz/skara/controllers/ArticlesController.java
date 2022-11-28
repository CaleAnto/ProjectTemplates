package kz.narxoz.skara.controllers;

import kz.narxoz.skara.entity.Article;
import kz.narxoz.skara.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ArticlesController {

  @Autowired
  ArticleService articleService;

  @GetMapping("/articles")
  public String getArticles(Model model) {
    model.addAttribute("articles", articleService.getAllArticle());
    return "main";
  }

  @GetMapping("/articles/{id}")
  public String getOneArticles(@PathVariable("id") Long id, Model model){
    Article article = articleService.getArticles(id);
    model.addAttribute("article", article);
    return null;
  }

}
