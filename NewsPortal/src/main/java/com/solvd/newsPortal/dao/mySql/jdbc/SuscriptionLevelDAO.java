package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.dao.ISuscriptionLevelDAO;
import com.solvd.newsPortal.models.user.SuscriptionLevel;
import org.apache.log4j.Logger;

import java.sql.*;

public class SuscriptionLevelDAO extends AbstractMysqlJdbcDAO<SuscriptionLevel> implements ISuscriptionLevelDAO {
    private final static Logger LOGGER = Logger.getLogger(SuscriptionLevelDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Suscription_level` (`name`, `cost`) VALUES (?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Suscription_level WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Suscription_level` SET `name` = ?, `cost` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Suscription_level` WHERE (`id` = ?);";

    @Override
    protected SuscriptionLevel build(ResultSet rs) throws SQLException {
        SuscriptionLevel sl = new SuscriptionLevel();
        sl.setName(rs.getString("name"));
        sl.setCost(rs.getFloat("cost"));
        sl.setId(rs.getLong("id"));
        return sl;
    }

    @Override
    protected void setParameters(SuscriptionLevel item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setFloat(2, item.getCost());
    }

    @Override
    public void createItem(SuscriptionLevel item) {
        createItem(item, CREATE);
    }

    @Override
    public SuscriptionLevel getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(SuscriptionLevel item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {

    }
}
