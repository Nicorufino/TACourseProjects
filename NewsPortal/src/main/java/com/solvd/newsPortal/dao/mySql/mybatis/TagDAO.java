package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ITagDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.AbstractMysqlJdbcDAO;
import com.solvd.newsPortal.models.tag.Tag;
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

public class TagDAO extends AbstractMysqlMybatisDAO<Tag> implements ITagDAO {
    private final static Logger LOGGER = Logger.getLogger(TagDAO.class);
    private Reader r = Resources.getResourceAsReader("mybatis-config.xml");
    private SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
    private SqlSession session = ssf.openSession();
    private ITagDAO tagDAO = session.getMapper(ITagDAO.class);


    public TagDAO() throws IOException {
    }

    @Override
    public void createItem(Tag item) {
        createItem(item, tagDAO, ssf);
    }

    @Override
    public Tag getItemById(Long id) {
        return getItemById(id, tagDAO, ssf);
    }

    @Override
    public void updateItem(Tag item, Long id) {
        updateItem(item, id, tagDAO, ssf);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, tagDAO, ssf);
    }
}

