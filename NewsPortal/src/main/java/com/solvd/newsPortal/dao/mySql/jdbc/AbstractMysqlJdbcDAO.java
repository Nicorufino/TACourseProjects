package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.connectionPool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;

public abstract class AbstractMysqlJdbcDAO<T> {
    private final static Logger LOGGER = Logger.getLogger(AbstractMysqlJdbcDAO.class);

    protected abstract T build(ResultSet rs) throws SQLException;
    protected abstract void setParameters(T item, PreparedStatement ps) throws SQLException;

    protected Long createItem(T item, String query){
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            setParameters(item, ps);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            LOGGER.debug("item created");
            return rs.getLong("id");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }


        return null;
    }

    protected T getItemById(Long id, String query){
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            return build(rs);

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return null;
    }

    protected void updateItem(T item, Long id, String query){
        Connection connection = ConnectionPool.getInstance().getConnection();


        try(PreparedStatement ps = connection.prepareStatement(query)) {
            setParameters(item, ps);
            ps.setLong(ps.getParameterMetaData().getParameterCount(), id);
            ps.executeUpdate();
            LOGGER.debug("item updated");
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }

    }

    protected void deleteItem(Long id, String query){
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            LOGGER.debug("item deleted");

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }


}


