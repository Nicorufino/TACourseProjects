package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.classes.article.Article;
import com.solvd.newsPortal.classes.comment.Comment;
import com.solvd.newsPortal.classes.user.User;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.ICommentDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class CommentDAO extends AbstractMysqlJdbcDAO implements ICommentDAO {
    private final static Logger LOGGER = Logger.getLogger(CommentDAO.class);
    private final static String CREATE = "INSERT INTO `newsPortal`.`Comments` (`comment_text`, `Users_id`, `Articles_id`) VALUES (?, ?, ?);";
    private final static String GET = "SELECT * FROM newsPortal.Comments WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Comments` SET `comment_text` = ?, `Users_id` = ?, `Articles_id` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Comments` WHERE (`id` = ?);";


    @Override
    public void createItem(Comment item) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getComment_text());
            ps.setLong(2, item.getUser().getId());
            ps.setLong(3, item.getArticle().getId());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getLong(1));
            }
            LOGGER.debug("item created");

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }

    }

    @Override
    public Comment getItemById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Comment c = new Comment();
        try(PreparedStatement ps = connection.prepareStatement(GET)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setComment_text(rs.getString("comment_text"));
            c.setId(rs.getLong("id"));
            Article article = new Article(rs.getLong("Articles_id"));
            c.setArticle(article);
            User user = new User(rs.getLong("Users_id"));
            c.setUser(user);

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return c;
    }

    @Override
    public void updateItem(Comment item, Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getComment_text());
            ps.setLong(2, item.getUser().getId());
            ps.setLong(3, item.getArticle().getId());
            ps.setLong(4, id);

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getLong(1));
            }
            LOGGER.debug("item created");

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            LOGGER.debug("item deleted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }
}
