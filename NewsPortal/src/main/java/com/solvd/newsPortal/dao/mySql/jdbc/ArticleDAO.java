package com.solvd.newsPortal.dao.mySql.jdbc;

import com.solvd.newsPortal.models.article.Article;
import com.solvd.newsPortal.models.article.Category;
import com.solvd.newsPortal.models.user.SuscriptionLevel;
import com.solvd.newsPortal.models.user.User;
import com.solvd.newsPortal.dao.IArticleDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class ArticleDAO extends AbstractMysqlJdbcDAO<Article> implements IArticleDAO {
    private final static Logger LOGGER = Logger.getLogger(ArticleDAO.class);
    private final static String CREATE ="INSERT INTO `newsPortal`.`Articles` (`name`, `date`, `body`, VALUES (?, ?, ?, ?, ?, ?);";
    private final static String GET = "SELECT * FROM `newsPortal`.`Articles` WHERE id = ?;";
    private final static String UPDATE = "UPDATE `newsPortal`.`Articles` SET `name` = ?, `date` = ?, `body` = ?, `Suscription_level_id` = ?, `Categories_id` = ?, `author` = ? WHERE (`id` = ?);";
    private final static String DELETE = "DELETE FROM `newsPortal`.`Articles` WHERE (`id` = ?);";


    @Override
    protected Article build(ResultSet rs) throws SQLException {
        Article a = new Article();
        a.setId(rs.getLong("id"));
        a.setDate(rs.getDate("date"));
        a.setName(rs.getString("name"));
        a.setBody(rs.getString("body"));
        SuscriptionLevel sl = new SuscriptionLevel(rs.getLong("Suscription_level_id"));
        a.setSuscriptionLevelRequired(sl);
        User author = new User(rs.getLong("author"));
        a.setAuthor(author);
        Category category = new Category(rs.getLong("Categories_id"));
        a.setCategory(category);

        return a;
    }

    @Override
    protected void setParameters(Article item, PreparedStatement ps) throws SQLException {
        ps.setString(1, item.getName());
        ps.setDate(2, Date.valueOf(item.getDate()));
        ps.setString(3, item.getBody());
        ps.setLong(4, item.getSuscriptionLevelRequired().getId());
        ps.setLong(5, item.getCategory().getId());
        ps.setLong(6, item.getAuthor().getId());
    }

    @Override
    public void createItem(Article item) {
        createItem(item, CREATE);
    }

    @Override
    public Article getItemById(Long id) {
        return getItemById(id, GET);
    }

    @Override
    public void updateItem(Article item, Long id) {
        updateItem(item, id, UPDATE);
    }

    @Override
    public void deleteById(Long id) {
        deleteItem(id, DELETE);
    }
}
