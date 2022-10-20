package com.example.articlerequest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.articlerequest.entity.Article;
import com.example.articlerequest.repository.ArticleRepository;
import com.example.articlerequest.repository.ArticleShortTextRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleShortTextRepository articleShortTextRepository;

    public ArticleService(ArticleRepository articleRepository, ArticleShortTextRepository articleShortTextRepository) {
        this.articleRepository = articleRepository;
        this.articleShortTextRepository = articleShortTextRepository;
    }
    
    public void save(List<Article> articles) {
        articleRepository.saveAll(articles);
        articles.stream().forEach(a -> 
            {
                a.getArticleTextShort().stream().forEach(
                    b -> 
                    {
                        b.setArticle(a);
                        this.articleShortTextRepository.save(b);
                    }
                );
            }
        );
    }


    
    
}
