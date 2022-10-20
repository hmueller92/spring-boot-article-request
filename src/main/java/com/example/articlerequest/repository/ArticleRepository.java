package com.example.articlerequest.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.articlerequest.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long>{
    
    Optional<Article> findByArticleNumber(String articleNumber);

}
