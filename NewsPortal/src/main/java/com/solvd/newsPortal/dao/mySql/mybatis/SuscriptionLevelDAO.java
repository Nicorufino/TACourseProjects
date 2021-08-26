package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ISuscriptionLevelDAO;
import com.solvd.newsPortal.models.user.SuscriptionLevel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class SuscriptionLevelDAO extends AbstractMysqlMybatisDAO<SuscriptionLevel> implements ISuscriptionLevelDAO {
    private final static Logger LOGGER = Logger.getLogger(SuscriptionLevelDAO.class);
    private Reader r = Resources.getResourceAsReader("mybatis-config.xml");
    private SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
    private SqlSession session = ssf.openSession();
    private ISuscriptionLevelDAO suscription_levelDAO = session.getMapper(ISuscriptionLevelDAO.class);

    public SuscriptionLevelDAO() throws IOException {
    }

    @Override
    public void createItem(SuscriptionLevel item) {
        createItem(item, suscription_levelDAO, session);
    }

    @Override
    public SuscriptionLevel getItemById(Long id) {
        return getItemById(id, suscription_levelDAO, session);
    }

    @Override
    public void updateItem(SuscriptionLevel item, Long id) {
        updateItem(item, id, suscription_levelDAO, session);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, suscription_levelDAO, session);
    }
}
