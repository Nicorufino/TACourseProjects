package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.IBaseDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public abstract class AbstractMysqlMybatisDAO <T> {
    private final static Logger LOGGER = Logger.getLogger(AbstractMysqlMybatisDAO.class);

    public void createItem(T item, IBaseDAO<T> dao, SqlSessionFactory ssf){
        SqlSession session = ssf.openSession();
        dao.createItem(item);
        session.close();
    }

    public T getItemById(Long id, IBaseDAO<T> dao, SqlSessionFactory ssf){
        SqlSession session = ssf.openSession();
        T result = dao.getItemById(id);
        session.close();
        return result;
    }

    public void updateItem(T item, Long id, IBaseDAO<T> dao, SqlSessionFactory ssf){
        SqlSession session = ssf.openSession();
        dao.updateItem(item, id);
        session.close();
    }

    public void deleteById(Long id, IBaseDAO<T> dao, SqlSessionFactory ssf){
        SqlSession session = ssf.openSession();
        dao.deleteById(id);
        session.close();
    }

}
