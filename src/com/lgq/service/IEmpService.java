package com.lgq.service;

import com.lgq.vo.Emp;

import java.util.List;

public interface IEmpService {
    public List<Emp> list();
    public boolean update(Emp vo);
    public boolean insert(Emp vo);
    public boolean locked(String  eid[]);
    public Emp findByEid(Long eid);
    public boolean login(Long vo);
}
