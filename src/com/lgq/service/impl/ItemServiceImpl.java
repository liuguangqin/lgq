package com.lgq.service.impl;

import com.lgq.dao.IItemDao;
import com.lgq.service.IItemService;
import com.lgq.vo.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ItemServiceImpl implements IItemService {
    @Resource(name = "itemDaoImpl")
    private IItemDao iItemDao;
    @Override
    public List<Item> list() {
        return this.iItemDao.findAll();
    }
}
