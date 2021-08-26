package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ICommentDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.comment.Comment;
import org.apache.log4j.Logger;

public class CommentDAO extends AbstractMysqlMybatisDAO<Comment> implements ICommentDAO {
    private final static Logger LOGGER = Logger.getLogger(CommentDAO.class);
    private ICommentDAO dao = MybatisUtil.getIDao(ICommentDAO.class);

    @Override
    public void createItem(Comment item) {
        createItem(item, dao);
    }

    @Override
    public Comment getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(Comment item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}
