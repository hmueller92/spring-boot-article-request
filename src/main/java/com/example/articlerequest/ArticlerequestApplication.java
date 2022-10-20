package com.example.articlerequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.articlerequest.entity.Article;
import com.example.articlerequest.service.ArticleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ArticlerequestApplication {

	Logger logger = LoggerFactory.getLogger(ArticlerequestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArticlerequestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ArticleService articleService){
	    return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Article>> typeReference = new TypeReference<List<Article>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/dummy_articles.json");
			try {
				List<Article> articles = mapper.readValue(inputStream,typeReference);
				articleService.save(articles);
				logger.info("Json into DB was successfull");
			} catch (IOException e){
				logger.error("Json into DB was not successfull");
			}
	    };
	}
	

}
