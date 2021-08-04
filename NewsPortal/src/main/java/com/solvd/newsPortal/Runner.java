package com.solvd.newsPortal;

import com.solvd.newsPortal.dao.article.ArticleDAO;
import com.solvd.newsPortal.dao.category.CategoryDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class Runner {
    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public final static void main(String[] args){


        ConnectionPool pool = ConnectionPool.init(5,
                "52.59.193.212:3306", "newsPortal",
                "root", "devintern");
        Connection connection = pool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM newsPortal.Categories where id = 1;")){
            try {
                ResultSet rs = ps.executeQuery();
                rs.next();
                LOGGER.debug("name: " + rs.getString("name"));

            } catch (SQLException e) {
            LOGGER.error(e);
        }

    } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }



    Article articleTest = new Article("testing", (new Date(2021,8,3)), "body", 1L, 1L, 1L );
    ArticleDAO articleDAO = new ArticleDAO();
    articleDAO.createItem(articleTest);
    LOGGER.debug(articleTest.getId());
    articleDAO.deleteById(articleTest.getId());
    CategoryDAO categoryDAO = new CategoryDAO();
    Category c = categoryDAO.getItemById(1L);
    c.setName("name test");
    categoryDAO.updateItem(c, c.getId());
    categoryDAO.getItemById(1L);
    }
}
