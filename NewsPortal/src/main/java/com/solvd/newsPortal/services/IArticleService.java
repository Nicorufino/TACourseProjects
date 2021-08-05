package com.solvd.newsPortal.services;

import com.solvd.newsPortal.classes.article.Article;

public interface IArticleService {
    Article getArticleById(Long id);
}
