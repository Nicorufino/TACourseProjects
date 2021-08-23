package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.models.comment.Comment;
import com.solvd.newsPortal.dao.mySql.mybatis.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.CommentDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.UserDAO;
import com.solvd.newsPortal.services.ICommentService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CommentService implements ICommentService {
    private final static Logger LOGGER = Logger.getLogger(CommentService.class);
    private CommentDAO commentDAO = new CommentDAO();
    private UserDAO userDAO = new UserDAO();
    private ArticleDAO articleDAO = new ArticleDAO();

    public CommentService() throws IOException {
    }

    @Override
    public Comment getCommentById(Long id) {
        Comment c = commentDAO.getItemById(id);
        c.setUser(userDAO.getItemById(c.getUser().getId()));
        c.setArticle(articleDAO.getItemById(c.getArticle().getId()));
        return c;
    }
}
