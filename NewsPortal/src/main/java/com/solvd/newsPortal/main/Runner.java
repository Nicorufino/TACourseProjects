package com.solvd.newsPortal.main;

import com.solvd.newsPortal.classes.article.Article;
import com.solvd.newsPortal.classes.article.Category;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.mySql.jdbc.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.CategoryDAO;
import com.solvd.newsPortal.services.impl.UserService;
import org.apache.log4j.Logger;

import java.sql.*;

public class Runner {
    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public final static void main(String[] args){

        Connection connection = ConnectionPool.getInstance().getConnection();
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

        UserService userService = new UserService();
        LOGGER.debug(userService.getUserById(2L).toString());
    }
}
