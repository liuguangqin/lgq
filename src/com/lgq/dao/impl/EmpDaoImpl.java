package com.lgq.dao.impl;

import com.lgq.dao.IEmpDao;
import com.lgq.vo.Emp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class EmpDaoImpl implements IEmpDao {
    @Resource
    private SqlSessionFactory sessionFactory;
    @Override
    public List<Emp> findEname() {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.emp.findEname");
    }

    @Override
    public List<Emp> findAll() {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.emp.findAll");
    }

    @Override
    public boolean update(Emp vo) {
        return this.sessionFactory.openSession().update("com.lgq.vo.emp.updateByEid",vo)>0;
    }

    @Override
    public boolean insert(Emp vo) {
        return this.sessionFactory.openSession().insert("com.lgq.vo.emp.insertEmp",vo)>0;
    }

    @Override
    public boolean locked(Emp vo) {
        return this.sessionFactory.openSession().delete("com.lgq.vo.emp.updateLocked",vo)>0;
    }

    @Override
    public Emp findByEid(Long eid) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.emp.findByEid",eid);
    }


    @Override
    public boolean login(Long vo) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.emp.findByEid",vo);
    }
}
