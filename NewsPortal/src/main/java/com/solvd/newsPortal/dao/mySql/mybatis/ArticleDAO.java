package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.IArticleDAO;
import com.solvd.newsPortal.models.article.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.Reader;

public class ArticleDAO extends AbstractMysqlMybatisDAO<Article> implements IArticleDAO {
    private final static Logger LOGGER = Logger.getLogger(ArticleDAO.class);
    private SqlSession session = MybatisUtil.getSession();
    private IArticleDAO articleDAO = session.getMapper(IArticleDAO.class);

    public ArticleDAO() throws IOException{
    }


    @Override
    public void createItem(Article item) {
        createItem(item, articleDAO, session);
    }

    @Override
    public Article getItemById(Long id) {
        return getItemById(id, articleDAO, session);
    }

    @Override
    public void updateItem(Article item, Long id) {
        updateItem(item, id, articleDAO, session);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, articleDAO, session);
    }
}
