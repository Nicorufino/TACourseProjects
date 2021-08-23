package com.solvd.newsPortal.services;

import com.solvd.newsPortal.models.user.User;

public interface IUserService {
    User getUserById(Long id);
}
