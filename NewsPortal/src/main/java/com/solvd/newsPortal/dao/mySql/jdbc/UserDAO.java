package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.models.user.SuscriptionLevel;
import com.solvd.newsPortal.models.user.User;
import com.solvd.newsPortal.dao.IUserDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserDAO extends AbstractMysqlJdbcDAO<User> implements IUserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Users` (`name`, `last_name`, `age`, `Suscription_level_id`) VALUES (?, ?, ?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Users WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Users` SET `name` = ?, `last_name` = ?, `age` = ?, `Suscription_level_id` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Users` WHERE (`id` = ?);";

    @Override
    protected User build(ResultSet rs) throws SQLException {
        User u = new User();
        u.setAge(rs.getInt("age"));
        u.setId(rs.getLong("id"));
        u.setName(rs.getString("name"));
        u.setLastName(rs.getString("last_name"));

        SuscriptionLevel suscription_level = new SuscriptionLevel(rs.getLong("Suscription_level_id"));
        u.setSuscriptionLevel(suscription_level);

        return u;
    }

    @Override
    protected void setParameters(User item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setString(2, item.getLastName());
        ps.setInt(3, item.getAge());
        ps.setLong(4, item.getSuscriptionLevel().getId());
    }

    @Override
    public void createItem(User item) {
        createItem(item, CREATE);
    }

    @Override
    public User getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(User item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {
        deleteItem(id, DELETE);
    }
}
