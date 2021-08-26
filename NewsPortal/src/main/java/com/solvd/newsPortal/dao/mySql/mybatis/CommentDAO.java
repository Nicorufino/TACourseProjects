package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ICommentDAO;
import com.solvd.newsPortal.dao.mySql.jdbc.AbstractMysqlJdbcDAO;
import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.models.comment.Comment;
import com.solvd.newsPortal.models.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDAO extends AbstractMysqlMybatisDAO<Comment> implements ICommentDAO {
    private final static Logger LOGGER = Logger.getLogger(CommentDAO.class);
    private SqlSession session = MybatisUtil.getSession();
    private ICommentDAO commentDAO = session.getMapper(ICommentDAO.class);

    public CommentDAO() throws IOException {
    }


    @Override
    public void createItem(Comment item) {
        createItem(item, commentDAO, session);
    }

    @Override
    public Comment getItemById(Long id) {
        return getItemById(id, commentDAO, session);
    }

    @Override
    public void updateItem(Comment item, Long id) {
        updateItem(item, id, commentDAO, session);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, commentDAO, session);
    }
}
