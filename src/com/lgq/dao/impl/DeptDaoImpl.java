package com.lgq.dao.impl;

import com.lgq.dao.IDeptDao;
import com.lgq.vo.Dept;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
    public class DeptDaoImpl implements IDeptDao {
    @Resource
     private SqlSessionFactory sessionFactory;
        @Override
        public List<Dept> findAllDept() {
            return this.sessionFactory.openSession().selectList("com.lgq.vo.dept.findAllDept");
        }

    @Override
    public boolean updateDname(Dept vo) {
        return this.sessionFactory.openSession().update("com.lgq.vo.dept.updateByDid",vo)>0;
    }

    @Override
    public Dept findByDid(Long did) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.dept.findByDid",did);
    }
}
