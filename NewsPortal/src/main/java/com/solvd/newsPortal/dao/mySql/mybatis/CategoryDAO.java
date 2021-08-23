package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ICategoryDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.AbstractMysqlJdbcDAO;
import com.solvd.newsPortal.models.article.Category;
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

public class CategoryDAO extends AbstractMysqlMybatisDAO<Category> implements ICategoryDAO {
    private final static Logger LOGGER = Logger.getLogger(CategoryDAO.class);
    private Reader r = Resources.getResourceAsReader("mybatis-config.xml");
    private SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);
    private SqlSession session = ssf.openSession();
    private ICategoryDAO categoryDAO = session.getMapper(ICategoryDAO.class);

    public CategoryDAO() throws IOException {
    }


    @Override
    public void createItem(Category item) {
        createItem(item, categoryDAO, ssf);
    }

    @Override
    public Category getItemById(Long id) {
        return getItemById(id, categoryDAO, ssf);
    }

    @Override
    public void updateItem(Category item, Long id) {
        updateItem(item, id, categoryDAO, ssf);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, categoryDAO, ssf);
    }
}

