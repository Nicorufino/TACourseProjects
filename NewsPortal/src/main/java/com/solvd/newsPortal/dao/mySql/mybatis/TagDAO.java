package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ITagDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.tag.Tag;
import org.apache.log4j.Logger;

public class TagDAO extends AbstractMysqlMybatisDAO<Tag> implements ITagDAO {
    private final static Logger LOGGER = Logger.getLogger(TagDAO.class);
    private ITagDAO dao = MybatisUtil.getIDao(ITagDAO.class);

    @Override
    public void createItem(Tag item) {
        createItem(item, dao);
    }

    @Override
    public Tag getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(Tag item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}

