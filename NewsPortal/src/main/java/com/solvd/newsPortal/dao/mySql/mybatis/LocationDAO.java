package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ILocationDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.AbstractMysqlJdbcDAO;
import com.solvd.newsPortal.models.article.Location;
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

public class LocationDAO extends AbstractMysqlMybatisDAO<Location> implements ILocationDAO {
    private final static Logger LOGGER = Logger.getLogger(LocationDAO.class);
    private Reader r = Resources.getResourceAsReader("mybatis-config.xml");
    private SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
    private SqlSession session = ssf.openSession();
    private ILocationDAO locationDAO = session.getMapper(ILocationDAO.class);

    public LocationDAO() throws IOException {
    }

    @Override
    public void createItem(Location item) {
        createItem(item, locationDAO, ssf);
    }

    @Override
    public Location getItemById(Long id) {
        return getItemById(id, locationDAO, ssf);
    }

    @Override
    public void updateItem(Location item, Long id) {
        updateItem(item, id, locationDAO, ssf);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, locationDAO, ssf);
    }
}
