package com.lgq.dao;

import com.lgq.vo.Item;

import java.awt.event.ItemEvent;
import java.util.List;

public interface IItemDao {
    public List<Item> findAll();
}
