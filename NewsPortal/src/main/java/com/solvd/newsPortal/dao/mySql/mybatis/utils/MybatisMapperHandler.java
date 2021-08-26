package com.solvd.newsPortal.dao.mySql.mybatis.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MybatisMapperHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> iDaoClass = proxy.getClass().getInterfaces()[0];


        try (SqlSession ss = MybatisUtil.getSSF().openSession()) {
            Object oResult = method.invoke(ss.getMapper(iDaoClass), args);
            ss.commit();
            return oResult;
        }
    }
}