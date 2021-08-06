package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.classes.tag.Tag;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.ITagDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class TagDAO extends AbstractMysqlJdbcDAO<Tag> implements ITagDAO {
    private final static Logger LOGGER = Logger.getLogger(TagDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Tags` (`name`) VALUES (?);";
    private final static String GET = "SELECT * FROM newsPortal.Tags WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Tags` SET `name` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Tags` WHERE (`id` = ?);";

    @Override
    protected Tag build(ResultSet rs) throws SQLException {
        Tag t = new Tag();
        t.setName(rs.getString("name"));
        t.setId(rs.getLong("id"));
        return t;
    }

    @Override
    protected void setParameters(Tag item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
    }

    @Override
    public void createItem(Tag item) {
        createItem(item, CREATE);
    }

    @Override
    public Tag getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(Tag item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {
        deleteItem(id, DELETE);
    }
}

