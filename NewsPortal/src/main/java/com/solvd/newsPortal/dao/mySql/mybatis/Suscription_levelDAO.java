package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ILocationDAO;
import com.solvd.newsPortal.dao.ISuscription_levelDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.AbstractMysqlJdbcDAO;
import com.solvd.newsPortal.models.user.Suscription_level;
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

public class Suscription_levelDAO extends AbstractMysqlMybatisDAO<Suscription_level> implements ISuscription_levelDAO {
    private final static Logger LOGGER = Logger.getLogger(Suscription_levelDAO.class);
    private Reader r = Resources.getResourceAsReader("mybatis-config.xml");
    private SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
    private SqlSession session = ssf.openSession();
    private ISuscription_levelDAO suscription_levelDAO = session.getMapper(ISuscription_levelDAO.class);

    public Suscription_levelDAO() throws IOException {
    }

    @Override
    public void createItem(Suscription_level item) {
        createItem(item, suscription_levelDAO, ssf);
    }

    @Override
    public Suscription_level getItemById(Long id) {
        return getItemById(id, suscription_levelDAO, ssf);
    }

    @Override
    public void updateItem(Suscription_level item, Long id) {
        updateItem(item, id, suscription_levelDAO, ssf);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, suscription_levelDAO, ssf);
    }
}
