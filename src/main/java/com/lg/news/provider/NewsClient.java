package com.lg.news.provider;

import com.lg.news.config.NewsConfig;
import com.lg.news.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NewsClient {

    private final RestTemplate restTemplate;
    private final NewsConfig newsConfig;

    public NewsClient(RestTemplate restTemplate, NewsConfig newsConfig) {
        this.restTemplate = restTemplate;
        this.newsConfig = newsConfig;
    }

    public URI getNewsURL () {
    return UriComponentsBuilder.fromHttpUrl(newsConfig.getNewsApiEndpoint())
            .queryParam("apiKey", newsConfig.getNewsKey())
            .queryParam("country","pl")
            .queryParam("category", "business")
            .build().encode().toUri();
    }

    public News getNews() {
        URI uri =getNewsURL();
        News response = restTemplate.getForObject(uri, News.class);
        return response;
    }
}
