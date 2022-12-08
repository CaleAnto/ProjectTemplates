package kz.narxoz.skara.controllers;

import kz.narxoz.skara.entity.Article;

import kz.narxoz.skara.entity.Commits;
import kz.narxoz.skara.services.ArticleService;
import kz.narxoz.skara.services.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticlesController {

  @Autowired
  ArticleService articleService;
  CommitsService commitsService;

  @GetMapping("/articles")
  public String getArticles(Model model) {
    List<Article> articles = articleService.getAllArticle();
    List<Article> first = articles.subList(0,2);
    List<Article> second = articles.subList(3,5);
    List<Article> threes = articles.subList(6,8);
    model.addAttribute("articles1", first);
    model.addAttribute("articles2", second);
    model.addAttribute("articles3", threes);

    return "main";
  }

  @GetMapping("/form/articles")
  public String formArticles(Model model){
    Article article = new Article();
    model.addAttribute("articles", article);
    return null;
  }

  @PostMapping("/save/articles")
  public String saveArticles(@ModelAttribute("articles") Article article){
    articleService.saveArticle(article);
    return null;
  }

  @GetMapping("/articles/{id}")
  public String getOneArticles(@PathVariable("id") Long id, Model model){
    Article article = articleService.getArticles(id);
    model.addAttribute("article", article);
    Commits commits = new Commits();
 //   model.addAttribute("commentsForm", commits);
 //   model.addAttribute("comments", commitsService.commentPost(id));
    return "main";
  }

  @PostMapping("/articles/commits/{id}")
  public String commitsArticles(@PathVariable("id") Long id, @ModelAttribute("commits") Commits commits){
    commitsService.saveComments(commits);
    return null;
  }

}
