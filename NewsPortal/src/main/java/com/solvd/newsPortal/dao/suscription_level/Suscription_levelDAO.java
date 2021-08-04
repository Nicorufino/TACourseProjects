package com.solvd.newsPortal.dao.suscription_level;

import com.solvd.newsPortal.ConnectionPool;
import com.solvd.newsPortal.Location;
import com.solvd.newsPortal.Suscription_level;
import com.solvd.newsPortal.dao.AbstractDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class Suscription_levelDAO extends AbstractDAO implements ISuscription_levelDAO {
    private final static Logger LOGGER = Logger.getLogger(Suscription_levelDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Suscription_level` (`name`, `cost`) VALUES (?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Suscription_level WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Suscription_level` SET `name` = ?, `cost` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Suscription_level` WHERE (`id` = ?);";
    @Override
    public void createItem(Suscription_level item) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setFloat(2, item.getCost());
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
    public Suscription_level getItemById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Suscription_level sl = new Suscription_level();
        try(PreparedStatement ps = connection.prepareStatement(GET)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            sl.setName(rs.getString("name"));
            sl.setCost(rs.getFloat("cost"));
            sl.setId(rs.getLong("id"));
            LOGGER.debug(sl.toString());


        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return sl;
    }

    @Override
    public void updateItem(Suscription_level item, Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, item.getName());
            ps.setFloat(2, item.getCost());
            ps.setLong(3, id);
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
