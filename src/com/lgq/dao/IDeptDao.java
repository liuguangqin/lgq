package com.lgq.dao;

import com.lgq.vo.Dept;

import java.util.List;

public interface IDeptDao {
  public List<Dept> findAllDept();
  public boolean updateDname(Dept vo);
  public  Dept findByDid(Long did);
}
