package com.solvd.newsPortal.dao.category;

import com.solvd.newsPortal.Article;
import com.solvd.newsPortal.Category;
import com.solvd.newsPortal.ConnectionPool;
import com.solvd.newsPortal.dao.AbstractDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class CategoryDAO extends AbstractDAO implements ICategoryDAO {
    private final static Logger LOGGER = Logger.getLogger(CategoryDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Categories` (`name`) VALUES (?);";
    private final static String GET = "SELECT * FROM newsPortal.Categories where id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Categories` SET `name` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Categories` WHERE (`id` = 1);";

    @Override
    public void createItem(Category item) {
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
    public Category getItemById(Long id){
        Connection connection = ConnectionPool.getInstance().getConnection();
        Category c = new Category();
        try(PreparedStatement ps = connection.prepareStatement(GET)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setName(rs.getString("name"));
            c.setId(rs.getLong("id"));
            LOGGER.debug(c.toString());


        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return c;
    }


    @Override
    public void updateItem(Category item, Long id) {
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
