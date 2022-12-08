package kz.narxoz.skara.services.impl;

import kz.narxoz.skara.entity.Article;
import kz.narxoz.skara.repository.ArticleRepository;
import kz.narxoz.skara.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticle(){
      List<Article> articles = articleRepository.findAll();
      return articles;
    }

    @Override
    public Article getArticles(Long id){
      return articleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Article> ratingArticles() {
      List<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.ASC, "view"));
      return articles;
    }

    @Override
    public Article saveArticle(Article article){
      return articleRepository.save(article);
    }

  @Override
  public List<Article> randArticles(int limit) {
    List<Article> articles = articleRepository.randArticles(limit);
    return articles;
  }


}
