package com.solvd.newsPortal.services.impl;

import com.solvd.newsPortal.classes.comment.Comment;
import com.solvd.newsPortal.dao.mySql.jdbc.ArticleDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.CommentDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.UserDAO;
import com.solvd.newsPortal.services.ICommentService;
import org.apache.log4j.Logger;

public class CommentService implements ICommentService {
    private final static Logger LOGGER = Logger.getLogger(CommentService.class);
    private CommentDAO commentDAO = new CommentDAO();
    private UserDAO userDAO = new UserDAO();
    private ArticleDAO articleDAO = new ArticleDAO();

    @Override
    public Comment getCommentById(Long id) {
        Comment c = commentDAO.getItemById(id);
        c.setUser(userDAO.getItemById(c.getUser().getId()));
        c.setArticle(articleDAO.getItemById(c.getArticle().getId()));
        return c;
    }
}
