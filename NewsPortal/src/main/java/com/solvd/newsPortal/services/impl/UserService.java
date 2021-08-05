package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.classes.user.User;
import com.solvd.newsPortal.dao.mySql.jdbc.Suscription_levelDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.UserDAO;
import com.solvd.newsPortal.services.IUserService;
import org.apache.log4j.Logger;

public class UserService implements IUserService {
    private final static Logger LOGGER = Logger.getLogger(UserService.class);
    private UserDAO userDAO = new UserDAO();
    private Suscription_levelDAO slDao = new Suscription_levelDAO();


    @Override
    public User getUserById(Long id) {
        User user = userDAO.getItemById(id);
        user.setSuscription_level(slDao.getItemById(user.getSuscription_level().getId()));
        return user;
    }
}
