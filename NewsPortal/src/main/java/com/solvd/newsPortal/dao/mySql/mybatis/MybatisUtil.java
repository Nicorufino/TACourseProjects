package com.solvd.newsPortal.dao.mySql.mybatis;

import com.mysql.cj.Session;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.IBaseDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

public class MybatisUtil {
    private final static Logger LOGGER = Logger.getLogger(MybatisUtil.class);
    private static Reader r;
    static {
        try {
            r = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
    private static SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(r);


    public static SqlSession getSession(){
        return ssf.openSession();

    }


}
