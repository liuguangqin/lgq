package com.lgq.dao;

import com.lgq.vo.DeptRole;
import com.lgq.vo.Emp;
import com.lgq.vo.Level;
import com.lgq.vo.RoleAction;

import java.util.List;

public interface ILevelDao {
  /**
   * 查询所有级别
   * @return
   */
  public List<Level> findAllLevel();

  /**
   * 通过lid查询所有信息
   * @param lid
   * @return
   */
  public Level findByLid(String lid);
  public List<RoleAction> findByRid(Emp rid);
  public List<DeptRole> findById(Emp vo);
}
