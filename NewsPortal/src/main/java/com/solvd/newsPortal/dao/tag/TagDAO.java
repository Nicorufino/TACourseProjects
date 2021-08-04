package com.solvd.newsPortal.dao.tag;

import com.solvd.newsPortal.Tag;
import com.solvd.newsPortal.ConnectionPool;
import com.solvd.newsPortal.Tag;
import com.solvd.newsPortal.dao.AbstractDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class TagDAO extends AbstractDAO implements ITagDAO {
    private final static Logger LOGGER = Logger.getLogger(TagDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Tags` (`name`) VALUES (?);";
    private final static String GET = "SELECT * FROM newsPortal.Tags WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Tags` SET `name` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Tags` WHERE (`id` = ?);";

    @Override
    public void createItem(Tag item) {
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
    public Tag getItemById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Tag t = new Tag();
        try(PreparedStatement ps = connection.prepareStatement(GET)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            t.setName(rs.getString("name"));
            t.setId(rs.getLong("id"));
            LOGGER.debug(t.toString());


        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return t;
    }

    @Override
    public void updateItem(Tag item, Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
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

