package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.models.article.Location;
import com.solvd.newsPortal.dao.ILocationDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class LocationDAO extends AbstractMysqlJdbcDAO<Location> implements ILocationDAO {
    private final static Logger LOGGER = Logger.getLogger(LocationDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Location` (`name`) VALUES (?);";
    private final static String GET = "SELECT * FROM newsPortal.Location WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Location` SET `name` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Location` WHERE (`id` = ?);";

    @Override
    protected Location build(ResultSet rs) throws SQLException {
        Location l = new Location();
        l.setName(rs.getString("name"));
        l.setId(rs.getLong("id"));
        return l;
    }

    @Override
    protected void setParameters(Location item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
    }

    @Override
    public void createItem(Location item) {
        createItem(item, CREATE);
    }

    @Override
    public Location getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(Location item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {
        deleteItem(id, DELETE);
    }
}
