package com.lgq.dao.impl;

import com.lgq.dao.IItemDao;
import com.lgq.vo.Item;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ItemDaoImpl implements IItemDao {
    @Resource
    private SqlSessionFactory sessionFactory;

    @Override
    public List<Item> findAll() {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.item.findAllitem");
    }
}
