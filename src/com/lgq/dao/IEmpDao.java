package com.lgq.dao;

import com.lgq.vo.Emp;

import java.util.List;

public interface IEmpDao {
    public List<Emp> findEname();
    public List<Emp> findAll();
    public  boolean update(Emp vo);
    public boolean insert(Emp vo);
    public boolean locked(Emp vo);
    public Emp findByEid(Long eid);
    public boolean login(Long vo);
}
