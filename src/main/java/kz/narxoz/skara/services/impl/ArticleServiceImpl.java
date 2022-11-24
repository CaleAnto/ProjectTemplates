package kz.narxoz.skara.services.impl;

import kz.narxoz.skara.entity.Article;
import kz.narxoz.skara.repository.ArticleRepository;
import kz.narxoz.skara.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticle(){
      List<Article> articles = articleRepository.findAll();
      return articles;
    }

}
