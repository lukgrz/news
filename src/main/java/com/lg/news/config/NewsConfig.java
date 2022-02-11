package com.lg.news.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NewsConfig {

    @Value("https://newsapi.org/v2/top-headlines")
    private String newsApiEndpoint;

    @Value("700b95da1cff4f849b880f47578aa824")
    private String newsKey;

    public String getNewsApiEndpoint() {
        return newsApiEndpoint;
    }

    public String getNewsKey() {
        return newsKey;
    }
}
