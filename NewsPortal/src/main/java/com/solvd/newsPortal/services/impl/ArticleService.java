package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.dao.mySql.mybatis.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.CategoryDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.Suscription_levelDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.UserDAO;
import com.solvd.newsPortal.services.IArticleService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ArticleService implements IArticleService {
    private final static Logger LOGGER = Logger.getLogger(ArticleService.class);
    private ArticleDAO articleDAO = new ArticleDAO();
    private Suscription_levelDAO slDAO = new Suscription_levelDAO();
    private CategoryDAO cDAO = new CategoryDAO();
    private UserDAO uDAO = new UserDAO();

    public ArticleService() throws IOException {
    }


    @Override
    public Article getArticleById(Long id) {
        Article a = articleDAO.getItemById(id);
        a.setAuthor(uDAO.getItemById(a.getAuthor().getId()));
        a.setCategory(cDAO.getItemById(a.getCategory().getId()));
        a.setSuscription_level(slDAO.getItemById(a.getSuscription_level().getId()));
        return a;
    }
}
