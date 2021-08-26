package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.IBaseDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;

public abstract class AbstractMysqlMybatisDAO <T> {
    private final static Logger LOGGER = Logger.getLogger(AbstractMysqlMybatisDAO.class);

    public void createItem(T item, IBaseDAO<T> dao, SqlSession session){
        dao.createItem(item);
        session.close();
    }

    public T getItemById(Long id, IBaseDAO<T> dao, SqlSession session){
        T result = dao.getItemById(id);
        session.close();
        return result;
    }

    public void updateItem(T item, Long id, IBaseDAO<T> dao, SqlSession session){
        dao.updateItem(item, id);
        session.close();
    }

    public void deleteById(Long id, IBaseDAO<T> dao, SqlSession session){
        dao.deleteById(id);
        session.close();

    }

}
