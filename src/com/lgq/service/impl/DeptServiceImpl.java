package com.lgq.service.impl;

import com.lgq.dao.IDeptDao;
import com.lgq.dao.IEmpDao;
import com.lgq.service.IDeptService;
import com.lgq.vo.Dept;
import com.lgq.vo.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
public class DeptServiceImpl  implements IDeptService {
    @Resource(name = "deptDaoImpl")
    private IDeptDao  deptDao;
    @Resource(name="empDaoImpl")
    private IEmpDao empdao;
    @Override
    public Map<String,Object> findDeptList() {
        Map<String,Object> map=new HashMap<String ,Object>();
        List<Dept> dept=this.deptDao.findAllDept();
        List<Emp> emp=this.empdao.findEname();
        map.put("emps",emp);
        map.put("depts",dept);
        return map;
    }

    @Override
    public boolean updateDname(Dept vo) {
        return this.deptDao.updateDname(vo);
    }

    @Override
    public List<Dept> listAll() {
        return this.deptDao.findAllDept();
    }
}
