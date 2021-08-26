package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ICategoryDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.article.Category;
import org.apache.log4j.Logger;

public class CategoryDAO extends AbstractMysqlMybatisDAO<Category> implements ICategoryDAO {
    private final static Logger LOGGER = Logger.getLogger(CategoryDAO.class);
    private ICategoryDAO dao = MybatisUtil.getIDao(ICategoryDAO.class);

   


    @Override
    public void createItem(Category item) { createItem(item, dao);
    }

    @Override
    public Category getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(Category item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}

