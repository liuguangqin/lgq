package com.lgq.service.impl;

import com.lgq.dao.IEmpDao;
import com.lgq.service.IEmpService;
import com.lgq.vo.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmpServiceImpl implements IEmpService {
    @Resource(name = "empDaoImpl")
    private IEmpDao empDao;
    @Override
    public List<Emp> list() {

        return this.empDao.findAll();
    }

    @Override
    public boolean update(Emp vo) {
        return this.empDao.update(vo);
    }

    @Override
    public boolean insert(Emp vo) {
        return this.empDao.insert(vo);
    }

    @Override
    public boolean locked(String eid[]) {
        for (int x = 0; x < eid.length; x++) {
            Emp vo = new Emp();
            vo.setEid(Long.parseLong(eid[x]));
            this.empDao.locked(vo);

        }
        return true;
    }

    @Override
    public Emp findByEid(Long eid) {
        return this.empDao.findByEid(eid);
    }

    @Override
    public boolean login(Long vo) {
        return this.empDao.login(vo);
    }
}
