package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.classes.user.Suscription_level;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.classes.user.User;
import com.solvd.newsPortal.dao.IUserDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserDAO extends AbstractMysqlJdbcDAO implements IUserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Users` (`name`, `last_name`, `age`, `Suscription_level_id`) VALUES (?, ?, ?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Users WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Users` SET `name` = ?, `last_name` = ?, `age` = ?, `Suscription_level_id` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Users` WHERE (`id` = ?);";
    @Override
    public void createItem(User item) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getLast_name());
            ps.setInt(3, item.getAge());
            ps.setLong(4, item.getSuscription_level().getId());

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
    public User getItemById(Long id) {

        Connection connection = ConnectionPool.getInstance().getConnection();
        User u = new User();
        try(PreparedStatement ps = connection.prepareStatement(GET)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            u.setAge(rs.getInt("age"));
            u.setId(rs.getLong("id"));
            u.setName(rs.getString("name"));
            u.setLast_name(rs.getString("last_name"));
            Suscription_level suscription_level = new Suscription_level(rs.getLong("Suscription_level_id"));
            u.setSuscription_level(suscription_level);

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return u;
    }

    @Override
    public void updateItem(User item, Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getLast_name());
            ps.setInt(3, item.getAge());
            ps.setLong(4, item.getSuscription_level().getId());
            ps.setLong(5, id);

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
