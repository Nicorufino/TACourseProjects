package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.classes.article.Location;
import com.solvd.newsPortal.dao.ILocationDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class LocationDAO extends AbstractMysqlJdbcDAO implements ILocationDAO {
    private final static Logger LOGGER = Logger.getLogger(LocationDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Location` (`name`) VALUES (?);";
    private final static String GET = "SELECT * FROM newsPortal.Location WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Location` SET `name` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Location` WHERE (`id` = ?);";

    @Override
    public void createItem(Location item) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getLong(1));
            }
            LOGGER.debug("item created");

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    @Override
    public Location getItemById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Location l = new Location();
        try(PreparedStatement ps = connection.prepareStatement(GET)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            l.setName(rs.getString("name"));
            l.setId(rs.getLong("id"));
            LOGGER.debug(l.toString());


        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return l;
    }

    @Override
    public void updateItem(Location item, Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, item.getName());
            ps.setLong(2, id);
            ps.executeUpdate();
            LOGGER.debug("item updated");

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            LOGGER.debug("item deleted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }
}
