package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.IArticleDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.article.Article;
import org.apache.log4j.Logger;
import java.io.IOException;

public class ArticleDAO extends AbstractMysqlMybatisDAO<Article> implements IArticleDAO {
    private final static Logger LOGGER = Logger.getLogger(ArticleDAO.class);
    private IArticleDAO dao = MybatisUtil.getIDao(IArticleDAO.class);

    public ArticleDAO() throws IOException{
    }


    @Override
    public void createItem(Article item) {
        createItem(item, dao);
    }

    @Override
    public Article getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(Article item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}
