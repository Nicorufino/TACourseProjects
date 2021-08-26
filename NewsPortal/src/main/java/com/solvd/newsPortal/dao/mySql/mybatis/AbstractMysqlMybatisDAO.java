package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.IBaseDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;

public abstract class AbstractMysqlMybatisDAO <T> {
    private final static Logger LOGGER = Logger.getLogger(AbstractMysqlMybatisDAO.class);

    public void createItem(T item, IBaseDAO<T> dao){
        dao.createItem(item);
       
    }

    public T getItemById(Long id, IBaseDAO<T> dao){
        T result = dao.getItemById(id);
        
        return result;
    }

    public void updateItem(T item, Long id, IBaseDAO<T> dao){
        dao.updateItem(item, id);
        
    }

    public void deleteById(Long id, IBaseDAO<T> dao){
        dao.deleteById(id);
        

    }

}
