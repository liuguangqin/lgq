package com.lgq.service;

import com.lgq.vo.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptService {
    /*
    1.查询部门所有信息
    2.根据查询出的信息的did查询出该部门的领导
    3.返回map集合<key:dname,value:ename>
     */
    public Map<String,Object> findDeptList();
    public boolean updateDname(Dept vo);
    public List<Dept> listAll();
}
