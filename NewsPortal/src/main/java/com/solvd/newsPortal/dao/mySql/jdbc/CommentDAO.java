package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.classes.article.Article;
import com.solvd.newsPortal.classes.comment.Comment;
import com.solvd.newsPortal.classes.user.User;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.ICommentDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class CommentDAO extends AbstractMysqlJdbcDAO<Comment> implements ICommentDAO {
    private final static Logger LOGGER = Logger.getLogger(CommentDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Comments` (`comment_text`, `Users_id`, `Articles_id`) VALUES (?, ?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Comments WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Comments` SET `comment_text` = ?, `Users_id` = ?, `Articles_id` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Comments` WHERE (`id` = ?);";

    @Override
    protected Comment build(ResultSet rs) throws SQLException {
        Comment c = new Comment();

        c.setComment_text(rs.getString("comment_text"));
        c.setId(rs.getLong("id"));

        Article article = new Article(rs.getLong("Articles_id"));
        c.setArticle(article);

        User user = new User(rs.getLong("Users_id"));
        c.setUser(user);

        return c;
    }

    @Override
    protected void setParameters(Comment item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getComment_text());
        ps.setLong(2, item.getUser().getId());
        ps.setLong(3, item.getArticle().getId());
    }

    @Override
    public void createItem(Comment item) {
        createItem(item, CREATE);
    }

    @Override
    public Comment getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(Comment item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {
        deleteItem(id, DELETE);
    }
}
