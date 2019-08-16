package com.lgq.service;

import com.lgq.vo.DeptRole;
import com.lgq.vo.Emp;
import com.lgq.vo.Level;
import com.lgq.vo.RoleAction;

import java.util.List;
import java.util.Map;

public interface ILevelService {
    public List<Level> list();
    public Map<String,Object> findById(Long eid) ;
}
