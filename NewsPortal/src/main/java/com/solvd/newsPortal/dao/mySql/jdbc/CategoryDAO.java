package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.classes.article.Category;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.ICategoryDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class CategoryDAO extends AbstractMysqlJdbcDAO<Category> implements ICategoryDAO {
    private final static Logger LOGGER = Logger.getLogger(CategoryDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Categories` (`name`) VALUES (?);";
    private final static String GET = "SELECT * FROM newsPortal.Categories where id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Categories` SET `name` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Categories` WHERE (`id` = 1);";

    @Override
    protected Category build(ResultSet rs) throws SQLException {
        Category c = new Category();
        c.setName(rs.getString("name"));
        c.setId(rs.getLong("id"));
        return c;
    }

    @Override
    protected void setParameters(Category item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
    }

    @Override
    public void createItem(Category item) {
        createItem(item, CREATE);
    }

    @Override
    public Category getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(Category item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {
        deleteItem(id, DELETE);
    }
}
