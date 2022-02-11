package com.lg.news.service;

import com.lg.news.domain.Article;
import com.lg.news.domain.News;
import com.lg.news.provider.NewsClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class NewsService {

    private final NewsClient newsClient;

    public NewsService(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public News fetchNews() {
        return newsClient.getNews();
    }

    @PostConstruct
    public void saveToFile() {
        try {
            PrintWriter saveNews = new PrintWriter("C:\\Users\\lukas\\IdeaProjects\\news\\src\\main\\resources\\Business in PL");
            List<Article> articles = fetchNews().getArticles();
            System.out.println(articles.size());
            for (Article article : articles) {
                saveNews.println(article.getTitle() + ":" + article.getDescription() + ":" + article.getAuthor() + "\n");
            }
            saveNews.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } finally {

        }
    }
}
