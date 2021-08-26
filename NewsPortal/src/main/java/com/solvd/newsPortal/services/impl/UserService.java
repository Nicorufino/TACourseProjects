package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.models.user.User;
import com.solvd.newsPortal.dao.mySql.mybatis.SuscriptionLevelDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.UserDAO;
import com.solvd.newsPortal.services.IUserService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class UserService implements IUserService {
    private final static Logger LOGGER = Logger.getLogger(UserService.class);
    private UserDAO userDAO = new UserDAO();
    private SuscriptionLevelDAO slDao = new SuscriptionLevelDAO();

    public UserService() throws IOException {
    }


    @Override
    public User getUserById(Long id) {
        User user = userDAO.getItemById(id);
        user.setSuscriptionLevel(slDao.getItemById(user.getSuscriptionLevel().getId()));
        return user;
    }
}
