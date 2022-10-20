package com.example.articlerequest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.articlerequest.entity.Article;
import com.example.articlerequest.repository.ArticleRepository;

@RestController
@RequestMapping("/article")
public class ArticlesController {

    Logger logger = LoggerFactory.getLogger(ArticlesController.class);

    private final ArticleRepository articleRepository;

    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/{articleNumber}")
    public Double readProduct(@PathVariable String articleNumber) {
        Optional<Article> article = articleRepository.findByArticleNumber(articleNumber);
        if(article.isPresent()) {
            logger.info("article was found with price " + article.get().getPrice());
            return article.get().getPrice();
        }
        logger.error("no article was found width articlenumber " + articleNumber);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "article with this articlenumber not found.");
    }


    
}
