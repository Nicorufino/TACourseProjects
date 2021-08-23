package com.solvd.newsPortal.services;

import com.solvd.newsPortal.models.article.Article;

public interface IArticleService {
    Article getArticleById(Long id);
}
