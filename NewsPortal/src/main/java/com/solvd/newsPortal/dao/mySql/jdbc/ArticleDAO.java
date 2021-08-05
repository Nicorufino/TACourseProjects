package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.classes.article.Article;
import com.solvd.newsPortal.classes.article.Category;
import com.solvd.newsPortal.classes.user.Suscription_level;
import com.solvd.newsPortal.classes.user.User;
import com.solvd.newsPortal.connectionPool.ConnectionPool;
import com.solvd.newsPortal.dao.IArticleDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class ArticleDAO extends AbstractMysqlJdbcDAO implements IArticleDAO {
    private final static Logger LOGGER = Logger.getLogger(ArticleDAO.class);
    private final static String CREATE ="INSERT INTO `newsPortal`.`Articles` (`name`, `date`, `body`, VALUES (?, ?, ?, ?, ?, ?);";
    private final static String GET = "SELECT * FROM `newsPortal`.`Articles` WHERE id = ?";
    private final static String UPDATE = "UPDATE `newsPortal`.`Articles` SET `name` = ?, `date` = ?, `body` = ?, `Suscription_level_id` = ?, `Categories_id` = ?, `author` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Articles` WHERE (`id` = ?);";
    @Override

    public void createItem(Article item) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setDate(2, item.getDate());
            ps.setString(3, item.getBody());
            ps.setLong(4, item.getSuscription_level().getId());
            ps.setLong(5, item.getCategory().getId());
            ps.setLong(6, item.getAuthor().getId());

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
    public Article getItemById(Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Article a = new Article();
        try(PreparedStatement ps = connection.prepareStatement(GET)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            a.setId(rs.getLong("id"));
            a.setDate(rs.getDate("date"));
            a.setName(rs.getString("name"));
            a.setBody(rs.getString("body"));
            Suscription_level sl = new Suscription_level(rs.getLong("Suscription_level_id"));
            a.setSuscription_level(sl);
            User author = new User(rs.getLong("author"));
            a.setAuthor(author);
            Category category = new Category(rs.getLong("Categories_id"));
            a.setCategory(category);


        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return a;
    }

    @Override
    public void updateItem(Article item, Long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement set = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")){
            set.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }

        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, item.getName());
            ps.setDate(2, item.getDate());
            ps.setString(3, item.getBody());
            ps.setLong(4, item.getSuscription_level().getId());
            ps.setLong(5, item.getCategory().getId());
            ps.setLong(6, item.getAuthor().getId());
            ps.setLong(7, id);

            ps.executeUpdate();
            LOGGER.debug("item updated");

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
