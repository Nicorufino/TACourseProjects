package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.models.comment.Comment;
import com.solvd.newsPortal.dao.mySql.mybatis.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.CommentDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.UserDAO;
import com.solvd.newsPortal.models.user.User;
import com.solvd.newsPortal.services.ICommentService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CommentService implements ICommentService {
    private final static Logger LOGGER = Logger.getLogger(CommentService.class);
    private CommentDAO commentDAO = new CommentDAO();
    private UserService uService = new UserService();
    private ArticleService aService = new ArticleService();

    public CommentService() throws IOException {
    }

    @Override
    public Comment getCommentById(Long id) {
        Comment c = commentDAO.getItemById(id);
        c.setUser(uService.getUserById(c.getUser().getId()));
        c.setArticle(aService.getArticleById(c.getArticle().getId()));
        return c;
    }
}
