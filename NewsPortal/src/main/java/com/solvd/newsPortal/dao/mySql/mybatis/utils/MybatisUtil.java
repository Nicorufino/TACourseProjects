package com.solvd.newsPortal.dao.mySql.mybatis.utils;

import com.solvd.newsPortal.dao.IBaseDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;

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


    public static SqlSessionFactory getSSF(){
        return ssf;
    }

    public static <T extends IBaseDAO<?>> T getIDao(Class<T> iClass) {
        Object o = Proxy.newProxyInstance(iClass.getClassLoader(), new Class[]{iClass}, new MybatisMapperHandler());

        return iClass.cast(o);

    }
}
