package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ILocationDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.article.Location;
import org.apache.log4j.Logger;

public class LocationDAO extends AbstractMysqlMybatisDAO<Location> implements ILocationDAO {
    private final static Logger LOGGER = Logger.getLogger(LocationDAO.class);
    private ILocationDAO dao = MybatisUtil.getIDao(ILocationDAO.class);

    @Override
    public void createItem(Location item) {
        createItem(item, dao);
    }

    @Override
    public Location getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(Location item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}
