package com.solvd.newsPortal.dao.mySql.mybatis;

import com.mysql.cj.log.Log;
import com.solvd.newsPortal.dao.IUserDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.AbstractMysqlJdbcDAO;
import com.solvd.newsPortal.models.user.Suscription_level;
import com.solvd.newsPortal.models.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractMysqlMybatisDAO<User> implements IUserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAO.class);
    private Reader r = Resources.getResourceAsReader("mybatis-config.xml");
    private SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
    private SqlSession session = ssf.openSession();
    private IUserDAO userDAO = session.getMapper(IUserDAO.class);


    public UserDAO() throws IOException {
    }

    @Override
    public void createItem(User item) {
        createItem(item, userDAO, ssf);
    }

    @Override
    public User getItemById(Long id) {
        return getItemById(id, userDAO, ssf);
    }

    @Override
    public void updateItem(User item, Long id) {
        updateItem(item, id, userDAO, ssf);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, userDAO, ssf);
    }
}
