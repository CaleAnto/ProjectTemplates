package kz.narxoz.skara.controllers;

import kz.narxoz.skara.entity.Article;
import kz.narxoz.skara.entity.Commits;
import kz.narxoz.skara.services.ArticleService;
import kz.narxoz.skara.services.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
*Автор контроллер.
 */
@Controller
public class ArticlesController {

  @Autowired
  ArticleService articleService;
  CommitsService commitsService;
  public static String UPLOAD_DIRECTORY =
      "C:/Users/admin/Desktop/project/Skara/src/main/resources/images";

  /**
   * Гет запрос на главную страницу.
   */
  @GetMapping("/news")
  public String getArticles(Model model) {
    model.addAttribute("articles1", articleService.firstArticles());
    model.addAttribute("articles2", articleService.secondArticles());
    model.addAttribute("articles3", articleService.threesArticles());

    return "news";
  }

  /**
   * Гет запрос на форму.
   */
  @GetMapping("/form/articles")
  public String formArticles(Model model) {
    Article article = new Article();
    model.addAttribute("articles", article);
    return "input";
  }

  @GetMapping("/ratings")
  public String ratingsArticles(Model model) {
    model.addAttribute("rating", articleService.ratingArticles());
    model.addAttribute("ads", articleService.firstArticles());
    return "ratings";
  }

  @GetMapping("/article/{tag}")
  public String ratingsArticles(@PathVariable("tag") String tag, Model model) {
    model.addAttribute("articles", articleService.findByTag(tag));
    return null; // Замена
  }

  @PostMapping("/save/articles")
  public String saveArticles(@ModelAttribute("articles") Article article,
                             @RequestParam("image") MultipartFile image) throws IOException {

    StringBuilder fileNames = new StringBuilder();
    Path fileNameAndPath1 = Paths.get(UPLOAD_DIRECTORY, image.getOriginalFilename());
    fileNames.append(image.getOriginalFilename());
    Files.write(fileNameAndPath1, image.getBytes());

    article.setTheme_image(image.getOriginalFilename());
    article.setView(0);
    article.setId_statia("none");
    article.setTemp("none");
    articleService.saveArticle(article);
    return "redirect:/news";
  }


  @PostMapping("/articles/commits/{id}")
  public String commitsArticles(@PathVariable("id") Long id,
                                @ModelAttribute("commits") Commits commits) {
    commitsService.saveComments(commits);
    return null;
  }

  /**
   * Гет запрос на отдельную страницу.
   */

  @GetMapping("/articles/{id}")
  public String getTokabe(@PathVariable("id") Long id, Model model) {
    Article article = articleService.getArticles(id);
    model.addAttribute("article", article);
    Commits commits = new Commits();
    //model.addAttribute("commentsForm", commits);
    //model.addAttribute("comments", commitsService.commentPost(id));
    return "main";
  }

}
