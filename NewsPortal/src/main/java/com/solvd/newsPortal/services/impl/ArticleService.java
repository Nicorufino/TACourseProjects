package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.dao.mySql.mybatis.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.CategoryDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.SuscriptionLevelDAO;
import com.solvd.newsPortal.services.IArticleService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ArticleService implements IArticleService {
    private final static Logger LOGGER = Logger.getLogger(ArticleService.class);
    private ArticleDAO articleDAO = new ArticleDAO();
    private SuscriptionLevelDAO slDAO = new SuscriptionLevelDAO();
    private CategoryDAO cDAO = new CategoryDAO();
    private UserService uService = new UserService();

    public ArticleService() throws IOException {
    }


    @Override
    public Article getArticleById(Long id) {
        Article a = articleDAO.getItemById(id);
        a.setAuthor(uService.getUserById(a.getAuthor().getId()));
        a.setCategory(cDAO.getItemById(a.getCategory().getId()));
        a.setSuscriptionLevelRequired(slDAO.getItemById(a.getSuscriptionLevelRequired().getId()));
        return a;
    }
}
