package com.example.articlerequest.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String articleNumber;
    private String eanCode;

    @OneToMany(mappedBy="article")
    List<ArticleShortText> articleTextShort;

    private Double price;
    private String articleTextShortDE;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleNumber() {
        return this.articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getEanCode() {
        return this.eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public List<ArticleShortText> getArticleTextShort() {
        return this.articleTextShort;
    }

    public void setArticleTextShort(List<ArticleShortText> articleTextShort) {
        this.articleTextShort = articleTextShort;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getArticleTextShortDE() {
        return this.articleTextShortDE;
    }

    public void setArticleTextShortDE(String articleTextShortDE) {
        this.articleTextShortDE = articleTextShortDE;
    }

}
