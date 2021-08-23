package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.models.user.Suscription_level;
import com.solvd.newsPortal.dao.ISuscription_levelDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class Suscription_levelDAO extends AbstractMysqlJdbcDAO<Suscription_level> implements ISuscription_levelDAO {
    private final static Logger LOGGER = Logger.getLogger(Suscription_levelDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Suscription_level` (`name`, `cost`) VALUES (?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Suscription_level WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Suscription_level` SET `name` = ?, `cost` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Suscription_level` WHERE (`id` = ?);";

    @Override
    protected Suscription_level build(ResultSet rs) throws SQLException {
        Suscription_level sl = new Suscription_level();
        sl.setName(rs.getString("name"));
        sl.setCost(rs.getFloat("cost"));
        sl.setId(rs.getLong("id"));
        return sl;
    }

    @Override
    protected void setParameters(Suscription_level item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setFloat(2, item.getCost());
    }

    @Override
    public void createItem(Suscription_level item) {
        createItem(item, CREATE);
    }

    @Override
    public Suscription_level getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(Suscription_level item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {

    }
}
