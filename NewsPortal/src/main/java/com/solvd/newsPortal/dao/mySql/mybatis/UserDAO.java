package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.IUserDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.user.User;
import org.apache.log4j.Logger;

public class UserDAO extends AbstractMysqlMybatisDAO<User> implements IUserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAO.class);
    private IUserDAO dao = MybatisUtil.getIDao(IUserDAO.class);

    @Override
    public void createItem(User item) {
        createItem(item, dao);
    }

    @Override
    public User getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(User item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}
