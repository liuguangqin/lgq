package com.lgq.dao.impl;

import com.lgq.dao.ILevelDao;
import com.lgq.vo.DeptRole;
import com.lgq.vo.Emp;
import com.lgq.vo.Level;
import com.lgq.vo.RoleAction;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class LevelDaoImpl  implements ILevelDao {
    @Resource
    private SqlSessionFactory sessionFactory;
    @Override
    public List<Level> findAllLevel() {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.level.findAllLevel");
    }

    @Override
    public Level findByLid(String lid) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.mapping.level.findByLid",lid);
    }

    @Override
    public List<RoleAction> findByRid(Emp rid) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.roleAction.findByRid",rid);
    }

    @Override
    public List<DeptRole> findById(Emp vo) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.deptRole.findById",vo);
    }
}
