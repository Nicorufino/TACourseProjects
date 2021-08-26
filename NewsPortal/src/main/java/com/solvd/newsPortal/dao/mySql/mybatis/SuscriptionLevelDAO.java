package com.solvd.newsPortal.dao.mySql.mybatis;

import com.solvd.newsPortal.dao.ISuscriptionLevelDAO;
import com.solvd.newsPortal.dao.mySql.mybatis.utils.MybatisUtil;
import com.solvd.newsPortal.models.user.SuscriptionLevel;
import org.apache.log4j.Logger;

public class SuscriptionLevelDAO extends AbstractMysqlMybatisDAO<SuscriptionLevel> implements ISuscriptionLevelDAO {
    private final static Logger LOGGER = Logger.getLogger(SuscriptionLevelDAO.class);
    private ISuscriptionLevelDAO dao = MybatisUtil.getIDao(ISuscriptionLevelDAO.class);

    @Override
    public void createItem(SuscriptionLevel item) {
        createItem(item, dao);
    }

    @Override
    public SuscriptionLevel getItemById(Long id) {
        return getItemById(id, dao);
    }

    @Override
    public void updateItem(SuscriptionLevel item, Long id) {
        updateItem(item, id, dao);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, dao);
    }
}
